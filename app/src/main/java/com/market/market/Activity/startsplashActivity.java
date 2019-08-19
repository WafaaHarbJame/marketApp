package com.market.market.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import com.market.market.R;



import com.market.market.MainActivity;

public class startsplashActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    public static final int SPLASH_TIME = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_startsplash);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.getIndeterminateDrawable()
                .setColorFilter( Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_IN);
        new CountDownTimer(SPLASH_TIME, 1000) {

            @Override
            public void onFinish() {
                progressBar.setVisibility(View.GONE);

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
