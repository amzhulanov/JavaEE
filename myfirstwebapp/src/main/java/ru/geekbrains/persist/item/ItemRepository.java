package ru.geekbrains.persist.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.MenuRepository;
import ru.geekbrains.persist.User;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ItemRepository {
    private Logger logger = LoggerFactory.getLogger(MenuRepository.class);

    @Inject
    private ServletContext servletContext;
    private Connection conn1;

    public ItemRepository() {
    }

    public ItemRepository(Connection conn1) throws SQLException {
        this.conn1 = conn1;
    }

    @PostConstruct
    public void init() throws SQLException {
        this.conn1 = (Connection) servletContext.getAttribute("jdbcConnection");
    }

       public List<Item> getAllItems() throws SQLException {
        List<Item> res=new ArrayList<>();
           logger.info("ItemRepository.getAllItems - Create List Items");
        try (Statement stmt = conn1.createStatement()) {
            logger.info("conn1.createStatememt - Ok");
            ResultSet rs = stmt.executeQuery("select id from network_chat.items");//", name, cost, vendor,category from items");
           // ,category where items.category=category.id
            logger.info("ItemRepository.getAllItems rs.name="+rs.getString(2));
            while (rs.next()) {
                res.add(new Item(rs.getInt(1),"ttt", 100.6,"nnn",23));
                               /*  rs.getString(2),
                                 rs.getFloat(3),
                                 rs.getString(4),
                                 rs.getInt(5)));*/
            }
        }catch(Exception e){
            logger.error("ItemRepository.getAllItems - conn1 not created!!!");
        }
        return res;
    }

}
