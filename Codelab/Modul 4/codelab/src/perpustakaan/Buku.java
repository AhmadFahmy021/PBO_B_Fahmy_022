package perpustakaan;

public abstract class Buku {
    private String judul;
    private String penulis;

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getJudul(){
        return judul;
    }
    public String getPenulis(){
        return penulis;
    }

    public abstract void displayInfo();
}
