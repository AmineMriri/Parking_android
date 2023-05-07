package com.example.parking_spot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method will be called whenever data is changed in the Realtime Database
                        for (DataSnapshot spotsnapshot : dataSnapshot.getChildren()){
                            //get the name and availability
                            String name = spotsnapshot.child("name").getValue(String.class);

                            boolean availability = spotsnapshot.child("availability").getValue(boolean.class);

                            //treat data

                            Log.d("TAG","Spot" + name + "is" + (availability? "available" : "not available"));
                        }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle any errors
                Log.e("TAG", "Database error: " + error.getMessage());

            }
        });



















        Button logout = findViewById(R.id.logoutadmin);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(admin.this,Login.class));
                finish();
            }
        });


    }


}