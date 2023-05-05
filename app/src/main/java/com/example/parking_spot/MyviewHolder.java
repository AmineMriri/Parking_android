package com.example.parking_spot;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyviewHolder extends RecyclerView.ViewHolder {

    Button button;


    public MyviewHolder(@NonNull View itemView) {
        super(itemView);
        button = itemView.findViewById(R.id.buttonview);

    }
}
