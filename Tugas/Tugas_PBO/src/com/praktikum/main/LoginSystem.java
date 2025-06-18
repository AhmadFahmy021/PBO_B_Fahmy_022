package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.*;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    Scanner inputScanner = new Scanner(System.in);
    User user;
    Admin admin = new Admin("Admin022", "Password022");
    Mahasiswa mahasiswa = new Mahasiswa("Ahmadfahmy", "202410370110022");
    int pilihan;

    public LoginSystem(){
        userList.add(new Admin("Admin022", "Password022"));
        userList.add(new Mahasiswa("Ahmadfahmy", "202410370110022"));

        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan : ");
        pilihan = inputScanner.nextInt();

        inputScanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Username : ");
                admin.setUsername(inputScanner.nextLine());

                System.out.print("Masukkan Password : ");
                admin.setPassword(inputScanner.nextLine());

                user = admin;


                if (admin.login(userList)) {
                    System.out.println("Login Admin Berhasil");
                    user.displayInfo(userList);
                    user.displayAppMenu();
                    break;
                } else {
                    do {
                        System.out.println("Login gagal! Username atau password salah.\n");

                        System.out.print("Masukkan Username : ");
                        admin.setUsername(inputScanner.nextLine());

                        System.out.print("Masukkan Password : ");
                        admin.setPassword(inputScanner.nextLine());

                        if (admin.login(userList)) {
                            System.out.println("Login Admin Berhasil!");
                            user.displayInfo(userList);
                            user.displayAppMenu();
                        }

                    } while(!admin.login(userList));
                }
                break;
            case 2:
                System.out.print("Masukkan Nama Mahasiswa : ");
                mahasiswa.setNama(inputScanner.nextLine());

                System.out.print("Masukkan NIM Mahasiswa : ");
                mahasiswa.setNim(inputScanner.nextLine());

                user = mahasiswa;

                if (user.login(userList)) {
                    System.out.println("Login Mahasiswa Berhasil!");
                    user.displayInfo(userList);
                    user.displayAppMenu();
                    break;
                } else {
                    do {
                        System.out.println("Login gagal! Nama atau NIM salah!");
                        System.out.print("Masukkan Nama : ");
                        mahasiswa.setNama(inputScanner.nextLine());

                        System.out.print("Masukkan NIM : ");
                        mahasiswa.setNim(inputScanner.nextLine());

                        if (user.login(userList)) {
                            System.out.println("Login Mahasiswa Berhasil!");
                            user.displayInfo(userList);
                            user.displayAppMenu();
                        }
                    } while(!mahasiswa.login(userList));

                    return;
                }
//                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }
}

