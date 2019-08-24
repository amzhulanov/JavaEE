package ru.geekbrains.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public ItemRepository(){
    }

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
            //ResultSet rs = stmt.executeQuery("select id, login, password from users");
            ResultSet rs = stmt.executeQuery("select id,name,vendor,category from items");

            while (rs.next()) {
                //res.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
                 res.add(new Item(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4)));
            }
        }
        res.add(new Item(100, "test", "test","test"));
        return res;
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("create table if not exists items (\n" +
                    "\t id int auto_increment primary key,\n" +
                    "    name varchar(25),\n" +
                 //   "    cost float,\n" +
                    "    vendor varchar(25)\n" +
                    "    category varchar(25)\n" +
                    ");");
        }
    }


}
