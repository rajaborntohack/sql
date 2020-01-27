package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editsurname,editMarks;
    Button btnAddData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);
        editName=(EditText)findViewById(R.id.editText);
        editsurname=(EditText)findViewById(R.id.editText2);
        editMarks=(EditText)findViewById(R.id.editText3);
        btnAddData=(Button) findViewById(R.id.button);

    }
}
