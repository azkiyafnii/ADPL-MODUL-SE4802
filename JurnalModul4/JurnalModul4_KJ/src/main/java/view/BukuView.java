package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class BukuView extends JFrame {
    private final JTextField textKodeBuku, textJudul, textPengarang, textTahunTerbit;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JButton btnTambah, btnEdit, btnHapus, btnRefresh;

    public BukuView() {
        setTitle("Sistem Data Buku Perpustakaan");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null); // Agar window tampil di tengah layar

        // Panel utama
        JPanel panelUtama = new JPanel(new BorderLayout(10, 10));
        panelUtama.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(panelUtama, BorderLayout.CENTER);

        // Panel Form Input
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelUtama.add(panelForm, BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label dan Text Field
        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(new JLabel("Kode Buku:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        textKodeBuku = new JTextField(20);
        panelForm.add(textKodeBuku, gbc);

        gbc.gridx = 3; gbc.gridwidth = 1;
        panelForm.add(new JLabel("Judul:"), gbc);
        gbc.gridx = 4; gbc.gridwidth = 2;
        textJudul = new JTextField(20);
        panelForm.add(textJudul, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelForm.add(new JLabel("Pengarang:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        textPengarang = new JTextField(20);
        panelForm.add(textPengarang, gbc);

        gbc.gridx = 3; gbc.gridwidth = 1;
        panelForm.add(new JLabel("Tahun Terbit:"), gbc);
        gbc.gridx = 4; gbc.gridwidth = 2;
        textTahunTerbit = new JTextField(20);
        panelForm.add(textTahunTerbit, gbc);

        // Panel Tombol
        JPanel panelButton = new JPanel(new GridLayout(1, 4, 10, 10));
        btnTambah = new JButton("Tambah");
        btnEdit = new JButton("Edit");
        btnHapus = new JButton("Hapus");
        btnRefresh = new JButton("Refresh");

        panelButton.add(btnTambah);
        panelButton.add(btnEdit);
        panelButton.add(btnHapus);
        panelButton.add(btnRefresh);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 6;
        panelForm.add(panelButton, gbc);

        // Tabel untuk Menampilkan Data Buku
        tableModel = new DefaultTableModel(new String[]{"Kode Buku", "Judul", "Pengarang", "Tahun Terbit"}, 0);
        table = new JTable(tableModel);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(table);
        panelUtama.add(scrollPane, BorderLayout.CENTER);
    }

    // Getter untuk Komponen
    public JTextField getTextKodeBuku() { return textKodeBuku; }
    public JTextField getTextJudul() { return textJudul; }
    public JTextField getTextPengarang() { return textPengarang; }
    public JTextField getTextTahunTerbit() { return textTahunTerbit; }
    public JButton getBtnTambah() { return btnTambah; }
    public JButton getBtnEdit() { return btnEdit; }
    public JButton getBtnHapus() { return btnHapus; }
    public JButton getBtnRefresh() { return btnRefresh; }
    public JTable getTable() { return table; }
    public DefaultTableModel getTableModel() { return tableModel; }

    // Event Listener untuk Tombol
    public void addTambahListener(ActionListener listener) { btnTambah.addActionListener(listener); }
    public void addEditListener(ActionListener listener) { btnEdit.addActionListener(listener); }
    public void addHapusListener(ActionListener listener) { btnHapus.addActionListener(listener); }
    public void addRefreshListener(ActionListener listener) { btnRefresh.addActionListener(listener); }
}
