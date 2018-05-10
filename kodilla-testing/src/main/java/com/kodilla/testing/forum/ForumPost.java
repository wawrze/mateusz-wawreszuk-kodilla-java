package com.kodilla.testing.forum;

public class ForumPost {

    private String postBody;
    private String author;

    public ForumPost(String author, String postBody) {
        this.postBody = postBody;
        this.author = author;
    }

    public String getPostBody() {
        return this.postBody;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;}
        if (o == null || this.getClass() != o.getClass()){
            return false;}
        ForumPost forumPost = (ForumPost) o;
        if (!postBody.equals(forumPost.getPostBody())){
            return false;}
        return this.author.equals(forumPost.getAuthor());
    }

    @Override
    public int hashCode() {
        int result = this.postBody.hashCode();
        result = 31 * result + this.author.hashCode();
        return result;
    }

}
