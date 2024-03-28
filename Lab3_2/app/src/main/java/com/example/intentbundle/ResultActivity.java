package com.example.intentbundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("package");
        String result = giaiPt(bundle.getInt("numberA"), bundle.getInt("numberB"), bundle.getInt("numberC"));
        TextView display = findViewById(R.id.displayResult);
        display.setText(result);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private String giaiPt(int a, int b, int c) {
        // kiểm tra các hệ số
        if (a == 0) {
            if (b == 0) {
                return "Phương trình vô nghiệm!";
            } else {
                return "Phương trình có một nghiệm: " + "x = " + (-c / b);
            }
        }
        // tính delta
        float delta = b * b - 4 * a * c;
        float x1;
        float x2;
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
            return "Phương trình có 2 nghiệm là: "+ "x1 = " + x1 + " và x2 = " + x2;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            return "Phương trình có nghiệm kép: "+ "x1 = x2 = " + x1;
        } else {
            return "Phương trình vô nghiệm!";
        }
    }
}