package ru.geekbrains.persist.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.UserRepository;
import ru.geekbrains.persist.item.Item;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ItemRepository {

    @Inject
    private ServletContext servletContext;

    private Connection conn;

    //конструктор требуется для аннотации Inject
    public ItemRepository() {
    }

    private Logger logger = LoggerFactory.getLogger(UserRepository.class);

    //конструктор для установки подключения к БД
    public ItemRepository(Connection conn) throws SQLException {
        this.conn = conn;
        createTableIfNotExists(conn);
    }

    @PostConstruct
    public void init() throws SQLException {
        this.conn = (Connection) servletContext.getAttribute("jdbcConnection");
        createTableIfNotExists(conn);
    }

    public List<Item> getAllItems() throws SQLException {
        List<Item> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id,name,vendor,category from items");
            while (rs.next()) {
                res.add(new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
            logger.info("ItemsRepository.getAllItems - Error with createStatement : " + e);
        }
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists items (\n" +
                    "\t id int auto_increment primary key,\n" +
                    "    name varchar(25),\n" +
                    //   "    cost float,\n" +
                    "    vendor varchar(25),\n" +
                    "    category varchar(25)\n" +
                    ");");
        }
    }

    public void saveItem(Item item) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update items set category = ?, name = ?, vendor=? where id = ?;")) {
            stmt.setString(1, item.getCategory());
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getVendor());
            stmt.setInt(4, item.getId());
            stmt.execute();
            logger.info("itemRepository.save Item=" + item.getId());
        }
    }

    public void deleteItem(Item item) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from items where id = ?;")) {
            stmt.setInt(1, item.getId());
            stmt.execute();
            logger.info("itemRepository.delete Item=" + item.getId());
        }
    }

    public void addItem(Item item) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into items (category,name,vendor) values (?,?,?);")) {
            stmt.setString(1, item.getCategory());
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getVendor());
            stmt.execute();
            logger.info("itemRepository.add Item=" + item.getName());
        }
    }
}