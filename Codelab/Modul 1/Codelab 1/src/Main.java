import java.time.LocalDateTime; //import ini digunakan untuk memanggil local date time nya
import java.util.Scanner; // import ini digunakan untuk memanggil scanner

public class Main { //inisiasi nama class
    public static void main(String[] args) {
        String nama; // disini untuk membuat variabel nama dengan type data string
        String jenis_kelamin = ""; // ini untuk membuat variabel jenis kelamin dengan type data string
        int tahun_lahir; // ini untuk membuat variabel tahun lahir dengan type data integer
        Scanner objInput = new Scanner(System.in); // disini declarasi atau membuat variabel objInput dengan fungsi scanner untuk mengambil input

        System.out.print("Masukkan Nama : "); // untuk menampilkan label untuk memasukkan inputan nama
        nama = objInput.nextLine(); //untuk mengambil inputan nama

        System.out.print("Masukkan Jenis Kelamin (P/L) : "); // untuk menampilkan label untuk memasukkan inputan jenis kelamin
        jenis_kelamin = objInput.nextLine(); // mengambil inputan jenis kelamin

        System.out.print("Masukkan Tahun Lahir  : "); // untuk menampilkan label untuk memasukkan inputan tahun lahir
        tahun_lahir = objInput.nextInt(); // mengambil inputan tahun lahir

        LocalDateTime now = LocalDateTime.now(); // deklarasi variabel now untuk mengambil waktu sekarang
        int umur = now.getYear() - tahun_lahir; // melakukan perhitungan untuk mencari umur dari user

        System.out.println("\nData Diri :"); // menampilkan output data diri
        System.out.println("Nama : "+nama); // menampilkan output dari nama
        System.out.println("Jenis Kelamin : "+jenis_kelamin); // menampilkan output dari jenis kelamin
        System.out.println("Umur : "+ umur+" tahun"); //menampilkan output dari umur yang telah di lakukan perhitungan selisih tahun
    }
}