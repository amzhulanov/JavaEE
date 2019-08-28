package ru.geekbrains.persist;


public class Menu {
    private Integer id;
    private String item;
    private String value;

    public Menu(int id,String item, String value) {
        this.id=id;
        this.item = item;
        this.value = value;

    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
