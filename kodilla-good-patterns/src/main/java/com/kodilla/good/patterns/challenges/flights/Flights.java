package com.kodilla.good.patterns.challenges.flights;

import java.util.Scanner;

public class Flights {

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many flights do you want to put in data base?");
        int flights = sc.nextInt();
        FlightsDB.initiateDB(flights);
        (new Menu()).start();
    }

}