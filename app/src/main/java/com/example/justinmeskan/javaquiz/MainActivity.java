package com.example.justinmeskan.javaquiz;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String SCORE = "com.example.justinmeskan.javaquiz.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;
    public void runTest(View view){
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;
        int q4 = 0;
        int q5 = 0;
        int q6 = 0;
        int q7 = 0;
        int q8 = 0;
        score = 0;
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.question1);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.question2);
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.question3);
        RadioGroup rg4 = (RadioGroup) findViewById(R.id.question4);
        RadioGroup rg5 = (RadioGroup) findViewById(R.id.question5);
        RadioGroup rg6 = (RadioGroup) findViewById(R.id.question6);
        RadioGroup rg7 = (RadioGroup) findViewById(R.id.question7);
        RadioGroup rg8 = (RadioGroup) findViewById(R.id.question8);
        int rg1ID = rg1.getCheckedRadioButtonId();
        int rg2ID = rg2.getCheckedRadioButtonId();
        int rg3ID = rg3.getCheckedRadioButtonId();
        int rg4ID = rg4.getCheckedRadioButtonId();
        int rg5ID = rg5.getCheckedRadioButtonId();
        int rg6ID = rg6.getCheckedRadioButtonId();
        int rg7ID = rg7.getCheckedRadioButtonId();
        int rg8ID = rg8.getCheckedRadioButtonId();
        if (rg1ID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(rg1ID);
            String text = selectedRadioButton.getText().toString();
            if(text == getString(R.string.q1b)){
                q1 = 1;
            }
        }
        if (rg2ID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(rg2ID);
            String text = selectedRadioButton.getText().toString();
            if(text == getString(R.string.q2c)){
                q2 = 1;
            }
        }
        if (rg3ID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(rg3ID);
            String text = selectedRadioButton.getText().toString();
            if(text == getString(R.string.q3a)){
                q3 = 1;
            }
        }
        if (rg4ID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(rg4ID);
            String text = selectedRadioButton.getText().toString();
            if(text == getString(R.string.q4b)){
                q4 = 1;
            }
        }
        if (rg5ID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(rg5ID);
            String text = selectedRadioButton.getText().toString();
            if(text == getString(R.string.q5d)){
                q5 = 1;
            }
        }
        if (rg6ID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(rg6ID);
            String text = selectedRadioButton.getText().toString();
            if(text == getString(R.string.q6b)){
                q6 = 1;
            }
        }
        if (rg7ID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(rg7ID);
            String text = selectedRadioButton.getText().toString();
            if(text == getString(R.string.q7a)){
                q7 = 1;
            }
        }
        if (rg8ID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(rg8ID);
            String text = selectedRadioButton.getText().toString();
            if(text == getString(R.string.q8b)){
                q8 = 1;
            }
        }
        score = q1 + q2 + q3 + q4 + q5 + q6 + q7 + q8;
        Log.v("tes the score", "om omg omg omg-"+score);
        String final_score = "";
        if(score == 8){
            final_score = "A+";
        }else if(score == 7){
            final_score = "A";
        }else if(score == 6){
            final_score = "B+";
        }else if(score == 5){
            final_score = "B";
        }else if(score == 4){
            final_score = "C+";
        }else if(score == 3){
            final_score = "C";
        }else if(score == 2){
            final_score = "D+";
        }else if(score == 1){
            final_score = "D";
        }else if(score == 0){
            final_score = "F";
        }
        String report_card = "You got a " + final_score + "\nYou got "+ score + " answers right!";
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(SCORE, report_card);
        startActivity(intent);
    }
}
