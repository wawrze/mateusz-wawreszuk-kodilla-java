package com.kodilla.patterns.strategy.social;

public class ZGeneration extends User {

    public ZGeneration(final String username) {
        super(username);
        this.socialPublisher = new FacebookPublisher();
    }

}