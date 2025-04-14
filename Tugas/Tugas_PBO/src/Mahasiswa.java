import java.math.BigInteger;

public class Mahasiswa {
    String nama;
    BigInteger nim;

    String setNama;
    BigInteger setNim;

    public  Mahasiswa() {

    }

    Boolean login(){
        boolean status = false;
        if (this.nama.equals(this.setNama) && this.nim.equals(this.setNim)){
            status = true;
        }
        return status;
    }

    void displayInfo(){
        System.out.println("Nama : " + this.setNama);
        System.out.println("NIM : " + String.valueOf(this.setNim));
    }
}
