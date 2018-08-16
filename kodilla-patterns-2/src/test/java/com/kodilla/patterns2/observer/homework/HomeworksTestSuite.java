package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworksTestSuite {

    @Test
    public void testUpdate() {
        //Given
        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");
        Student student1 = new Student("Student 1", mentor1);
        Student student2 = new Student("Student 2", mentor1);
        Student student3 = new Student("Student 3", mentor1);
        Student student4 = new Student("Student 4", mentor2);
        Student student5 = new Student("Student 5", mentor2);
        //When
        student1.addHomework(new Homework(student1, "1.1", "Some solution"));
        student1.addHomework(new Homework(student1, "1.2", "Some solution"));
        student1.addHomework(new Homework(student1, "1.3", "Some solution"));
        student2.addHomework(new Homework(student2, "1.1", "Some solution"));
        student2.addHomework(new Homework(student2, "1.2", "Some solution"));
        student3.addHomework(new Homework(student3, "5.1", "Some solution"));
        student3.addHomework(new Homework(student3, "5.2", "Some solution"));
        student4.addHomework(new Homework(student4, "1.1", "Some solution"));
        student4.addHomework(new Homework(student4, "1.2", "Some solution"));
        student5.addHomework(new Homework(student5, "5.1", "Some solution"));
        student5.addHomework(new Homework(student5, "5.2", "Some solution"));
        student5.addHomework(new Homework(student5, "5.3", "Some solution"));
        //Then
        Assert.assertEquals(7, mentor1.getHomeworksToCheck().size());
        Assert.assertEquals(5, mentor2.getHomeworksToCheck().size());
    }

}