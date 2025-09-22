import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class SeminarView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JComboBox<String> comboBox;
	private JRadioButton rdbtnNewRadioButton, rdbtnNewRadioButton_1, rdbtnNewRadioButton_2_1;
	private JCheckBox chckbxNewCheckBox, chckbxNewCheckBox_1, chckbxNewCheckBox_2;
	private DefaultTableModel tableModel;
	private JOptionPane JOptionPane;
	private ButtonGroup group;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeminarView frame = new SeminarView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeminarView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nama Lengkap");
		lblNewLabel.setBounds(10, 11, 86, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(105, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Alamat Email");
		lblNewLabel_1.setBounds(10, 42, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 39, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Topik");
		lblNewLabel_2.setBounds(10, 67, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AI & Machine Learning", "Cyber Security", "Cloud Computing", "Software Engineering"}));
		comboBox.setBounds(105, 63, 133, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Peserta");
		lblNewLabel_3.setBounds(10, 103, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		rdbtnNewRadioButton = new JRadioButton("Mahasiswa");
		rdbtnNewRadioButton.setBounds(101, 99, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Umum");
		rdbtnNewRadioButton_1.setBounds(101, 129, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Fasilitas");
		lblNewLabel_4.setBounds(10, 196, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		chckbxNewCheckBox = new JCheckBox("Merchandise");
		chckbxNewCheckBox.setBounds(105, 247, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("E-Sertifikat");
		chckbxNewCheckBox_1.setBounds(105, 196, 97, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Makan Siang");
		chckbxNewCheckBox_2.setBounds(105, 221, 97, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		JButton btnNewButton = new JButton("Daftar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tambahDataKeTabelDanTampilkanDialog();
			}
		});
		btnNewButton.setBounds(49, 292, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(269, 11, 452, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Nama Lengkap", "Alamat Email", "Topik Seminar", "Jenis Peserta", "Fasilitas"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(88);
		scrollPane.setViewportView(table);
		
		rdbtnNewRadioButton_2_1 = new JRadioButton("VIP");
		rdbtnNewRadioButton_2_1.setBounds(101, 155, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2_1);
		group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2_1);
	}
	
	private void tambahDataKeTabelDanTampilkanDialog() {
	    // Mengambil nilai dari input form
	    String nama = textField.getText();
	    String email = textField_1.getText();
	    String topik = (String) comboBox.getSelectedItem();

	    // Validasi input tidak boleh kosong
	    if (nama.isEmpty() || email.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Nama dan Email harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    // Mendapatkan jenis peserta yang dipilih
	    String jenisPeserta = "";
	    if (rdbtnNewRadioButton.isSelected()) jenisPeserta = "Mahasiswa";
	    else if (rdbtnNewRadioButton_1.isSelected()) jenisPeserta = "Umum";
	    else if (rdbtnNewRadioButton_2_1.isSelected()) jenisPeserta = "VIP";
	    else {
	        JOptionPane.showMessageDialog(this, "Silakan pilih jenis peserta!", "Peringatan", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    // Mengambil fasilitas tambahan
	    StringBuilder fasilitas = new StringBuilder();
	    if (chckbxNewCheckBox_1.isSelected()) fasilitas.append("E-Sertifikat ");
	    if (chckbxNewCheckBox_2.isSelected()) fasilitas.append("Makan Siang ");
	    if (chckbxNewCheckBox.isSelected()) fasilitas.append("Merchandise");

	    // Menambahkan data ke tabel
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.addRow(new Object[]{nama, email, topik, jenisPeserta, fasilitas.toString()});

	    // Menampilkan dialog ringkasan
	    JOptionPane.showMessageDialog(this, 
	        "Pendaftaran Berhasil!\n\n" +
	        "Nama: " + nama + "\n" +
	        "Email: " + email + "\n" +
	        "Topik: " + topik + "\n" +
	        "Jenis Peserta: " + jenisPeserta + "\n" +
	        "Fasilitas: " + fasilitas,
	        "Ringkasan Pendaftaran", JOptionPane.INFORMATION_MESSAGE
	    );

	    // Mengosongkan input setelah daftar
	    textField.setText("");
	    textField_1.setText("");
	    rdbtnNewRadioButton.setSelected(false);
	    rdbtnNewRadioButton_1.setSelected(false);
	    rdbtnNewRadioButton_2_1.setSelected(false);
	    chckbxNewCheckBox.setSelected(false);
	    chckbxNewCheckBox_1.setSelected(false);
	    chckbxNewCheckBox_2.setSelected(false);

	    // Set fokus ke input nama agar siap untuk pendaftaran berikutnya
	    textField.requestFocus();
	}
}
