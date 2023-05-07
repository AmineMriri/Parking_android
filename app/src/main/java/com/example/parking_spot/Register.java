package com.example.parking_spot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class Register extends AppCompatActivity {


    ActivityRegisterBinding binding;

    ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;

    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseAuth=FirebaseAuth.getInstance();

        firebaseFirestore=FirebaseFirestore.getInstance();

        progressDialog=new ProgressDialog(this);

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=binding.idName.getText().toString().trim();
                String email=binding.IdEmailRegister.getText().toString().trim();
                String matricule=binding.IdMatricule.getText().toString().trim();
                int phone=Integer.parseInt(binding.idPhone.getText().toString());
                String password=binding.IdPassRegister.getText().toString();

                progressDialog.show();

                firebaseAuth.createUserWithEmailAndPassword(email,password)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                DocumentReference df = firebaseFirestore.collection("user")
                                        .document(user.getUid());
                                Map<String,Object> userInfo = new HashMap<>();
                                userInfo.put("name",name);
                                userInfo.put("email",email);
                                userInfo.put("matricule",matricule);
                                userInfo.put("phone",phone);

                                userInfo.put("isuser","1");

                                df.set(userInfo);
                                startActivity(new Intent(Register.this,Login.class));
                                progressDialog.cancel();
                                finish();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Register.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                progressDialog.cancel();
                            }
                        });
            }
        });
        binding.loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });


    }
}