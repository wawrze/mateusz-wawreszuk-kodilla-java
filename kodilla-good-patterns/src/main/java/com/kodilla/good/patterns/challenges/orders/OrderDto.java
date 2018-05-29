package com.kodilla.good.patterns.challenges.orders;

public class OrderDto {

    private int orderNumber;
    private boolean isOrdered;

    public OrderDto(int orderNumber, boolean isOrdered) {
        if(orderNumber > 999 && orderNumber < 10000)
            this.orderNumber = orderNumber;
        else
            this.orderNumber = 0;
        this.isOrdered = isOrdered;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

}
