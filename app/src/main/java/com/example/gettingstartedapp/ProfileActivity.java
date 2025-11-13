package com.example.gettingstartedapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {
    TextView profileName = findViewById(R.id.profileName);
    TextView profileNIM = findViewById(R.id.profileNIM);
    TextView profileKelas = findViewById(R.id.profileKelas);
    TextView profileGender = findViewById(R.id.profileGender);
    ImageView profileImage = findViewById(R.id.profileImage);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        profileName.setText(prefs.getString("name", ""));
        profileNIM.setText(prefs.getString("nim", ""));
        profileKelas.setText(prefs.getString("kelas", ""));
        profileGender.setText(prefs.getString("gender", ""));

        String gender = prefs.getString("gender", "");

        if (gender.equals("Male")) {
            profileImage.setImageResource(R.drawable.hamis);
        } else {
            profileImage.setImageResource(R.drawable.raisa);
        }
    }
}