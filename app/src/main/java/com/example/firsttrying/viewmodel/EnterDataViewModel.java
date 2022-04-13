package com.example.firsttrying.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.firsttrying.EnterData;
import com.example.firsttrying.RowData;
import com.example.firsttrying.room.DataBase;
import com.example.firsttrying.room.DatabaseUnit;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class EnterDataViewModel extends AndroidViewModel implements LifecycleObserver{
    List<DatabaseUnit> data=new ArrayList<>();
    private long dataCounter=1;
   public MutableLiveData<List<DatabaseUnit>> mld=new MutableLiveData<>();
    DataBase dataBase=null;

    public EnterDataViewModel(@NonNull Application application) {
        super(application);
        dataBase=Room.databaseBuilder(application, DataBase.class,"test").fallbackToDestructiveMigration().build();

        new AsyncTask<Void, Void, List<DatabaseUnit>>() {
            @Override
            protected List<DatabaseUnit> doInBackground(Void... voids) {
                return dataBase.daoData().getAll();
            }

            @Override
            protected void onPostExecute(List<DatabaseUnit> databaseUnits) {
                super.onPostExecute(databaseUnits);
                long maxID=1;
                for(DatabaseUnit unit:databaseUnits){
                    if(unit.id>=maxID){
                        maxID=unit.id+1;
                    }
                }
                data.addAll(databaseUnits);
               mld.setValue(data);
            }
        }.execute();
    }
    public void createNewRowData(){
        dataCounter++;
        DatabaseUnit newDbUnit=new DatabaseUnit(dataCounter," "," ", " ", " ", " ");
        data.add(newDbUnit);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                dataBase.daoData().insert(newDbUnit);
                return null;

            }

        }.execute();
        mld.setValue(data);
    }
    public void saveAll(){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                dataBase.daoData().insert(mld.getValue());
                return null;

            }

        }.execute();
    }
    public void saveToFile(File file){
        try {
            FileWriter output=new FileWriter(file);
            for(DatabaseUnit unit:data){
            String result= new StringBuilder().append(unit.km).append(";").append(unit.coord).append(";").append(unit.ipi).append(";").append(unit.ve).append(";").append(unit.note).append("\n").toString();
            output.write(result);
            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

