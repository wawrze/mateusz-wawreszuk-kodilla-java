package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(15), cost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        //When
        String description = pizzaOrder.getDescription();
        //Then
        Assert.assertEquals("Pizza", description);
    }

    @Test
    public void testDeepCrustPizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new DeepCrustPizzaOrderOrderDecorator(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(18), cost);
    }

    @Test
    public void testDeepCrustPizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new DeepCrustPizzaOrderOrderDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        Assert.assertEquals("Pizza /deep crust/", description);
    }

    @Test
    public void testThinCrustExtraCheesePizzaOrderGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new ThinCrustPizzaOrderOrderDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheesePizzaOrderDecorator(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        Assert.assertEquals(new BigDecimal(19), cost);
    }

    @Test
    public void testThinCrustExtraCheesePizzaOrderGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new ThinCrustPizzaOrderOrderDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheesePizzaOrderDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        Assert.assertEquals("Pizza /thin crust/ + extra cheese", description);
    }

    @Test
    public void testBasicPizzaOrderHamMushroomsOlivesOnionsPepperoniPeppersGetCost() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new HamPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new MushroomsPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new OlivesPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new PepperoniPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new PeppersPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new OnionsPizzaOrderDecorator(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getCost();
        BigDecimal expected = new BigDecimal(15)
                .add(new BigDecimal(2.5))
                .add(new BigDecimal(1))
                .add(new BigDecimal(1.5))
                .add(new BigDecimal(3))
                .add(new BigDecimal(2))
                .add(new BigDecimal(1));
        //Then
        Assert.assertEquals(expected, cost);
    }

    @Test
    public void testBasicPizzaOrderHamMushroomsOlivesOnionsPepperoniPeppersGetDescription() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizza();
        pizzaOrder = new HamPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new MushroomsPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new OlivesPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new PepperoniPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new PeppersPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new OnionsPizzaOrderDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        Assert.assertEquals("Pizza + ham + mushrooms + olives + pepperoni + peppers + onions", description);
    }

}