package com.example.weddingapp;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class dresses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dresses);
        // Data for the ListView
        String[] dresses = {"Dress place 1", "Dress place" +
                " 2", "Dress place" +
                " 3", "Dress place" +
                " 4"};

        // Reference to ListView
        ListView dressesListView = findViewById(R.id.dressesListview);

        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dresses
        );

        // Set the adapter to the ListView
        dressesListView.setAdapter(adapter);

        // Handle item clicks
        dressesListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedDress = dresses[position];
            Toast.makeText(this, "You have selected suit's shop: " + selectedDress, Toast.LENGTH_SHORT).show();
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                startActivity(new Intent(dresses.this, home_page.class));
                return true;
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(dresses.this, profile.class));
                return true;
            } else if (itemId == R.id.budget) {
                startActivity(new Intent(dresses.this, budget.class));
                return true;
            } else if (itemId == R.id.favorites) {
                startActivity(new Intent(dresses.this, favorites.class));
                return true;
            } else {
                return false;
            }
        });
    }
}
