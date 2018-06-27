package com.app.daggarmvvmnotes.viewmodels;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.widget.Toast;

import com.app.daggarmvvmnotes.R;
import com.app.daggarmvvmnotes.activities.CreateNoteActivity;
import com.app.daggarmvvmnotes.db.AppDatabase;
import com.app.daggarmvvmnotes.db.Notes;
import com.app.daggarmvvmnotes.db.NotesDao;


public class MainViewModel extends BaseViewModel implements IViewModel {
    private static final String TAG = MainViewModel.class.toString();
    public MainViewModel() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }
    //This method performs all the saving operation of notes in notes table
    @Override
    public void setCurrentActivity(Activity value,String text) {
        Notes content = new Notes(text);
        //add new message to database
        NotesDao messageDao = (NotesDao) AppDatabase.getInstance(value).message();
        messageDao.insertNewMessage(content);
        Toast.makeText(value, R.string.note_saved, Toast.LENGTH_SHORT).show();

    }

}
