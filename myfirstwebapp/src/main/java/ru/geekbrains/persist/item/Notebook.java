package ru.geekbrains.persist.item;

public class Notebook extends Item {
    private String color;
    private String diagonal;

    public Notebook(String name, String cost, String model, String vendor, String color, String diagonal) {
        super(name, cost, model, vendor);
        this.color = color;
        this.diagonal = diagonal;
    }


}
