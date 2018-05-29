package com.kodilla.good.patterns.challenges.orders.ordersdb;

import com.kodilla.good.patterns.challenges.orders.orderable.Orderable;

import java.util.HashMap;
import java.util.Map;

public class SomeOrdersRepository implements OrderRepository{

    private Map<Integer,Orderable> orders;

    public SomeOrdersRepository(){
        this.orders = new HashMap<>();
    }

    @Override
    public void createOrder(int orderNumber, Orderable orderItem){
        orders.put(orderNumber,orderItem);
    }

    @Override
    public Orderable getOrder(int orderNumber){
        if(orders.containsKey(orderNumber))
            return orders.get(orderNumber);
        else
            return null;
    }

    @Override
    public boolean deleteOrder(int orderNumber){
        if(orders.containsKey(orderNumber)) {
            orders.remove(orderNumber);
            return true;
        }
        else
            return false;
    }

}
