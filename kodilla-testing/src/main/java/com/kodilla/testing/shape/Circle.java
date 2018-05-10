package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    @Override
    public String getShapeName(){
        return "circle";
    }

    @Override
    public double getField(){
        return Math.PI * this.r * this.r;
    }

}
