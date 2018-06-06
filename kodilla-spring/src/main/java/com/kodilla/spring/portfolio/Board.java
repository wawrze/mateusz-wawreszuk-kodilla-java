package com.kodilla.spring.portfolio;

public class Board {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addTask(String taskListName, String task) {
        switch (taskListName) {
            case "toDoList":
                toDoList.addTask(task);
                break;
            case "inProgressList":
                inProgressList.addTask(task);
                break;
            case "doneList":
                doneList.addTask(task);
                break;
            default:
                break;
        }
    }

    public void printTasks() {
        System.out.println("To do list:\n" + toDoList);
        System.out.println("In progress list:\n" + inProgressList);
        System.out.println("Done list:\n" + doneList);
    }

}