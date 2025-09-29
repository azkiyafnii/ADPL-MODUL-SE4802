package model;

public class Lagu {
    private String judul;
    private String penyanyi;
    private String genre;
    private String durasi;
    private boolean favorit;
    private String bahasa;

    public Lagu(String judul, String penyanyi, String genre, String durasi, boolean favorit, String bahasa) {
        this.judul = judul;
        this.penyanyi = penyanyi;
        this.genre = genre;
        this.durasi = durasi;
        this.favorit = favorit;
        this.bahasa = bahasa;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenyanyi() {
        return penyanyi;
    }

    public String getGenre() {
        return genre;
    }

    public String getDurasi() {
        return durasi;
    }

    public boolean isFavorit() {
        return favorit;
    }

    public String getBahasa() {
        return bahasa;
    }
}
