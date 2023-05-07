package com.example.parking_spot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.longrunning.WaitOperationRequest;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        RecyclerView recyclerView1 = findViewById(R.id.recycleview1);

        RecyclerView recyclerView2 = findViewById(R.id.recycleview2);

        Button logout = findViewById(R.id.logoutbtn);

      List<item> items = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("spot");


        Toast.makeText(HomeScreen.this,"to the event listener",Toast.LENGTH_SHORT).show();

        myRef.addValueEventListener(new ValueEventListener() {



            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(HomeScreen.this,"on data change",Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onDataChange() triggered");
                items.clear();
                // This method will be called whenever data is changed in the Realtime Database
                for (DataSnapshot spotsnapshot : dataSnapshot.getChildren()){
                    //get the name and availability
                    String name = spotsnapshot.child("name").getValue(String.class);
                    boolean availability = spotsnapshot.child("availability").getValue(boolean.class);
                    //treat data
                    item newspot = new item(name,availability);
                    items.add(newspot);




                    Log.d("TAG","Spot" + name + "is" + (availability? "available" : "not available"));
                }

                ////
                MyAdapter adaptater1 = new MyAdapter(getApplicationContext(),items);

                recyclerView1.setLayoutManager(new LinearLayoutManager(HomeScreen.this));
                recyclerView1.setAdapter(adaptater1);
                Toast.makeText(HomeScreen.this,"adaptater set",Toast.LENGTH_SHORT).show();
                adaptater1.notifyDataSetChanged();


                recyclerView2.setLayoutManager(new LinearLayoutManager(HomeScreen.this));
                recyclerView2.setAdapter(new MyAdapter(getApplicationContext(),items));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle any errors
                Log.e("TAG", "Database error: " + error.getMessage());

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(HomeScreen.this,Login.class));
                finish();
            }
        });


    }

}

//        items.add(new item("spot1"));
//        items.add(new item("spot2"));
//        items.add(new item("spot3"));
//        items.add(new item("spot4"));
//        items.add(new item("spot5"));
//        items.add(new item("spot6"));
//        items.add(new item("spot7"));
//        items.add(new item("spot2"));
//        items.add(new item("spot3"));
//        items.add(new item("spot4"));
//        items.add(new item("spot5"));
//        items.add(new item("spot6"));
//        items.add(new item("spot7"));
//        items.add(new item("spot2"));
//        items.add(new item("spot3"));
//        items.add(new item("spot4"));
//        items.add(new item("spot5"));
//        items.add(new item("spot6"));
//        items.add(new item("spot7"));
//
//