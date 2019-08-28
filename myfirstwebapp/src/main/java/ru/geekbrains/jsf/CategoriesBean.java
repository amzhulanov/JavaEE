package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.item.Category;
import ru.geekbrains.persist.item.CategoryRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped// параметр для определения время жизни Bean`а
@Named
public class CategoriesBean implements Serializable {
    private CategoryRepository categoryRepository;

    private Logger logger = LoggerFactory.getLogger(CategoriesBean.class);

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @PostConstruct
    public void init() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        categoryRepository = (CategoryRepository) servletContext.getAttribute("categoryRepository");
    }

    public String openCategory(){
        return "/categories.xhtml?faces-redirect=true";
    }

    public List<Category> getAllCategories() throws SQLException {
        return categoryRepository.getAllCategories();

    }

    public String editCategory(Category category) {
        this.category = category;
        return "/categories.xhtml?faces-redirect=true";
    }

    public void deleteCategory(Category category) throws SQLException {
        categoryRepository.deleteCategory(category);

    }

    public String saveCategory(Category category) throws SQLException {
        if (this.category.getId()!=-1){
            categoryRepository.saveCategory(this.category);
        }else{
            categoryRepository.addCategory(this.category);
        }

        return "/categories.xhtml?faces-redirect=true";
    }

    public String addCategory() {
        this.category = new Category();
        return "/categories.xhtml?faces-redirect=true";
    }
}