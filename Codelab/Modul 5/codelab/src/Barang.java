public class Barang {
    private String nama;
    private int stock;

    public Barang (String nama, int stockBarang){
        this.nama = nama;
        this.stock = stockBarang;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNama() {
        return nama;
    }

    public int getStock() {
        return stock;
    }


}