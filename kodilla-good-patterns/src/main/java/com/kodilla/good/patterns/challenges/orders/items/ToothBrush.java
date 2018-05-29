package com.kodilla.good.patterns.challenges.orders.items;

public class ToothBrush implements Product {

    private String name;
    private double price;
    private String softness;

    public ToothBrush(String name, double price, String softness) {
        this.name = name;
        this.price = price;
        this.softness = softness;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getPrice(){
        return price;
    }

    public String getSoftness() {
        return softness;
    }

}