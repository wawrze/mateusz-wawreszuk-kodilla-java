package com.kodilla.good.patterns.challenges.food2door;

public class ExtraFoodShop implements Provider {

    @Override
    public boolean process(Product product, int quantity){
        double orderValue = product.getPrice() * quantity;
        if(orderValue > 10) {
            placeOrder(product, quantity);
            return true;
        }
        else{
            System.out.println("Order value is too low!");
            return false;
        }
    }

    private void placeOrder(Product product, int quantity){
        System.out.println("Delivering " + quantity + " of " + product.getName() + " to customer.");
    }

}
