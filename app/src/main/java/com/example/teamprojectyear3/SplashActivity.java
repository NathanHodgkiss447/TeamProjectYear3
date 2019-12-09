package com.example.teamprojectyear3;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progressSplash;

    private static int SPLASH_TIME = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Removes the top bar from the splash screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        //declare progress bar
        progressSplash = findViewById(R.id.progressSplash);


        progressStart();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent hIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(hIntent);
                finish();
            }
        },SPLASH_TIME);


    }
    //Method to run progress bar for 4.5 seconds
    public void progressStart(){
        ObjectAnimator.ofInt(progressSplash, "progress",100)
        .setDuration(4500)
        .start();
    }
}
