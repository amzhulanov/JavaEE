package ru.geekbrains.jsf;

import ru.geekbrains.persist.item.Order;
import ru.geekbrains.persist.repository.OrderRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class OrderService {

    @EJB
    private OrderRepository orderRepository;

    @Transactional
    public Order merge(OrderRepr order) {
        return orderRepository.merge(new Order(order));
    }

    @Transactional
    public void delete(int id) {
        orderRepository.delete(id);
    }

    @Transactional
    public OrderRepr findById(int id) {
        return new OrderRepr(orderRepository.findById(id));
    }

    @Transactional
    public boolean existsById(int id) {
        return orderRepository.findById(id) != null;
    }

    @Transactional
    public List<OrderRepr> getAllOrders() {
        return orderRepository.getAllOrders().stream()
                .map(OrderRepr::new)
                .collect(Collectors.toList());
    }
}
