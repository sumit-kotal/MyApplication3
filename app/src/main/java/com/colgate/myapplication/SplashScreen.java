package com.colgate.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            @Override

            public void run() {


                Intent i = new Intent(SplashScreen.this,SecondActivity.class);

                startActivity(i);

                finish();

            }

        }, 5*1000); // wait for 5 seconds
    }
}
