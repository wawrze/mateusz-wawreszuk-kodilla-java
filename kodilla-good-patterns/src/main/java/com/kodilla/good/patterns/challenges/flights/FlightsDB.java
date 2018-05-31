package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalTime;
import java.util.*;

public class FlightsDB {

    private static Random r = new Random();

    private static Map<Integer,Flight> flightList = new HashMap<>();
    private static List<Airport> airportList = new ArrayList<>();

    public static Map<Integer,Flight> getFlights(){
        return flightList;
    }

    public static void addFlight(Flight flight){
        flightList.put(flight.hashCode(),flight);
    }

    public static void removeFlight(Flight flight){
        flightList.remove(flight.hashCode());
    }

    public static void printAllFlights(){
        flightList.entrySet().stream()
                .map(entry -> entry.getValue())
                .forEach(System.out::println);
    }

    public static void printAirports(){
        airportList.stream().forEach(System.out::println);
    }

    public static List<Airport> getAirportList(){
        return new ArrayList<>(airportList);
    }

    public static void initiateDB(int flightsQuantity){
        int flightNumber = -1;
        airportList.add(new Airport("Warszawa"));
        airportList.add(new Airport("Wroclaw"));
        airportList.add(new Airport("Krakow"));
        airportList.add(new Airport("Gdynia"));
        airportList.add(new Airport("Bydgoszcz"));
        airportList.add(new Airport("Katowice"));
        airportList.add(new Airport("Modlin"));
        airportList.add(new Airport("Szczecin"));
        airportList.add(new Airport("Poznan"));
        for(int i = 0;i < flightsQuantity;i++){
            Airport departure = getAirport(null);
            Airport arrival = getAirport(departure);
            LocalTime dTime = getTime();
            LocalTime aTime = dTime.plusMinutes(r.nextInt(90) + 30);
            flightNumber++;
            addFlight(new Flight(flightNumber, departure,arrival,dTime,aTime));
        }
    }

    private static Airport getAirport(Airport airport){
        List<Airport> airports = getAirportList();
        airports.remove(airport);
        return airports.get(r.nextInt(airports.size()));
    }

    private static LocalTime getTime(){
        return LocalTime.of(r.nextInt(16) + 6,r.nextInt(60));
    }

}