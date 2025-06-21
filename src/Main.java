import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BukuDAO dao = new BukuDAO();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n==== Menu Perpustakaan ====");
            System.out.println("1. Tampilkan Data Buku");
            System.out.println("2. Tambah Data Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // untuk membersihkan newline

            switch (pilihan) {
                case 1:
                    List<Buku> daftar = dao.getSemuaBuku();
                    System.out.println("\n=== Daftar Buku ===");
                    for (Buku b : daftar) {
                        System.out.println("ID          : " + b.getId());
                        System.out.println("Judul       : " + b.getJudul());
                        System.out.println("Pengarang   : " + b.getPengarang());
                        System.out.println("Tahun Terbit: " + b.getTahunTerbit());
                        System.out.println("-----------------------------");
                    }
                    break;

                case 2:
                    System.out.print("Judul       : ");
                    String judul = scanner.nextLine();
                    System.out.print("Pengarang   : ");
                    String pengarang = scanner.nextLine();
                    System.out.print("Tahun Terbit: ");
                    int tahun = scanner.nextInt();
                    dao.tambahBuku(new Buku(judul, pengarang, tahun));
                    break;

                case 0:
                    System.out.println("Keluar...");
                    break;

                default:
                    System.out.println("❌ Pilihan tidak valid.");
            }

        } while (pilihan != 0);

        scanner.close();
    }
}
