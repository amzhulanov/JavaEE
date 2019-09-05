package ru.geekbrains.persist.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.item.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class CategoryRepository {
    private Logger logger = LoggerFactory.getLogger(CategoryRepository.class);

    @PersistenceContext(unitName = "ds")
    protected EntityManager em;

    public CategoryRepository(){
    }

    @Transactional
    public Category merge(Category category){
        return em.merge(category);
    }

    @Transactional
    public void delete(Category category){

        try {
            Category attached =findById(category.getId());
            if (attached!=null){
                em.remove(attached);
            }
        } catch (Exception e) {
            logger.error("Error with entity class", e);
            throw new IllegalStateException(e);
        }
    }

    public Category findById(int id) {
        return em.find(Category.class, id);
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    public List<Category> getAllCategories() {
        return em.createQuery("from Category ").getResultList();
    }
}
