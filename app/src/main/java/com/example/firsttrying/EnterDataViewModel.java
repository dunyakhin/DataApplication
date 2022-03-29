package com.example.firsttrying;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.ArrayList;
import java.util.List;


public class EnterDataViewModel extends AndroidViewModel implements LifecycleObserver{
    List<RowData> data=new ArrayList<>();
    MutableLiveData<List<RowData>> mld=new MutableLiveData<>();

    public EnterDataViewModel(@NonNull Application application) {
        super(application);
        data.add(new RowData("km","vp", "7426.000,6346", "korobovo", "10"));
        mld.setValue(data);
    }

    void createNewRowData(){
        data.add(new RowData("1","vp", "", "", ""));
        mld.setValue(data);


    }



    }

