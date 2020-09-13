package com.example.projecttask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginData extends AppCompatActivity {

    EditText email, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_data);

        email = findViewById(R.id.emailL);
        password = findViewById(R.id.passL);
        btnLogin =findViewById(R.id.btnL);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailLogin = email.getText().toString();
                String passLogin = password.getText().toString();
            }
        });
    }
}
