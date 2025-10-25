package com.example.gettingstartedapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.v("lifecycle", "onCreate2 called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("lifecycle", "onStart2 called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("lifecycle", "onResume2 called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("lifecycle", "onPause2 called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("lifecycle", "onStop2 called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("lifecycle", "onDestroy2 called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("lifecycle", "onRestart2 called");
    }
}