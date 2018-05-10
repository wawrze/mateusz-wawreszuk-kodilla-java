package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;

public class ForumUser {

    private String name;
    private String realName;
    private ArrayList<ForumPost> posts = new ArrayList<ForumPost>();
    private LinkedList<ForumComment> comments = new LinkedList<ForumComment>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postBody){
        this.posts.add(new ForumPost(author,postBody));
    }

    public void addComment(ForumPost thePost, String author, String commentBody){
        this.comments.add(new ForumComment(thePost, author, commentBody));
    }

    public int getPostsQuantity(){
        return this.posts.size();
    }

    public int getCommentsQuantity(){
        return this.comments.size();
    }

    public ForumPost getPost(int postNumber){
        ForumPost forumPost = null;
        if(postNumber >= 0 && postNumber < this.posts.size())
            forumPost = this.posts.get(postNumber);
        return forumPost;
    }

    public ForumComment getComment(int commentNumber){
        ForumComment forumComment = null;
        if(commentNumber >= 0 && commentNumber < this.comments.size())
            forumComment = this.comments.get(commentNumber);
        return forumComment;
    }

    public boolean removePost(ForumPost thePost){
        if(this.posts.contains(thePost)){
            posts.remove(thePost);
            return true;
        }
        else
            return false;
    }

    public boolean removeComment(ForumComment theComment){
        if(this.comments.contains(theComment)) {
            comments.remove(theComment);
            return true;
        }
        else
            return false;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

}
