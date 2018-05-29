package com.kodilla.good.patterns.challenges.orders.confirmation;

import com.kodilla.good.patterns.challenges.orders.User;

public class orderEmailConfirmationService implements OrderConfirmationService{

    @Override
    public void send(User user){
        System.out.println("E-mail send to: " + user.geteMail());
    }

}
