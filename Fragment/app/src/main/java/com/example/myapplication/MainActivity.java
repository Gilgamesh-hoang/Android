package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements CommunicationInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClickTopFragment(String carName, String carYear) {
        Fragment_Bottom fragBot = (Fragment_Bottom) getSupportFragmentManager().findFragmentById(R.id.bottomFragment);
        if (fragBot != null || fragBot.isInLayout()) { // kiểm tra Fragment cần truyền data đến có thực sự tồn tại và đang hiện.
            fragBot.updateFragment(carName, carYear);
        }else{
            Toast.makeText(this, "Khong tim thay, hoac fragment khong hien", Toast.LENGTH_SHORT).show();
        }
    }

}