package com.ajts.androidmads.sqlite2xlDemo.model;

public class Users {

    private String userId;
    private String contactPersonName;
    private String contactNumber;

    public Users(String contactPersonName, String contactNumber) {
        this.contactPersonName = contactPersonName;
        this.contactNumber = contactNumber;
    }

    public Users(String userId, String contactPersonName, String contactNumber) {
        this.userId = userId;
        this.contactPersonName = contactPersonName;
        this.contactNumber = contactNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
