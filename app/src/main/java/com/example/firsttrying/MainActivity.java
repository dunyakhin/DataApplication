package com.example.firsttrying;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

Button first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    first=findViewById(R.id.firstbutton);
    second=findViewById(R.id.secondbutton);
    first.setOnClickListener(this);
    second.setOnClickListener(this);

            }

    @Override
    public void onClick(View view) {
        Intent startEnterData=new Intent(this,EnterData.class);
        startActivity(startEnterData);
    }
}



