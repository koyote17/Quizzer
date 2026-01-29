package com.example.quizzer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizzer.R;
import com.example.quizzer.models.Question;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button citiesBtn;
    private Button historyBtn;
    private Button sportBtn;
    private Button carsBtn;
    private Button resultsBtn;

    private List<Question> questions;
    private int currentIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        setupClickListeners();
    }


    private void initViews() {
        citiesBtn = findViewById(R.id.cities_btn);
        historyBtn = findViewById(R.id.history_btn);
        sportBtn = findViewById(R.id.sport_btn);
        carsBtn = findViewById(R.id.cars_btn);
        resultsBtn = findViewById(R.id.results_btn);
    }

    private void setupClickListeners() {
        citiesBtn.setOnClickListener(v -> startQuiz("CITIES"));
        historyBtn.setOnClickListener(v -> startQuiz("HISTORY"));
        sportBtn.setOnClickListener(v -> startQuiz("SPORT"));
        carsBtn.setOnClickListener(v -> startQuiz("CARS"));
        resultsBtn.setOnClickListener(v -> {
            //TODO
        });
    }


    private void startQuiz(String category) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("CATEGORY", category);
        startActivity(intent);
    }
}