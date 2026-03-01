package com.example.app1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActiviteRecyclerview extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Item> list;
    ItemAdapter adapter;
    Button btnAdd, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activite_recyclerview);


        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);
        btnBack = findViewById(R.id.btnBack5);

        list = new ArrayList<>();
        list.add(new Item("Carotte", R.drawable.carotte));
        list.add(new Item("Tomate", R.drawable.tomate));
        list.add(new Item("Poivron", R.drawable.poivron));
        list.add(new Item("Oignon", R.drawable.oignon));
        list.add(new Item("Laitue", R.drawable.laitue));

        adapter = new ItemAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ActiviteRecyclerview.this);
                builder.setTitle("Ajouter un légume");

                final EditText input = new EditText(ActiviteRecyclerview.this);
                input.setHint("Entrez le nom du légume");
                LinearLayout container = new LinearLayout(ActiviteRecyclerview.this);
                container.setPadding(48, 16, 48, 10); // left, top, right, bottom in pixels
                container.addView(input);

                builder.setView(container);


                builder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = input.getText().toString().trim();
                        if (!title.isEmpty()) {
                            list.add(new Item(title, R.drawable.legumes));
                            adapter.notifyItemInserted(list.size() - 1);
                            recyclerView.scrollToPosition(list.size() - 1);
                        }
                    }
                });

                builder.setNegativeButton("Annuler", null);
                builder.show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
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