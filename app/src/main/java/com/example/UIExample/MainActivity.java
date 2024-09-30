package com.example.UIExample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.UIExample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up OnClickListener for table elements
        TableLayout tableLayout = findViewById(R.id.tlMain);
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            View child = tableLayout.getChildAt(i);
            if (child instanceof TableRow) {
                TableRow row = (TableRow) child;
                for (int j = 0; j < row.getChildCount(); j++) {
                    View element = row.getChildAt(j);
                    element.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (element instanceof ViewGroup) {
                                ViewGroup viewGroup = (ViewGroup) element;
                                View innerElement = viewGroup.getChildAt(1);
                                if (innerElement instanceof TextView) {
                                    String text = ((TextView) innerElement).getText().toString();
                                    Toast.makeText(MainActivity.this, "Clicked: " + text, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
            }
        }

        // Set up OnClickListener for logout button
        Button logoutButton = findViewById(R.id.btnLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });
    }
}