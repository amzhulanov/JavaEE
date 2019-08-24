package ru.geekbrains.persist.item;

public class Item {
    private Integer id;
    private String name;
   // private Double cost;
    private String category;
    private String vendor;

    public Item(Integer id, String name, String vendor, String category) {
        this.id = id;
        this.name = name;
        // this.cost=cost;
        this.vendor = vendor;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }*/

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
