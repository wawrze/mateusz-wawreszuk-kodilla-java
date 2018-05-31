package com.kodilla.good.patterns.challenges.food2door;

public class GlutenFreeShop implements Provider {

    @Override
    public boolean process(Product product, int quantity) {
        double orderWeight = product.getWeight() * quantity;
        double orderValue = product.getPrice() * quantity;
        if(orderValue < 20){
            System.out.println("You have to order more products! Value is too low!");
            return false;
        }
        if(orderWeight > 100){
            System.out.println("You have to order less products! Weight is too high!");
            return false;
        }
        deliver(product,quantity);
        return true;
    }

    private void deliver(Product product, int quantity) {
        System.out.println("" + quantity + " of " + product.getName() + " are in their way to customer.");
    }

}