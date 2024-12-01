package com.example.weddingapp;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class venues extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venues);

        // Data for the ListView
        String[] venues = {"Venue 1", "Venue 2", "Venue 3", "Venue 4"};

        // Reference to ListView
        ListView venuesListView = findViewById(R.id.venuesListview);

        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                venues
        );

        // Set the adapter to the ListView
        venuesListView.setAdapter(adapter);

        // Handle item clicks
        venuesListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedVenue = venues[position];
            Toast.makeText(this, "You have chosen: " + selectedVenue, Toast.LENGTH_SHORT).show();
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener (item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                startActivity(new Intent(venues.this, home_page.class));
                return true;
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(venues.this, profile.class));
                return true;
            } else if (itemId == R.id.budget) {
                startActivity(new Intent(venues.this, budget.class));
                return true;
            } else if (itemId == R.id.favorites) {
                startActivity(new Intent(venues.this, favorites.class));
                return true;
            } else {
                return false;
            }
        });
    }
}