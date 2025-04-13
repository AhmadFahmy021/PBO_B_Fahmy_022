public class Main {
    public static void main(String[] args) {
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        rekening1.nomerRekening = "202410370110022";
        rekening1.namaPemilik = "Ahmad Fahmy";
        rekening1.saldo = 500000.0;

        rekening2.nomerRekening = "202410370110020";
        rekening2.namaPemilik = "Naufal Arkaan";
        rekening2.saldo = 1000000.0;

        rekening1.tampilkanInfo();
        System.out.println();
        rekening2.tampilkanInfo();

        System.out.println();

        rekening1.setorUang(200000);
        rekening2.setorUang(500000);

        System.out.println();

        rekening1.tarikUang(800000);
        rekening2.tarikUang(300000);

        System.out.println();

        rekening1.tampilkanInfo();
        System.out.println();
        rekening2.tampilkanInfo();
    }
}