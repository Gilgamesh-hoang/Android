package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment_Top extends Fragment {
    CommunicationInterface listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CommunicationInterface) {
            listener = (CommunicationInterface) context;
        } else {
            throw new RuntimeException(context.toString() + "Can phai implement");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_top, container, false);

        EditText inputCarName = view.findViewById(R.id.inputCarName);
        EditText inputCarYear = view.findViewById(R.id.inputCarYear);
        Button btnSubmit = view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickTopFragment(inputCarName.getText().toString(), inputCarYear.getText().toString());
            }
        });
        return view;
    }
}