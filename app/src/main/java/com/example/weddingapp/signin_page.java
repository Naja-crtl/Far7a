package com.example.weddingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signin_page extends AppCompatActivity {

    private EditText emailInput;
    private EditText passwordInput;
    private Button signInButton;
    private TextView forgotPassword;
    private TextView signUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinpage);

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        signInButton = findViewById(R.id.signInButton);
        forgotPassword = findViewById(R.id.forgotPassword);
        signUpLink = findViewById(R.id.signUpLink);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(signin_page.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle login authentication
                    Toast.makeText(signin_page.this, "Sign-In Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Forgot Password Activity
                Toast.makeText(signin_page.this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set up clickable "Sign Up" link
        String text = "Don't have an Account? Sign Up";
        SpannableString spannable = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Navigate to SignUpActivity
                Intent intent = new Intent(signin_page.this, signup_page.class);
                startActivity(intent);
            }
        };

        // Make "Sign Up" clickable and change its color
        int signUpStartIndex = text.indexOf("Sign Up");
        spannable.setSpan(clickableSpan, signUpStartIndex, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(
                new ForegroundColorSpan(Color.BLUE),
                signUpStartIndex,
                text.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        signUpLink.setText(spannable);
        signUpLink.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
    }
}
