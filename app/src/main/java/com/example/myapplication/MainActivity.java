package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Adddata();

    }
    public void Adddata()
    {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted= myDb.insertData(editName.getText().toString(),editsurname.getText().toString(),editMarks.getText().toString());
             if(isInserted=true)
                 Toast.makeText(MainActivity.this,"data Inserted",Toast.LENGTH_LONG).show();
             else
                 Toast.makeText(MainActivity.this,"data not Inserted",Toast.LENGTH_LONG).show();
            }
        });
    }
}
