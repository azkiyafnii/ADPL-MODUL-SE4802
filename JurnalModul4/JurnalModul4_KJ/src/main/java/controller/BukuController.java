package controller;

import model.Buku;
import model.Database;
import view.BukuView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BukuController {
    private Database db;
    private BukuView view;

    public BukuController(Database db, BukuView view) {
        this.db = db;
        this.view = view;
        db.connect();
        loadData();

        // Event Listener untuk tombol-tombol
        view.addTambahListener(e -> tambahBuku());
        view.addEditListener(e -> editBuku());
        view.addHapusListener(e -> hapusBuku());
        view.addRefreshListener(e -> loadData());
    }

    // Metode untuk Menambahkan Buku
    private void tambahBuku() {
        String kode = view.getTextKodeBuku().getText();
        String judul = view.getTextJudul().getText();
        String pengarang = view.getTextPengarang().getText();
        String tahunTerbit = view.getTextTahunTerbit().getText();

        // Validasi input kosong
        if (kode.isEmpty() || judul.isEmpty() || pengarang.isEmpty() || tahunTerbit.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi angka pada tahunTerbit
        try {
            Integer.parseInt(tahunTerbit);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Tahun Terbit harus berupa angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String sql = "INSERT INTO buku (kodeBuku, judul, pengarang, tahunTerbit) VALUES ('" +
                     kode + "', '" + judul + "', '" + pengarang + "', " + tahunTerbit + ")";
        
        db.query(sql);
        JOptionPane.showMessageDialog(view, "Buku berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        loadData();
        resetForm();
    }

    // Metode untuk Mengedit Buku
    private void editBuku() {
        String kode = view.getTextKodeBuku().getText();
        String judul = view.getTextJudul().getText();
        String pengarang = view.getTextPengarang().getText();
        String tahunTerbit = view.getTextTahunTerbit().getText();

        // Validasi input kosong
        if (kode.isEmpty() || judul.isEmpty() || pengarang.isEmpty() || tahunTerbit.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validasi angka pada tahunTerbit
        try {
            Integer.parseInt(tahunTerbit);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Tahun Terbit harus berupa angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(view, "Apakah Anda yakin ingin mengedit buku ini?", 
                         "Konfirmasi Edit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "UPDATE buku SET judul='" + judul + "', pengarang='" + pengarang +
                         "', tahunTerbit=" + tahunTerbit + " WHERE kodeBuku='" + kode + "'";
            
            db.query(sql);
            JOptionPane.showMessageDialog(view, "Buku berhasil diperbarui!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            resetForm();
        }
    }

    // Metode untuk Menghapus Buku
    private void hapusBuku() {
        String kode = view.getTextKodeBuku().getText();

        if (kode.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Kode Buku harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(view, "Apakah Anda yakin ingin menghapus buku ini?", 
                         "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM buku WHERE kodeBuku='" + kode + "'";
            db.query(sql);
            JOptionPane.showMessageDialog(view, "Buku berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            loadData();
            resetForm();
        }
    }

    // Metode untuk Menampilkan Data dalam JTable
    private void loadData() {
        List<Buku> bukuList = new ArrayList<>();
        ResultSet rs = db.view("SELECT * FROM buku");
        try {
            while (rs.next()) {
                bukuList.add(new Buku(
                        rs.getString("kodeBuku"),
                        rs.getString("judul"),
                        rs.getString("pengarang"),
                        rs.getInt("tahunTerbit")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Mengisi JTable dengan data dari database
        String[] columnNames = {"Kode Buku", "Judul", "Pengarang", "Tahun Terbit"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        for (Buku buku : bukuList) {
            tableModel.addRow(new Object[]{buku.getKodeBuku(), buku.getJudul(), buku.getPengarang(), buku.getTahunTerbit()});
        }
        view.getTable().setModel(tableModel);
    }

    // Metode untuk Mereset Form
    private void resetForm() {
        view.getTextKodeBuku().setText("");
        view.getTextJudul().setText("");
        view.getTextPengarang().setText("");
        view.getTextTahunTerbit().setText("");
    }
}
