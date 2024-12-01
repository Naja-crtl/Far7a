package com.example.weddingapp;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class suits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suits);

        // Data for the ListView
        String[] suits = {"Suits place 1", "Suits place" +
                " 2", "Suits place" +
                " 3", "Suits place" +
                " 4"};

        // Reference to ListView
        ListView suitsListView = findViewById(R.id.suitsListview);

        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                suits
        );

        // Set the adapter to the ListView
        suitsListView.setAdapter(adapter);

        // Handle item clicks
        suitsListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSuits = suits[position];
            Toast.makeText(this, "You have selected suit's shop: " + selectedSuits, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(suits.this, favorites.class);
            intent.putExtra("selectedSuits", selectedSuits);
            startActivity(intent);
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener (item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                startActivity(new Intent(suits.this, home_page.class));
                return true;
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(suits.this, profile.class));
                return true;
            } else if (itemId == R.id.budget) {
                startActivity(new Intent(suits.this, budget.class));
                return true;
            } else if (itemId == R.id.favorites) {
                startActivity(new Intent(suits.this, favorites.class));
                return true;
            } else {
                return false;
            }
        });
    }
}