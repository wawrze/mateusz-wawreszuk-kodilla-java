package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {

    private String username;

    public ForumUser() {
        this.username = "John Smith";
    }

    @Override
    public String toString(){
        return this.username;
    }

}
