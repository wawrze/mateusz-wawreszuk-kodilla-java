package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    ArrayList<Shape> collection;

    public ShapeCollector(){
        this.collection = new ArrayList<>();
    }

    public void addFigure(Shape shape){
        if(shape != null)
            this.collection.add(shape);
    }

    public boolean removeFigure(Shape shape){
        if(shape != null && this.collection.contains(shape)){
            this.collection.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n){
        if(n >= 0 && n < this.collection.size())
            return this.collection.get(n);
        return null;
    }

    public String showFigures(){
        String s = "";
        for(Shape shape : this.collection) {
            s += shape.getShapeName();
            if (shape instanceof Square)
                s += " [a=" + ((Square) shape).getA() + "]";
            if (shape instanceof Circle)
                s += " (r=" + ((Circle) shape).getR() + ")";
            if (shape instanceof Triangle)
                s += " /a=" + ((Triangle) shape).getA() + ",b=" + ((Triangle) shape).getB() + ",c=" + ((Triangle) shape).getC() + "/";
            s += "\n";
        }
        return s;
    }

    public int getFigureQty(){
        return this.collection.size();
    }

}
