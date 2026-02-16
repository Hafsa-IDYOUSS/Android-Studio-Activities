package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActiviteAnimals extends AppCompatActivity {

    ImageButton imgCat, imgDog, imgRabbit, imgFox, imgCrow, imgSquirrel, imgElephant, imgPenguin, imgBear;
    Button btnRetour;
    View.OnClickListener animalClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activite_animals);


        imgCat = findViewById(R.id.imgCat);
        imgDog = findViewById(R.id.imgDog);
        imgRabbit = findViewById(R.id.imgRabbit);
        imgFox = findViewById(R.id.imgFox);
        imgCrow = findViewById(R.id.imgCrow);
        imgSquirrel = findViewById(R.id.imgSquirrel);
        imgElephant = findViewById(R.id.imgElephant);
        imgPenguin = findViewById(R.id.imgPenguin);
        imgBear = findViewById(R.id.imgBear);
        btnRetour = findViewById(R.id.btnBack12);

        animalClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String viewName = getResources().getResourceEntryName(v.getId());
                String animalName = viewName.substring(3).toLowerCase();

                Intent intent = new Intent(getApplicationContext(), ActiviteAnimalDetail.class);
                intent.putExtra("animal", animalName);

                startActivity(intent);
            }
        };

        imgCat.setOnClickListener(animalClickListener);
        imgDog.setOnClickListener(animalClickListener);
        imgFox.setOnClickListener(animalClickListener);
        imgCrow.setOnClickListener(animalClickListener);
        imgSquirrel.setOnClickListener(animalClickListener);
        imgBear.setOnClickListener(animalClickListener);
        imgElephant.setOnClickListener(animalClickListener);
        imgRabbit.setOnClickListener(animalClickListener);
        imgPenguin.setOnClickListener(animalClickListener);

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