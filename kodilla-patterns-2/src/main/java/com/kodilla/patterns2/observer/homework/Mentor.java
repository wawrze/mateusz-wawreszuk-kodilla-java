package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class Mentor implements Observer {

    private final String name;
    private final Deque<Homework> homeworksToCheck;

    public Mentor(String name) {
        this.name = name;
        this.homeworksToCheck = new ArrayDeque<>();
    }

    @Override
    public void update(Homework homework) {
        homeworksToCheck.push(homework);
        System.out.println("New homework in queue (number: " + homework.getNumber() + ", student: "
                + homework.getStudent().getName() + ".");
    }

    public String getName() {
        return name;
    }

    public Deque<Homework> getHomeworksToCheck() {
        return homeworksToCheck;
    }

}