package com.example.gettingstartedapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText personName = findViewById(R.id.personName);
    EditText personNIM = findViewById(R.id.personNIM);
    EditText personKelas = findViewById(R.id.personKelas);
    RadioGroup rgGender = findViewById(R.id.rgGender);


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, ProfileActivity.class);
        if (item.getItemId() == R.id.nav_profile) {
            intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_pakayan) {
            intent = new Intent(this, PakayanActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_sepatu) {
            intent = new Intent(this, SepatuActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.nav_pesan)  {

        }
        return super.onOptionsItemSelected(item);
    }

    public void btnSaveFunc(View view) {
        int genderId = rgGender.getCheckedRadioButtonId();
        RadioButton genderRb = findViewById(genderId);

        getSharedPreferences("UserData", MODE_PRIVATE).edit()
                .putString("name", personName.getText().toString())
                .putString("nim", personNIM.getText().toString())
                .putString("kelas", personKelas.getText().toString())
                .putString("gender", genderRb.getText().toString())
                .apply();

        Toast.makeText(this, "data berhasil disimpan", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
