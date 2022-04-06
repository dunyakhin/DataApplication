package com.example.firsttrying;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class EnterData extends AppCompatActivity implements View.OnClickListener {

    ViewModelProvider provider;
    Button upd;
    EnterDataViewModel enterDataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);
        upd=findViewById(R.id.firstbtn);
        upd.setOnClickListener(this);

        RecyclerView rv=findViewById(R.id.rv);
        MyRvAdapter adapter=new MyRvAdapter();
        rv.setAdapter(adapter);

        provider=new ViewModelProvider(this);
       enterDataViewModel=provider.get(EnterDataViewModel.class);
        getLifecycle().addObserver((LifecycleObserver) enterDataViewModel);
        provider.get(EnterDataViewModel.class).mld.observe(this, new Observer<List<RowData>>() {

            @Override
            public void onChanged(List<RowData> rowData) {
                adapter.updateItems(rowData);

            }

        });

}

    @Override
    public void onClick(View view) {
       enterDataViewModel.createNewRowData();

    }

}
