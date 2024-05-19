package com.example.dogwalkingapptest4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dogwalkingapptest4.SearchActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement or navigate to password recovery logic/screen
                Toast.makeText(LoginActivity.this, "Password recovery not implemented", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void login() {
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String registeredUsername = prefs.getString("Username", "");
        String registeredPassword = prefs.getString("Password", "");

        String enteredUsername = etUsername.getText().toString();
        String enteredPassword = etPassword.getText().toString();

        if (enteredUsername.equals(registeredUsername) && enteredPassword.equals(registeredPassword)) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            // Navigate to the next part of your application
            startActivity(new Intent(LoginActivity.this, SearchActivity.class)); // Assuming SearchActivity is the target
            finish(); // Finish LoginActivity so user can't go back to it
        } else {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
    }
}
