package com.example.gettingstartedapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ItemViewHolder> {
    static ArrayList<Song> songs;
    static SongAdapter.onItemClickListener listener;

    public SongAdapter(ArrayList<Song> songs, onItemClickListener listener) {
        this.songs = songs;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Song currentSong = songs.get(position);
        holder.tvTitle.setText(currentSong.title);
        holder.tvArtist.setText(currentSong.artist);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public interface onItemClickListener {
        void onItemClick(Song song);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvArtist;
        public ItemViewHolder(android.view.View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvSongTitle);
            tvArtist = itemView.findViewById(R.id.tvSongArtist);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Song clickedSong = songs.get(getAdapterPosition());
                }
            });
        }
    }
}
