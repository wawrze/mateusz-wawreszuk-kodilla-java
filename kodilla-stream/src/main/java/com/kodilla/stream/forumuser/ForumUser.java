package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userID;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int posts;

    public ForumUser(final int userID, final String userName, final char sex, final LocalDate dateOfBirth, final int posts) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.posts = posts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return userName + " (" + sex + ", date of birth: " + dateOfBirth + ", " + posts + " posts)";
    }

}
