package ru.geekbrains.persist.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.UserRepository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class OrderRepository {

    @Inject
    private ServletContext servletContext;

    private Connection conn;

    private Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public OrderRepository(){

    }

    //конструктор для установки подключения к БД
    public OrderRepository(Connection conn) throws SQLException {
        this.conn = conn;
    }

    @PostConstruct
    public void init() throws SQLException {
        this.conn = (Connection) servletContext.getAttribute("jdbcConnection");
    }

    public List<Order> getAllOrders() throws SQLException {
        List<Order> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id,num_order,buyer from orders");
            while (rs.next()) {
                res.add(new Order(rs.getInt(1), rs.getString(2), rs.getString(3)));           }
        } catch (Exception e) {
            logger.error("OrdersRepository.getAllOrders - Error with createStatement : " + e);
        }
        return res;
    }


    public void saveOrder(Order order) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update orders set num_order = ?, buyer= ? where id = ?;")) {
            stmt.setString(1, order.getNum_order());
            stmt.setString(2, order.getBuyer());
            stmt.setInt(3, order.getId());
            stmt.execute();
        }
    }

    public void deleteOrder(Order order) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from orders where id = ?;")) {
            stmt.setInt(1, order.getId());
            stmt.execute();
        }
    }

    public void addOrder(Order order) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into orders (num_order,buyer) values (?,?);")) {
            stmt.setString(1, order.getNum_order());
            stmt.setString(2, order.getBuyer());
            stmt.execute();
        }
    }
}
