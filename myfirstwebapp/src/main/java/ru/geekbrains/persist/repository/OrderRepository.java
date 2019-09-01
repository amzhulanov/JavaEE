package ru.geekbrains.persist.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.item.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class OrderRepository {

    private Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @PersistenceContext(unitName = "ds")
    protected EntityManager em;

    public OrderRepository(){ }

    @Transactional
    public Order merge(Order order){
        return em.merge(order);
    }



    @Transactional
    public void delete(int id){

        try {
            Order attached =findById(id);
            if (attached!=null){

                em.remove(attached);
            }
        } catch (Exception e) {
            logger.error("Error with entity class", e);
            throw new IllegalStateException(e);
        }
    }

    public Order findById(int id) {
        return em.find(Order.class, id);
    }

    public boolean existsById(int id) {
        return findById(id) != null;
    }

    public List<Order> getAllOrders() {
        return em.createQuery("from Order ").getResultList();
    }


}
