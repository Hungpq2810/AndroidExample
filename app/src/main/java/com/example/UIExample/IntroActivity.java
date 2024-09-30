package com.example.UIExample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.UIExample.R;

public class IntroActivity extends AppCompatActivity {

    private ConstraintLayout loginButton, signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);

        loginButton = findViewById(R.id.tvLoginBtn);
        signupButton = findViewById(R.id.tvSignupBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}