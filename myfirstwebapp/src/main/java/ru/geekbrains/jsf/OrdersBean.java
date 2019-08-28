package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.item.Order;
import ru.geekbrains.persist.item.OrderRepository;

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
public class OrdersBean implements Serializable {

    private OrderRepository orderRepository;

    private Logger logger = LoggerFactory.getLogger(OrdersBean.class);

    private Order order;


    public Order getOrder() {
        return order;
    }

    public void setCategory(Order order) {
        this.order = order;
    }

    @PostConstruct
    public void init() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        orderRepository = (OrderRepository) servletContext.getAttribute("orderRepository");
    }

    //метод для открытия страницы заказов
    public String openOrder() {
        return "/orders.xhtml?faces-redirect=true";
    }

    public List<Order> getAllOrders() throws SQLException {
        return orderRepository.getAllOrders();

    }

    public String editOrder(Order order) {
        this.order = order;
        return "/order.xhtml?faces-redirect=true";
    }

    public void deleteOrder(Order order) throws SQLException {
        orderRepository.deleteOrder(order);

    }

    public String saveOrder(Order order) throws SQLException {
        if (this.order.getId() != -1) {
            orderRepository.saveOrder(this.order);
        } else {
            orderRepository.addOrder(this.order);
        }

        return "/orders.xhtml?faces-redirect=true";
    }

    public String addOrder() {
        this.order = new Order();
        return "/order.xhtml?faces-redirect=true";
    }

}
