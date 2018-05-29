package com.kodilla.good.patterns.challenges.orders.items;

public class Game implements Product {

    private String name;
    private double price;
    private String kind;

    public Game(String name, double price, String kind) {
        this.name = name;
        this.price = price;
        this.kind = kind;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getPrice(){
        return price;
    }

    public String getKind() {
        return kind;
    }

}