package com.example.justinmeskan.javaquiz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    //this variable is for my intent at the bottom of the page.
    public static final String SCORE = "com.example.justinmeskan.javaquiz.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // I created a method so i wouldn't have to repeat sthe same code for every question
    private int checkAnswer(int id, int quest){
        RadioGroup rg = (RadioGroup) findViewById(id);
        int rgID = rg.getCheckedRadioButtonId();
        if (rgID != -1) {
            RadioButton selectedRadioButton = (RadioButton) findViewById(rgID);
            String text = selectedRadioButton.getText().toString();
            if(text == getString(quest)){
                return 1;
            }
        }
        return 0;
    }
    //This is were I check the anwsers and grade the quiz
    public void gradeQuiz(View view){
        String final_score = "";
        //these methods actuals store a point if the correct anwser was choosen
        int questionOnePoint = checkAnswer(R.id.question1, R.string.q1b);
        int questionTwoPoint = checkAnswer(R.id.question2, R.string.q2c);
        int questionThreePoint = checkAnswer(R.id.question3, R.string.q3a);
        int questionFourPoint = checkAnswer(R.id.question4, R.string.q4b);
        int questionFivePoint = checkAnswer(R.id.question5, R.string.q5d);
        int questionSixPoint = checkAnswer(R.id.question6, R.string.q6b);
        int questionSevenPoint = checkAnswer(R.id.question7, R.string.q7a);
        int questionEightPoint = checkAnswer(R.id.question8, R.string.q8b);
        //This is where i add up all the correct anwsers
        int score = questionOnePoint + questionTwoPoint + questionThreePoint + questionFourPoint;
        score += questionFivePoint + questionSixPoint + questionSevenPoint + questionEightPoint;
        //Here i test my final score again different amounts and assign a grade to final_score
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
        //I build the final output string here
        String report_card = "You got a " + final_score + "\nYou got "+ score + " answers right!";
        //At this fun spot I actual switch Activities and post my anwser on a completely different View or screen
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(SCORE, report_card);
        startActivity(intent);
    }
}
