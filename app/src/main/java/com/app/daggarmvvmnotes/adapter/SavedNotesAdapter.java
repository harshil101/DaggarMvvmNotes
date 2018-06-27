package com.app.daggarmvvmnotes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.daggarmvvmnotes.R;
import com.app.daggarmvvmnotes.db.Notes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SavedNotesAdapter extends RecyclerView.Adapter<SavedNotesAdapter.Holder> {
    Context context;
    private List<Notes> noteList;
    //Constructor to initialize items
    public SavedNotesAdapter(Context context, List<Notes> noteList) {
        this.context = context;
        this.noteList = noteList;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_saved_notes,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        if (noteList!=null && noteList.size()>0){
            //Fething each notes according to position in list
            final Notes item = noteList.get(position);
            //Setting individual note on list row
            holder.quoteText.setText(item.getContent());
        }
    }
    @Override
    public int getItemCount() {
        return noteList.size();
    }

    //Inner class for holder pattern
    class Holder extends RecyclerView.ViewHolder {
        TextView quoteText;
        public Holder(View itemView) {
            super(itemView);
            //Finding view in list row
            quoteText =  itemView.findViewById(R.id.quoteText);
        }
    }
}
