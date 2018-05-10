package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.*;
import org.junit.*;


//Test suite for classes of Forum
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddPost(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        //When
        forumUser.addPost("mrsmith", "Hello everyone, this is my first post!");
        //Then
        Assert.assertEquals(1, forumUser.getPostsQuantity());
    }

    @Test
    public void testAddComment(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith","John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first post!","mrsmith");
        //When
        forumUser.addComment(forumPost,"mrsmith","Thank you all!");
        //Then
        Assert.assertEquals(1, forumUser.getCommentsQuantity());
    }

    @Test
    public void testGetPost(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("mrsmith", "Hello everyone, this is my first post!");
        forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());
        //When
        ForumPost retrievedForumPost = forumUser.getPost(0);
        //Then
        Assert.assertEquals(forumPost, retrievedForumPost);
    }

    @Test
    public void testGetComment(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("mrsmith", "Hello everyone, this is my first post!");
        forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());
        ForumComment forumComment = new ForumComment(forumPost, "Thank you all!", "mrsmith");
        forumUser.addComment(forumComment.getForumPost(), forumComment.getCommentBody(), forumComment.getAuthor());
        //When
        ForumComment retrievedComment;
        retrievedComment = forumUser.getComment(0);
        //Then
        Assert.assertEquals(forumComment, retrievedComment);
    }

    @Test
    public void testRemovePostNotExisting(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first post!", "mrsmith");
        //When
        boolean result = forumUser.removePost(forumPost);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveCommentNotExisting(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first post!", "mrsmith");
        ForumComment forumComment = new ForumComment(forumPost, "Thank you all!", "mrsmith");
        //When
        boolean result = forumUser.removeComment(forumComment);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testRemovePost(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("Hello everyone, this is my first post!", "mrsmith");
        forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());
        //When
        boolean result = forumUser.removePost(forumPost);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getPostsQuantity());
    }

    @Test
    public void testRemoveComment(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost forumPost = new ForumPost("mrsmith","Hello everyone, this is my first post!");
        forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());
        ForumComment forumComment = new ForumComment(forumPost, "Thank you all!", "mrsmith");
        forumUser.addComment(forumComment.getForumPost(), forumComment.getCommentBody(),forumComment.getAuthor());
        //When
        boolean result = forumUser.removeComment(forumComment);
        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getCommentsQuantity());
    }

}