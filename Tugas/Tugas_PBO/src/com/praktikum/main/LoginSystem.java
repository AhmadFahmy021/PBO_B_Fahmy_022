package com.praktikum.main;

import com.praktikum.users.*;

import java.util.Scanner;

public class LoginSystem {

//    User user = new Admin("Admin022", "Password022");
//    User user = new Mahasiswa("Ahmadfahmy", "202410370110022");

    Scanner inputScanner = new Scanner(System.in);
    User user;
    Admin admin = new Admin("Admin022", "Password022");
    Mahasiswa mahasiswa = new Mahasiswa("Ahmadfahmy", "202410370110022");
    int pilihan;

    public LoginSystem(){
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

                if (user.login(admin)) {
                    System.out.println("Login Admin Berhasil");
                    user.displayInfo(admin);
                    user.displayAppMenu();
                    break;
                } else {
                    do {
                        System.out.println("Login gagal! Username atau password salah.\n");

                        System.out.print("Masukkan Username : ");
                        admin.setUsername(inputScanner.nextLine());

                        System.out.print("Masukkan Password : ");
                        admin.setPassword(inputScanner.nextLine());

                        if (user.login(admin)) {
                            System.out.println("Login Admin Berhasil!");
                            user.displayInfo(admin);
                            user.displayAppMenu();
                        }

                    } while(!admin.login(admin));
                }
            case 2:
                System.out.print("Masukkan Nama Mahasiswa : ");
                mahasiswa.setNama(inputScanner.nextLine());

                System.out.print("Masukkan NIM Mahasiswa : ");
                mahasiswa.setNim(inputScanner.nextLine());

                user = mahasiswa;

                if (user.login(mahasiswa)) {
                    System.out.println("Login Mahasiswa Berhasil!");
                    user.displayInfo(mahasiswa);
                    user.displayAppMenu();
                    break;
                } else {
                    do {
                        System.out.println("Login gagal! Nama atau NIM salah!");
                        System.out.print("Masukkan Nama : ");
                        mahasiswa.setNama(inputScanner.nextLine());

                        System.out.print("Masukkan NIM : ");
                        mahasiswa.setNim(inputScanner.nextLine());

                        if (user.login(mahasiswa)) {
                            System.out.println("Login Mahasiswa Berhasil!");
                            user.displayInfo(mahasiswa);
                            user.displayAppMenu();
                        }
                    } while(!mahasiswa.login(mahasiswa));

                    return;
                }
//                return;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }
}
