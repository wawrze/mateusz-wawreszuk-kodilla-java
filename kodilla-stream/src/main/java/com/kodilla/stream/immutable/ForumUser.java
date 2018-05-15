package com.kodilla.stream.immutable;

public final class ForumUser {

    private final String userName;
    private final String realName;

    public ForumUser(final String userName, final String realName){
        this.realName = realName;
        this.userName = userName;
    }

}