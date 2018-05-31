package com.kodilla.good.patterns.challenges.food2door;

public class Dairy implements Product {

    private String name;
    private double price;
    private double weight;
    private boolean isVegan;
    private double fatContent;

    public Dairy(String name, double price, double weight, boolean isVegan, double fatContent) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.isVegan = isVegan;
        this.fatContent = fatContent;
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

    public boolean isVegan() {
        return isVegan;
    }

    public double getFatContent() {
        return fatContent;
    }

}
