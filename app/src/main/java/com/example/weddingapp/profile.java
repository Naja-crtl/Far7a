package com.example.weddingapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class profile extends AppCompatActivity {

    private EditText etPartner1, etPartner2, etEmail;
    private Button btnWeddingDate, btnSave;
    private String selectedWeddingDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize Views
        etPartner1 = findViewById(R.id.etPartner1);
        etPartner2 = findViewById(R.id.etPartner2);
        etEmail = findViewById(R.id.etEmail);
        btnWeddingDate = findViewById(R.id.btnWeddingDate);
        btnSave = findViewById(R.id.btnSave);

        // Load Existing Data
        loadProfileData();

        // Wedding Date Button Click
        btnWeddingDate.setOnClickListener(view -> {
            showDatePickerDialog();
        });

        // Save Button Click
        btnSave.setOnClickListener(view -> {
            saveProfileData();
        });
    }

    private void loadProfileData() {
        SharedPreferences prefs = getSharedPreferences("ProfileData", MODE_PRIVATE);

        String partner1 = prefs.getString("partner1", String.valueOf(etPartner1));
        String partner2 = prefs.getString("partner2", String.valueOf(etPartner2));
        String email = prefs.getString("email", "");
        selectedWeddingDate = prefs.getString("weddingDate", "Select Wedding Date");

        etPartner1.setText(partner1);
        etPartner2.setText(partner2);
        etEmail.setText(email);
        btnWeddingDate.setText(selectedWeddingDate);
    }

    private void saveProfileData() {
        String partner1 = etPartner1.getText().toString().trim();
        String partner2 = etPartner2.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (partner1.isEmpty() || partner2.isEmpty() || selectedWeddingDate.equals("Select Wedding Date")) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save to SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences("ProfileData", MODE_PRIVATE).edit();
        editor.putString("partner1", partner1);
        editor.putString("partner2", partner2);
        editor.putString("weddingDate", selectedWeddingDate);
        editor.putString("email", email);
        editor.apply();

        Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show();

        // Navigate back to home page
        Intent intent = new Intent(profile.this, home_page.class);
        startActivity(intent);
        finish();
    }


    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
            selectedWeddingDate = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
            btnWeddingDate.setText(selectedWeddingDate);
        }, year, month, day);

        datePickerDialog.show();
    }
}
