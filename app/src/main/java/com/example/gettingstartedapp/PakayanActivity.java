package com.example.gettingstartedapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gettingstartedapp.adapter.ProductAdapter;
import com.example.gettingstartedapp.model.Product;

import java.util.ArrayList;

public class PakayanActivity extends AppCompatActivity {
    ArrayList<Product> products;
    RecyclerView rvPakaian = findViewById(R.id.rvPakaian);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pakayan);

        products.add(new Product(R.drawable.baju1, "Baju 1", "1000"));
        products.add(new Product(R.drawable.baju2, "Baju 2", "1000"));
        products.add(new Product(R.drawable.baju3, "Baju 3", "1000"));
        products.add(new Product(R.drawable.baju1, "Baju 4", "1000"));
        products.add(new Product(R.drawable.baju2, "Baju 5", "1000"));
        products.add(new Product(R.drawable.baju3, "Baju 6", "1000"));
        products.add(new Product(R.drawable.baju1, "Baju 7", "1000"));
        products.add(new Product(R.drawable.baju2, "Baju 8", "1000"));
        products.add(new Product(R.drawable.baju3, "Baju 9", "1000"));

        rvPakaian.setLayoutManager(new LinearLayoutManager(this));
        rvPakaian.setAdapter(new ProductAdapter(products));
    }
}