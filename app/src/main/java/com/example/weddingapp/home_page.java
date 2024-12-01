package com.example.weddingapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.example.weddingapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class home_page extends AppCompatActivity {

    // Declare the UI components
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageButton btnMenu;
    private TextView tvWelcomeMessage, tvCountdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Initialize Views
        drawerLayout = findViewById(R.id.drawerLayout); // DrawerLayout for side menu
        navigationView = findViewById(R.id.navigationView); // NavigationView for menu items
        btnMenu = findViewById(R.id.btnMenu); // Menu button to open drawer
        tvWelcomeMessage = findViewById(R.id.tvCoupleNames); // TextView to display welcome message
        tvCountdown = findViewById(R.id.tvCountdown); // TextView to display wedding countdown

        // Find ImageView elements for the categories
        ImageView venuesImage = findViewById(R.id.venuesImage);
        ImageView photographerImage = findViewById(R.id.photographerImage);
        ImageView makeupImage = findViewById(R.id.makeupImage);
        ImageView dressImage = findViewById(R.id.dressImage);
        ImageView suitsImage = findViewById(R.id.suitsImage);
        ImageView flouristImage = findViewById(R.id.flouristImage);

        // Bottom Navbar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView); // Bottom navigation bar

        // Set OnClickListeners for category images to navigate to respective activities
        venuesImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, venues.class);
                startActivity(intent); // Start venues activity
            }
        });

        photographerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, photographer.class);
                startActivity(intent); // Start photographer activity
            }
        });

        makeupImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, makeup.class);
                startActivity(intent); // Start makeup activity
            }
        });

        dressImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, dresses.class);
                startActivity(intent); // Start dresses activity
            }
        });

        suitsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, suits.class);
                startActivity(intent); // Start suits activity
            }
        });

        flouristImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, flourist.class);
                startActivity(intent); // Start flourist activity
            }
        });

        // View All Button
        Button btn_viewAll = findViewById(R.id.btn_viewAll); // Button to view all categories
        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_page.this, categories.class);
                startActivity(intent); // Start categories activity
            }
        });

        // Set OnItemSelectedListener for Bottom Navigation View
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId(); // Get the selected item ID

            // Handle bottom navigation item clicks
            if (itemId == R.id.home) {
                startActivity(new Intent(home_page.this, home_page.class));
                return true;
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(home_page.this, profile.class));
                return true;
            } else if (itemId == R.id.budget) {
                startActivity(new Intent(home_page.this, budget.class));
                return true;
            } else if (itemId == R.id.favorites) {
                startActivity(new Intent(home_page.this, favorites.class));
                return true;
            } else {
                return false;
            }
        });

        // Retrieve data passed from the previous screen (couple names and days remaining)
        String partner1 = getIntent().getStringExtra("partner1");
        String partner2 = getIntent().getStringExtra("partner2");
        int daysRemaining = getIntent().getIntExtra("daysRemaining", -1);

        // Set the welcome message if partner names are provided
        if (partner1 != null && partner2 != null) {
            tvWelcomeMessage.setText("Welcome " + partner1 + " & " + partner2 + "!");
        }

        // Set the countdown message if the days remaining are valid
        if (daysRemaining >= 0) {
            tvCountdown.setText("Days until your BIG DAY:\n" + daysRemaining);
        } else {
            tvCountdown.setText("Invalid Wedding Date"); // Handle invalid date
        }

        // Open the navigation drawer on menu button click
        btnMenu.setOnClickListener(view -> {
            if (drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawer(navigationView); // Close the drawer
            } else {
                drawerLayout.openDrawer(navigationView); // Open the drawer
            }
        });

        // Handle Navigation Menu Item Clicks
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId(); // Get the selected menu item ID

            // Handle navigation based on selected item
            if (id == R.id.navMyEvents) {
                handleMyEvents();
            } else if (id == R.id.navFavorites) {
                handleFavorities();
            } else if (id == R.id.navBudget) {
                handleBudget();
            } else if (id == R.id.navProfile) {
                handleProfile();
            } else if (id == R.id.navLogOut) {
                handleLogOut();
            }

            // Close drawer after menu item click
            drawerLayout.closeDrawer(navigationView);
            return true;
        });
    }

    // Methods to handle navigation menu item clicks
    private void handleMyEvents() {
        Intent intent = new Intent(home_page.this, myevents.class);
        startActivity(intent); // Start the "My Events" activity
    }

    private void handleFavorities() {
        Intent intent = new Intent(home_page.this, favorites.class);
        startActivity(intent); // Start the "Favorites" activity
    }

    private void handleBudget() {
        Intent intent = new Intent(home_page.this, budget.class);
        startActivity(intent); // Start the "Budget" activity
    }

    private void handleProfile() {
        Intent intent = new Intent(home_page.this, profile.class);
        startActivity(intent); // Start the "Profile" activity
    }

    private void handleLogOut() {
        // Log out logic to be implemented here
    }
}