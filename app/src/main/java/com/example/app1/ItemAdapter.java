package com.example.app1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    ArrayList<Item> list;

    public ItemAdapter(ArrayList<Item> list) {
        this.list = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        Button btnUpdate, btnDelete;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Item item = list.get(position);

        holder.textView.setText(item.title);
        holder.imageView.setImageResource(item.image);

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int currentPosition = holder.getAdapterPosition();

                if (currentPosition != RecyclerView.NO_POSITION) {
                    list.remove(currentPosition);
                    notifyItemRemoved(currentPosition);
                }
            }
        });

        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {

                    // Context from the holder's itemView
                    final AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());

                    final EditText input = new EditText(holder.itemView.getContext());
                    input.setText(list.get(currentPosition).title);

                    builder.setTitle("Modifier le nom");
                    LinearLayout container = new LinearLayout(holder.itemView.getContext());
                    container.setPadding(48, 16, 48, 10); // left, top, right, bottom in pixels
                    container.addView(input);

                    builder.setView(container);

                    builder.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String newTitle = input.getText().toString().trim();
                            if (!newTitle.isEmpty()) {
                                list.get(currentPosition).title = newTitle;
                                notifyItemChanged(currentPosition);
                            }
                        }
                    });

                    builder.setNegativeButton("Annuler", null);
                    builder.show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}