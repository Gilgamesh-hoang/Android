package com.example.intentbundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btnResult);
        EditText numberA = findViewById(R.id.numberA);
        EditText numberB = findViewById(R.id.numberB);
        EditText numberC = findViewById(R.id.numberC);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("numberA", Integer.parseInt(numberA.getText()+""));
                bundle.putInt("numberB", Integer.parseInt(numberB.getText()+""));
                bundle.putInt("numberC", Integer.parseInt(numberC.getText()+""));

                intent.putExtra("package", bundle);
                startActivity(intent);
            }
        });
    }
}