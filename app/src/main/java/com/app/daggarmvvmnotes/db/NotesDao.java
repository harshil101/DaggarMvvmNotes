package com.app.daggarmvvmnotes.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;
//Interface for performing various sql operations
@Dao
public interface NotesDao {

    @Query("Select * from Notes")
    public LiveData<List<Notes>> getAllMessage();

    @Insert(onConflict = REPLACE)
    public void insertNewMessage(Notes message);
}
