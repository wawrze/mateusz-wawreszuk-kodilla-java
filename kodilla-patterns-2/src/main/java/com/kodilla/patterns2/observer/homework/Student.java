package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Student implements Observable {

    private final String name;
    private final Deque<Homework> homeworks;
    private List<Observer> observers;

    public Student(String name, Mentor mentor) {
        homeworks = new ArrayDeque<>();
        this.name = name;
        this.observers = new ArrayList<>();
        this.observers.add(mentor);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(homeworks.peekLast()));
    }

    public void addHomework(Homework homework) {
        homeworks.push(homework);
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public Deque<Homework> getHomeworks() {
        return homeworks;
    }

    public List<Observer> getObservers() {
        return observers;
    }

}