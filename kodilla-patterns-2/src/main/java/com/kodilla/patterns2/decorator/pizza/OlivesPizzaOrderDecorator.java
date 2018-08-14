package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OlivesPizzaOrderDecorator extends AbstractPizzaOrderDecorator {

    public OlivesPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(1.5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + olives";
    }

}