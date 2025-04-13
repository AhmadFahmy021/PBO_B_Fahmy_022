class Musuh extends KarakterGame { //disini dilakukan untuk melakukan extends super class KarakterGame
    public Musuh(String nama, int kesehatan){ // disini fungsi atau method constructor bisa menerima inputan
        super(nama, kesehatan); // disini memanggil variable nama dan kesehatanyang ada di super class Karaktergame
    }

    public void serang(KarakterGame target){
        System.out.println(nama+" menyerang "+target.getNama()+" menggunakan sihir!");
        int nowKesehatan = target.getKesehatan() - 15; // disini deklarasi variabel dari now kesehatan sekaligus dilakukan pengurangan point pada fungsi serang
        System.out.println(target.getNama()+" sekarang memiliki kesehatan : "+nowKesehatan); // disini menampilkan status kesehatan
        target.setKesehatan(nowKesehatan);
    }
}
