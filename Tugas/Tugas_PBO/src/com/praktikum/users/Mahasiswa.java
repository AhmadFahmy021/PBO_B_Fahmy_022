package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
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
    public Boolean login(ArrayList<User> list){
        for (User data : list){
            if (data instanceof Mahasiswa){
                return data.getNama().equals(this.nama) && data.getNim().equals(this.nim);
            }
        }
        return false;
    }

    @Override
    public void displayInfo(ArrayList<User> list){
        System.out.println("\nAnda login sebagai : ");
        for (User data : list){
            if (data instanceof Mahasiswa){
                System.out.println("Nama : " + data.getNama());
                System.out.println("NIM : " + data.getNim());
            }
        }
    }

    @Override
    public void reportItem() {
        String namaBarang;
        String deskripsiBarang;
        String lokasiTerakhir;

        Scanner inputScanner = new Scanner(System.in);
        try {
            boolean status = false;

            do {
                System.out.println("\n=== Masukkan Informasi Barang Temuan ===");
                System.out.print("Masukkan nama barang      : ");
                namaBarang = inputScanner.nextLine();
                System.out.print("Masukkan deskripsi barang : ");
                deskripsiBarang = inputScanner.nextLine();
                System.out.print("Masukkan lokasi terakhir  : ");
                lokasiTerakhir = inputScanner.nextLine();

                if (namaBarang.trim().isEmpty() ||  deskripsiBarang.trim().isEmpty() || lokasiTerakhir.trim().isEmpty()){
                    status = true;
                }else {
                    status = false;
                }
            }while(status);

        } catch (InputMismatchException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e){
            throw new RuntimeException(e);
        }

        LoginSystem.reportedItems.add(new Item(namaBarang, deskripsiBarang, lokasiTerakhir, "Reported"));
        System.out.println("\n+++ Detail Barang +++");
        System.out.println("Nama Barang        : "+namaBarang);
        System.out.println("Deskripsi Barang   : "+deskripsiBarang);
        System.out.println("Lokasi Terakhir    : "+lokasiTerakhir);

    }

    @Override
    public void viewReportedItems() {
        if (LoginSystem.reportedItems.size() == 0){
            System.out.println("Belum ada laporan barang");
        } else {
            ListIterator<Item> daftarItems = LoginSystem.reportedItems.listIterator();
            while (daftarItems.hasNext()){
                Item data = daftarItems.next();

                if (data.getStatus() == "Reported") {
                    System.out.println("Nama Barang : " +data.getName());
                    System.out.println("Deskripsi Barang : " +data.getDescription());
                    System.out.println("Lokasi Terakhir Barang"+data.getLocation());
                }
            }
        }
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
            System.out.print("Masukkan pilihan menu : ");
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
