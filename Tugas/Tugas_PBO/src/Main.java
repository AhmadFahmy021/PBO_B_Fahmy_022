

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int pilihan = 0;

        String dataUsernameAdmin = "Admin022";
        String dataPasswordAdmin = "Password022";

        String dataNamaMahasiswa = "Ahmad Fahmy";
        BigInteger dataNimMahasiswa = new BigInteger("202410370110022");

        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan : ");
        pilihan = inputScanner.nextInt();

        inputScanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Username : ");
                String username = inputScanner.nextLine();
                System.out.print("Masukkan Password : ");
                String password = inputScanner.nextLine();
                if (username.equals(dataUsernameAdmin) && password.equals(dataPasswordAdmin)) {
                    System.out.println("Login Admin Berhasil");
                    break;
                } else {
                    do {
                        System.out.println("Login gagal! Username atau password salah.\n");
                        System.out.print("Masukkan Username : ");
                        username = inputScanner.nextLine();

                        System.out.print("Masukkan Password : ");
                        password = inputScanner.nextLine();

                        if (username.equals(dataUsernameAdmin) && password.equals(dataPasswordAdmin)) {
                            System.out.println("Login Admin Berhasil!");
                        }

                    } while(!username.equals(dataUsernameAdmin) || !password.equals(dataPasswordAdmin));

                    return;
                }
            case 2:
                System.out.print("Masukkan Nama Mahasiswa : ");
                String nama = inputScanner.nextLine();

                System.out.print("Masukkan NIM Mahasiswa : ");
                BigInteger nim = inputScanner.nextBigInteger();

                inputScanner.nextLine();

                if (nama.equals(dataNamaMahasiswa) && nim.equals(dataNimMahasiswa)) {
                    System.out.println("Login Mahasiswa Berhasil!");
                    System.out.println("Nama : " + dataNamaMahasiswa);
                    System.out.println("NIM : " + String.valueOf(dataNimMahasiswa));
                    break;
                } else {
                    do {
                        System.out.println("Login gagal! Nama atau NIM salah!");
                        System.out.print("Masukkan Nama : ");
                        nama = inputScanner.nextLine();

                        System.out.print("Masukkan NIM : ");
                        nim = inputScanner.nextBigInteger();
                        
                        inputScanner.nextLine();
                        if (nama.equals(dataNamaMahasiswa) && nim.equals(dataNimMahasiswa)) {
                            System.out.println("Login Mahasiswa Berhasil!");
                            System.out.println("Nama : " + dataNamaMahasiswa);
                            System.out.println("NIM : " + String.valueOf(dataNimMahasiswa));
                        }
                    } while(!nama.equals(dataNamaMahasiswa) || !nim.equals(dataNimMahasiswa));

                    return;
                }
            default:
                System.out.println("Pilihan tidak valid!");
        }

    }
}
