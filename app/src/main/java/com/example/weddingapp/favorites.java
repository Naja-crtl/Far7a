package com.example.weddingapp;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class favorites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        // Initialize UI components
        TextView tvFavorites = findViewById(R.id.tv_favorites);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Get intent extras
        Intent intent = getIntent();
        if (intent.hasExtra("favorites")) {
            String favoritesText = intent.getStringExtra("favorites");
            tvFavorites.setText(favoritesText);
            tvFavorites.setVisibility(View.VISIBLE);
        } else {
            tvFavorites.setText("You haven't added any favorites yet!");
            tvFavorites.setVisibility(View.VISIBLE);
        }

        // Set up bottom navigation listener
        bottomNavigationView.setOnItemSelectedListener (item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                startActivity(new Intent(favorites.this, home_page.class));
                return true;
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(favorites.this, profile.class));
                return true;
            } else if (itemId == R.id.budget) {
                startActivity(new Intent(favorites.this, budget.class));
                return true;
            } else if (itemId == R.id.favorites) {
                startActivity(new Intent(favorites.this, favorites.class));
                return true;
            } else {
                return false;
            }
        });
    }
}
