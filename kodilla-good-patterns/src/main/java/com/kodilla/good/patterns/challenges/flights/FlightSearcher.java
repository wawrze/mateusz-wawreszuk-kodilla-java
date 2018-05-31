package com.kodilla.good.patterns.challenges.flights;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.MINUTES;

public class FlightSearcher {

    public static List<Flight> searchDepartures(Airport airport){
        List<Flight> foundFlights = FlightsDB.getFlights().entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(flight -> flight.getDepartureAirport().equals(airport))
                .collect(Collectors.toList());
        return foundFlights;
    }

    public static List<Flight> searchArrivals(Airport airport){
        List<Flight> foundFlights = FlightsDB.getFlights().entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(flight -> flight.getArrivalAirport().equals(airport))
                .collect(Collectors.toList());
        return foundFlights;
    }

    public static List<Flight> searchFlightWithTransfer(Airport departure, Airport transfer, Airport arrival, int maxWaitingTime){
        List<Flight> foundFlights = new LinkedList<>();
        List<Flight> tmp = FlightsDB.getFlights().entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(flight -> flight.getDepartureAirport().equals(departure))
                .filter(flight -> flight.getArrivalAirport().equals(transfer))
                .collect(Collectors.toList());
        for(Flight f : tmp){
            System.out.println("Checking: " + f);
            FlightsDB.getFlights().entrySet().stream()
                    .map(entry -> entry.getValue())
                    .filter(flight -> flight.getDepartureAirport().equals(transfer))
                    .filter(flight -> flight.getArrivalAirport().equals(arrival))
                    .filter(flight -> flight.getDepartureTime().isAfter(f.getArrivalTime()))
                    .filter(flight -> f.getArrivalTime().until(flight.getDepartureTime(),MINUTES) >= 5)
                    .filter(flight -> f.getArrivalTime().until(flight.getDepartureTime(),MINUTES) <= maxWaitingTime)
                    .forEach(flight -> foundFlights.add(new TransferFlight(f,flight)));
        }
        return foundFlights;
    }

}
