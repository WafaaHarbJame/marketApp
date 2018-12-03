package com.h2oapp.h2o.Activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.h2oapp.h2o.MainActivity;
import com.h2oapp.h2o.R;

public class ActivitySplash extends AppCompatActivity {
    private ProgressBar progressBar;
    public static final int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
       // progressBar = findViewById(R.id.progressBar);
       // progressBar.setVisibility(View.VISIBLE);

        new CountDownTimer(SPLASH_TIME, 1000) {

            @Override
            public void onFinish() {

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();

    }







    @Override
    public void onBackPressed()
    {

        super.onBackPressed();
    }
}
