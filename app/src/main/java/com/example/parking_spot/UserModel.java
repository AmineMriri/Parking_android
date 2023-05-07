package com.example.parking_spot;

public class UserModel {
    private String name,email,matricule;
    private int phone;

    public UserModel() {
    }

    public UserModel(String name, String email, String matricule, int phone) {
        this.name = name;
        this.email = email;
        this.matricule = matricule;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
