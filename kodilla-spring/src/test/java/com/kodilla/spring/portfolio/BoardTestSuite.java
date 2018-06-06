package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        Board board = context.getBean(Board.class);
        board.addTask("toDoList", "task 1");
        board.addTask("toDoList", "task 2");
        board.addTask("inProgressList", "task 3");
        board.addTask("inProgressList", "task 4");
        board.addTask("doneList", "task 5");
        board.addTask("doneList", "task 6");
        //Then
        board.printTasks();
    }

}
