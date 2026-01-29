package com.example.quizzer.models;

public class QuizResults {
    private String quizCategory;
    private int score;

    public QuizResults(String quizCategory, int score) {
        this.quizCategory = quizCategory;
        this.score = score;
    }

    public String getQuizCategory() { return quizCategory; }
    public int getScore() { return score; }
}
