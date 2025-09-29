package controller;

import model.LaguModel;
import view.LaguView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaguController {
    private LaguModel model;
    private LaguView view;

    public LaguController(LaguModel model, LaguView view) {
        this.model = model;
        this.view = view;

        // Override any existing TableModel in the view with the model's TableModel (6 columns).
        view.getTable().setModel(model.getTableModel());

        // Button "Tambah"
        view.getBtnTambah().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Read input fields
                String judul = view.getJudulField().getText();
                String penyanyi = view.getPenyanyiField().getText();
                String durasi = view.getDurasiField().getText();
                String genre = (String) view.getGenreComboBox().getSelectedItem();

                // Radio buttons (bahasa)
                String bahasa = "";
                if (view.getRbIndonesia().isSelected()) {
                    bahasa = "Indonesia";
                } else if (view.getRbEnglish().isSelected()) {
                    bahasa = "English";
                } else if (view.getRbOther().isSelected()) {
                    bahasa = "Other";
                }

                // Checkbox favorit
                boolean favorit = view.getFavoritCheckBox().isSelected();

                // Add data to Model
                model.addLagu(judul, penyanyi, genre, durasi, favorit, bahasa);

                // Optionally, clear the form
                view.getJudulField().setText("");
                view.getPenyanyiField().setText("");
                view.getDurasiField().setText("");
                view.getGenreComboBox().setSelectedIndex(0);
                view.getGroupRadio().clearSelection();
                view.getFavoritCheckBox().setSelected(false);
            }
        });

        // Button "Hapus"
        view.getBtnHapus().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowSelected = view.getTable().getSelectedRow();
                if (rowSelected != -1) {
                    model.removeLagu(rowSelected);
                }
            }
        });

        // Button "Clear"
        view.getBtnClear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.clearData();
            }
        });
    }
}
