package com.example.gettingstartedapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {
    TextView profileNama = findViewById(R.id.profileNama);
    TextView profileNIM = findViewById(R.id.profileNIM);
    TextView profileKelas = findViewById(R.id.profileKelas);
    TextView profileGender = findViewById(R.id.profileGender);
    ImageView profileImage = findViewById(R.id.profileImage);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Shared Preferences
        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);

        profileNama.setText("Nama: " + prefs.getString("name", ""));
        profileNIM.setText("NIM: " + prefs.getString("nim", ""));
        profileKelas.setText("Kelas: " + prefs.getString("kelas", ""));
        profileGender.setText("Gender: " + prefs.getString("gender", ""));

        String gender = prefs.getString("gender", "");

        if (gender.equals("Male")) {
            profileImage.setImageResource(R.drawable.hamis);
        } else {
            profileImage.setImageResource(R.drawable.raisa);
        }
    }
}