package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        String name = "toDo";
        TaskList taskList = new TaskList(name, "Things to do");
        List<TaskList> list;
        //When
        taskListDao.save(taskList);
        list = taskListDao.findByListName(name);
        //Then
        Assert.assertEquals(1, list.size());
        //CleanUp
        int id = list.get(0).getId();
        taskListDao.delete(id);
    }

}