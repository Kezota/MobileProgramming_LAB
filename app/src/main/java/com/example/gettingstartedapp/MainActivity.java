package com.example.gettingstartedapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HttpManager.OnDataReceivedListener {
    List<Album> albums;
    AlbumAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        albums = new ArrayList<>();

        ListView listView = findViewById(R.id.listView);
        adapter = new AlbumAdapter(this, R.layout.row_album, albums);

        HttpManager task = new HttpManager(this, this);
        task.execute("https://itunes.apple.com/search?term=jack+johnson");
    }

    @Override
    public void onDataReceived(List<Album> albums) {
        if (albums != null && !albums.isEmpty()) {
            adapter.clear();
            adapter.addAll(albums);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}