 class KarakterGame {
    String nama; // disini melakukan deklarasi variable nama type string
    int kesehatan; // disini melakuka  deklarasi variable kesehatan type integer

    public String getNama(){ // disini fungsi untuk menampilkan atau memberitahukan isi dari variabel nama
        return nama; // disini dilakukan pengembalian nilai pada fungsi yang bernilai String
    }

    public int getKesehatan(){// disini fungsi untuk menampilkan atau memberitahukan isi dari variabel kesehatan
        return kesehatan; // disini dilakukan pengembalian nilai pada fungsi yang bernilai integer
    }

    public void setNama(String nama){ // disini fungsi untuk mengisi dari variabel nama
        this.nama = nama; // disini dilakukan set nama yang dilakukan untuk menyimpan nama ke pada variabel yang bertipe private
    }

    public void setKesehatan(int kesehatan){// disini fungsi untuk mengisi dari variabel kesehatan
        this.kesehatan = kesehatan; // disini dilakukan set kesehatan yang dilakukan untuk menyimpan nama ke pada variabel yang bertipe private
    }

    public void serang(KarakterGame target){
        System.out.println(nama+" menyerang "+target.getNama());
    }

    public KarakterGame(String nama, int kesehatan){ // ini adalah fungsi constructor untuk untuk menerima input
        this.nama = nama;
        this.kesehatan = kesehatan;
    }
}
