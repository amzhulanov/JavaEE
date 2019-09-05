package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.item.Category;
import ru.geekbrains.persist.repository.CategoryRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped// параметр для определения время жизни Bean`а
@Named
public class CategoriesBean implements Serializable {
    @Inject
    private CategoryRepository categoryRepository;

    private Logger logger = LoggerFactory.getLogger(CategoriesBean.class);

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setItem(Category category) {
        this.category = category;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    public String editCategory(Category category) {
        this.category=category;
        return "/category.xhtml?faces-redirect=true";
    }

    public void deleteCategory(Category category) {

        categoryRepository.delete(category);
    }

    public String createCategory() {

        this.category=new Category();
        return "/category.xhtml?faces-redirect=true";
    }

    public String saveCategory() {
        categoryRepository.merge(this.category);
        return "/categories.xhtml?faces-redirect=true";
    }
}