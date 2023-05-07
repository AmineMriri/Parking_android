package com.example.parking_spot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.parking_spot.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {


    ActivityLoginBinding binding;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        firebaseFirestore = FirebaseFirestore.getInstance();


        binding.BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.IdEmail.getText().toString().trim();
                String password=binding.IdPassword.getText().toString().trim();
                progressDialog.show();
                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                progressDialog.cancel();
                                Toast.makeText(Login.this,"GOOD login",Toast.LENGTH_SHORT).show();

                                checkuseraccess(authResult.getUser().getUid());


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressDialog.cancel();
                                Toast.makeText(Login.this,"BAD login "+e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
        binding.IdLinkResetpass.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (binding.IdEmail.getText().toString().trim()==null){
                    Toast.makeText(Login.this,"resetting in progress",Toast.LENGTH_SHORT).show();
                    String email=binding.IdEmail.getText().toString().trim();
                    progressDialog.setTitle("Sending Reset Mail");
                    progressDialog.show();
                    firebaseAuth.sendPasswordResetEmail(email)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    progressDialog.cancel();
                                    Toast.makeText(Login.this,"reset mail sent to "+ email,Toast.LENGTH_SHORT).show();

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    progressDialog.cancel();
                                    Toast.makeText(Login.this,"failed due to : "+ e.getMessage(),Toast.LENGTH_SHORT).show();
                                }
                            });


                } else {
                    Toast.makeText(Login.this,"please put the email adress",Toast.LENGTH_SHORT).show();

                }

            }
        });
        binding.IdLinkRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }

    private void checkuseraccess(String uid) {
        DocumentReference df = firebaseFirestore.collection("user").document(uid);
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {

                Log.d("TAG", "onSuccess: "+documentSnapshot.getData());

                if (documentSnapshot.getString("isuser") != null){
                    //normal user

                    startActivity(new Intent(Login.this,HomeScreen.class));
                    finish();
                }else {
//                     admin
                    startActivity(new Intent(Login.this,admin.class));
                    finish();
                }

            }
        });
    }
}