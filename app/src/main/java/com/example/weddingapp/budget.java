package com.example.weddingapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class budget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener (item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                startActivity(new Intent(budget.this, home_page.class));
                return true;
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(budget.this, profile.class));
                return true;
            } else if (itemId == R.id.budget) {
                startActivity(new Intent(budget.this, budget.class));
                return true;
            } else if (itemId == R.id.favorites) {
                startActivity(new Intent(budget.this, favorites.class));
                return true;
            } else {
                return false;
            }
        });
    }
}