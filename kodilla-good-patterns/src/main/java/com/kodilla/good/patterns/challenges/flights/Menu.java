package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);

    public void start() {
        String o;
        do {
            printMenu();
            o = sc.nextLine();
            option(o);
        } while (!o.equals("x"));
    }

    private void printMenu() {
        this.cls();
        System.out.println("Choose option:");
        System.out.println("(1) Print airport list");
        System.out.println("(2) Print flight list");
        System.out.println("(3) Search by departure airport");
        System.out.println("(4) Search by arrival airport");
        System.out.println("(5) Search flight with transfer");
        System.out.println("(x) Exit");
    }

    private void option(String o) {
        List<Airport> airports = FlightsDB.getAirportList();
        List<Flight> searchResult = null;
        switch (o) {
            case "1":
                FlightsDB.printAirports();
                waitForEnter();
                return;
            case "2":
                FlightsDB.printAllFlights();
                waitForEnter();
                return;
            case "3":
                System.out.print("Searching flights by departure. ");
                searchResult = FlightSearcher.searchDepartures(getAirport(airports));
                break;
            case "4":
                System.out.print("Searching flights by arrivals. ");
                searchResult = FlightSearcher.searchArrivals(getAirport(airports));
                break;
            case "5":
                Airport arrival,departure,transfer;
                System.out.print("Searching flights with transfer. Choose departure airport. ");
                departure = getAirport(airports);
                airports.remove(departure);
                System.out.print("Choose transfer airport. ");
                transfer = getAirport(airports);
                airports.remove(transfer);
                System.out.print("Choose arrival airport. ");
                arrival = getAirport(airports);
                int minutes = getWaitingTime();
                searchResult = FlightSearcher.searchFlightWithTransfer(departure,transfer,arrival,minutes);
                break;
            case "x":
                return;
            default:
                return;
        }
        if(searchResult == null || searchResult.isEmpty()){
            System.out.println("\nNo flights found.");
        }
        else{
            System.out.println("\nFound flights:");
            searchResult.stream().forEach(System.out::println);
        }
        waitForEnter();
    }

    private Airport getAirport(List<Airport> airports){
        Airport airport;
        System.out.println("Possible airports:");
        airports.stream().forEach(System.out::println);
        do{
            System.out.print("\nEnter airport name: ");
            airport = new Airport(sc.nextLine());
            for(Airport a : airports)
                if(airport.equals(a))
                    return a;
        }while(true);
    }

    private int getWaitingTime(){
        int minutes = 0;
        do {
            System.out.print("Enter maximum transfer time (in minutes - from 5 to 120): ");
            try {
                minutes = Integer.valueOf(sc.nextLine());
            }
            catch(NumberFormatException e){}
        }while(minutes < 5 || minutes > 120);
        return minutes;
    }

    private void cls() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    private void waitForEnter() {
        System.out.println("\nPress \"Enter\" to continue.");
        sc.nextLine();
    }

}