package com.example.app1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activite11 extends AppCompatActivity {

    ImageButton imgChat, imgChien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activite11);

        imgChat = findViewById(R.id.imgChat);
        imgChien = findViewById(R.id.imgChien);

        imgChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer media = MediaPlayer.create(getApplicationContext(), R.raw.chat);
                if (!media.isPlaying()) {
                    media.start();
                }
                Toast.makeText(getApplicationContext(), "Coucou Chat", Toast.LENGTH_LONG).show();
            }
        });

        imgChien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer media = MediaPlayer.create(getApplicationContext(), R.raw.chien);
                if (!media.isPlaying()) {
                    media.start();
                }
                Toast.makeText(getApplicationContext(), "Coucou Chien", Toast.LENGTH_LONG).show();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}