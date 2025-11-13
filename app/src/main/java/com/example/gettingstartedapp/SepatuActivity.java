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

public class SepatuActivity extends AppCompatActivity {
    ArrayList<Product> products;
    RecyclerView rvSepatu = findViewById(R.id.rvSepatu);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepatu);

        products.add(new Product(R.drawable.sepatu1, "Sepatu 1", "1000"));
        products.add(new Product(R.drawable.sepatu2, "Sepatu 2", "1000"));
        products.add(new Product(R.drawable.sepatu3, "Sepatu 3", "1000"));
        products.add(new Product(R.drawable.sepatu1, "Sepatu 4", "1000"));
        products.add(new Product(R.drawable.sepatu2, "Sepatu 5", "1000"));
        products.add(new Product(R.drawable.sepatu3, "Sepatu 6", "1000"));
        products.add(new Product(R.drawable.sepatu1, "Sepatu 7", "1000"));
        products.add(new Product(R.drawable.sepatu2, "Sepatu 8", "1000"));
        products.add(new Product(R.drawable.sepatu3, "Sepatu 9", "1000"));

        rvSepatu.setLayoutManager(new LinearLayoutManager(this));
        rvSepatu.setAdapter(new ProductAdapter(products));
    }
}