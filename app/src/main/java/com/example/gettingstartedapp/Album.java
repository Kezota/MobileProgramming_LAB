package com.example.gettingstartedapp;

public class Album {
    private String wrapperType;
    private String artistName;
    private String artworkUrl100;

    public Album(String wrapperType, String artistName, String artworkUrl100) {
        this.wrapperType = wrapperType;
        this.artistName = artistName;
        this.artworkUrl100 = artworkUrl100;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }
}
