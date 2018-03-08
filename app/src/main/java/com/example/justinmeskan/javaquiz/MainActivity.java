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
    private int test(int id, int quest){
        RadioGroup rg1 = (RadioGroup) findViewById(id);
        int rg1ID = rg1.getCheckedRadioButtonId();
        if (rg1ID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(rg1ID);
            String text = selectedRadioButton.getText().toString();
            if(text == getString(quest)){
                return 1;
            }
        }
        return 0;
    }

    public void runTest(View view){
        int q1 = test(R.id.question1, R.string.q1b);
        int q2 = test(R.id.question2, R.string.q2c);
        int q3 = test(R.id.question3, R.string.q3a);
        int q4 = test(R.id.question4, R.string.q4b);
        int q5 = test(R.id.question5, R.string.q5d);
        int q6 = test(R.id.question6, R.string.q6b);
        int q7 = test(R.id.question7, R.string.q7a);
        int q8 = test(R.id.question8, R.string.q8b);
        score = 0;
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
