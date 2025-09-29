package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class LaguView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JComboBox comboBox;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JCheckBox chckbxNewCheckBox;
	private ButtonGroup group;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaguView frame = new LaguView();
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
	public LaguView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Judul:");
		lblNewLabel.setBounds(35, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Penyanyi:");
		lblNewLabel_1.setBounds(35, 36, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Durasi:");
		lblNewLabel_2.setBounds(35, 61, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(106, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 33, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 58, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Genre:");
		lblNewLabel_3.setBounds(35, 86, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Pop", "Rock", "Jazz", "EDM"}));
		comboBox.setBounds(106, 82, 86, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Bahasa");
		lblNewLabel_4.setBounds(35, 111, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		rdbtnNewRadioButton = new JRadioButton("Indonesia");
		rdbtnNewRadioButton.setBounds(106, 107, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("English");
		rdbtnNewRadioButton_1.setBounds(106, 133, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Other");
		rdbtnNewRadioButton_2.setBounds(106, 159, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		
		chckbxNewCheckBox = new JCheckBox("Favorit");
		chckbxNewCheckBox.setBounds(35, 185, 97, 23);
		contentPane.add(chckbxNewCheckBox);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 11, 378, 197);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Judul", "Penyanyi", "Durasi", "Genre", "Bahasa"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(128);
		table.getColumnModel().getColumn(1).setPreferredWidth(133);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(91);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Tambah");
		btnNewButton.setBounds(58, 219, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(473, 219, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Hapus");
		btnNewButton_2.setBounds(358, 219, 89, 23);
		contentPane.add(btnNewButton_2);
	}
	
    public JTextField getJudulField() {
        return textField;
    }

    public JTextField getPenyanyiField() {
        return textField_1;
    }

    public JTextField getDurasiField() {
        return textField_2;
    }

    public JTable getTable() {
        return table;
    }

    public JComboBox getGenreComboBox() {
        return comboBox;
    }

    public JRadioButton getRbIndonesia() {
        return rdbtnNewRadioButton;
    }

    public JRadioButton getRbEnglish() {
        return rdbtnNewRadioButton_1;
    }

    public JRadioButton getRbOther() {
        return rdbtnNewRadioButton_2;
    }

    public JCheckBox getFavoritCheckBox() {
        return chckbxNewCheckBox;
    }

    public ButtonGroup getGroupRadio() {
        return group;
    }

    public JButton getBtnTambah() {
        return btnNewButton;
    }

    public JButton getBtnClear() {
        return btnNewButton_1;
    }

    public JButton getBtnHapus() {
        return btnNewButton_2;
    }

	
}
