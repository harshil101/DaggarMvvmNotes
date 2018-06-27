package com.app.daggarmvvmnotes.activities;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.daggarmvvmnotes.MyApplication;
import com.app.daggarmvvmnotes.R;
import com.app.daggarmvvmnotes.viewmodels.MainViewModel;

import javax.inject.Inject;

public class CreateNoteActivity extends BaseActivity implements View.OnClickListener{
    private Button save;
    //Injecting view model in view
    @Inject
    MainViewModel mMainViewModel;
    private EditText noteHeading;
    private TextView clickSaveNotes;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MyApplication) getApplication()).getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        //Setting activity title
        TextView title = findViewById(R.id.title);
        title.setText(R.string.create_note);

        //finding views from layout
        save = findViewById(R.id.save);
        noteHeading = findViewById(R.id.noteHeading);
        clickSaveNotes = findViewById(R.id.clickSaveNotes);

        // Get the ViewModel.
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        //Registering click events
        save.setOnClickListener(this);
        clickSaveNotes.setOnClickListener(this);
    }

    //Overrided method
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.save:
                //Checking field validation
                if (TextUtils.isEmpty(noteHeading.getText().toString().trim())){
                    Toast.makeText(CreateNoteActivity.this, R.string.add_note_validation, Toast.LENGTH_SHORT).show();
                }else {
                    //Accessing method return in viewmodel
                    mMainViewModel.setCurrentActivity(CreateNoteActivity.this,noteHeading.getText().toString());
                    noteHeading.setText("");
                }
                break;
            case R.id.clickSaveNotes:
                //Navigating to saved notes activity
                startActivity(new Intent(CreateNoteActivity.this,SavedNoteActivity.class));
                break;
        }
    }
}
