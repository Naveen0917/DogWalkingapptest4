package com.example.dogwalkingapptest4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText etFirstName, etLastName, etUsername, etPassword;
    Button btnCreateAccount;
    Spinner spinnerCountry;
    private Switch switchAge;
    private String role;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        switchAge = findViewById(R.id.switchAge);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        role = getIntent().getStringExtra("role");

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();

                if ("Dog Walker".equals(role)){
                    Intent intent = new Intent(RegisterActivity.this, DogWalkerListActivity.class);
                    intent.putExtra("newDogWalker", etFirstName.getText().toString() + " " + etLastName.getText().toString());
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        });

        spinnerCountry = findViewById(R.id.spinnerCountry);

        adapter = ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void saveUserData() {

            SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("FirstName", etFirstName.getText().toString());
            editor.putString("LastName", etLastName.getText().toString());
            editor.putString("Username", etUsername.getText().toString());
            editor.putString("Password", etPassword.getText().toString());
            editor.putString("Country", spinnerCountry.getSelectedItem().toString());
            editor.putBoolean("Over 18",switchAge.isChecked());
            editor.putString("Role", role);
            editor.apply();

            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
        }
    }
