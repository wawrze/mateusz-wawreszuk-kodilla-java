package com.kodilla.good.patterns.challenges.orders;

import com.kodilla.good.patterns.challenges.orders.orderable.Orderable;

public class OrderRequest {

    private int orderNumber;
    private Orderable orderItem;
    private User user;

    public OrderRequest(int orderNumber, Orderable orderItem, User user) {
        this.orderNumber = orderNumber;
        this.orderItem = orderItem;
        this.user = user;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Orderable getOrderItem() {
        return orderItem;
    }

    public User getUser() {
        return user;
    }

}
