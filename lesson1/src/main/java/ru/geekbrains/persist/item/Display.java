package ru.geekbrains.persist.item;

public class Display extends Item {

    private String pixel;

    public Display(String name, String cost, String model, String vendor, String pixel) {
        super(name, cost, model, vendor);
        this.pixel = pixel;
    }
}
