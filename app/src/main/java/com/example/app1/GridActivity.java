package com.example.app1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridActivity extends AppCompatActivity {

    String pay[] = {
            "Maroc","France","Espagne","Italie","Allemagne","Portugal",
            "USA","Canada","Brésil","Argentine","Mexique","Chine",
            "Japon","Corée","Inde","Russie","Turquie","Égypte",
            "Tunisie","Algérie","Libye","Sénégal","Mali","Nigéria",
            "Kenya","Ghana","Australie","Norvège","Suède","Finlande",
            "Suisse","Pologne","Autriche","Belgique","Pays-Bas",
            "Danemark","Grèce","Roumanie","Bulgarie","Ukraine"
    };

    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid);

        grid = findViewById(R.id.gridPays);

        grid.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                pay
        ));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}