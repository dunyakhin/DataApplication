package com.example.firsttrying;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.firsttrying.room.DatabaseUnit;
import com.example.firsttrying.viewmodel.EnterDataViewModel;

import java.io.File;
import java.util.List;

public class EnterData extends AppCompatActivity implements View.OnClickListener {

    ViewModelProvider provider;
    Button upd, save;
    EnterDataViewModel enterDataViewModel;
    RecyclerView rv;
    MyRvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);
        Intent intent=getIntent();
        String result=intent.getStringExtra("title");
        upd=findViewById(R.id.firstbtn);
        upd.setOnClickListener(this);
        save=findViewById(R.id.button2);
        save.setOnClickListener(view -> {
        File file=new File(getApplicationContext().getExternalCacheDir(),result+".xls");
            enterDataViewModel.saveToFile(file);
            Toast.makeText(this,"Загружено в"+file.getAbsolutePath(), Toast.LENGTH_LONG).show();

            adapter.clearData();
            adapter.notifyDataSetChanged();

        });
        rv=findViewById(R.id.rv);
        adapter=new MyRvAdapter();
        rv.setAdapter(adapter);

        provider=new ViewModelProvider(this);
       enterDataViewModel=provider.get(EnterDataViewModel.class);
        getLifecycle().addObserver((LifecycleObserver) enterDataViewModel);
        provider.get(EnterDataViewModel.class).mld.observe(this, new Observer<List<DatabaseUnit>>() {

            @Override
            public void onChanged(List<DatabaseUnit> rowData) {
                adapter.updateItems(rowData);

            }

        });



}
    public boolean onCreateOptionsMenu(Menu menu){
menu.add("Очистить");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getTitle().toString()){
            case "Очистить":
                adapter.clearData();
                adapter.notifyDataSetChanged();
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
       enterDataViewModel.createNewRowData();

    }

    @Override
    protected void onPause() {
        super.onPause();
        enterDataViewModel.saveAll();
    }

    @Override
    protected void onStop() {
        super.onStop();
        provider.get(EnterDataViewModel.class).mld.setValue(null);
        adapter.clearData();
        adapter.notifyDataSetChanged();

    }
}
