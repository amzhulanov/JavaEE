package ru.geekbrains.jsf;

import ru.geekbrains.persist.item.Order;

public class OrderRepr {

    private int id;

    private String num_order;

    private String buyer;

    public OrderRepr() {
    }

    public OrderRepr(Order order) {
        this.id = order.getId();
        this.num_order = order.getNum_order();
        this.buyer = order.getBuyer();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum_order() {
        return num_order;
    }

    public void setNum_order(String num_order) {
        this.num_order = num_order;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}
