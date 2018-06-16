package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "Shopping task";
    public static final String PAINTING = "Painting task";
    public static final String DRIVING = "Driving task";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("To buy", "bread", 1.0);
            case PAINTING:
                return new PaintingTask("to paint", "red", "hammer");
            case DRIVING:
                return new DrivingTask("to drive", "school", "car");
            default:
                return null;
        }
    }

}