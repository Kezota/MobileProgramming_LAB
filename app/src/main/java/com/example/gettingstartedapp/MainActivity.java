package com.example.gettingstartedapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle, tvAlbum, tvArtist;
    ImageView ivArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTrackName);
        tvAlbum = findViewById(R.id.tvAlbumName);
        tvArtist = findViewById(R.id.tvArtistName);
        ivArt = findViewById(R.id.ivArt);

        DemoTask task1 = new DemoTask();
        task1.execute();
    }

    public String readStream(InputStream is) {
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int i = is.read();

            while (i != -1) {
                buffer.write(i);
                i = is.read();
            }

            return buffer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private class DemoTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String result = "";

            try {
                URL url = new URL("https://itunes.apple.com/search?term=beyonce");
                HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConn.getInputStream());
                result = readStream(in);
                urlConn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.v("serverResponse", result);

            ITunesParser iTunesParser = new ITunesParser();
            ArrayList<Song> songs;

            try {
                songs = iTunesParser.parseJsonToSongs(new JSONObject(result));
            } catch (JSONException e) {
                throw new RuntimeException();
            }

            tvTitle.setText(songs.get(1).title);
            tvArtist.setText(songs.get(1).artist);
//            tvAlbum.setText(songs.get(1).album);
            Picasso.get().load(songs.get(1).art).into(ivArt);
//            ivArt.setText(songs.get(0).art);
        }
    }
}