package com.app.daggarmvvmnotes.retrowebservices;


////Here I suppose basic request to server will look like this
public class BasicRequest {
    String userName, userPassword;

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
}
