package perpustakaan;

public class Anggota implements Peminjaman{
    String namaAnggota;
    String idAnggota;

    public Anggota(String namaAnggota, String idAnggota) {
        this.namaAnggota = namaAnggota;
        this.idAnggota = idAnggota;
    }

    public void infoAnggota(){
        System.out.println("Anggota : "+namaAnggota+" (ID: "+idAnggota+")");
    }

    @Override
    public void pinjamBuku(String judulBuku){
        System.out.println(namaAnggota+" meminjam buku berjudul : "+judulBuku);
    }

    @Override
    public void pinjamBuku(String judul, String durasi){
        System.out.println(namaAnggota+" meminjam buku : "+judul+" selama "+durasi);
    }


    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(namaAnggota+" mengembalikan buku berjudul : "+judul);
    }
}
