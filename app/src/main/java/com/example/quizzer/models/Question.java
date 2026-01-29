package com.example.quizzer.models;

public class Question {
    private String question;
    private String[] answer;
    private int correctIndex;

    public Question(String question, String[] answer, int correctIndex) {
        this.question = question;
        this.answer = answer;
        this.correctIndex = correctIndex;
    }

    public String getQuestion() { return question;}
    public String[] getAnswers() { return answer;}
    public int getCorrectIndex() {return correctIndex;}
}
