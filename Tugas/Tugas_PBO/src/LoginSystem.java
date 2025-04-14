import java.math.BigInteger;
import java.util.Scanner;

public class LoginSystem {
    Scanner inputScanner = new Scanner(System.in);
    Admin admin = new Admin();
    Mahasiswa mahasiswa = new Mahasiswa();
    int pilihan = 0;

    public LoginSystem(){
        admin.setUsername = "Admin022";
        admin.setPassword = "Password022";

        mahasiswa.setNama = "Ahmad Fahmy";
        mahasiswa.setNim = new BigInteger("202410370110022");

        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan : ");
        pilihan = inputScanner.nextInt();

        inputScanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Username : ");
                admin.username = inputScanner.nextLine();

                System.out.print("Masukkan Password : ");
                admin.password = inputScanner.nextLine();

                if (admin.login()) {
                    System.out.println("Login Admin Berhasil");
                    break;
                } else {
                    do {
                        System.out.println("Login gagal! Username atau password salah.\n");

                        System.out.print("Masukkan Username : ");
                        admin.username = inputScanner.nextLine();

                        System.out.print("Masukkan Password : ");
                        admin.password = inputScanner.nextLine();

                        if (admin.login()) {
                            System.out.println("Login Admin Berhasil!");
                        }

                    } while(!admin.login());

                    return;
                }
            case 2:
                System.out.print("Masukkan Nama Mahasiswa : ");
                mahasiswa.nama = inputScanner.nextLine();

                System.out.print("Masukkan NIM Mahasiswa : ");
                mahasiswa.nim = inputScanner.nextBigInteger();

                inputScanner.nextLine();

                if (mahasiswa.login()) {
                    System.out.println("Login Mahasiswa Berhasil!");
                    mahasiswa.displayInfo();
                    break;
                } else {
                    do {
                        System.out.println("Login gagal! Nama atau NIM salah!");
                        System.out.print("Masukkan Nama : ");
                        mahasiswa.nama = inputScanner.nextLine();

                        System.out.print("Masukkan NIM : ");
                        mahasiswa.nim = inputScanner.nextBigInteger();

                        inputScanner.nextLine();
                        if (mahasiswa.login()) {
                            System.out.println("Login Mahasiswa Berhasil!");
                            System.out.println("Nama : " + mahasiswa.setNama);
                            System.out.println("NIM : " + String.valueOf(mahasiswa.setNim));
                        }
                    } while(!mahasiswa.login());

                    return;
                }
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }
}
