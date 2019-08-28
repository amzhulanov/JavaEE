package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.util.List;

@SessionScoped// параметр для определения время жизни Bean`а
public class UsersBean implements Serializable {


    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UsersBean.class);

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    @PostConstruct
//    public void init() {
//        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//        userRepository = (UserRepository) servletContext.getAttribute("userRepository");
//    }


    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public String editUser(User user) {
        return "/user.xhtml?faces-redirect=true";
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public String createUser() {
        return "/user.xhtml?faces-redirect=true";
    }

    public String saveUser() {
        userRepository.merge(this.user);
        return "/users.xhtml?faces-redirect=true";
    }
}