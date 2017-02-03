package com.ajts.androidmads.sqlite2xlDemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.ajts.androidmads.sqlite2xlDemo.DBConstants.CREATE_USER_TABLE;
import static com.ajts.androidmads.sqlite2xlDemo.DBConstants.USER_TABLE;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    public static String DB_NAME = "sqlite2ExcelDemo";
    private static int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
    }

}
