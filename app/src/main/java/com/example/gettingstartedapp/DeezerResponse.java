package com.example.gettingstartedapp;

import java.util.List;

public class DeezerResponse {
    private List<Track> data;

    public DeezerResponse(List<Track> data) {
        this.data = data;
    }

    public List<Track> getData() {
        return data;
    }
}
