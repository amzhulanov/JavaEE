package ru.geekbrains.persist.item;


import ru.geekbrains.jsf.GarbageRepr;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "garbage")
public class Garbage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type", unique = true, nullable = false) //type = item or order
    private String type;

    @Column(name = "name", unique = true, nullable = true)
    private String name;

    @Column(name = "category", unique = true, nullable = true)
    private String category;

    @Column(name = "vendor", unique = true, nullable = true)
    private String vendor;

    @Column(name = "num_order", unique = true, nullable = true)
    private String num_order;

    @Column(name = "buyer", unique = true, nullable = true)
    private String buyer;

    public Garbage() {

    }

    public Garbage(String type, String name, String category, String vendor, String num_order, String buyer) {
        this.type = type;
        this.name = name;
        this.category = category;
        this.vendor = vendor;
        this.num_order = num_order;
        this.buyer = buyer;
    }

    public Garbage(GarbageRepr garbage) {
        this.type = garbage.getType();
        this.name = garbage.getName();
        this.category = garbage.getCategory();
        this.vendor = garbage.getVendor();
        this.num_order = garbage.getNum_order();
        this.buyer = garbage.getBuyer();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
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