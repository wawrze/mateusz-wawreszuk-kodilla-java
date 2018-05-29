package com.kodilla.good.patterns.challenges.orders.ordersdb;

import com.kodilla.good.patterns.challenges.orders.orderable.Orderable;

public interface OrderRepository {

    void createOrder(int orderNumber, Orderable orderItem);
    Orderable getOrder(int orderNumber);
    boolean deleteOrder(int orderNumber);

}
