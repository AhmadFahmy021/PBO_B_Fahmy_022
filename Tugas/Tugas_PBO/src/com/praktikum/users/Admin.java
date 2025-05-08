package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;

import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, String nim){
        super(nama, nim);
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public Boolean login(User users){
        return users.getNama().equals(this.username) && users.getNim().equals(this.password);
    }

    @Override
    public void displayInfo(User users){
        System.out.println("\nAnda login sebagai :");
        System.out.println("Nama : " + users.getNama());
//        System.out.println("NIM : " + this.nim);
    }

    @Override
    public void manageItems() {
        System.out.println(">> Fitur kelola barang belum tersedia <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Fitur kelola mahasiswa belum tersedia");
    }

    @Override
    public void displayAppMenu() {
        Scanner inputScanner = new Scanner(System.in);
        boolean status = true;

        do {
            System.out.println("\nPilihan Menu");
            System.out.println("1. Kelola laporan barang");
            System.out.println("2. Kelola data mahasiswa");
            System.out.println("0. Logout");
            int pilihan;
            pilihan = inputScanner.nextInt();
            switch (pilihan) {
                case 1 :
                    System.out.println();
                    manageItems();
                    break;
                case 2:
                    System.out.println();
                    manageUsers();
                    break;
                case 0:
                    status = false;
                    System.out.println("Good Bye "+getNama());
                    System.out.println();
                    new LoginSystem();
                    break;
                default:
                    System.out.println();
                    System.out.println("Pilihan anda tidak valid");
                    break;
            }
        } while (status);
    }
}
