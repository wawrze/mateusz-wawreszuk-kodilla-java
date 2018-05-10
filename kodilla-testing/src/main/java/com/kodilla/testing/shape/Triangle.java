package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String getShapeName(){
        return "triangle";
    }

    @Override
    public double getField(){
        double p = (this.a + this.b + this.c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

}
