package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.item.Order;
import ru.geekbrains.persist.item.OrderRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped// параметр для определения время жизни Bean`а
@Named
public class OrdersBean implements Serializable {

    @Inject
    private OrderRepository orderRepository;

    private Logger logger = LoggerFactory.getLogger(OrdersBean.class);

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public String editOrder(Order order) {
        this.order=order;
        return "/order.xhtml?faces-redirect=true";
    }

    public void deleteOrder(Order order) {

        orderRepository.delete(order);
    }

    public String createOrder() {

        this.order=new Order();
        return "/order.xhtml?faces-redirect=true";
    }

    public String saveOrder() {
        orderRepository.merge(this.order);
        return "/orders.xhtml?faces-redirect=true";
    }

}
