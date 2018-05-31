package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalTime;
import java.util.Objects;

public class Flight {

    protected final String flightNumber;
    protected final Airport departureAirport;
    protected final Airport arrivalAirport;
    protected final LocalTime departureTime;
    protected final LocalTime arrivalTime;

    public Flight(final int flightNumber, final Airport departureAirport, final Airport arrivalAirport,
                  final LocalTime departureTime, final LocalTime arrivalTime) {
        this.flightNumber = ("" + departureAirport.getName().charAt(0) + departureAirport.getName().charAt(1)
                + departureAirport.getName().charAt(2) + flightNumber).toUpperCase();
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(getFlightNumber(), flight.getFlightNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlightNumber());
    }

    @Override
    public String toString(){
        return "Flight " + flightNumber + ", departure: " + departureAirport + " ("
                + toTwoDigits(departureTime.getHour()) + ":" + toTwoDigits(departureTime.getMinute())
                + "), arrival: " + arrivalAirport + " (" + toTwoDigits(arrivalTime.getHour())
                + ":" + toTwoDigits(arrivalTime.getMinute()) + ")";
    }

    protected String toTwoDigits(int number){
        if(number < 10)
            return "0" + number;
        else
            return "" + number;
    }

}