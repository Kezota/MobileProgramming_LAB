package com.example.gettingstartedapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SongAdapter.onItemClickListener {

    RecyclerView rvMainSongs;
    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String scope = "onCreate";

        rvMainSongs = findViewById(R.id.rvMainSongs);
        songs = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            songs.add(new Song("Song " + (i + 1), "Artist " + (i + 1)));
            Log.v(scope, "Added: Song " + (i + 1) + " by Artist " + (i + 1));
        }

        SongAdapter adapter = new SongAdapter(songs, this);
        rvMainSongs.setAdapter(adapter);
        rvMainSongs.setLayoutManager(new LinearLayoutManager(this));
        Log.v(scope, "Adapter set with " + songs.size() + " songs.");
    }

    @Override
    public void onItemClick(Song song) {
        Toast.makeText(this, song.title + " is clicked", Toast.LENGTH_SHORT).show();
    }
}