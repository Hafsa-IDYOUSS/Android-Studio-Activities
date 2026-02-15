package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activite7 extends AppCompatActivity {

    Button demarrer, btnRetour;
    EditText txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activite7);
        demarrer = findViewById(R.id.b1);
        txt1 = findViewById(R.id.txt1);
        btnRetour = findViewById(R.id.btnBack3);

        demarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1= txt1.getText().toString();
                Intent relation = new Intent(getApplicationContext(), Activite7pt2.class);
                relation.putExtra("c1", s1);
                startActivity(relation);
            }
        });

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}