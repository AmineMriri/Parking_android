package com.example.parking_spot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class admin extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);



        RecyclerView recyclerView;
        recyclerView = findViewById(R.id.userlist);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        ArrayList<UserModel> list = new ArrayList<>();

        Log.d("ADMINPAGE", "fetching data ...");
        CollectionReference userRef = db.collection("user");
        userRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {

            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                Log.d("ADMINPAGE", "data fetched successfuly");
//                list.clear();
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){

                    //get the user data one by one
                    String name = documentSnapshot.getString("name");
                    int phone = documentSnapshot.getLong("phone").intValue();
                    String email = documentSnapshot.getString("email");
                    String matricule = documentSnapshot.getString("matricule");
                    String id = documentSnapshot.getId();

                    Log.d("ADMINPAGE", "Name: " + name);
                    Log.d("ADMINPAGE", "Phone: " + phone);
                    Log.d("ADMINPAGE", "Email: " + email);
                    Log.d("ADMINPAGE", "Matricule: " + matricule);

                    Log.d("ADMINPAGE", "Id: " + id);


                    //treat the data
                    UserModel newuser = new UserModel(name,email,matricule,id,phone);
                    list.add(newuser);

                }

                Log.d("ADMINPAGE", "before recycle view");
                recyclerView.setLayoutManager(new LinearLayoutManager(admin.this));
                AdapterUser adapterUser = new AdapterUser(getApplicationContext(),list);

                recyclerView.setAdapter(adapterUser);
                adapterUser.notifyDataSetChanged();
            }
        }


        );

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