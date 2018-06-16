package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bigmac {

    private boolean isBunWithSesame;
    private int burgers;
    private String sauce;
    private List<String> ingredients;

    public static class BigmacBuilder {

        private boolean isBunWithSesame;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder isBunWithSesame(boolean bun) {
            this.isBunWithSesame = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if(burgers < 1)
                throw new IllegalStateException("There has to be at least one burger!");
            if(burgers > 5)
                throw new IllegalStateException("To many burgers!");
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if(!sauce.equals("standard") || sauce.equals("1000 Islands") || sauce.equals("Barbecue"))
                throw new IllegalStateException("Incorrect sauce!");
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            switch(ingredient) {
                case "salad":
                case "onion":
                case "bacon":
                case "cucumber":
                case "chili peppers":
                case "mushrooms":
                case "shrimps":
                case "cheese":
                    ingredients.add(ingredient);
                    break;
                default:
                    throw new IllegalStateException("Incorrect ingredient!");
            }
            return this;
        }

        public Bigmac build() {
            return new Bigmac(isBunWithSesame, burgers, sauce, ingredients);
        }

    }

    private Bigmac(boolean bun, int burgers, String sauce, List<String> ingredients) {
        this.isBunWithSesame = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public boolean getBun() {
        return isBunWithSesame;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac: " + (isBunWithSesame ? "bun with sesame" : "bun without sesame") + ", " + burgers + " burgers, "
                + sauce + " sauce and additional ingredients: " + ingredients.stream()
                .collect(Collectors.joining(", ")) + ".";
    }

}