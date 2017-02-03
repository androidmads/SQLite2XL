package com.ajts.androidmads.sqlite2xlDemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ajts.androidmads.library.SQLiteToExcel;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtUser;
    Button btnSaveUser, btnExport;
    ListView lvUsers;
    ArrayAdapter lvUserAdapter;
    List<String> usersList;

    DBHelper dbHelper;
    DBQueries dbQueries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(getApplicationContext());
        dbQueries = new DBQueries(getApplicationContext());

        edtUser = (EditText) findViewById(R.id.edt_user);
        btnSaveUser = (Button) findViewById(R.id.btn_save_user);
        btnExport = (Button) findViewById(R.id.btn_export);

        lvUsers = (ListView) findViewById(R.id.lv_users);
        dbQueries.open();
        usersList = dbQueries.readUsers();
        lvUserAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, usersList);
        lvUsers.setAdapter(lvUserAdapter);
        dbQueries.close();

        btnSaveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users = new Users();
                if (edtUser.getText().toString().length() > 0) {
                    dbQueries.open();
                    users.setContactPersonName(edtUser.getText().toString());
                    dbQueries.insertUser(users);
                    usersList = dbQueries.readUsers();
                    lvUserAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, usersList);
                    lvUsers.setAdapter(lvUserAdapter);
                    dbQueries.close();
                } else {
                    edtUser.setError("Enter Name");
                }
            }
        });

        btnExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Backup/";
                File file = new File(directory_path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                // Export SQLite DB as EXCEL FILE
                SQLiteToExcel sqliteToExcel = new SQLiteToExcel(getApplicationContext(), DBHelper.DB_NAME, directory_path);
                sqliteToExcel.startExportAllTables("users.xls", new SQLiteToExcel.ExportListener() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(getApplicationContext(), "Successfully Exported", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {
                    }
                });
            }
        });

    }



}
