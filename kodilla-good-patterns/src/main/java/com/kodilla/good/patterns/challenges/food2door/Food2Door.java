package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;
import java.util.List;

public class Food2Door {

    private static List<Provider> providers;

    public static void main(String args[]){
        providers = new ArrayList<>();
        providers.add(new ExtraFoodShop());
        providers.add(new HealthyShop());
        providers.add(new GlutenFreeShop());

        order(providers.get(0),new Dairy("Butter", 6.5, 0.2, false, 0.83),1);
        order(providers.get(0),new Dairy("Milk", 2.0, 0.98, false, 0.02),10);
        order(providers.get(1),new Vegetable("Lettuce", 2.5, 0.15, "ice"),50);
        order(providers.get(1),new Vegetable("Carrot", 0.5, 0.2, "red"),10);
        order(providers.get(2),new Dairy("Soy milk", 4.5, 0.95, true, 0.0),1);
        order(providers.get(2),new Vegetable("Pepper", 3.0, 0.15, "sweet"),1500);
    }

    public static void order(Provider provider, Product product, int quantity){
        boolean isOrdered = provider.process(product,quantity);
        if(isOrdered)
            System.out.println("Order placed.");
        else
            System.out.println("Can't place order!");
    }

}