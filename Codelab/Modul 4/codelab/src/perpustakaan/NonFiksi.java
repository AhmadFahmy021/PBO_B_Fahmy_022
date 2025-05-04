package perpustakaan;

public class NonFiksi extends Buku{
    private String genre;
    public NonFiksi(String judul, String penulis, String genre){
        setJudul(judul);
        setPenulis(penulis);
        this.genre = genre;
    }

    @Override
    public void displayInfo(){
        System.out.println("Buku Non-Fiksi : "+getJudul()+" oleh "+getPenulis()+" (Genre : "+genre+")");
    }
}
