package com.app.daggarmvvmnotes.activities;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.daggarmvvmnotes.R;
import com.app.daggarmvvmnotes.adapter.SavedNotesAdapter;
import com.app.daggarmvvmnotes.db.AppDatabase;
import com.app.daggarmvvmnotes.db.Notes;
import com.app.daggarmvvmnotes.db.NotesDao;

import java.util.List;

public class SavedNoteActivity extends BaseActivity {
    private ImageView close;
    private TextView title;
    private RecyclerView notesView;
    private SavedNotesAdapter notesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_note);

        //finding views from layout
        close = findViewById(R.id.close);
        close.setVisibility(View.VISIBLE);
        title = findViewById(R.id.title);
        notesView = findViewById(R.id.savedViews);

        //Setting activity title
        title.setText(R.string.save_notes);

        //Handling click event
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //setting data on adapter
        setAdapter();
    }

    //Method for setting multiple notes on list view
    private void setAdapter(){
        try {
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setReverseLayout(true);
            mLayoutManager.setStackFromEnd(true);
            notesView.setLayoutManager(mLayoutManager);
            notesView.setItemAnimator(new DefaultItemAnimator());
            NotesDao messageDao = (NotesDao) AppDatabase.getInstance(getApplicationContext()).message();
            messageDao.getAllMessage().observe(this, (List<Notes> message) -> {
                if (message!=null &&message.size()>0) {
                    notesAdapter = new SavedNotesAdapter(this, message);
                    notesView.setAdapter(notesAdapter);
                }else {
                    Toast.makeText(this, R.string.no_note, Toast.LENGTH_SHORT).show();
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
