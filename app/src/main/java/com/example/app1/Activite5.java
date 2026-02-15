package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activite5 extends AppCompatActivity {

    Button btnPlus, btnMoins, btnMulti, btnDiv, btnCls, btnRetour;
    EditText var1, var2, resultat;
    String v1, v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activite5);
        btnPlus = findViewById(R.id.btnPlus);
        btnMoins = findViewById(R.id.btnMoins);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);
        btnCls = findViewById(R.id.btnCls);
        var1 = findViewById(R.id.var1);
        var2 = findViewById(R.id.var2);
        resultat = findViewById(R.id.resultat);
        btnRetour = findViewById(R.id.btnBack2);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Addition
                v1 = var1.getText().toString();
                v2 = var2.getText().toString();
                int r = Integer.parseInt(v1) + Integer.parseInt(v2);
                resultat.setText(String.valueOf(r));
            }
        });

        btnMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Soustraction
                v1 = var1.getText().toString();
                v2 = var2.getText().toString();
                int r = Integer.parseInt(v1) - Integer.parseInt(v2);
                resultat.setText(String.valueOf(r));
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Multiplication
                v1 = var1.getText().toString();
                v2 = var2.getText().toString();
                int r = Integer.parseInt(v1) * Integer.parseInt(v2);
                resultat.setText(String.valueOf(r));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Division
                v1 = var1.getText().toString();
                v2 = var2.getText().toString();
                if (!v2.equals("0")) {
                    float r;
                    r = (float) Integer.parseInt(v1) / Integer.parseInt(v2);
                    resultat.setText(String.valueOf(r));
                } else {
                    resultat.setText("Erreur!");
                }
            }
        });

        btnCls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Initialisation
                var1.setText("");
                var2.setText("");
                resultat.setText("");
            }
        });

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activite5.this, MainActivity.class);
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