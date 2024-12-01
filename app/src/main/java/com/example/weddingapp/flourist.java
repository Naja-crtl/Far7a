package com.example.weddingapp;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class flourist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flourist);

        // Data for the ListView
        String[] flourist = {"Flourist 1", "Flourist" +
                " 2", "Flourist" +
                " 3", "Flourist" +
                " 4"};

        // Reference to ListView
        ListView flouristListView = findViewById(R.id.flouristListview);

        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                flourist
        );

        // Set the adapter to the ListView
        flouristListView.setAdapter(adapter);

        // Handle item clicks
        flouristListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedfloruist = flourist[position];
            Toast.makeText(this, "You have selected suit's shop: " + selectedfloruist, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(flourist.this,flourist.class);
            intent.putExtra("selectedfloruist", selectedfloruist);
            startActivity(intent);
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener (item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                startActivity(new Intent(flourist.this, home_page.class));
                return true;
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(flourist.this, profile.class));
                return true;
            } else if (itemId == R.id.budget) {
                startActivity(new Intent(flourist.this, budget.class));
                return true;
            } else if (itemId == R.id.favorites) {
                startActivity(new Intent(flourist.this, favorites.class));
                return true;
            } else {
                return false;
            }
        });
    }
}