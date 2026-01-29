package com.example.quizzer.activities;

import android.os.Bundle;
import android.widget.Button;
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

import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView categoryTv, questionTv;
    private Button answerA, answerB, answerC, answerD, confirmAnswer;

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quiz), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();
        loadData();
        displayQuestions();
        setupAnswersListeners();

    }

    private void initViews() {
        categoryTv = findViewById(R.id.category_text);
        questionTv = findViewById(R.id.questionTv);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);
        confirmAnswer = findViewById(R.id.confirmAnswerBtn);
    }

    private void loadData() {
        String category = getIntent().getStringExtra("CATEGORY");
        categoryTv.setText(category);
        questions = QuizRepository.getQuestions(category);
    }

    private void displayQuestions() {
        if (currentQuestionIndex >= questions.size()) {
            finishQuiz();
            return;
        }

        Question question = questions.get(currentQuestionIndex);
        questionTv.setText(question.getQuestion());

        String[] answers = question.getAnswers();
        answerA.setText(answers[0]);
        answerB.setText(answers[1]);
        answerC.setText(answers[2]);
        answerD.setText(answers[3]);
    }

    private void setupAnswersListeners() {
        answerA.setOnClickListener(v -> checkAnswer(0));
        answerB.setOnClickListener(v -> checkAnswer(1));
        answerC.setOnClickListener(v -> checkAnswer(2));
        answerD.setOnClickListener(v -> checkAnswer(3));
    }

    private void checkAnswer(int selectedIndex) {
        Question question = questions.get(currentQuestionIndex);

        if (selectedIndex == question.getCorrectIndex()) {
            score++;
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else { Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show(); }
        currentQuestionIndex++;
        displayQuestions();

    }

    private void finishQuiz() {
        Toast.makeText(
                this,
                "Your score is : " + score+ "/" + questions.size(),
                Toast.LENGTH_LONG).show();
        finish();
    }
}