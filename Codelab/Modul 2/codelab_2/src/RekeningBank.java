public class RekeningBank {
    String nomerRekening;
    String namaPemilik;
    Double saldo;

    void tampilkanInfo() {
        System.out.println("Nomor Rekening : "+nomerRekening);
        System.out.println("Nama Pemilik : "+namaPemilik);
        System.out.println("Saldo : Rp"+saldo);
    }

    void setorUang(double jumlah) {
        saldo += jumlah;
        System.out.println(namaPemilik+" menyetor Rp"+jumlah+". Saldo sekarang : Rp"+saldo);
    }

    void tarikUang(double jumlah) {
        double min = saldo - jumlah;

        if (min > 0){
            saldo -= jumlah;
            System.out.println(namaPemilik+" menarik Rp"+jumlah+" (Berhasil) Saldo sekarang : Rp"+saldo);
        } else {
            System.out.println(namaPemilik+" menarik Rp"+jumlah+" (Gagal, Saldo tidak mencukupi) Saldo sekarang : Rp"+saldo);
        }
    }
}
