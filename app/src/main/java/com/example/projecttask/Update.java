package com.example.projecttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    EditText name, email;
    Button btnU;

    String n, e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name = findViewById(R.id.nameU);
        email = findViewById(R.id.emailU);
        btnU = findViewById(R.id.btnU);

        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        getData();
        MyDatabaseHelper databaseHelper = new MyDatabaseHelper(Update.this);
        databaseHelper.updataData(n,e);

    }

    void getData(){
        if (getIntent().hasExtra("Name") && getIntent().hasExtra("Email")){
            n = getIntent().getStringExtra("Name");
            e = getIntent().getStringExtra("Email");

            name.setText(n);
            email.setText(e);

        }else {
            Toast.makeText(this,"No Data !", Toast.LENGTH_SHORT).show();
        }
    }
}
