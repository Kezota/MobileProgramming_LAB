package com.example.gettingstartedapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView nav = findViewById(R.id.bottomNav);

        loadFragment(new FragmentHome());

        nav.setOnItemSelectedListener(item -> {
            Fragment newFragment = null;
            if (item.getItemId() == R.id.nav_home) newFragment = new FragmentHome();
            else if (item.getItemId() == R.id.nav_about) newFragment = new FragmentAbout();
            else if (item.getItemId() == R.id.nav_music) newFragment = new FragmentMusic();

            return loadFragment(newFragment);
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();

            return true;
        }
        return false;
    }
}