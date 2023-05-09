package com.example.parking_spot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyviewHolder> {


    Context context;
    List<item> items;


    public MyAdapter(Context context, List<item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyviewHolder(LayoutInflater.from(context).inflate(R.layout.item_vieww,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        item currentItem = items.get(position);

        holder.button.setText("spot "+items.get(position).getName());

        if (currentItem.availability) {
            holder.button.setClickable(true);
            holder.button.setBackgroundColor(context.getResources().getColor(R.color.teal_200));

        } else {
            holder.button.setBackgroundColor(context.getResources().getColor(android.R.color.holo_red_light));

            holder.button.setClickable(false);
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
