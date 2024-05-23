package panen;

public class broilerPanen {
    private String noDO;
    private String tanggalPanen;
    private int jumlahPanen;
    private double beratKg;
    private double hargaJualPerEkor;

    public broilerPanen() {}

    public broilerPanen(String noDO, String tanggalPanen, int jumlahPanen, double beratKg, double hargaJualPerEkor) {
        this.noDO = noDO;
        this.tanggalPanen = tanggalPanen;
        this.jumlahPanen = jumlahPanen;
        this.beratKg = beratKg;
        this.hargaJualPerEkor = hargaJualPerEkor;
    }

    public double hitungPenjualanKotor() {
        return jumlahPanen * hargaJualPerEkor;
    }
}
