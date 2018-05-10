package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CalculateStatsTestSuite {

    @Test
    public void testPosts0(){
        //Given
        CalculateStats calculateStats = new CalculateStats();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(0);
        List<String> userList = new ArrayList();
        for(int i = 0;i<100;i++)
            userList.add("User " + i);
        when(statistics.usersNames()).thenReturn(userList);
        when(statistics.commentsCount()).thenReturn(100);
        //When
        calculateStats.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0, calculateStats.getPostsQty());
        Assert.assertEquals(0, calculateStats.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(0, calculateStats.getAveragePosts(), 0);
        Assert.assertEquals(100, calculateStats.getCommentsQty());
        Assert.assertEquals(100, calculateStats.getUsersQty());
        Assert.assertEquals(1,calculateStats.getAverageCommentsPerUser(),0);
    }

    @Test
    public void testPosts1000(){
        //Given
        CalculateStats calculateStats = new CalculateStats();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(1000);
        List<String> userList = new ArrayList();
        for(int i = 0;i<100;i++)
            userList.add("User " + i);
        when(statistics.usersNames()).thenReturn(userList);
        when(statistics.commentsCount()).thenReturn(100);
        //When
        calculateStats.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(1000, calculateStats.getPostsQty());
        Assert.assertEquals(0.1, calculateStats.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(10, calculateStats.getAveragePosts(), 0);
        Assert.assertEquals(100, calculateStats.getCommentsQty());
        Assert.assertEquals(100, calculateStats.getUsersQty());
        Assert.assertEquals(1,calculateStats.getAverageCommentsPerUser(),0);
    }

    @Test
    public void testComments0(){
        //Given
        CalculateStats calculateStats = new CalculateStats();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(100);
        List<String> userList = new ArrayList();
        for(int i = 0;i<100;i++)
            userList.add("User " + i);
        when(statistics.usersNames()).thenReturn(userList);
        when(statistics.commentsCount()).thenReturn(0);
        //When
        calculateStats.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(100, calculateStats.getPostsQty());
        Assert.assertEquals(0, calculateStats.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(1, calculateStats.getAveragePosts(), 0);
        Assert.assertEquals(0, calculateStats.getCommentsQty());
        Assert.assertEquals(100, calculateStats.getUsersQty());
        Assert.assertEquals(0,calculateStats.getAverageCommentsPerUser(),0);
    }

    @Test
    public void testCommentsLessThanPosts(){
        //Given
        CalculateStats calculateStats = new CalculateStats();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(200);
        List<String> userList = new ArrayList();
        for(int i = 0;i<100;i++)
            userList.add("User " + i);
        when(statistics.usersNames()).thenReturn(userList);
        when(statistics.commentsCount()).thenReturn(100);
        //When
        calculateStats.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(200, calculateStats.getPostsQty());
        Assert.assertEquals(0.5, calculateStats.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(2, calculateStats.getAveragePosts(), 0);
        Assert.assertEquals(100, calculateStats.getCommentsQty());
        Assert.assertEquals(100, calculateStats.getUsersQty());
        Assert.assertEquals(1,calculateStats.getAverageCommentsPerUser(),0);
    }

    @Test
    public void testPostsLessThanComments(){
        //Given
        CalculateStats calculateStats = new CalculateStats();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(100);
        List<String> userList = new ArrayList();
        for(int i = 0;i<100;i++)
            userList.add("User " + i);
        when(statistics.usersNames()).thenReturn(userList);
        when(statistics.commentsCount()).thenReturn(200);
        //When
        calculateStats.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(100, calculateStats.getPostsQty());
        Assert.assertEquals(2, calculateStats.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(1, calculateStats.getAveragePosts(), 0);
        Assert.assertEquals(200, calculateStats.getCommentsQty());
        Assert.assertEquals(100, calculateStats.getUsersQty());
        Assert.assertEquals(2,calculateStats.getAverageCommentsPerUser(),0);
    }

    @Test
    public void testUsers0(){
        //Given
        CalculateStats calculateStats = new CalculateStats();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.usersNames()).thenReturn(new ArrayList<String>());
        when(statistics.commentsCount()).thenReturn(100);
        //When
        calculateStats.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(100, calculateStats.getPostsQty());
        Assert.assertEquals(1, calculateStats.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(0, calculateStats.getAveragePosts(), 0);
        Assert.assertEquals(100, calculateStats.getCommentsQty());
        Assert.assertEquals(0, calculateStats.getUsersQty());
        Assert.assertEquals(0,calculateStats.getAverageCommentsPerUser(),0);
    }

    @Test
    public void testUsers100(){
        //Given
        CalculateStats calculateStats = new CalculateStats();
        Statistics statistics = mock(Statistics.class);
        when(statistics.postsCount()).thenReturn(100);
        List<String> userList = new ArrayList();
        for(int i = 0;i<100;i++)
            userList.add("User " + i);
        when(statistics.usersNames()).thenReturn(userList);
        when(statistics.commentsCount()).thenReturn(100);
        //When
        calculateStats.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(100, calculateStats.getPostsQty());
        Assert.assertEquals(1, calculateStats.getAverageCommentsPerPost(), 0);
        Assert.assertEquals(1, calculateStats.getAveragePosts(), 0);
        Assert.assertEquals(100, calculateStats.getCommentsQty());
        Assert.assertEquals(100, calculateStats.getUsersQty());
        Assert.assertEquals(1,calculateStats.getAverageCommentsPerUser(),0);
    }

}
