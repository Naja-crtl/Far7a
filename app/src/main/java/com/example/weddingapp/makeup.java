package com.example.weddingapp;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class makeup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);
        // Data for the ListView
        String[] makeup = {"MakeUp Artist 1", "MakeUp Artist 2", "MakeUp Artist 3", "MakeUp Artist 4"};

        // Reference to ListView
        ListView makeupListView = findViewById(R.id.makeupListview);

        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                makeup
        );

        // Set the adapter to the ListView
        makeupListView.setAdapter(adapter);

        // Handle item clicks
        makeupListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedmakeup = makeup[position];
            Toast.makeText(this, "You have chosen: " + selectedmakeup, Toast.LENGTH_SHORT).show();
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener (item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                startActivity(new Intent(makeup.this, home_page.class));
                return true;
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(makeup.this, profile.class));
                return true;
            } else if (itemId == R.id.budget) {
                startActivity(new Intent(makeup.this, budget.class));
                return true;
            } else if (itemId == R.id.favorites) {
                startActivity(new Intent(makeup.this, favorites.class));
                return true;
            } else {
                return false;
            }
        });
    }
}