import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuDAO {
    public void tambahBuku(Buku buku) {
        String sql = "INSERT INTO buku (judul, pengarang, tahun_terbit) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, buku.getJudul());
            stmt.setString(2, buku.getPengarang());
            stmt.setInt(3, buku.getTahunTerbit());
            stmt.executeUpdate();
            System.out.println("✅ Buku berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("❌ Gagal menambahkan buku: " + e.getMessage());
        }
    }

    public List<Buku> getSemuaBuku() {
        List<Buku> daftarBuku = new ArrayList<>();
        String sql = "SELECT * FROM buku";

        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Buku buku = new Buku(
                    rs.getInt("id"),
                    rs.getString("judul"),
                    rs.getString("pengarang"),
                    rs.getInt("tahun_terbit")
                );
                daftarBuku.add(buku);
            }
        } catch (SQLException e) {
            System.out.println("❌ Gagal mengambil data buku: " + e.getMessage());
        }

        return daftarBuku;
    }
}
