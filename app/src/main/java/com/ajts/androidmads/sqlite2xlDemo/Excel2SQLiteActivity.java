package com.ajts.androidmads.sqlite2xlDemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ajts.androidmads.library.ExcelToSQLite;
import com.ajts.androidmads.sqlite2xlDemo.db.DBHelper;
import com.ajts.androidmads.sqlite2xlDemo.db.DBQueries;
import com.ajts.androidmads.sqlite2xlDemo.util.Utils;

import java.io.File;

public class Excel2SQLiteActivity extends AppCompatActivity {

    EditText edtFilePath;
    Button btnImport;
    DBHelper dbHelper;
    DBQueries dbQueries;
    String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Backup/users.xls";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xl_2_sqlite);

        dbHelper = new DBHelper(getApplicationContext());
        dbQueries = new DBQueries(getApplicationContext());

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtFilePath = (EditText) findViewById(R.id.edt_file_path);
        btnImport = (Button) findViewById(R.id.btn_import);
        edtFilePath.setText(directory_path);
        btnImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                File file = new File(directory_path);
                if (!file.exists()) {
                    Utils.showSnackBar(view, "No file");
                    return;
                }
                dbQueries.open();
                // Is used to import data from excel without dropping table
                // ExcelToSQLite excelToSQLite = new ExcelToSQLite(getApplicationContext(), DBHelper.DB_NAME);

                // if you want to add column in excel and import into DB, you must drop the table
                ExcelToSQLite excelToSQLite = new ExcelToSQLite(getApplicationContext(), DBHelper.DB_NAME, false);
                // Import EXCEL FILE to SQLite
                excelToSQLite.importFromFile(directory_path, new ExcelToSQLite.ImportListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted(String dbName) {
                        Utils.showSnackBar(view, "Excel imported into " + dbName);
                    }

                    @Override
                    public void onError(Exception e) {
                        Utils.showSnackBar(view, "Error : " + e.getMessage());
                    }
                });
                dbQueries.close();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return true;
    }
}
