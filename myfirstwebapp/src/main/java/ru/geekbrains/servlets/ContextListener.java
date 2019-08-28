package ru.geekbrains.servlets;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.MenuRepository;
import ru.geekbrains.persist.UserRepository;
import ru.geekbrains.persist.item.CategoryRepository;
import ru.geekbrains.persist.item.ItemRepository;
import ru.geekbrains.persist.item.OrderRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class ContextListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        logger.info("Context initialization: " + context.getContextPath());
        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/network_chat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Novosibirsk", "root", "localhost_1");
        //String jdbcConnectionString = context.getInitParameter("jdbc:mysql://localhost:3306/network_chat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Novosibirsk");
        String jdbcConnectionString = context.getInitParameter("jdbcConnection");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        if (isNotNullOrEmpty(jdbcConnectionString) || isNotNullOrEmpty(username)) {
            logger.error("Connection string and DB username must be specified");
            return;
        }
        try {
            Connection connection = DriverManager.getConnection(jdbcConnectionString, username, password);
            // Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/network_chat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Novosibirsk", "root", "localhost_1");
            context.setAttribute("jdbcConnection", connection);
            ItemRepository itemRepository = new ItemRepository(connection);
            context.setAttribute("itemRepository", itemRepository);
            CategoryRepository categoryRepository = new CategoryRepository(connection);
            context.setAttribute("categoryRepository", categoryRepository);
            OrderRepository orderRepository = new OrderRepository(connection);
            context.setAttribute("orderRepository", orderRepository);


        } catch (SQLException e) {
            logger.error("ContextListener SQLException = "+e);
        }

        MenuRepository menuRepository = new MenuRepository();
        context.setAttribute("menuRepository", menuRepository);
    }

    private boolean isNotNullOrEmpty(String str) {
        return str != null && str.isEmpty();
    }
}