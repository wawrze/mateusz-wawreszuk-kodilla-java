package com.kodilla.good.patterns.challenges.food2door;

public class Vegetable implements Product{

    private String name;
    private double price;
    private double weight;
    private String type;

    public Vegetable(String name, double price, double weight, String type) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}