package com.example.firsttrying.room;

/*
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
*/

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoData {

    @Query("SELECT * FROM DatabaseUnit")
   List<DatabaseUnit>getAll();
    @Query ("SELECT * FROM DatabaseUnit where id=:id")
    DatabaseUnit getById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DatabaseUnit dataUnit);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List <DatabaseUnit> dataUnit);

    @Update
    void update(DatabaseUnit dataUnit);

    @Delete
    void delete(DatabaseUnit dataUnit);
}
