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
public class CategoryRepository {

    @Inject
    private ServletContext servletContext;

    private Connection conn;

    private Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public CategoryRepository(){
    }

    public CategoryRepository(Connection conn) throws SQLException {
        this.conn = conn;
    }

    @PostConstruct
    public void init() throws SQLException {
        this.conn = (Connection) servletContext.getAttribute("jdbcConnection");
    }



    public List<Category> getAllCategories() throws SQLException {
        List<Category> res = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select id,name from categories");

            while (rs.next()) {
                res.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        }catch(Exception e){
            logger.info("CategoryRepository.getAllCategories - Error with createStatement : "+e);
        }
        return res;
    }


    public void saveCategory(Category category) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update categories set name = ? where id = ?;")) {
            stmt.setString(1, category.getName());
            stmt.setInt(2, category.getId());
            stmt.execute();
        }
    }

    public void deleteCategory(Category category) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from categories where id = ?;")) {
            stmt.setInt(1, category.getId());
            stmt.execute();
        }
    }

    public void addCategory(Category category) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into categories (name) values (?);")) {
            stmt.setString(1, category.getName());
            stmt.execute();
        }
    }
}
