package com.example.parking_spot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

import java.util.ArrayList;

public class adminpage extends AppCompatActivity {

        RecyclerView recyclerView;
        DatabaseReference database;
        AdapterUser adapterUser;
        ArrayList<UserModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);

//        Button logout = findViewById(R.id.logoutadmin);

//
//
//        recyclerView = findViewById(R.id.userlist);
//
//        database = FirebaseDatabase.getInstance().getReference("user");
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        list = new ArrayList<>();
//
//        adapterUser = new AdapterUser(this,list);
//
//        recyclerView.setAdapter(adapterUser);
//
//
//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                   UserModel userModel = dataSnapshot.getValue(UserModel.class);
//                   list.add(userModel);
//
//
//                }
//
//                adapterUser.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(adminpage.this,Login.class));
//                finish();
//            }
//        });
//
//    }
//    public void logoutAdmin(View view) {
//        FirebaseAuth.getInstance().signOut();
//        startActivity(new Intent(adminpage.this,Login.class));
//        finish();
//    }

}}