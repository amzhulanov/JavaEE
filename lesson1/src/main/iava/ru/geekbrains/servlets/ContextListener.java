package ru.geekbrains.servlets;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.MenuRepository;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;
import ru.geekbrains.persist.item.ItemRepository;

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
        logger.info(" - AAAAAAAAAAAAA Context initialization: " + context.getContextPath());
        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/network_chat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Novosibirsk", "root", "localhost_1");
        //String jdbcConnectionString = context.getInitParameter("jdbc:mysql://localhost:3306/network_chat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Novosibirsk");
        String jdbcConnectionString = context.getInitParameter("jdbcConnectionString");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        if (isNotNullOrEmpty(jdbcConnectionString) || isNotNullOrEmpty(username)) {
            logger.error("Connection string and DB username must be specified  - AAAAAAAAAAAAA");
            return;
        }
        try {
            Connection connection = DriverManager.getConnection(jdbcConnectionString, username, password);
            logger.error("Connection Ok  - AAAAAAAAAAAAA - "+ connection);
           // Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/network_chat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Novosibirsk", "root", "localhost_1");
            context.setAttribute("jdbcConnection", connection);
            UserRepository userRepository = new UserRepository(connection);
            context.setAttribute("userRepository", userRepository);

            if (userRepository.getAllUsers().size() == 0) {
                userRepository.insert(new User(-1, "first_user", "ppp"));
                userRepository.insert(new User(-1, "second_user", "ppp"));
            }
        } catch (SQLException e) {
            logger.error(" - AAAAAAAAAAAAA", e);
        }

        MenuRepository menuRepository = new MenuRepository();
        context.setAttribute("menuRepository", menuRepository);
        ItemRepository itemRepository=new ItemRepository();
        context.setAttribute("itemRepository", itemRepository);
    }

    private boolean isNotNullOrEmpty(String str) {
        return str != null && str.isEmpty();
    }
}
