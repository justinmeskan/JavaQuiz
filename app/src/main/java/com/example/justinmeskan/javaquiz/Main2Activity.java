package com.example.justinmeskan.javaquiz;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    //created a variable to store my message from the other activity
    String message = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //this is where I am grabbing the intent from the last Activity
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.SCORE);
        TextView tv = findViewById(R.id.grade);
        tv.setText(message);
    }
    //Am here i am using an intent to send an email if the user would like there score emailed to them
    public void sendEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Your Quiz Score");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(Intent.createChooser(intent, "Send Email"));
        }
    }
}
