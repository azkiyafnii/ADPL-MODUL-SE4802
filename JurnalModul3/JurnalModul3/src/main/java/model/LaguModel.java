package model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class LaguModel {
    private final List<Lagu> listLagu;
    private final DefaultTableModel tableModel;

    public LaguModel() {
        listLagu = new ArrayList<>();
        tableModel = new DefaultTableModel(new Object[]{"Judul", "Penyanyi", "Genre", "Durasi", "Favorit", "Bahasa"}, 0);
    }

    public void addLagu(String judul, String penyanyi, String genre, String durasi, boolean favorit, String bahasa) {
        Lagu laguBaru = new Lagu(judul, penyanyi, genre, durasi, favorit, bahasa);
        listLagu.add(laguBaru);
        tableModel.addRow(new Object[]{
                judul,
                penyanyi,
                genre,
                durasi,
                favorit ? "Ya" : "Tidak",
                bahasa
        });
    }

    public void removeLagu(int index) {
        if (index >= 0 && index < listLagu.size()) {
            listLagu.remove(index);
            tableModel.removeRow(index);
        }
    }

    public void clearData() {
        listLagu.clear();
        tableModel.setRowCount(0);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
