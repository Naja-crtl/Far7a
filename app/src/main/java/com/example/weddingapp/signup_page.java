package com.example.weddingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class signup_page extends AppCompatActivity {

    private TextView signinLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        // Set up the Spinner for country codes
        Spinner countryCodeSpinner = findViewById(R.id.countryCode);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.country_codes,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryCodeSpinner.setAdapter(adapter);

        // Set up the clickable "Sign In" text
        signinLink = findViewById(R.id.signinlink);
        String text = "Already have an Account? Sign In";
        SpannableString spannable = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Navigate to SignInActivity
                Intent intent = new Intent(signup_page.this, signin_page.class);
                startActivity(intent);
            }
        };

        // Style the "Sign In" text
        int signInStartIndex = text.indexOf("Sign In");
        spannable.setSpan(clickableSpan, signInStartIndex, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(
                new ForegroundColorSpan(Color.BLUE),
                signInStartIndex,
                text.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        signinLink.setText(spannable);
        signinLink.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
    }
}
