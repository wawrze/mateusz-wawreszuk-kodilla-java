package com.kodilla.good.patterns.challenges.orders;

public class User {

    private String userName;
    private String realName;
    private String eMail;
    private String postAdress;

    public User(String userName, String realName, String eMail, String postAdress) {
        this.userName = userName;
        this.realName = realName;
        this.eMail = eMail;
        this.postAdress = postAdress;
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPostAdress() {
        return postAdress;
    }

}