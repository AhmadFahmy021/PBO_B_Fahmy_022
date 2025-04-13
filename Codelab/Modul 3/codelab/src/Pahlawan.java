class Pahlawan extends KarakterGame{ // disini dilakukan extend kepada super class KarakterGame
    private int nowKesehatan; // disini dilakukan deklarasi variabel bertype int dengan nama nowKesehatan dan memiliki enkapsulasi / modifier private
    public Pahlawan(String nama, int kesehatan) { // disini fungsi constructor untuk deklarasi variabel yang ada di class KarakterGame
        super(nama, kesehatan); // disini untuk memanggil variabel yang berada pada class KarakterGame dan variable yang memiliki encapsulation private
    }

    @Override // disini ovverride bertujuan agar fungsi yang sama dan berada pada class super isi nya bisa di isi oleh yang berada di sub class
    public void serang(KarakterGame target){ // disini deklarasi fungsi serang
        System.out.println(nama+" menyerang "+target.getNama()+" menggunakan pedang"); // disini menampilkan tampilan dari keterangan menyerang
        this.nowKesehatan = target.getKesehatan() - 20; // pengurangan point kesehatan
        System.out.println(target.getNama()+" sekarang memiliki kesehatan : "+nowKesehatan); // disini menampilkan status kesehatan
        target.setKesehatan(this.nowKesehatan); // disini set kesehatan yang telah di kurangi point nya
    }
}
