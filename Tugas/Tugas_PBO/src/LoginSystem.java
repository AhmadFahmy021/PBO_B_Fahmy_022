import java.math.BigInteger;
import java.util.Scanner;

class LoginSystem {
    Scanner inputScanner = new Scanner(System.in);
    Admin admin = new Admin("Admin022", "Password022");
    Mahasiswa mahasiswa = new Mahasiswa("Ahmadfahmy", "202410370110022");
    int pilihan = 0;

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

                if (admin.login(admin)) {
                    System.out.println("Login Admin Berhasil");
                    admin.displayInfo(admin);
                    break;
                } else {
                    do {
                        System.out.println("Login gagal! Username atau password salah.\n");

                        System.out.print("Masukkan Username : ");
                        admin.setUsername(inputScanner.nextLine());

                        System.out.print("Masukkan Password : ");
                        admin.setPassword(inputScanner.nextLine());

                        if (admin.login(admin)) {
                            System.out.println("Login Admin Berhasil!");
                            admin.displayInfo(admin);
                        }

                    } while(!admin.login(admin));
                }
            case 2:
                System.out.print("Masukkan Nama Mahasiswa : ");
                mahasiswa.setNama(inputScanner.nextLine());

                System.out.print("Masukkan NIM Mahasiswa : ");
                mahasiswa.setNim(inputScanner.nextLine());


                if (mahasiswa.login(mahasiswa)) {
                    System.out.println("Login Mahasiswa Berhasil!");
                    mahasiswa.displayInfo(mahasiswa);
                    break;
                } else {
                    do {
                        System.out.println("Login gagal! Nama atau NIM salah!");
                        System.out.print("Masukkan Nama : ");
                        mahasiswa.setNama(inputScanner.nextLine());

                        System.out.print("Masukkan NIM : ");
                        mahasiswa.setNim(inputScanner.nextLine());

                        if (mahasiswa.login(mahasiswa)) {
                            System.out.println("Login Mahasiswa Berhasil!");
                            mahasiswa.displayInfo(mahasiswa);
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
