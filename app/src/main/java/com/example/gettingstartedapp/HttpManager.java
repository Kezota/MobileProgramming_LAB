package com.example.gettingstartedapp;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class HttpManager extends AsyncTask<String, Void, List<Album>> {
    private Context ctx;
    private OnDataReceivedListener listener;

    public interface OnDataReceivedListener {
        void onDataReceived(List<Album> albums);
    }

    public HttpManager(Context ctx, OnDataReceivedListener listener) {
        this.ctx = ctx;
        this.listener = listener;
    }

    @Override
    protected List<Album> doInBackground(String... strings) {
        return getData();
    }

    public List<Album> getData() {
        BufferedReader reader = null;
        String result = "";
        StringBuffer stringBuffer = new StringBuffer();

        try {
            URL url = new URL("https://itunes.apple.com/search?term=jack+johnson");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            while ((result = reader.readLine()) != null) {
                stringBuffer.append(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            AlbumParser parser = new AlbumParser();
            return parser.parseJSONToAlbum(ctx, new JSONObject(result));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
