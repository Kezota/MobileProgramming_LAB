package com.example.gettingstartedapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.*;

public class FragmentMusic extends Fragment {
    RecyclerView recycler;
    MusicAdapter adapter;
    List<Track> list  = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_music, container, false);

        recycler = v.findViewById(R.id.recyclerMusic);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new MusicAdapter(getContext(), list);
        recycler.setAdapter(adapter);

        loadMusic();
        return v;
    }

    private void loadMusic() {
        RetrofitAPIService api = RetrofitAPIClient.getClient().create(RetrofitAPIService.class);

        api.searchMusic("eminem").enqueue(new Callback<DeezerResponse>() {
            @Override
            public void onResponse(Call<DeezerResponse> call, Response<DeezerResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    list.clear();
                    list.addAll(response.body().getData());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<DeezerResponse> call, Throwable t) {

            }
        });
    }
}