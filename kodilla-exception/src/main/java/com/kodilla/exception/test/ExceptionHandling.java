package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main (String args[]){

        try{
            SecondChallenge secondChallenge = new SecondChallenge();
            System.out.println(secondChallenge.probablyIWillThrowException(10,0));
        }
        catch(Exception e){
            System.out.println("Exception caught.");
        }
        finally{
            System.out.println("End of program.");
        }

    }

}
