package com.example.gettingstartedapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gettingstartedapp.dataAccess.PesananDao;
import com.example.gettingstartedapp.model.Order;

public class CreatePesananActivity extends AppCompatActivity {
    EditText createOrderName = findViewById(R.id.createOrderName);
    EditText createOrderQuantity = findViewById(R.id.createOrderQuantity);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_pesanan);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void createOrderFunc(View view) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        PesananDao pesananDao = new PesananDao(dbHelper);

        Order order = new Order(createOrderName.getText().toString(), createOrderQuantity.getText().toString());

        pesananDao.createOrder(order);

        Toast.makeText(this, "pesanan created", Toast.LENGTH_LONG);
    }

    public void viewOrderFunc(View view) {
        Intent niatPindah = new Intent(this, ViewPesananActivity.class);
        startActivity(niatPindah);
    }
}