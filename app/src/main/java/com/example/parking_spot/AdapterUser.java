package com.example.parking_spot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.MyViewHolderUser> {



    Context context;
    ArrayList<UserModel> list;

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

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderUser holder, int position) {


        UserModel userModel = list.get(position);
        holder.name.setText(userModel.getName());
        holder.email.setText(userModel.getEmail());
        holder.phone.setText(userModel.getPhone());
        holder.matricule.setText(userModel.getMatricule());

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