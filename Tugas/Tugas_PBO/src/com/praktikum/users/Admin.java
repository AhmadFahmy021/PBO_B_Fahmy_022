package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    Scanner inputScanner = new Scanner(System.in);



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
    public Boolean login(ArrayList<User> list){

        for (User data : list){
            if (data instanceof Admin){
                return data.getNama().equals(username) && data.getNim().equals(password);
            }
        }
        return false;
    }

    @Override
    public void displayInfo(ArrayList<User> list){
        System.out.println("\nAnda login sebagai :");
        for (User data : list){
            if (data instanceof Admin){
                System.out.println("Nama : " + data.getNama());
            }
        }
    }

    @Override
    public void manageItems() {
//        System.out.println(">> Fitur kelola barang belum tersedia <<");
        System.out.println("\nPilihan Menu");
        System.out.println("1. Lihat Semua Laporan");
        System.out.println("2. Ubah Status Barang Terlapor");
//        System.out.println("0. Keluar");
        int pilihan;
        System.out.print("Masukkan pilihan menu : ");
        try {
            pilihan  = inputScanner.nextInt();
            inputScanner.nextLine();
            ListIterator<Item> daftarItems =  LoginSystem.reportedItems.listIterator();
            switch (pilihan){
                case 1:
//                        System.out.println("Belum Ada Barang Terlapor");
                    if (LoginSystem.reportedItems.size() == 0){
                        System.out.println("Belum Ada Barang Terlapor");
                    } else {
                        while (daftarItems.hasNext()){
                            Item data = daftarItems.next();
                            System.out.println("Nama Barang : " + data.getName());
                            System.out.println("Deskripsi Barang : " + data.getDescription());
                            System.out.println("Lokasi Terakhir Barang : " + data.getLocation());
                            System.out.println("Status Barang : " + data.getStatus());
                        }
                    }
                    break;
                case 2:
                    if (LoginSystem.reportedItems.size() == 0){
                        System.out.println("Belum Ada Barang Terlapor");
                    } else {
                        int i = 1;

                        while (daftarItems.hasNext()){
                            Item data = daftarItems.next();
                            System.out.println(i+" Nama Barang : " + data.getName() + " Deskripsi Barang : " + data.getDescription() + " Lokasi Terakhir Barang : " + data.getLocation() + " Status Barang : " + data.getStatus());
                        }
                        int index;
                        System.out.print("Masukkan index : ");
                        index = inputScanner.nextInt();
                        inputScanner.nextLine();
                        int pilihanStatus = 0;
                        System.out.println("Pilihan Ubah Status : ");
                        System.out.println("1. Claimed");
                        System.out.println("2. Reported");
                        System.out.print("Masukkan Angka Status : ");
                        pilihanStatus = inputScanner.nextInt();
                        inputScanner.nextLine();
                        Item dataIndex = LoginSystem.reportedItems.get(index-1);
                        switch(pilihanStatus){
                            case 1:
                                LoginSystem.reportedItems.set(index-1, new Item(dataIndex.getName(),dataIndex.getDescription(), dataIndex.getLocation(), "Claimed"));
                                break;
                            case 2 :
                                LoginSystem.reportedItems.set(index-1, new Item(dataIndex.getName(),dataIndex.getDescription(), dataIndex.getLocation(), "Reported"));
                                break;
                            default:
                                System.out.println("Pilihan Tidak Valid");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
                    break;
            }
        } catch (InputMismatchException e){
            throw new RuntimeException(e);
        } catch (IndexOutOfBoundsException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void manageUsers() {
        System.out.println("Masukkan pilihan menu :");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Lihat Daftar Mahasiswa");
        System.out.println("0. Keluar Dari Menu");
        int pilihanMenuUsers;
        System.out.print("Masukkan pilihan menu");
        pilihanMenuUsers = inputScanner.nextInt();
        inputScanner.nextLine();

        ListIterator<User> daftarUsers = LoginSystem.userList.listIterator();
        switch (pilihanMenuUsers){
            case 2:
//                int i = 1;
//                while (daftarUsers.hasNext()){
//                    User data = daftarUsers.next();
//                    i++;
//                    if (data instanceof )
//                    System.out.println(i+"Nama Mahasiswa : "+data.getNama()+" NIM : "+data.getNim());
//                }
                try {
                    int index;
                    System.out.print("Masukkan nomer data yang akan di hapus : ");
                    index = inputScanner.nextInt();
                    inputScanner.nextLine();

                    User dataIndexUser = LoginSystem.userList.remove(index-1);
                    System.out.println(LoginSystem.userList.get(index-1));

                } catch (InputMismatchException e){
                    throw new RuntimeException(e);
                } catch (NullPointerException e){
                    throw new RuntimeException(e);
                } catch (IndexOutOfBoundsException e){
                    throw new RuntimeException(e);
                }


                break;
        }
    }

    @Override
    public void displayAppMenu() {

        boolean status = true;

        do {
            System.out.println("\nPilihan Menu");
            System.out.println("1. Kelola laporan barang");
            System.out.println("2. Kelola data mahasiswa");
            System.out.println("0. Logout");
            int pilihan;
            System.out.print("Masukkan pilihan : ");
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
