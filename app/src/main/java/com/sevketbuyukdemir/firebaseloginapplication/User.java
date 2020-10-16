package com.sevketbuyukdemir.firebaseloginapplication;

import java.util.UUID;

public class User {
    private String userName;
    private String userPassword;
    private String userMail;
    private String user_UUID;
    public User(){

    }

    public User(String userName, String userPassword, String userMail) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.user_UUID = UUID.randomUUID().toString();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUser_UUID() {
        return user_UUID;
    }

    @Override
    public String toString() {
        return userName + '-' + userPassword + '-' + userMail;
    }
}
