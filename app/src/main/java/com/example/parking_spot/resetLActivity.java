package com.example.parking_spot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.parking_spot.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import com.example.parking_spot.databinding.ActivityResetLactivityBinding;

public class resetLActivity extends AppCompatActivity {




    ActivityResetLactivityBinding binding;



    ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;

    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityResetLactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        firebaseAuth=FirebaseAuth.getInstance();

        firebaseFirestore=FirebaseFirestore.getInstance();

        progressDialog=new ProgressDialog(this);

        binding.resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.IdEmail.getText().toString().trim();



                if(!(email.isEmpty())){
                    progressDialog.show();
                    firebaseAuth.sendPasswordResetEmail(email)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(resetLActivity.this,"resetting in progress",Toast.LENGTH_SHORT).show();
                                    String email=binding.IdEmail.getText().toString().trim();
                                    progressDialog.setTitle("Sending Reset Mail");
                                    progressDialog.show();
                                    firebaseAuth.sendPasswordResetEmail(email)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    progressDialog.cancel();
                                                    Toast.makeText(resetLActivity.this,"reset mail sent to "+ email,Toast.LENGTH_SHORT).show();

                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    progressDialog.cancel();
                                                    Toast.makeText(resetLActivity.this,"failed due to : "+ e.getMessage(),Toast.LENGTH_SHORT).show();
                                                }
                                            });
                }




                            });


                        }
                else {

                    Toast.makeText(resetLActivity.this,"please fill the email",Toast.LENGTH_SHORT).show();
                }

            }
        });
        binding.Idlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(resetLActivity.this,Login.class));
                finish();
            }
        });

        binding.IdLinkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(resetLActivity.this,Register.class));
                finish();
            }
        });


    }
}
