package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightsFinder {

        public static boolean findFlight(Flight flight) throws RouteNotFoundException{
            Map<String, Boolean> airports = new HashMap<>();
            airports.put("Warszawa",true);
            airports.put("Modlin",true);
            airports.put("Poznan",true);
            airports.put("Krakow",true);
            airports.put("Katowice",true);
            airports.put("Lodz",true);
            airports.put("Gdansk",true);
            airports.put("Bydgoszcz",true);
            airports.put("Rzeszow",true);
            airports.put("Szczecin",true);
            airports.put("Zielona Gora",true);
            airports.put("Bialystok",false);
            airports.put("Czestochowa",false);
            airports.put("Gdynia",false);
            airports.put("Koszalin",false);
            airports.put("Olsztyn",false);
            airports.put("Slupsk",false);
            airports.put("Wroclaw",false);
            airports.put("Elblag",false);
            airports.put("Gliwice",false);
            airports.put("Gubin",false);
            airports.put("Jelenia Gora",false);
            airports.put("Malbork",false);
            airports.put("Nysa",false);
            airports.put("Pila",false);
            if(!airports.containsKey(flight.getArrivalAirport()))
                throw new RouteNotFoundException(flight.getArrivalAirport());
            if(!airports.containsKey(flight.getDepartureAirport()))
                throw new RouteNotFoundException(flight.getDepartureAirport());
            return airports.get(flight.getDepartureAirport()) && airports.get(flight.getArrivalAirport());
        }

}