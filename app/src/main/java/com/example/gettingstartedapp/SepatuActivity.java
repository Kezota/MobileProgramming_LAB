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

    ArrayList<Product> products = new ArrayList<>();
    RecyclerView rvSepatu = findViewById((R.id.rvSepatu));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sepatu);

        products.add(new Product(R.drawable.sepatu1, "Sepatu 1", "100000"));
        products.add(new Product(R.drawable.sepatu2, "Sepatu 2", "100000"));
        products.add(new Product(R.drawable.sepatu3, "Sepatu 3", "100000"));
        products.add(new Product(R.drawable.sepatu1, "Sepatu 4", "100000"));
        products.add(new Product(R.drawable.sepatu2, "Sepatu 5", "100000"));
        products.add(new Product(R.drawable.sepatu3, "Sepatu 6", "100000"));
        products.add(new Product(R.drawable.sepatu1, "Sepatu 7", "100000"));
        products.add(new Product(R.drawable.sepatu2, "Sepatu 8", "100000"));
        products.add(new Product(R.drawable.sepatu3, "Sepatu 9", "100000"));

        rvSepatu.setLayoutManager(new LinearLayoutManager(this));
        rvSepatu.setAdapter(new ProductAdapter(products));
    }
}