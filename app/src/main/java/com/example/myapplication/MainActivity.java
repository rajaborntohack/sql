package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editsurname,editMarks;
    Button btnAddData;
    Button btnviewall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);
        editName=(EditText)findViewById(R.id.editText);
        editsurname=(EditText)findViewById(R.id.editText2);
        editMarks=(EditText)findViewById(R.id.editText3);
        btnAddData=(Button) findViewById(R.id.button);
        btnviewall=(Button) findViewById(R.id.button2);
        Adddata();
        viewAll();

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
    public void viewAll()
    {
        btnviewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=myDb.getAllData();
                if(res.getCount()==0)
                {
                    showMessage("Error","No data found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Id:"+res.getString(0)+"\n");
                    buffer.append("Name:"+res.getString(1)+"\n");
                    buffer.append("Surname:"+res.getString(2)+"\n");
                    buffer.append("Marks:"+res.getString(3)+"\n\n");
                }
                //shpw all data
                showMessage("Data",buffer.toString());
            }
        });
    }
    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
