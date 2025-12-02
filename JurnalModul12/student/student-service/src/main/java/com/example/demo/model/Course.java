package com.example.demo.model;

public class Course {
    private String kode;
    private String judul;
    private String dosen;

    public Course() {}

    public Course(String kode, String judul, String dosen) {
        this.kode = kode;
        this.judul = judul;
        this.dosen = dosen;
    }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getJudul() { return judul; }
    public void setJudul(String judul) { this.judul = judul; }

    public String getDosen() { return dosen; }
    public void setDosen(String dosen) { this.dosen = dosen; }
}

