package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Bottom extends Fragment {
    TextView textCarName;
    TextView textCarYear;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_bottom, container, true);
         textCarName = view.findViewById(R.id.textCarName);
         textCarYear = view.findViewById(R.id.textCarYear);
        return view;
    }
    public void updateFragment(String carName, String carYear) {
        textCarName.setText(carName);
        textCarYear.setText(carYear);
    }
}