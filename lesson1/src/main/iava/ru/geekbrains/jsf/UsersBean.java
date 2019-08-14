package ru.geekbrains.jsf;

import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@ManagedBean
public class UsersBean {

    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        ServletContext servletContext=(ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        userRepository=(UserRepository) servletContext.getAttribute("userRepository");
    }

    public List<User> getAllUsers() throws SQLException {
        return userRepository.getAllUsers();

    }
}
