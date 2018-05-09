package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.Random;

public class CollectionTestSuite {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("CollectionTestSuite: begin");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("CollectionTestSuite: end");
    }

    @Before
    public void before(){
        System.out.println("Test case: begin");
    }

    @After
    public void after(){
        System.out.println("Test case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> list = new ArrayList();
        //When
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(list);
        //Then
        Assert.assertEquals(list,result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> list = new ArrayList();
        Random r = new Random();
        for(int i = 0;i<100;i++)
            list.add(r.nextInt(1000));
        //When
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(list);
        boolean b = true;
        for(Integer i : result)
            b = b && ((i % 2) == 0);
        //Then
        Assert.assertTrue(b);
    }

}
