package ternak;

import java.util.Scanner;
import panen.*;

public class Ternak {

    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukan No DO Panen: ");
        String noDO = input.nextLine();
        System.out.print("Masukan Tanggal Panen: ");
        String tanggalPanen = input.nextLine();
        System.out.print("Masukan Jumlah Panen: ");
        int jumlahPanen = input.nextInt();
        System.out.print("Masukan Berat (kg): ");
        double beratKg = input.nextDouble();
        double hargaJualPerEkor = 30000; // Harga jual per ekor ayam
        
        // Membuat objek broilerPanen
        broilerPanen panen = new broilerPanen(noDO, tanggalPanen, jumlahPanen, beratKg, hargaJualPerEkor);
        
        System.out.println("=============================== ");
        System.out.println("Penjualan Kotor: " + panen.hitungPenjualanKotor());
        
    }
    
    
}
