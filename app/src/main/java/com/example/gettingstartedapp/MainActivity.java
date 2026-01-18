package com.example.gettingstartedapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvArtist, tvTitle;
    ImageView ivArtwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        tvArtist = findViewById(R.id.tvArtist);
        ivArtwork = findViewById(R.id.ivArtwork);

        performSearch("OneRepublic");
    }

    public void performSearch(String query){
        ITunesApiService apiService = RetrofitClient.getApiService();
        Call<ITunesResponse> call = apiService.search(query, "musicTrack", 10);
        call.enqueue(new Callback<ITunesResponse>() {
            @Override
            public void onResponse(Call<ITunesResponse> call, Response<ITunesResponse> response) {
                List<ITunesItem> items = response.body().results;
                tvTitle.setText(items.get(0).trackName);
                tvArtist.setText(items.get(0).artistName);
                Picasso.get().load(items.get(0).artworkUrl100).into(ivArtwork);
            }

            @Override
            public void onFailure(Call<ITunesResponse> call, Throwable t) {
                Log.e("NETWORK ERROR", t.getMessage());
            }
        });

    }
}
