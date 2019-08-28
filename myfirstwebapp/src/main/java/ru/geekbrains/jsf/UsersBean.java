package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped// параметр для определения время жизни Bean`а
@Named
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

    @PostConstruct
    public void init() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        userRepository = (UserRepository) servletContext.getAttribute("userRepository");
    }


    public List<User> getAllUsers() throws SQLException {
        return userRepository.getAllUsers();

    }

    public String editUser(User user) {
        this.user = user;
        return "/user.xhtml?faces-redirect=true";
    }

    public void deleteUser(User user) throws SQLException {
        userRepository.delete(user);

    }

    public String createUser() {
        this.user = new User();
        return "/user.xhtml?faces-redirect=true";
    }

    public String saveUser() throws SQLException {
        if (this.user.getId()!=-1){
            userRepository.save(this.user);
        }else{
            userRepository.insert(this.user);
        }

        return "/users.xhtml?faces-redirect=true";
    }
}