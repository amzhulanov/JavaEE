package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class UsersBean {

    private UserRepository userRepository;
    //private Logger logger = LoggerFactory.getLogger(ContextListener.class);
    private Logger logger= LoggerFactory.getLogger(UsersBean.class);
    @PostConstruct
    public void init(){
        ServletContext servletContext=(ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        logger.info("AAAA - Info. Create servletContext - Ok");
        userRepository=(UserRepository) servletContext.getAttribute("userRepository");
        logger.info("AAAA - Info. Create userRepository - Ok");
    }

    public List<User> getAllUsers() throws SQLException {
        return userRepository.getAllUsers();

    }
}
