package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.main.LoginSystem;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    @Override
    public Boolean login(User users){
        return users.getNama().equals(this.nama)&&users.getNim().equals(this.nim);
    }

    @Override
    public void displayInfo(User users){
        System.out.println("\nAnda login sebagai : ");
        System.out.println("Nama : " + users.getNama());
        System.out.println("NIM : " + users.getNim());
    }

    @Override
    public void reportItem() {
        String namaBarang;
        String deskripsiBarang;
        String lokasiTerakhir;

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("\n=== Masukkan Informasi Barang Temuan ===");
        System.out.print("Masukkan nama barang      : ");
        namaBarang = inputScanner.nextLine();
        System.out.print("Masukkan deskripsi barang : ");
        deskripsiBarang = inputScanner.nextLine();
        System.out.print("Masukkan lokasi terakhir  : ");
        lokasiTerakhir = inputScanner.nextLine();

        System.out.println("\n+++ Detail Barang +++");
        System.out.println("Nama Barang        : "+namaBarang);
        System.out.println("Deskripsi Barang   : "+deskripsiBarang);
        System.out.println("Lokasi Terakhir    : "+lokasiTerakhir);

    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur ini belum tersedia <<");
    }


    @Override
    public void displayAppMenu() {
        Scanner inputScanner = new Scanner(System.in);

        boolean status = true;

        do {
            System.out.println("\nPilihan Menu");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            int pilihan;
            pilihan = inputScanner.nextInt();
            switch (pilihan) {
                case 1 :
                    reportItem();
                    break;
                case 2:
                    System.out.println();
                    viewReportedItems();
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
