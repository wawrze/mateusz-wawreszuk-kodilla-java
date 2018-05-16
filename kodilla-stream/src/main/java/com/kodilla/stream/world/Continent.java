package com.kodilla.stream.world;

import java.util.List;

public class Continent {

    private final List<Country> countryList;

    public Continent(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Country> getCountryList(){
        List<Country> list = this.countryList;
        return list;
    }

}