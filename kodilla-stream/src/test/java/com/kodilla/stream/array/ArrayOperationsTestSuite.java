package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        //Given
        int[] array = {10, 3, 9, 4, 19, 19, 18, 2, 10, 5, 16, 11};
        //When
        double result = ArrayOperations.getAverage(array);
        //Then
        Assert.assertEquals(10.5,result,0);
    }

}