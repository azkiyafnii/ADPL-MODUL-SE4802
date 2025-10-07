package model;

public class Buku {
	private String kodeBuku;
    private String judul;
    private String pengarang;
    private int tahunTerbit;

    public Buku(String kodeBuku, String judul, String pengarang, int tahunTerbit) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    public String getKodeBuku() { return kodeBuku; }
    public String getJudul() { return judul; }
    public String getPengarang() { return pengarang; }
    public int getTahunTerbit() { return tahunTerbit; }
}
