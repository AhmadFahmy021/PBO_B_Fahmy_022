import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);
//        Pahlawan brimStone = new Pahlawan("Brimstone", 150);
//        Musuh viper = new Musuh("Viper", 200);
//
//        System.out.println("Status Awal : ");
//        System.out.println(brimStone.getNama()+" memiliki kesehatan : "+ brimStone.getKesehatan());
//        System.out.println(viper.getNama()+" memiliki kesehatan : "+ viper.getKesehatan());
//
//        brimStone.serang(viper);
//        viper.serang(brimStone);
        Scanner scan = new Scanner(System.in); // Ini deklarasi scanner untuk menerima input
        int pilihanMenu = 0; // Deklarasi variable int untuk menampung pilihan menu;

        System.out.println("==== Main Menu Permainan ===="); // Menampilkan tampilan untuk judul
        System.out.println("Silahkan pilih menu berikut : "); // Menampilkan tampilan untuk agar memilih menu
        System.out.println("1. Start"); // Menampilkan tampilan untuk pilihan menu Start
        System.out.println("2. Exit"); // Menampilkan tampilan untuk Exit (Keluar)
        System.out.print("Masukkan pilihan anda : "); // Menampilkan tampilan untuk memasukkan input atau pilihan menu
        pilihanMenu = scan.nextInt(); // Menampung input pilihan

        switch (pilihanMenu){
            case 1 : // Cek apakah pilihan nya adalah 1
                scan.nextLine(); //disini dilakukan penghapusan line yang ditimbulkan karena tombol enter di tekan
                String namaPahlawan; // dekalrasi nama pahlawan
                int kesehatanPahlawan = 0; // deklarasi kesehatan pahlawan

                String namaMusuh; // deklarasi nama musuh
                int kesehatanMusuh = 0; // deklarasi kesehatan musuh

                System.out.println("\n+++ Masukkan Identitas Pahlawan +++"); // menampilakan tampilan untuk judul

                System.out.print("Silahkan masukkan nama : "); // menampilkan permintaan input nama pahlawan
                namaPahlawan = scan.nextLine(); // menerima isi masukan nama

                System.out.print("Silahkan masukkan jumlah kesehatan : "); // menampilkan permintaan input kesehatan pahlawan
                kesehatanPahlawan = scan.nextInt(); // menerima isi kesehatan

                scan.nextLine(); //disini dilakukan penghapusan line yang ditimbulkan karena tombol enter di tekan
                System.out.println("\n+++ Masukkan Identitas Musuh +++"); // menampilakan tampilan untuk judul

                System.out.print("Silahkan masukkan nama : "); // menampilkan permintaan input nama musuh
                namaMusuh = scan.nextLine(); // menerima isi nama

                System.out.print("Silahkan masukkan jumlah kesehatan : "); // menampilkan permintaan input kesehatan musuh
                kesehatanMusuh = scan.nextInt(); // menerima isi kesehatan

                Pahlawan pahlawan = new Pahlawan(namaPahlawan, kesehatanPahlawan); // mengirimkan data pahlawan ke kelas subclass pahlawan
                Musuh musuh = new Musuh(namaMusuh, kesehatanMusuh); // mengirimkan data pahlawan ke kelas subclass musuh

                System.out.println("\n--- Status Awal ---"); // menampilkan tampilan judul status
                System.out.println(pahlawan.getNama()+" memiliki kesehatan : "+pahlawan.getKesehatan()); // menampilkan status atau data pahlawan
                System.out.println(musuh.getNama()+" memiliki kesehatan : "+musuh.getKesehatan()); // menampilkan status atau data musuh

                int pilihanMenuAction = 0; // deklarasi pilihan menu action
                boolean menuAction = true; // deklarasi menuAction untuk membatasi looping

                do {
                    System.out.println("\n_____ Menu Action _____"); // menampilkan tampilan judul menu Action
                    System.out.println("1. Serang Pahlawan"); // menampilkan pilihan action serang pahlawan
                    System.out.println("2. Serang Musuh"); // menmapilkan pilihan action serang musuh
                    System.out.println("3. Check Status"); // menampilkan pilihan check status
                    System.out.println("4. Exit"); // menampilakn pilihan exit
                    System.out.print("Silahkan masukkan pilihan : "); // menampilkan untuk mengisikan input pilihan action
                    pilihanMenuAction = scan.nextInt(); // menampung pilihan menu action

                    switch (pilihanMenuAction) {
                        case 1 : // cek apakah pilihan nya adalah 1
                            musuh.serang(pahlawan); // memanggil fungsi serang yang ada di class musuh untuk serang pahlawan
                            break;
                        case 2 :
                            pahlawan.serang(musuh); // memanggil fungsi serang yang ada di class pahlawan untuk serang musuh
                            break;
                        case 3 :
                            System.out.println(pahlawan.getNama()+" kesehatan tersisa : "+pahlawan.getKesehatan()); // menampilkan status kesehatan para actor
                            System.out.println(musuh.getNama()+" kesehatan tersisa : "+musuh.getKesehatan());
                            break;
                        case 4 :
                            menuAction = false; //disini mengubah variabel menu action menjadi false agar looping tidak dilakukan lagi
                            System.out.println("Terima kasih telah bermain di platform kami"); // disini menampilkan tampilan terima kasih
                            break;
                    }
                } while (menuAction); // disini di cek apakah menu action benilai tru atau false

                break; // disini kode di hentikan pada bagian ini saja
            case 2 :
                System.out.println("Exit"); // menampilkan tampilan proses ini telah di hentikan dan di keluarkan
                break;
            default:
                System.out.println("Pilihan menu tidak ada"); // disini di tampilkan untuk menampilkan bahwa pilihan tidak ada
                break;
        }
    }
}