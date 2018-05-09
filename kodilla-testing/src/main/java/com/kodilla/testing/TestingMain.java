package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;


public class TestingMain {

    public static void main(String[] args){

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser"))
            System.out.println("test OK");
        else
            System.out.println("Error!");

        if (Calculator.add(1,2) == 3)
            System.out.println("add: test OK");
        else
            System.out.println("add: Error!");

        if (Calculator.subtract(3,2) == 1)
            System.out.println("subtract: test OK");
        else
            System.out.println("subtract: Error!");

    }

}