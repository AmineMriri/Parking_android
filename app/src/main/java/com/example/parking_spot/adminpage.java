package com.example.parking_spot;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class adminpage extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);

//        recyclerView = findViewById(R.id.userlist);
//
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        ArrayList<UserModel> list = new ArrayList<>();
//        Log.d("ADMINPAGE", "fetching data ...");
//        CollectionReference userRef = db.collection("user");
//        userRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                Log.d("ADMINPAGE", "data fetched successfuly");
////                list.clear();
//                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
//
//                    //get the user data one by one
//                    String name = documentSnapshot.getString("name");
//                    int phone = documentSnapshot.getLong("phone").intValue();
//                    String email = documentSnapshot.getString("email");
//                    String matricule = documentSnapshot.getString("matricule");
//
//                    Log.d("ADMINPAGE", "Name: " + name);
//                    Log.d("ADMINPAGE", "Phone: " + phone);
//                    Log.d("ADMINPAGE", "Email: " + email);
//                    Log.d("ADMINPAGE", "Matricule: " + matricule);
//
//
//                    //treat the data
//                    UserModel newuser = new UserModel(name,email,matricule,phone);
//                    list.add(newuser);
//
//                }
//
//                recyclerView.setLayoutManager(new LinearLayoutManager(adminpage.this));
//                AdapterUser adapterUser = new AdapterUser(getApplicationContext(),list);
//
//                recyclerView.setAdapter(adapterUser);
//                adapterUser.notifyDataSetChanged();
//            }
//        }
//
//
//        );
//
    }
}