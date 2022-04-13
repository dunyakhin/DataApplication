package com.example.firsttrying.room;

/*
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;*/

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DatabaseUnit {
    @PrimaryKey
    public long id;
    public String km;
    public String coord;
    public String ipi;
    public String ve;
    public String note;

    public DatabaseUnit(long id,String km, String coord, String ipi, String ve, String note) {
        this.km = km;
        this.coord = coord;
        this.ipi = ipi;
        this.ve = ve;
        this.note = note;
        this.id=id;
    }

}
