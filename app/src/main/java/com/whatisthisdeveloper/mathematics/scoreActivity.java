package com.whatisthisdeveloper.mathematics;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static com.whatisthisdeveloper.mathematics.MainActivity.totalAnswer;
import static com.whatisthisdeveloper.mathematics.MainActivity.totalTotal;

public class scoreActivity extends AppCompatActivity {
    TextView et_correct;
    TextView et_answers;
    TextView et_ratio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getSupportActionBar().hide();

        double ratio1 = totalAnswer;
        double ratio2 = totalTotal;
        double ratio = (ratio1/ratio2)*100;

        TextView et_correct = (TextView) findViewById(R.id.et_scoreCorrect);
        TextView et_answers = (TextView) findViewById(R.id.et_scoreTotal);
        TextView et_ratio = (TextView) findViewById(R.id.et_ratio);



        et_correct.setText(String.valueOf(totalAnswer));
        et_answers.setText(String.valueOf(totalTotal));
        et_ratio.setText(String.format("%.1f",ratio));






    }
}