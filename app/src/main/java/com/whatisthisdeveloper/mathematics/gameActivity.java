package com.whatisthisdeveloper.mathematics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import static com.whatisthisdeveloper.mathematics.MainActivity.totalAnswer;
import static com.whatisthisdeveloper.mathematics.MainActivity.totalTotal;

public class gameActivity extends AppCompatActivity {

    public int firstNumber = 1;
    public int secondNumber = 1;
    public int results = 0;
    public int finalValue;
    TextView frNum;
    TextView srNum;
    EditText et_answers;
    TextView oper;
    Button submit;
    Random rand = new Random();
    TextView et_points;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getSupportActionBar().hide();


        frNum = (TextView) findViewById(R.id.firstNumbertxt);
        srNum = (TextView) findViewById(R.id.secondNumbertxt);
        et_answers = (EditText) findViewById(R.id.et_answers);
        oper = (TextView) findViewById(R.id.operatortxt);
        submit = (Button) findViewById(R.id.submitButton);
        oper.setText("+");
        et_points = (TextView) findViewById(R.id.et_points);
        newNumber();

        submit.setOnClickListener(new submitButtonClick());


    }


    public void submitButtonClicked() {

        String value = et_answers.getText().toString();
        finalValue = Integer.parseInt(value);
        results = (firstNumber + secondNumber);
        newNumber();
        et_answers.setText("");

    }

    public void newNumber(){

        firstNumber=(rand.nextInt(10)+1);
        secondNumber=(rand.nextInt(10)+1);
        frNum.setText(Integer.toString(firstNumber));
        srNum.setText(Integer.toString(secondNumber));
    }

    class submitButtonClick implements View.OnClickListener {
        public int counter = 0;
        public int points = 0;

        @Override
        public void onClick(View view) {
            counter++;
            totalTotal++;

            if (counter == 5){
                Intent finish = new Intent(gameActivity.this, playActivity.class);
                startActivity(finish);



            }

            submitButtonClicked();


            if (results == finalValue){
                points++;
                et_points.setText(Integer.toString(points));
                totalAnswer++;

            }

        }

    }


}



