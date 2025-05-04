package perpustakaan;

interface Peminjaman {

    void pinjamBuku (String judul);
    void pinjamBuku (String judul, String durasi);
    void kembalikanBuku (String judul);
}
