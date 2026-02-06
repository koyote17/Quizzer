package com.example.quizzer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizzer.R;

public class ResultActivity extends AppCompatActivity {

    private TextView categoryTv, scoreTv, resultMessageTv;
    private Button backBtn, tryAgainBtn;
    private String category, playerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        loadData();
        setupListeners();
    }


    private void initViews() {
        categoryTv = findViewById(R.id.resultCategoryTv);
        scoreTv = findViewById(R.id.resultScoreTv);
        backBtn = findViewById(R.id.backToMenuTv);
        tryAgainBtn = findViewById(R.id.tryAgainBtn);
        resultMessageTv = findViewById(R.id.resultMessageTv);
    }

    private void loadData() {
        category = getIntent().getStringExtra("CATEGORY");
        playerName = getIntent().getStringExtra("PLAYER_NAME");
        int score = getIntent().getIntExtra("SCORE", 0);
        int total = getIntent().getIntExtra("TOTAL", 0);

        categoryTv.setText(category);
        scoreTv.setText(score + " / " + total);

        String message = getResultMessage(score, total, playerName);
        resultMessageTv.setText(message);
    }

    private void setupListeners() {
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("PLAYER_NAME", playerName);
            startActivity(intent);
            finish();
        });

        tryAgainBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("CATEGORY", category);
            intent.putExtra("PLAYER_NAME", playerName);
            startActivity(intent);
            finish();
        });
    }

    private String getResultMessage(int score, int total, String name) {

        if (score == total) {
            return "🏆 PERFECT " + name + "!\nYou absolutely crushed it!";
        }
        else if (score >= total * 0.6) {
            return "😎 Great job " + name + "!\nYou really know your stuff.";
        }
        else if (score >= total * 0.3) {
            return "🤔 Not bad " + name + "!\nBut there is room for improvement.";
        }
        else {
            return "😅 Oops...\nMaybe try again " + name + "?";
        }
    }

}