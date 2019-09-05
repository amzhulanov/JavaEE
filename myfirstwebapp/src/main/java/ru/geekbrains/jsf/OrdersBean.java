package ru.geekbrains.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Stateless
@Named
public class OrdersBean implements Serializable {

    @Inject
    private OrderService orderService;

    @Inject
    private GarbageService garbageService;

    private Logger logger = LoggerFactory.getLogger(OrdersBean.class);

    private OrderRepr order;

    public OrderRepr getOrder() {
        return order;
    }

    public void setOrder(OrderRepr order) {
        this.order = order;
    }

    public List<OrderRepr> getAllOrders() {return orderService.getAllOrders();}

    public String editOrder(OrderRepr order) {
        this.order=order;
        return "/order.xhtml?faces-redirect=true";
    }

    public void deleteOrder(OrderRepr order) {
        garbageService.merge(new GarbageRepr(order));
        orderService.delete(order.getId());}

    public String createOrder() {
        this.order=new OrderRepr();
        return "/order.xhtml?faces-redirect=true";
    }

    public String saveOrder() {
        orderService.merge(this.order);
        return "/orders.xhtml?faces-redirect=true";
    }
//    public String saveOrder(int id) {
//        orderService.merge(this.order);
//        return "/orders.xhtml?faces-redirect=true";
//    }

}
