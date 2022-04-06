package com.example.firsttrying;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.AndroidViewModel;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

Button  addBtn;
ListView lv;
ArrayList<String> data=new ArrayList<>();
ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = findViewById(R.id.addRowBtn);
        lv = findViewById(R.id.listview);
        addBtn.setOnClickListener(this);
        Intent intent=new Intent(this, EnterData.class);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(intent);
            }
        });

    }


    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.addRowBtn:
                FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                Fragment addRowFragment=new AddRowFragment();
                ft.replace(R.id.default_background,addRowFragment);
                fm.setFragmentResultListener("requestKey", this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                    String results=result.getString("resultKey");
                    data.add(0,results);
                    adapter.notifyDataSetChanged();
                    }
                });
                ft.addToBackStack(null);
                ft.commit();
                break;
        }


    }

}



