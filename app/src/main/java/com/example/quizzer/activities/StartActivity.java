package com.example.quizzer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizzer.R;

public class StartActivity extends AppCompatActivity {

    EditText nameEt;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nameEt = findViewById(R.id.nameEt);
        startBtn = findViewById(R.id.startBtn);

        startBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString().trim();
            if (name.isEmpty()) {
                nameEt.setError("Please enter your name");
                return;
            }

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("PLAYER_NAME", name);
            startActivity(intent);
            finish();
        });

    }
}