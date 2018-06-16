package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task task = factory.makeTask(TaskFactory.SHOPPING);
        String execute = task.executeTask();
        boolean isExecuted = task.isTaskExecuted();
        //Then
        Assert.assertEquals("Buying 1.0 of bread.", execute);
        Assert.assertTrue(isExecuted);
    }

    @Test
    public void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task task = factory.makeTask(TaskFactory.PAINTING);
        String execute = task.executeTask();
        boolean isExecuted = task.isTaskExecuted();
        //Then
        Assert.assertEquals("Painting red hammer.", execute);
        Assert.assertTrue(isExecuted);
    }

    @Test
    public void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task task = factory.makeTask(TaskFactory.DRIVING);
        String execute = task.executeTask();
        boolean isExecuted = task.isTaskExecuted();
        //Then
        Assert.assertEquals("Driving to school by car.", execute);
        Assert.assertTrue(isExecuted);
    }

}