package com.example.parking_spot;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.protobuf.Value;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.MyViewHolderUser> {

    ProgressDialog progressDialog;


    Context context;
    public ArrayList<UserModel> list;
    public String id ;

    public AdapterUser(Context context, ArrayList<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolderUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_user,parent,false);


        return new MyViewHolderUser(v);

    }



    public static void delusr(String email){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

//        mAuth.sendPasswordResetEmail(email)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Log.d("DELETE", "User deleted successfully.");
//                        } else {
//                            Log.e("DELETE", "Error deleting user.", task.getException());
//                        }
//                    }
//                });
        mAuth.sendPasswordResetEmail(email)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {

                        Log.d("TAG", "onSuccess reset pass: "+email);




                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("TAG", "onFail reset pass: "+email);
                    }
                });


    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolderUser holder, int position) {


        UserModel userModel = list.get(position);
        holder.name.setText(userModel.getName());
        holder.email.setText(userModel.getEmail());
        holder.phone.setText(String.valueOf(userModel.getPhone()));
        holder.matricule.setText(userModel.getMatricule());
        this.id= userModel.getId();



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolderUser extends RecyclerView.ViewHolder{
            TextView name,email,phone,matricule;

            public MyViewHolderUser(@NonNull View itemView) {
                super(itemView);

                name = itemView.findViewById(R.id.idusername);
                email = itemView.findViewById(R.id.iduseremail);
                phone = itemView.findViewById(R.id.iduserphone);
                matricule = itemView.findViewById(R.id.idusermatricule);
                Button delete = itemView.findViewById(R.id.resetbtn);



                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Log.d("DELETE", "onClick: DELETE");
                        delusr(email.getText().toString().trim());


                    }
                });



            }
        }









}

/*

    Context context;

    ArrayList<User> list;

    public AdapterUser(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolderUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_user,parent,false);

        return new MyViewHolderUser(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderUser holder, int position) {

        UserModel user = list.get(position);
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        holder.phone.setText(user.getPhone());
        holder.matricule.setText(user.getMatricule());


    }
   @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolderUser extends RecyclerView.ViewHolder{


        TextView name,email,phone,matricule;

        public MyViewHolderUser(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.idusername);
            email = itemView.findViewById(R.id.iduseremail);
            phone = itemView.findViewById(R.id.iduserphone);
            matricule = itemView.findViewById(R.id.idusermatricule);


        }
    }

 */