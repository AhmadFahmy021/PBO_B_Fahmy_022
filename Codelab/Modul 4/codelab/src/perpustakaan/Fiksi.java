package perpustakaan;

public class Fiksi extends Buku{
    private String bidang;

    public Fiksi(String judul, String penulis, String bidang){
        setJudul(judul);
        setPenulis(penulis);
        this.bidang = bidang;
    }

    @Override
    public void displayInfo(){
        System.out.println("Buku fiksi : "+getJudul()+" oleh "+getPenulis()+" (Bidang : "+ this.bidang+")");
    }
}
