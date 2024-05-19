package com.example.dogwalkingapptest4;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DogWalkerListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_walker_list);

        String newDogWalker = getIntent().getStringExtra("newDogWalker");

        int selectedPayRange = getIntent().getIntExtra("selectedPayRange", 0);
        String country = getIntent().getStringExtra("country");

        if (!"Australia".equals(country)){
            Toast.makeText(this, "Sorry, No dog walkers are searched place.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        List<DogWalker> dogWalkers = new ArrayList<>();
        dogWalkers.add(new DogWalker("Naveen", "Experienced with large breeds", R.drawable.ic_profile, 25)); // Example pay rate
        dogWalkers.add(new DogWalker("Ganesh", "Friendly and punctual", R.drawable.ic_profile, 30)); // Example pay rate
        dogWalkers.add(new DogWalker("Sravani", "Your fur babies are far from second home", R.drawable.ic_profile, 25));
        dogWalkers.add(new DogWalker("Gopi", "Your babies are in safe hands", R.drawable.ic_profile, 28));

        if (newDogWalker!=null){
            dogWalkers.add(new DogWalker(newDogWalker, "Newly Registered", R.drawable.ic_profile, 0));
        }

        List<DogWalker> filteredDogWalkers = new ArrayList<>();
        for (DogWalker dogWalker : dogWalkers) {
            if (dogWalker.getPayRate() <= selectedPayRange){
                filteredDogWalkers.add(dogWalker);
            }
        }

        ListView listView = findViewById(R.id.lvDogWalkers);
        DogWalkerAdapter adapter = new DogWalkerAdapter(this, dogWalkers);
        listView.setAdapter(adapter);
    }
}
