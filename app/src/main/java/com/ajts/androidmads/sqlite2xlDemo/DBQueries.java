package com.ajts.androidmads.sqlite2xlDemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import static com.ajts.androidmads.sqlite2xlDemo.DBConstants.CONTACT_ID;
import static com.ajts.androidmads.sqlite2xlDemo.DBConstants.CONTACT_PERSON_NAME;
import static com.ajts.androidmads.sqlite2xlDemo.DBConstants.SELECT_QUERY;
import static com.ajts.androidmads.sqlite2xlDemo.DBConstants.USER_TABLE;

public class DBQueries {

    private Context context;
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public DBQueries(Context context) {
        this.context = context;
    }

    public DBQueries open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    // Users
    public boolean insertUser(Users users) {
        ContentValues values = new ContentValues();
        values.put(CONTACT_PERSON_NAME, users.getContactPersonName());
        return database.insert(USER_TABLE, null, values) > -1;
    }

    public ArrayList<String> readUsers() {
        ArrayList<String> list = new ArrayList<>();
        try {
            Cursor cursor;
            database = dbHelper.getReadableDatabase();
            cursor = database.rawQuery(SELECT_QUERY, null);
            list.clear();
            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {
                    do {
                        String contactId = cursor.getString(cursor.getColumnIndex(CONTACT_ID));
                        String conPerson = cursor.getString(cursor.getColumnIndex(CONTACT_PERSON_NAME));
                        list.add(conPerson);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
        } catch (Exception e) {
            Log.v("Exception", e.getMessage());
        }
        return list;
    }

}
