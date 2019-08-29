package ru.geekbrains.persist.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.UserRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
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
    public void delete(Order order){

        try {
            Order attached =findById(order.getId());
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
