package com.example.gettingstartedapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button btnLogin, btnRegister;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

//        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        btnLogin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        // test

        Log.v("lifecycle", "onCreate called");

        spinner = findViewById(R.id.my_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_items,
                android.R.layout.simple_spinner_item
        );

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("lifecycle", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("lifecycle", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("lifecycle", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("lifecycle", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("lifecycle", "onDestroy called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("lifecycle", "onRestart called");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogin) {
            Toast.makeText(this, "btnLogin is clicked", Toast.LENGTH_LONG).show();

            Intent niatPindah = new Intent(this, SecondActivity.class);
            startActivity(niatPindah);
        } else {
            Toast.makeText(this, "btnRegister is clicked", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}