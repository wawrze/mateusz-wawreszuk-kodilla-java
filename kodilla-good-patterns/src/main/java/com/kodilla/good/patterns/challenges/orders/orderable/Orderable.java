package com.kodilla.good.patterns.challenges.orders.orderable;

import com.kodilla.good.patterns.challenges.orders.User;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Orderable {

    LocalDate getDateCreated();
    LocalTime getTimeCreated();
    double getValue();
    User getUser();
    boolean order();

}
