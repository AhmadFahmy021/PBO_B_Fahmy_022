import java.math.BigInteger;

class Mahasiswa extends  User{
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setNim(String nim){
        this.nim = nim;
    }

    @Override
    public Boolean login(User users){
        return users.getNama().equals(this.nama)&&users.getNim().equals(this.nim);
    }

    @Override
    public void displayInfo(User users){
        System.out.println("\nAnda login sebagai : ");
        System.out.println("Nama : " + users.getNama());
        System.out.println("NIM : " + users.getNim());
    }

}
