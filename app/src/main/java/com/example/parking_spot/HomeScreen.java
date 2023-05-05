package com.example.parking_spot;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView1 = findViewById(R.id.recycleview1);

        RecyclerView recyclerView2 = findViewById(R.id.recycleview2);


        List<item> items = new ArrayList<item>();
        items.add(new item("spot1"));
        items.add(new item("spot2"));
        items.add(new item("spot3"));
        items.add(new item("spot4"));
        items.add(new item("spot5"));
        items.add(new item("spot6"));
        items.add(new item("spot7"));
        items.add(new item("spot2"));
        items.add(new item("spot3"));
        items.add(new item("spot4"));
        items.add(new item("spot5"));
        items.add(new item("spot6"));
        items.add(new item("spot7"));
        items.add(new item("spot2"));
        items.add(new item("spot3"));
        items.add(new item("spot4"));
        items.add(new item("spot5"));
        items.add(new item("spot6"));
        items.add(new item("spot7"));


        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(new MyAdapter(getApplicationContext(),items));

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(new MyAdapter(getApplicationContext(),items));

    }
}