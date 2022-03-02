package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.quizapp.databinding.ActivityMainBinding;
import com.example.quizapp.model.Queztion;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Queztion> queztions;
    private int currentQuztionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addQuestions();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.questionTextView.setText(queztions.get(0).getAnswerResID());

        binding.nextButton.setOnClickListener(view -> changeQuetion(1));
        binding.preBuuton.setOnClickListener(view -> {
            if (currentQuztionIndex > 0)
                changeQuetion(-1);
        });

        binding.trueButton.setOnClickListener(view->checkAnswer(true));
        binding.falseButton.setOnClickListener(view->checkAnswer(false));
    }

    private void changeQuetion(int manner) {
        currentQuztionIndex = (currentQuztionIndex + manner) % queztions.size();
        Log.d("Main", "onCreate " + currentQuztionIndex);
        binding.questionTextView.setText(queztions.get(currentQuztionIndex).getAnswerResID());
    }

    private void checkAnswer(boolean userAnswer) {
        boolean answer = queztions.get(currentQuztionIndex).isAnswerTrue();
        int messagID;
        messagID = ((answer == userAnswer)) ? R.string.corrot_answer : R.string.wrong_answer;
        Snackbar.make(binding.imageView, messagID, Snackbar.LENGTH_SHORT).show();
        changeQuetion(1);
    }

    private void addQuestions() {
        queztions = new ArrayList<>();
        queztions.add(new Queztion(R.string.question_1, true));
        queztions.add(new Queztion(R.string.question_2, false));
        queztions.add(new Queztion(R.string.question_3, true));
        queztions.add(new Queztion(R.string.question_4, true));
        queztions.add(new Queztion(R.string.question_5, false));
        queztions.add(new Queztion(R.string.question_6, true));
        queztions.add(new Queztion(R.string.question_7, true));
        queztions.add(new Queztion(R.string.question_8, false));
        queztions.add(new Queztion(R.string.question_9, false));
        queztions.add(new Queztion(R.string.question_10, true));
        queztions.add(new Queztion(R.string.question_11, false));
    }
}