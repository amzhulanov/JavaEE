package ru.geekbrains.persist.item;

public class Order {

    private Integer id;
    private String num_order;
    private String buyer;

    public Order() {
        this.id = -1;
    }

    public Order(Integer id, String num_order, String buyer) {
        this.id = id;
        this.num_order = num_order;
        this.buyer = buyer;
    }

    public Integer getId() {
        return id;
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
