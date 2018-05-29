package com.kodilla.good.patterns.challenges.orders.items;

public class Slippers implements Product {

    private String name;
    private double price;
    private int size;

    public Slippers(String name, double price, int size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getPrice(){
        return price;
    }

    public int getSize() {
        return size;
    }

}