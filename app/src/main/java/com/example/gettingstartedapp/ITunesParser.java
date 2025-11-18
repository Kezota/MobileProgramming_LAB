package com.example.gettingstartedapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ITunesParser {
    public ArrayList<Song> parseJsonToSongs(JSONObject source) {
        ArrayList<Song> songs = new ArrayList<>();

        try {
            JSONArray jArrSong = source.getJSONArray("results");

            for (int i = 0; i < jArrSong.length(); i++) {
                Song song = new Song();
                song.title = ((JSONObject)jArrSong.get(i)).getString("trackName");
                song.artist = ((JSONObject)jArrSong.get(i)).getString("artistName");
//                song.album = ((JSONObject)jArrSong.get(i)).getString("collectionName");
                song.art = ((JSONObject)jArrSong.get(i)).getString("artworkUrl100");
                songs.add(song);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return songs;
    }
}
