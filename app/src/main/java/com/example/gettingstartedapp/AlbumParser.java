package com.example.gettingstartedapp;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AlbumParser {
    public List<Album> parseJSONToAlbum(Context context, JSONObject source) {
        ArrayList<Album> albums = new ArrayList<>();

        try {
            JSONArray arrAlbums = source.getJSONArray("results");

            for (int i = 0; i < arrAlbums.length(); i++) {
                String wrapperType = ((JSONObject) arrAlbums.get(i)).getString("wrapperType");
                String artistName = ((JSONObject) arrAlbums.get(i)).getString("artistName");
                String artworkUrl100 = ((JSONObject) arrAlbums.get(i)).getString("artworkUrl100");
                Album album = new Album(wrapperType, artistName, artworkUrl100);

                albums.add(album);
                Toast.makeText(context, album.getArtistName()+" Added", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return albums;
    }
}
