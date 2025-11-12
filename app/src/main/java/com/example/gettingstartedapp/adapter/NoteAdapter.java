package com.example.gettingstartedapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gettingstartedapp.R;
import com.example.gettingstartedapp.helper.DatabaseHelper;
import com.example.gettingstartedapp.model.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<Note> noteList;
    private OnNoteClickListener onNoteClickListener;

    public interface OnNoteClickListener {
        void onNoteClick(Note note);
    }

    public NoteAdapter(List<Note> noteList, OnNoteClickListener onNoteClickListener) {
        this.noteList = noteList;
        this.onNoteClickListener = onNoteClickListener;
    }

    @NonNull
    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteViewHolder holder, int position) {
        // TODO: no 7
        Note note = noteList.get(position);
        holder.bind(note, onNoteClickListener);
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNoteTitle, tvNoteLastEdited;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNoteTitle = itemView.findViewById(R.id.tvNoteTitle);
            tvNoteLastEdited = itemView.findViewById(R.id.tvNoteLastEdited);
        }

        public void bind(final Note note, final OnNoteClickListener listener) {
            tvNoteTitle.setText(note.getTitle());
            String formattedDate = DatabaseHelper.formatTimestamp(note.getLastEditedAt());
            tvNoteLastEdited.setText("Last Edited: " + formattedDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNoteClick(note);
                }
            });
        }
    }
}
