package com.example.weddingapp;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class photographer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photographer);

        // Data for the ListView
        String[] photographer = {
                "Photographer 1",
                "Photographer 2",
                "Photographer 3",
                "Photographer 4"
        };

        // Reference to ListView
        ListView photographerListView = findViewById(R.id.photographerListview);

        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // Context
                android.R.layout.simple_list_item_1, // Layout for individual list items
                photographer // Data source
        );

        // Set the adapter to the ListView
        photographerListView.setAdapter(adapter);

        // Handle item clicks
        photographerListView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected photographer based on the position
            String selectedPhotographer = photographer[position];
            // Show a toast message with the selected photographer
            Toast.makeText(this, "You have selected suit's shop: " + selectedPhotographer, Toast.LENGTH_SHORT).show();
        });

        // Reference to BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Handle Bottom Navigation item clicks
        bottomNavigationView.setOnItemSelectedListener(item -> {
            // Get the ID of the clicked item
            int itemId = item.getItemId();

            // Navigate to the corresponding activity based on the item ID
            if (itemId == R.id.home) {
                startActivity(new Intent(photographer.this, home_page.class));
                return true; // Return true to indicate the click was handled
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(photographer.this, profile.class));
                return true;
            } else if (itemId == R.id.budget) {
                startActivity(new Intent(photographer.this, budget.class));
                return true;
            } else if (itemId == R.id.favorites) {
                startActivity(new Intent(photographer.this, favorites.class));
                return true;
            } else {
                return false; // Return false if the click was not handled
            }
        });
    }
}