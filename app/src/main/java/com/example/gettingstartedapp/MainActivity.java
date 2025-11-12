package com.example.gettingstartedapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gettingstartedapp.adapter.NoteAdapter;
import com.example.gettingstartedapp.helper.DatabaseHelper;
import com.example.gettingstartedapp.helper.SessionManager;
import com.example.gettingstartedapp.model.Note;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SessionManager sessionManager;
    private DatabaseHelper dbHelper;
    private TextView tvUsername;
    private RecyclerView rvNotes;
    private NoteAdapter noteAdapter;
    private ArrayList<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);
        dbHelper = new DatabaseHelper(this);

        tvUsername = findViewById(R.id.tvUsername);
        rvNotes = findViewById(R.id.rvNotes);

        // handle apakah sudah login atau belum?
        if (sessionManager.isLoggedIn()) {
            tvUsername.setText("Welcome, " + sessionManager.getUsername());
        } else {
            tvUsername.setText("Not logged in");
        }

        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        // load ulang data setiap kembali ke sini
        loadNotes();
    }

    private void loadNotes() {
        noteList = dbHelper.getAllNotes();
        noteAdapter = new NoteAdapter(noteList, new NoteAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(Note note) {
                // Handle klik item (Request 7)
                Intent intent = new Intent(MainActivity.this, NoteDetailActivity.class);
                intent.putExtra("NOTE_ID", note.getId());
                startActivity(intent);
            }
        });
        rvNotes.setAdapter(noteAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO: no 2 (inflate main_menu)

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        // TODO: no 2

        if (id == R.id.action_create_note) {
            // Pindah ke CreateNoteActivity
            // TODO: no 2

            return true;
        } else if (id == R.id.action_logout) {
            // Logout. sessionManager panggil logout untuk hapus info user
            sessionManager.logout();
            // TODO: no 2

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}