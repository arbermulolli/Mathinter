package com.whatisthisdeveloper.mathematics;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class helpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getSupportActionBar().hide();


        TextView v_name = (TextView) findViewById(R.id.vname);
        TextView v_code = (TextView) findViewById(R.id.vcode);



       try {
           PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
           String version = packageInfo.versionName;
           int verCode = packageInfo.versionCode;
           v_code.setText(Integer.toString(verCode));
           v_name.setText(version);

       } catch (PackageManager.NameNotFoundException e) {
           e.printStackTrace();
       }

    }
}