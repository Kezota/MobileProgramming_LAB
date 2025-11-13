package com.example.gettingstartedapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.gettingstartedapp.R;
import com.example.gettingstartedapp.model.Product;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<Product> {
    private Context context;
    private int resource;
    private ArrayList<Product> items = new ArrayList<>();
    public ListViewAdapter(Context context, int resource, ArrayList<Product> items) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.items = items
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.);
        }
        return convertView;
    }
}
