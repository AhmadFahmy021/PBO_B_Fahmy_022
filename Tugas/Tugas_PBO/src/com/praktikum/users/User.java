package com.praktikum.users;

import java.util.ArrayList;

public abstract class User {
    private String nama;
    private String nim;


    public User(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    public String getNama(){
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public abstract Boolean login(ArrayList<User> list);

    public abstract void displayAppMenu();

    public void displayInfo(ArrayList<User> list){
        System.out.println("Nama : " + this.nama);
        System.out.println("NIM : " + this.nim);
    }
}
