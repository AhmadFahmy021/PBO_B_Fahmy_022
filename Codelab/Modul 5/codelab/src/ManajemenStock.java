import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

public class ManajemenStock {
    public ManajemenStock (){
        ArrayList<Barang> dataBarang = new ArrayList<>();

        dataBarang.add(new Barang("laptop 09", 12));
        dataBarang.add(new Barang("laptop 12", 12));
        dataBarang.add(new Barang("laptop 01", 12));
        dataBarang.add(new Barang("laptop 02", 12));
        dataBarang.add(new Barang("laptop 03", 12));

        Scanner inputScanner = new Scanner(System.in);

        boolean status = true;
        int pilihan;
        do {
            System.out.println("==== Main Main ====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan menu : ");
            pilihan = inputScanner.nextInt();
            inputScanner.nextLine();
            ListIterator<Barang> daftarBarang = dataBarang.listIterator();
            switch (pilihan){
                case 1:
                    String namaBarang;
                    int stockBarang;
                    try {
                        System.out.print("Nama Barang : ");
                        namaBarang = inputScanner.nextLine();
                        System.out.print("Stock Barang : ");
                        stockBarang = inputScanner.nextInt();
                        inputScanner.nextLine();

                        dataBarang.add(new Barang(namaBarang,stockBarang));
                    } catch (InputMismatchException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    if (dataBarang.size() == 0){
                        System.out.println("Barang Sedang Kosong\n");
                    } else {
                        while (daftarBarang.hasNext()){
                            Barang daftar = daftarBarang.next();
                            System.out.println("Nama : "+daftar.getNama() + " Stock : "+daftar.getStock());
                        }
                    }
                    break;
                case 3:
//                    ListIterator<Barang> daftarBarang = dataBarang.listIterator();
                    int i = 0;
//                    System.out.println("");
                    while (daftarBarang.hasNext()){
                        Barang daftar = daftarBarang.next();
                        i+=1;
                        System.out.println(i+". Nama Barang : "+daftar.getNama()+". Stock : "+daftar.getStock());
                    }

                    int index ;
                    int stockKurangi ;
                    try {
                        System.out.print("Nomer Barang : ");
                        index = inputScanner.nextInt();
                        inputScanner.nextLine();
                        System.out.print("Jumlah Stock Yang Di Kurangi : ");
                        stockKurangi = inputScanner.nextInt();
                        inputScanner.nextLine();

                        Barang dataIndex = dataBarang.get(index-1);

                        int updateStock = dataIndex.getStock() - stockKurangi;
                        if (updateStock>=0){
                            dataBarang.add(index-1, new Barang(dataIndex.getNama(), updateStock));
                            System.out.println("Stock barang "+dataIndex.getNama()+" telah berhasil di kurangi, jumlah stock saat ini "+updateStock);
                        } else {
                            throw new StokTidakCukupException("Stock barang "+dataIndex.getNama()+" saat ini tidak cukup!!!. Jumlah stock yang tersedia saat ini "+dataIndex.getStock());
                        }
                    } catch (InputMismatchException e){
                        throw new RuntimeException(e);
                    } catch (StokTidakCukupException e) {
                        throw new RuntimeException(e);
                    } catch (IndexOutOfBoundsException e){
                        throw new RuntimeException(e);
                    }

                    break;
                case 0:
                    System.out.println("\nTerima Kasih!!!");
                    status = false;
                    break;
                default :
                    System.out.println("Opsi Tidak Ada");
                    break;
            }
        } while(status);
        inputScanner.close();
    }
}
