package com.kodilla.good.patterns.challenges.orders.orderable;

import com.kodilla.good.patterns.challenges.orders.User;
import com.kodilla.good.patterns.challenges.orders.items.Product;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Basket implements Orderable {

    private Map<Product, Integer> products;
    private LocalTime timeCreated;
    private LocalDate dateCreated;
    private User user;

    public Basket(User user) {
        this.products = new HashMap<>();
        timeCreated = LocalTime.now();
        dateCreated = LocalDate.now();
        this.user = user;
    }

    public void addProduct(Product product, int quantity){
        products.put(product,quantity);
    }

    @Override
    public double getValue(){
        return products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue().intValue())
                .sum();
    }

    @Override
    public LocalDate getDateCreated(){
        return dateCreated;
    }

    @Override
    public LocalTime getTimeCreated(){
        return timeCreated;
    }

    @Override
    public boolean order(){
        return true;
    }

    @Override
    public User getUser() {
        return user;
    }
}