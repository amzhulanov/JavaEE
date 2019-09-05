package ru.geekbrains.persist.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.item.Garbage;
import ru.geekbrains.persist.item.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class GarbageRepository {

    private Logger logger = LoggerFactory.getLogger(GarbageRepository.class);

    @PersistenceContext(unitName = "ds")
    protected EntityManager em;

    public GarbageRepository(){ }

    @Transactional
    public Garbage merge(Garbage garbage){
        return em.merge(garbage);
    }

    @Transactional
    public void delete(int id){

        try {
            Garbage attached =findById(id);
            if (attached!=null){
                em.remove(attached);
            }
        } catch (Exception e) {
            logger.error("Error with entity class", e);
            throw new IllegalStateException(e);
        }
    }

    public Garbage findById(int id) {
        return em.find(Garbage.class, id);
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }


    public List<Garbage> getAllGarbages() {
        return em.createQuery("from Garbage ").getResultList();
    }

}
