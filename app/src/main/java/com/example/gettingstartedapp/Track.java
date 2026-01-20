package com.example.gettingstartedapp;

public class Track {
    private String title;
    private String preview;
    private Artist artist;

    public Track(String title, String preview, Artist artist) {
        this.title = title;
        this.preview = preview;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getPreview() {
        return preview;
    }

    public Artist getArtist() {
        return artist;
    }
}
