package com.whatisthisdeveloper.mathematics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class playActivity extends AppCompatActivity {
    public static Button scoreButton;
    public Button helpButton;
    public static Button playButton;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getSupportActionBar().hide();


        scoreButton = (Button) findViewById(R.id.scoreButton);
        helpButton = (Button) findViewById(R.id.helpButton);
        playButton =(Button)  findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();

            }
        });

        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getScore();
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getHelp();
            }
        });

    }

    public void startGame(){

        Intent intent = new Intent(playActivity.this, gameActivity.class);
        startActivity(intent);

    }
    public void getScore(){

        startActivity(new Intent(playActivity.this, scoreActivity.class));
    }
    public void getHelp(){

        startActivity(new Intent(playActivity.this, helpActivity.class));


    }
}
