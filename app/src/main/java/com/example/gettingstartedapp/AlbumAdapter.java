package com.example.gettingstartedapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AlbumAdapter extends ArrayAdapter<Album> {
    public AlbumAdapter(@NonNull Context context, int resource, @NonNull List<Album> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_album, parent, false);
        }

        Album album = getItem(position);

        TextView tvTrack = convertView.findViewById(R.id.tvTrack);
        TextView tvArtist = convertView.findViewById(R.id.tvArtist);
        TextView imgArtwork = convertView.findViewById(R.id.imgArtwork);

        tvTrack.setText(album.getWrapperType());
        tvArtist.setText(album.getArtistName());
        imgArtwork.setText(album.getArtworkUrl100());

        return convertView;
    }
}
