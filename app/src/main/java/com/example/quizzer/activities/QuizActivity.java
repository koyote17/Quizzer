package com.example.quizzer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.quizzer.R;
import com.example.quizzer.models.Question;
import com.example.quizzer.repository.QuizRepository;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView categoryTv, questionTv;
    private Button answerA, answerB, answerC, answerD, confirmAnswer;
    private Button[] answerButtons;
    private ProgressBar quizProgress;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private boolean answerLocked = false;
    String playerName;
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quiz), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        loadData();
        displayQuestion();
        setupAnswerListeners();
    }

    private void initViews() {
        categoryTv = findViewById(R.id.category_text);
        questionTv = findViewById(R.id.questionTv);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);

        answerButtons = new Button[]{answerA, answerB, answerC, answerD};
        quizProgress = findViewById(R.id.quizProgress);

        playerName = getIntent().getStringExtra("PLAYER_NAME");
    }

    private void loadData() {
        String category = getIntent().getStringExtra("CATEGORY");
        categoryTv.setText(category);
        questions = QuizRepository.getQuestions(category);
        Collections.shuffle(questions);
        quizProgress.setMax(questions.size());
    }

    private void displayQuestion() {
        quizProgress.setProgress(currentQuestionIndex + 1);

        if (currentQuestionIndex >= questions.size()) {
            finishQuiz();
            return;
        }

        resetAnswerColors();
        answerLocked = false;

        Question question = questions.get(currentQuestionIndex);
        questionTv.setText(question.getQuestion());

        String[] answers = question.getAnswers();
        answerA.setText(answers[0]);
        answerB.setText(answers[1]);
        answerC.setText(answers[2]);
        answerD.setText(answers[3]);
    }

    private void resetAnswerColors() {
        for (Button btn : answerButtons) {
            btn.setBackgroundResource(R.drawable.btn_rectangle);
        }
    }

    private void setupAnswerListeners() {
        for (int i = 0; i < answerButtons.length; i++) {
            int index = i;
            answerButtons[i].setOnClickListener(v -> onAnswerClicked(index));
        }
    }

    private void onAnswerClicked(int selectedIndex) {
        if (answerLocked) return;
        answerLocked = true;


        answerButtons[selectedIndex].setBackgroundColor(getColor(R.color.answer_selected));

        handler.postDelayed(() -> {
            Question question = questions.get(currentQuestionIndex);
            int correctIndex = question.getCorrectIndex();

            if (selectedIndex == correctIndex) {
                answerButtons[selectedIndex].setBackgroundColor(getColor(R.color.correct_answer));
                score++;
            } else {
                answerButtons[selectedIndex].setBackgroundColor(getColor(R.color.incorrect_answer));
                answerButtons[correctIndex].setBackgroundColor(getColor(R.color.correct_answer));
            }

            handler.postDelayed(() -> {
                currentQuestionIndex++;
                displayQuestion();
            }, 1000);

        }, 2000);
    }

    private void finishQuiz() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("SCORE", score);
        intent.putExtra("TOTAL", questions.size());
        intent.putExtra("CATEGORY", categoryTv.getText().toString());
        intent.putExtra("PLAYER_NAME", playerName);
        startActivity(intent);
        finish();
    }
}