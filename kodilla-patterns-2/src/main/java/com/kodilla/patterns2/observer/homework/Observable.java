package com.kodilla.patterns2.observer.homework;



public interface Observable {

    void addObserver(Observer observer);

    void notifyObserver();

    void changeObserver(Observer observer);

}