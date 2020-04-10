package com.colgate.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3;

    Intent it;

    String appOne, appTwo, appThree;

    SharedPreferences preferences;

    String PREFERENCE_NAME = "MyPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showLog("Activity Created");

        it = getIntent();

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        appOne = it.getStringExtra("key_one");
        appTwo = it.getStringExtra("key_two");
        appThree = it.getStringExtra("key_three");

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("key_one",appOne);
        editor.putString("key_two",appTwo);
        editor.putString("key_three",appThree);
        editor.commit();

        t1 = findViewById(R.id.txt1);
        t2 = findViewById(R.id.txt2);
        t3 = findViewById(R.id.txt3);


        t1.setText(appOne);
        t2.setText(appTwo);
        t3.setText(appThree);
    }

    private void showLog(String activity_created) {
        Log.d("Task - ",activity_created);
    }

    @Override

    protected void onRestart(){

        super.onRestart();//call to restart after onStop

        showLog("Activity restarted");

    }

    @Override

    protected void onStart() {

        super.onStart();//soon be visible

        showLog("Activity started");

    }

    @Override

    protected void onResume() {

        super.onResume();//visible

        showLog("Activity resumed");

    }

    @Override

    protected void onPause() {

        super.onPause();//invisible

        showLog("Activity paused");

    }

    @Override

    protected void onStop() {

        super.onStop();

        showLog("Activity stopped");

    }

    @Override

    protected void onDestroy() {

        super.onDestroy();

        showLog("Activity is being destroyed");

    }
}
