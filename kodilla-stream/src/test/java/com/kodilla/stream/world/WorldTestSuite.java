package com.kodilla.stream.world;

import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given
        List<Continent> continents = new ArrayList<>();
        //first continent
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("17130875"));
        countries.add(new Country("2226762"));
        countries.add(new Country("29628342"));
        countries.add(new Country("15715903"));
        continents.add(new Continent(countries));
        //second continent
        countries = new ArrayList<>();
        countries.add(new Country("2678630"));
        countries.add(new Country("94225257"));
        countries.add(new Country("36330694"));
        countries.add(new Country("7326096"));
        countries.add(new Country("44664691"));
        continents.add(new Continent(countries));
        //third continent
        countries = new ArrayList<>();
        countries.add(new Country("4497800"));
        countries.add(new Country("42093116"));
        continents.add(new Continent(countries));
        //fourth continent
        countries = new ArrayList<>();
        countries.add(new Country("7957736"));
        countries.add(new Country("73628944"));
        countries.add(new Country("1043427"));
        continents.add(new Continent(countries));
        World world = new World(continents);
        //When
        BigDecimal expectedPeopleQuantity = new BigDecimal("379148273");
        BigDecimal actualPeopleQuantity = world.getPeopleQuantity();
        //Then
        Assert.assertEquals(expectedPeopleQuantity,actualPeopleQuantity);
    }

}
