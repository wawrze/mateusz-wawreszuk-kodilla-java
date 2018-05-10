package com.kodilla.testing.shape;

public class Square implements Shape {

    private double a;

    public Square(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    @Override
    public String getShapeName(){
        return "square";
    }

    @Override
    public double getField(){
        return this.a * this.a;
    }

}