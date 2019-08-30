package ru.geekbrains.persist.item;

import javax.persistence.*;

@Entity
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",unique = true,nullable = false)
    private String name;

    @Column(name="category",unique = true,nullable = false)
    private String category;

    @Column(name="vendor",unique = true,nullable = false)
    private String vendor;

    public Item() {

    }

    public Item(Integer id, String name, String vendor, String category) {
        this.id = id;
        this.name = name;
        this.vendor = vendor;
        this.category = category;
    }

    public Integer getId() {
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
