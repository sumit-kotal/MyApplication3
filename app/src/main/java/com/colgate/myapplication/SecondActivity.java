package com.colgate.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView appOne, appTwo,appThree,appName;
    Button submit,process;
    String one,two,three;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        one  = preferences.getString("key_one",null);
        two = preferences.getString("key_two",null);
        three = preferences.getString("key_three",null);

        appOne = findViewById(R.id.edt_app_one);
        appTwo = findViewById(R.id.edt_app_two);
        appThree = findViewById(R.id.edt_app_three);
        appName = findViewById(R.id.txt_app_name);

        submit = findViewById(R.id.btn_submit);
        process = findViewById(R.id.btn_process);

        appOne.setText(one);
        appTwo.setText(two);
        appThree.setText(three);

        submit.setOnClickListener(this);
        process.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        one = appOne.getText().toString();
        two = appTwo.getText().toString();
        three = appThree.getText().toString();

        switch (view.getId()){
            case R.id.btn_submit:
                Intent it = new Intent(SecondActivity.this,MainActivity.class);
                it.putExtra("key_one",one);
                it.putExtra("key_two",two);
                it.putExtra("key_three",three);

                startActivity(it);
                break;
            case R.id.btn_process:
                appName.setText(one+" -- "+two+" -- "+three);
                Toast.makeText(SecondActivity.this, "Process button clicked", Toast.LENGTH_SHORT).show();

                break;
        }



    }
}
