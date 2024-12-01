package com.example.weddingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class couplenames extends AppCompatActivity {

    // Declare UI elements
    private EditText etPartner1, etPartner2;
    private Button btnWeddingDate, btnNext;
    private String selectedWeddingDate = ""; // Store selected wedding date

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couplenames);

        // Initialize Views
        etPartner1 = findViewById(R.id.etPartner1);
        etPartner2 = findViewById(R.id.etPartner2);
        btnWeddingDate = findViewById(R.id.btnWeddingDate);
        btnNext = findViewById(R.id.btnNext);

        // Set up MaterialDatePicker for selecting the wedding date
        btnWeddingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and configure MaterialDatePicker
                MaterialDatePicker.Builder<Long> builder = MaterialDatePicker.Builder.datePicker();
                builder.setTitleText("Select Wedding Date");

                // Optional: Set constraints (e.g., disable past dates)
                CalendarConstraints.Builder constraintsBuilder = new CalendarConstraints.Builder();
                builder.setCalendarConstraints(constraintsBuilder.build());

                // Build and show the date picker dialog
                MaterialDatePicker<Long> datePicker = builder.build();
                datePicker.addOnPositiveButtonClickListener(selection -> {
                    // Format and display the selected wedding date
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                    selectedWeddingDate = sdf.format(selection);
                    btnWeddingDate.setText("Wedding Date: " + selectedWeddingDate);
                });

                datePicker.show(getSupportFragmentManager(), "WEDDING_DATE_PICKER");
            }
        });

        // Set up Next Button to navigate to the next screen
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String partner1 = etPartner1.getText().toString();
                String partner2 = etPartner2.getText().toString();

                // Check if any fields are empty
                if (partner1.isEmpty() || partner2.isEmpty() || selectedWeddingDate.isEmpty()) {
                    Toast.makeText(couplenames.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Calculate the number of days remaining until the wedding
                    int daysRemaining = calculateDaysRemaining(selectedWeddingDate);

                    // Pass the collected data to the next activity (home_page)
                    Intent intent = new Intent(couplenames.this, home_page.class);
                    intent.putExtra("partner1", partner1);
                    intent.putExtra("partner2", partner2);
                    intent.putExtra("daysRemaining", daysRemaining);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    // Helper method to calculate the number of days remaining until the wedding
    private int calculateDaysRemaining(String weddingDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        try {
            Date currentDate = new Date(); // Get the current date
            Date weddingDateObj = sdf.parse(weddingDate); // Parse the wedding date string
            if (weddingDateObj != null) {
                long diffInMillis = weddingDateObj.getTime() - currentDate.getTime(); // Calculate the difference in milliseconds
                return (int) (diffInMillis / (1000 * 60 * 60 * 24)); // Convert milliseconds to days
            }
        } catch (ParseException e) {
            e.printStackTrace(); // Handle parsing error
        }
        return -1; // Return -1 if there's an error calculating the days
    }
}