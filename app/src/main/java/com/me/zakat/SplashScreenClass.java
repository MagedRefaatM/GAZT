package com.me.zakat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenClass extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent mainActivityIntent = new Intent(SplashScreenClass.this, MainActivity.class);
                startActivity(mainActivityIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}