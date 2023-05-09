package com.example.parking_spot;

public class UserModel {
    private String name,email,matricule,id;
    private int phone;

    public UserModel() {
    }

    public UserModel(String name, String email, String matricule,String id ,int phone) {
        this.name = name;
        this.email = email;
        this.matricule = matricule;
        this.id=id;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
