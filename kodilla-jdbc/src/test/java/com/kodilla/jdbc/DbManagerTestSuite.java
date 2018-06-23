package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String query = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_COUNT " +
                "FROM USERS U, POSTS P " +
                "WHERE P.USER_ID = U.ID " +
                "GROUP BY P.USER_ID " +
                "HAVING COUNT(*) >= 2;";
        //When
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs =statement.executeQuery(query);
        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + " " +
            rs.getString("LASTNAME") + " (" + rs.getInt("POSTS_COUNT") + " posts)");
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(2, counter);
    }

    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

}