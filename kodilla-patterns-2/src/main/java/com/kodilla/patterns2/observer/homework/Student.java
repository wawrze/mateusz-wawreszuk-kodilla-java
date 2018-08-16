package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class Student implements Observable {

    private final String name;
    private final Deque<Homework> homeworks;
    private Mentor mentor;

    public Student(String name, Mentor mentor) {
        homeworks = new ArrayDeque<>();
        this.name = name;
        this.mentor = mentor;
    }

    @Override
    public void addObserver(Observer observer) {
        mentor = (Mentor) observer;
    }

    @Override
    public void changeObserver(Observer observer) {
        mentor = (Mentor) observer;
    }

    @Override
    public void notifyObserver() {
        mentor.update(homeworks.peekFirst());
    }

    public void addHomework(Homework homework) {
        homeworks.push(homework);
        notifyObserver();
    }

}