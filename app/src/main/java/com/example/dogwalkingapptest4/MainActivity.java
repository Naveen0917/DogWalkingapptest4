package com.example.dogwalkingapptest4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btnDogOwner, btnDogWalker;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);

        db = FirebaseFirestore.getInstance();
        addFirstUser();
        addSecondUser();

        btnDogOwner = findViewById(R.id.btnDogOwner);
        btnDogWalker = findViewById(R.id.btnDogWalker);

        View.OnClickListener registerListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to the Registration Activity
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        };

        btnDogOwner.setOnClickListener(registerListener);
        btnDogWalker.setOnClickListener(registerListener);
    }

    private void addFirstUser() {
        Map<String, Object> user = new HashMap<>();
        user.put("first", "sandeep");
        user.put("last", "penugonda");
        user.put("username", "s_s");
        user.put("password", 1234);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("MYDEBUG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("MYDEBUG", "Error adding document", e);
                    }
                });
    }

    private void addSecondUser(){
        Map<String, Object> user = new HashMap<>();
        user.put("first", "ganesh");
        user.put("Second", "babu");
        user.put("username", "g_g");
        user.put("password", 1234);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("MYDEBUG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("MYDEBUG", "Error adding document", e);
                    }
                });


    }
}
