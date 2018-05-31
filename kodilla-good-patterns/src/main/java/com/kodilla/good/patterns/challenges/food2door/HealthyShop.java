package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop implements Provider {

    @Override
    public boolean process(Product product, int quantity) {
        double orderWeight = product.getWeight() * quantity;
        if (orderWeight < 50) {
            send(product,quantity);
            return true;
        } else {
            System.out.println("Ordered products are too heavy!");
            return false;
        }
    }

    private void send(Product product, int quantity) {
        System.out.println("Sending " + quantity + " of " + product.getName() + " to customer.");
    }

}
