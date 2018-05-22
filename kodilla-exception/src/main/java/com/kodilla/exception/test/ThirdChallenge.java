package com.kodilla.exception.test;

import java.util.Scanner;

public class ThirdChallenge {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter departure airport name: ");
        String departure = sc.nextLine();
        System.out.println("Enter arrival airport name: ");
        String arrival = sc.nextLine();
        Flight flight = new Flight(departure,arrival);
        try {
            if(FlightsFinder.findFlight(flight))
                System.out.println("The flight is possible.");
            else
                System.out.println("There is no such flight.");
        }
        catch (RouteNotFoundException e){
            System.out.println("Airport " + e.getMessage() + " doesn't exist!");
        }
    }

}