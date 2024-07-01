package ternak;

import java.util.Scanner;
import panen.*;
import crud.koneksi;
import gui.frameUtama;


public class Ternak {

    public static void main(String[] args) {
        
        new frameUtama().setVisible(true);
        
        // koneksi db = new koneksi();
        // db.ubahPanen(16, "2024-01-10", 20, 20, 100000);
        // db.hapusPanen(16);
        // db.cariPanen(11);
        // db.cariPanen(11);
        // db.dataPanen();
//       
//        Scanner input = new Scanner(System.in);
//        
//        System.out.print("Masukan No DO Panen: ");
//        String noDO = input.nextLine();
//        System.out.print("Masukan Tanggal Panen: ");
//        String tanggalPanen = input.nextLine();
//        System.out.print("Masukan Jumlah Panen: ");
//        int jumlahPanen = input.nextInt();
//        System.out.print("Masukan Berat (kg): ");
//        double beratKg = input.nextDouble();
//        double hargaJualPerEkor = 30000; // Harga jual per ekor ayam
//        
//        // Membuat objek broilerPanen
//        broilerPanen panen = new broilerPanen(noDO, tanggalPanen, jumlahPanen, beratKg, hargaJualPerEkor);
//        
//        System.out.println("=============================== ");
//        System.out.println("Penjualan Kotor: " + panen.hitungPenjualanKotor());
       
        
    }
    
    
}
