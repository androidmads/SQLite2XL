package com.ajts.androidmads.sqlite2xlDemo;

class DBConstants {

    static final String USER_TABLE = "users";
    static final String CONTACT_ID = "contact_id";
    static final String CONTACT_PERSON_NAME = "contact_person_name";

    static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + USER_TABLE + " ("
            + CONTACT_ID + " INTEGER PRIMARY KEY,"
            + CONTACT_PERSON_NAME + " TEXT)";

    static final String SELECT_QUERY = "SELECT * FROM " + USER_TABLE;

}
