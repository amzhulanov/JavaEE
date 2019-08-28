package ru.geekbrains.persist.item;

public abstract class Item  {
   // private Integer id;
    private String name;
    private String cost;
    private String model;
    private String vendor;

    public Item(String name, String cost, String model, String vendor) {
       // this.id=id;
        this.name=name;
        this.model = model;
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
