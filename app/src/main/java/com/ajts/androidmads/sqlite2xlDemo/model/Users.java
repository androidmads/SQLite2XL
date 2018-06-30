package com.ajts.androidmads.sqlite2xlDemo.model;

public class Users {

    private String userId;
    private String contactPersonName;
    private String contactNumber;
    private byte[] contactPhoto;

    public Users(String contactPersonName, String contactNumber, byte[] contactPhoto) {
        this.contactPersonName = contactPersonName;
        this.contactNumber = contactNumber;
        this.contactPhoto = contactPhoto;
    }

    public Users(String userId, String contactPersonName, String contactNumber, byte[] contactPhoto) {
        this.userId = userId;
        this.contactPersonName = contactPersonName;
        this.contactNumber = contactNumber;
        this.contactPhoto = contactPhoto;
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

    public byte[] getContactPhoto() {
        return contactPhoto;
    }

    public void setContactPhoto(byte[] contactPhoto) {
        this.contactPhoto = contactPhoto;
    }
}
