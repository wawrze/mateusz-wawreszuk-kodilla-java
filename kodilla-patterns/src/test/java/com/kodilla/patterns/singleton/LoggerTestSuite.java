package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        String log1 = "Log content.";
        String log2 = "New log content.";
        String log;
        //When
        Logger.getInstance().log(log1);
        Logger.getInstance().log(log2);
        log = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals(log2, log);
    }

}