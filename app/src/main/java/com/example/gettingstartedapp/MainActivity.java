package com.example.gettingstartedapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
    EditText personClass = findViewById(R.id.personClass);
    RadioGroup personGender = findViewById(R.id.personGender);
    Button btnSave = findViewById(R.id.saveProfile);


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
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void savePerson(View view) {
        String name = personName.toString();
        String nim = personNIM.toString();
        String kelas = personClass.toString();
        int genderId = personGender.getCheckedRadioButtonId();
        RadioButton genderRb = findViewById(genderId);
        String gender = genderRb.getText().toString();

        getSharedPreferences("UserData", MODE_PRIVATE).edit()
                .putString("name", name).putString("kelas", kelas).putString("nim", nim).putString("gender", gender).apply();

        Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_LONG).show();
    }
}



