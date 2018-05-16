package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class World {

    private final List<Continent> continentList;

    public World(List<Continent> continentList) {
        this.continentList = continentList;
    }

    public BigDecimal getPeopleQuantity(){
        return this.continentList.stream()
                .flatMap(continent -> continent.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO,(sum,actual) -> sum = sum.add(actual));
    }

}