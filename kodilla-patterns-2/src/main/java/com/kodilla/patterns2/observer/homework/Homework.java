package com.kodilla.patterns2.observer.homework;

public class Homework {

    private final String number;
    private final Student student;
    private final String solution;

    public Homework(Student student, String number, String solution) {
        this.student = student;
        this.number = number;
        this.solution = solution;
    }

    public String getNumber() {
        return number;
    }

    public String getSolution() {
        return solution;
    }

    public Student getStudent() {
        return student;
    }

}