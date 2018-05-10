package com.kodilla.testing.forum.statistics;

import java.util.List;

public class CalculateStats {

    private int usersQty;
    private int postsQty;
    private int commentsQty;
    private double averagePosts;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public CalculateStats() {
        this.usersQty = 0;
        this.postsQty = 0;
        this.commentsQty = 0;
        this.averagePosts = 0;
        this.averageCommentsPerUser = 0;
        this.averageCommentsPerPost = 0;
    }

    public void calculateAdvStatistics(Statistics statistics){
        this.usersQty = statistics.usersNames().size();
        this.postsQty = statistics.postsCount();
        this.commentsQty = statistics.commentsCount();
        if(this.usersQty == 0)
            this.averagePosts = 0;
        else
            this.averagePosts = (double) this.postsQty / this.usersQty;
        if(this.usersQty == 0)
            this.averageCommentsPerUser = 0;
        else
            this.averageCommentsPerUser = (double) this.commentsQty / this.usersQty;
        if(this.postsQty == 0)
            this.averageCommentsPerPost = 0;
        else
            this.averageCommentsPerPost = (double) this.commentsQty / this.postsQty;
    }

    public int getUsersQty() {
        return usersQty;
    }

    public int getPostsQty() {
        return postsQty;
    }

    public int getCommentsQty() {
        return commentsQty;
    }

    public double getAveragePosts() {
        return averagePosts;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }

    public void showStatistics(){
        System.out.println("Users quantity: " + this.usersQty);
        System.out.println("Posts quantity: " + this.postsQty);
        System.out.println("Comments quantity: " + this.commentsQty);
        System.out.println("Posts per user: " + this.averagePosts);
        System.out.println("Comments per user: " + this.averageCommentsPerUser);
        System.out.println("Comments per post: " + this.averageCommentsPerPost);
    }

}
