package app;

import perpustakaan.Anggota;
import perpustakaan.Fiksi;
import perpustakaan.NonFiksi;

public class Main {
    public static void main(String[] args) {
        Fiksi fiksi1 = new Fiksi("Madilog", "Tan Malaka", "Sejarah");

        Anggota anggota1 = new Anggota("Fahmy",  "022");
        Anggota anggota2 = new Anggota("Arkaan",   "020");

        NonFiksi nonFiksi1 = new NonFiksi("Kode", "fahmy", "dongeng");



        fiksi1.displayInfo();
        nonFiksi1.displayInfo();

        anggota1.infoAnggota();
        anggota2.infoAnggota();

        anggota1.pinjamBuku(nonFiksi1.getJudul());
        anggota2.pinjamBuku("Madilog", "7 hari");

        anggota1.kembalikanBuku(nonFiksi1.getJudul());
        anggota2.kembalikanBuku(fiksi1.getJudul());

    }
}