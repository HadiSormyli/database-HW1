package com.example.quizapp.model;

public class Queztion {

    private int answerResID;
    private boolean answerTrue;

    public int getAnswerResID() {
        return answerResID;
    }

    public void setAnswerResID(int answerResID) {
        this.answerResID = answerResID;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }

    public Queztion(int answerResID, boolean answerTrue) {
        this.answerResID = answerResID;
        this.answerTrue = answerTrue;
    }


}
