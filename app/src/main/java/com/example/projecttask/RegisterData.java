package com.example.projecttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterData extends AppCompatActivity {

    MyDatabaseHelper db;
    EditText email, pass, name;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_data);

        db = new MyDatabaseHelper(this);

        name = findViewById(R.id.nameR);
        email = findViewById(R.id.emailR);
        pass = findViewById(R.id.passR);
        btnRegister = findViewById(R.id.btnR);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameT  = name.getText().toString();
                String emailT = email.getText().toString();
                String passT = pass.getText().toString();

                Boolean insert = db.insert(nameT,emailT,passT);
                if (insert==true){
                    Toast.makeText(getApplicationContext(),"R Success !",Toast.LENGTH_SHORT).show();
                }

                startActivity(new Intent(RegisterData.this, MainActivity.class));

            }
        });

    }

}
