package ru.geekbrains.jsf;

import ru.geekbrains.persist.item.Item;

public class ItemRepr {

    private int id;

    private String name;

    private String category;

    private String vendor;

    public ItemRepr() {
    }

    public ItemRepr(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.category = item.getCategory();
        this.vendor = item.getVendor();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
