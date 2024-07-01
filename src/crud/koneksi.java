package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class koneksi {
    private String databaseName = "2210010485";
    private String username = "root";
    private String password = "";
    private String lokasi = "jdbc:mysql://localhost:3306/" + databaseName; 
    public static Connection koneksiDB;
    
    public koneksi() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            koneksiDB.setAutoCommit(false); // Disable autocommit
            System.out.println("Database Terkoneksi");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver tidak ditemukan: " + e.toString());
        } catch (SQLException e) {
            System.err.println("Koneksi gagal: " + e.toString());
        }
    }
    
    public void simpanPanen(int paramNoDO, String paramTanggalpanen,
            int paramJumlah_panen, int paramBeratkg, int paramHargajual, int paramPenjualankotor){
        
        try {
            String SQL = "INSERT INTO panen (noDO, tanggal_panen, jumlah_panen, berat_kg, harga_jual, penjualan_kotor)"
                    + "VALUES(?,?,?,?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramNoDO);
            perintah.setString(2, paramTanggalpanen);
            perintah.setInt(3, paramJumlah_panen);
            perintah.setInt(4, paramBeratkg);
            perintah.setInt(5, paramHargajual);
            perintah.setInt(6, paramPenjualankotor);
            
            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil disimpan");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void ubahPanen(int paramNoDO, String paramTanggalpanen,
            int paramJumlah_panen, int paramBeratkg, int paramHargajual, int paramPenjualankotor){
        
        try {
            String SQL = "UPDATE panen SET tanggal_panen =?, jumlah_panen=?,"
                    + "berat_kg=?, harga_jual=?, penjualan_kotor=? WHERE noDO=?";
                    
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramTanggalpanen);
            perintah.setInt(2, paramJumlah_panen);
            perintah.setInt(3, paramBeratkg);
            perintah.setInt(4, paramHargajual);
            perintah.setInt(5, paramPenjualankotor);
            perintah.setInt(6, paramNoDO);
            
            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil diubah");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void hapusPanen(int paramNoDO){
        try {
            String SQL = "DELETE FROM panen WHERE noDO=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramNoDO);
            perintah.executeUpdate();
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil dihapus");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void cariPanen(int paramNoDo){
        try {
            String SQL = "SELECT * FROM panen WHERE noDO=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramNoDo);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("noDO: "+ data.getInt("noDO"));
                System.out.println("Tanggal Panen: "+ data.getString("tanggal_panen"));
                System.out.println("Jumlah Panen: "+ data.getInt("jumlah_panen"));
                System.out.println("Berat(KG): "+ data.getInt("berat_kg"));
                System.out.println("Harga Jual: "+ data.getInt("harga_jual"));
                System.out.println("Penjualan Kotor:" + data.getInt("penjualan_kotor"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataPanen(){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("SELECT * FROM panen ORDER BY noDO ASC");
            while(baris.next()){
                System.out.println("noDO: " + baris.getInt("noDO") + " | " +
                                   "Tanggal Panen: " + baris.getString("tanggal_panen") + " | " +
                                   "Jumlah Panen: " + baris.getInt("jumlah_panen") + " | " +
                                   "Berat (KG): " + baris.getInt("berat_kg") + " | " +
                                   "Harga Jual: " + baris.getInt("harga_jual") + " | " +
                                   "Penjualan Kotor: " + baris.getInt("penjualan_kotor"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    //    ----------------------------------PRODUKSI-----------------------------------------------
    
    public void simpanBiaya(int paramIdBiaya, String paramJumlah, String paramTanggal){
        
        try {
            String SQL = "INSERT INTO biaya_pakan (id_biaya, jumlah_pakan, tanggal)"
                    + "VALUES(?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramIdBiaya);
            perintah.setString(2, paramJumlah);
            perintah.setString(3, paramTanggal);
            
            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil disimpan");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    public void ubahBiaya(int paramIdBiaya, String paramJumlah, String paramTanggal){
        
        try {
            String SQL = "UPDATE biaya_pakan SET jumlah_pakan=?, tanggal=?  WHERE id_biaya=?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramJumlah);
            perintah.setString(2 ,paramTanggal);
            perintah.setInt(3, paramIdBiaya);
            
            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil diubah");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void hapusBiaya(int paramIdBiaya){
        
        try {
            String SQL = "DELETE FROM biaya_pakan WHERE id_biaya =?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramIdBiaya);

            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil dihapus");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    //    --------------------------------- PRODUKSI --------------------------------------------
    
    public void simpanProduksi(int paramId_Produksi, String paramTanggalProduksi){
        
        try {
            String SQL = "INSERT INTO produksi (id_produksi, tanggal_produksi)"
                    + "VALUES(?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId_Produksi);
            perintah.setString(2, paramTanggalProduksi);
            
            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil disimpan");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    public void ubahProduksi(int paramId_Produksi, String paramTanggalProduksi){
        
        try {
            String SQL = "UPDATE produksi SET tanggal_produksi=?  WHERE id_produksi=?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramTanggalProduksi);
            perintah.setInt(2, paramId_Produksi);
            
            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil diubah");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void hapusProduksi(int paramId_Produksi){
        
        try {
            String SQL = "DELETE FROM produksi WHERE id_produksi =?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId_Produksi);

            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil dihapus");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    //    ----------------------------------MASTER PAKAN--------------------------------------
    
    public void simpanMaster(int paramIdMaster, String paramNama, String paramJenis, String paramBerat, 
            String paramLemak, String paramProtein, String paramEnergi){
        
        try {
            String SQL = "INSERT INTO master_pakan (id_pakan, nama_pakan, jenis_pakan, berat_kemasan, lemak, protein, energi) "
                    + "VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramIdMaster);
            perintah.setString(2, paramNama);
            perintah.setString(3, paramJenis);
            perintah.setString(4, paramBerat);
            perintah.setString(5, paramLemak);
            perintah.setString(6, paramProtein);
            perintah.setString(7, paramEnergi);
            
            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil disimpan");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void ubahMaster(int paramIdMaster, String paramNama, String paramJenis, String paramBerat, 
            String paramLemak, String paramProtein, String paramEnergi){
        
        try {
            String SQL = "UPDATE master_pakan SET nama_pakan=?, jenis_pakan=?, berat_kemasan=?, lemak=?, protein=?, energi=? WHERE id_pakan=?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramNama);
            perintah.setString(2, paramJenis);
            perintah.setString(3, paramBerat);
            perintah.setString(4, paramLemak);
            perintah.setString(5, paramProtein);
            perintah.setString(6, paramEnergi);
            perintah.setInt(7, paramIdMaster);
            
            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil diubah");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void hapusMaster(int paramIdMaster){
        
        try {
            String SQL = "DELETE FROM master_pakan WHERE id_pakan =?";
            
            PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramIdMaster);

            perintah.executeUpdate(); // Eksekusi pernyataan SQL
            koneksiDB.commit(); // Commit perubahan
            System.out.println("Data berhasil dihapus");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
