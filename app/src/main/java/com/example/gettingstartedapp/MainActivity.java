package com.example.gettingstartedapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvHelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHelloWorld = findViewById(R.id.tvHelloWorld);
        registerForContextMenu(tvHelloWorld);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Ini ContextMenu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_help) {
            Toast.makeText(this, "Context help diklik", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(this, "Context settings diklik", Toast.LENGTH_LONG).show();

            Intent niatSett = new Intent(this, SettingsActivity.class);
            startActivity(niatSett);

            return true;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(this, "Settings diklik", Toast.LENGTH_LONG).show();

            Intent niatSett = new Intent(this, SettingsActivity.class);
            startActivity(niatSett);
        } else if (item.getItemId() == R.id.action_help) {
            Toast.makeText(this, "About diklik", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}