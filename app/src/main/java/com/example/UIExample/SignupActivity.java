package com.example.UIExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.UIExample.R;

public class SignupActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail, editTextPassword, editTextRePassword;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        editTextName = findViewById(R.id.edTextName);
        editTextEmail = findViewById(R.id.edTextEmail);
        editTextPassword = findViewById(R.id.edTextPassword);
        editTextRePassword = findViewById(R.id.edTextRePassword);
        buttonSignUp = findViewById(R.id.btnSignup);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String rePassword = editTextRePassword.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(rePassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Add your sign-up logic here (e.g., send data to server, save to database, etc.)

        Toast.makeText(this, "Sign-up successful", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}