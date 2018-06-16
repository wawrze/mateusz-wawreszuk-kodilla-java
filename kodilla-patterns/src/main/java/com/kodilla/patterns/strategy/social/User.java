package com.kodilla.patterns.strategy.social;

public class User {

    final private String username;
    protected SocialPublisher socialPublisher;

    public User(final String username) {
        this.username = username;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return username;
    }

}