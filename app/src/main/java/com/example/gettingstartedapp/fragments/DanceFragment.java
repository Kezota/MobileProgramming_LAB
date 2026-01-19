package com.example.gettingstartedapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gettingstartedapp.R;
import com.example.gettingstartedapp.databinding.FragmentDanceBinding;
import com.example.gettingstartedapp.services.PlayBabySharkService;

public class DanceFragment extends Fragment {

    FragmentDanceBinding binding;

    public DanceFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDanceBinding.inflate(inflater);
        binding.btnPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 3C: play baby shark dari PlayBabySharkService
                if(binding.btnPlayStop.getText().equals("Play")){
                    //code here

                    binding.btnPlayStop.setText("Stop");
                }
                else{
                    //code here

                    binding.btnPlayStop.setText("Play");
                }


            }
        });


        return binding.getRoot();
    }
}