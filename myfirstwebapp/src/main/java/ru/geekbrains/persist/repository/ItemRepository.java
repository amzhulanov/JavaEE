package ru.geekbrains.persist.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.item.Item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ItemRepository {
    private Logger logger = LoggerFactory.getLogger(ItemRepository.class);

    @PersistenceContext(unitName = "ds")
    protected EntityManager em;

    public ItemRepository(){ }

    @Transactional
    public Item merge(Item item){
        return em.merge(item);
    }

    @Transactional
    public void delete(int id){

        try {
            Item attached =findById(id);
            if (attached!=null){
                em.remove(attached);
            }
        } catch (Exception e) {
            logger.error("Error with entity class", e);
            throw new IllegalStateException(e);
        }
    }

    public Item findById(int id) {
        return em.find(Item.class, id);
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    public List<Item> getAllItems() {
        return em.createQuery("from Item ").getResultList();
    }


}