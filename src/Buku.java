public class Buku {
    private int id;
    private String judul;
    private String pengarang;
    private int tahunTerbit;

    public Buku(String judul, String pengarang, int tahunTerbit) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    public Buku(int id, String judul, String pengarang, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    public int getId() { return id; }
    public String getJudul() { return judul; }
    public String getPengarang() { return pengarang; }
    public int getTahunTerbit() { return tahunTerbit; }
}
