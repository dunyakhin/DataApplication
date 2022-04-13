package com.example.firsttrying.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.firsttrying.MainActivity;
import com.example.firsttrying.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_xml);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main=new Intent(SplashActivity.this, MainActivity.class);
                startActivity(main);
                finish();
            }
        },2000);
    }
}