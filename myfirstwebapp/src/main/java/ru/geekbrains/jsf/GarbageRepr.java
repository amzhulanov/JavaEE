package ru.geekbrains.jsf;

import ru.geekbrains.persist.item.Garbage;

public class GarbageRepr {

    private int id;

    private String type;

    private String name;

    private String category;

    private String vendor;

    private String num_order;

    private String buyer;

    public GarbageRepr(){
    }

    public GarbageRepr(ItemRepr item) {
        this.id = item.getId();
        this.type = "item";
        this.name = item.getName();
        this.category = item.getCategory();
        this.vendor = item.getVendor();
        this.num_order = null;
        this.buyer = null;
    }
    public GarbageRepr(OrderRepr order) {
        this.id = order.getId();
        this.type = "order";
        this.name = null;
        this.category = null;
        this.vendor = null;
        this.num_order = order.getNum_order();
        this.buyer = order.getBuyer();
    }

    public GarbageRepr(Garbage garbage) {
        this.id = garbage.getId();
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
