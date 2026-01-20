package com.example.gettingstartedapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.IOException;

public class MusicService extends Service {
    MediaPlayer mp;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String url = intent.getStringExtra("preview");

        try {
            if (mp != null) {
                mp.stop();
                mp.release();
            }

            mp = new MediaPlayer();
            mp.setDataSource(url);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (mp != null) {
            mp.stop();
            mp.release();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
