package com.codecool.items;

public class Item {

    private int id;
    private String name;
    private double price;

    public Item(String name, double price) {
        this.id = id++;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
