package ru.geekbrains.persist.item;

public class Category {
    private Integer id;
    private String name;

    public Category() {
        this.id = -1;
    }

    public Category(Integer id, String name) {
        this.id=id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}
