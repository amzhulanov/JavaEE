package ru.geekbrains.persist.item;


import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="num_order",unique = true,nullable = false)
    private String num_order;

    @Column(name="buyer",unique = true,nullable = false)
    private String buyer;

    public Order() {    }

    public Order(Integer id, String num_order, String buyer) {
        this.id = id;
        this.num_order = num_order;
        this.buyer = buyer;
    }

    public Integer getId() {
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
