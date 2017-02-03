package com.ajts.androidmads.sqlite2xlDemo;

public class Users {

    private String userId;
    private String contactPersonName;

    public Users(String userId, String contactPersonName) {
        this.userId = userId;
        this.contactPersonName = contactPersonName;
    }

    public Users() {

    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

}
