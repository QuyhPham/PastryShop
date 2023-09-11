package App;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Database.BillConnect;
import Database.EmployeeConnect;
import Normal.Bill;
import Normal.Employee;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class BillMana extends JPanel {
	private JTable table;
	ArrayList<Bill> bilist = new ArrayList<Bill>();
	private BillConnect bi = new BillConnect();
	public JButton btnNewButton_Exit = new JButton("Exit");

	/**
	 * Create the panel.
	 */
	public BillMana() {
		setBackground(new Color(193, 255, 193));
		setLayout(null);
		setBounds(0, 0, 1156, 652);
		
		JLabel lblNewLabel_2 = new JLabel("The list of Bill");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2.setBounds(82, 11, 276, 43);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						BillMana.class.getResource("/Image/bil.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(339, 11, 54, 38);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						BillMana.class.getResource("/Image/bil1.jpg")
						)
				).getImage().getScaledInstance(612, 147, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(143, 505, 612, 147);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						BillMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(783, 11, 41, 36);
		add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(50, 49, 454, 2);
		add(separator);
		
		table = new JTable();
		table.setBackground(new Color(255, 198, 198));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"IDB", "IDC", "Date order", "Date Pay", "Price", "Goods Purchased"
			}
				) {
					boolean[] columnEdittables = new boolean[] {
							false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEdittables[column];
					}
					Class[] columnTypes = new Class[] {
						Object.class, Object.class, Object.class, Object.class, Long.class, Object.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				} );
		
		
		
		
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setBounds(375, 91, 889, 422);
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		Object[] row = new Object[6];

		for (int i = 0; i < bi.size(); i++) {
			row[0]=((Bill) bi.get(i)).getIDB();
			row[1]=((Bill) bi.get(i)).getIDC();

		
		row[2]= ((Bill) bi.get(i)).getDateOrder();
		
		row[3]=((Bill) bi.get(i)).getDatePay();

		row[4]=((Bill) bi.get(i)).getPrice();

		
		row[5]=((Bill) bi.get(i)).getGood();
		
		
			
	} table.setRowHeight(30);
	model.addRow(row);
		
		loadInformationBill();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBounds(10, 60, 1136, 438);
		add(scrollPane);
		
		JTextField textField_Find = new JTextField();
		textField_Find.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			String  searchString = textField_Find.getText();
			reseach(searchString);
			
		}
	});
		textField_Find.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Find.setColumns(10);
		textField_Find.setBounds(833, 11, 295, 36);
		add(textField_Find);
		
		
		
		btnNewButton_Exit.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit.setBounds(977, 583, 104, 43);
		add(btnNewButton_Exit);
		
		JButton btnNewButton_Reset = new JButton("Reset");
		btnNewButton_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadInformationBill();
			}
		});
		btnNewButton_Reset.setForeground(new Color(128, 0, 0));
		btnNewButton_Reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Reset.setBackground(new Color(255, 128, 128));
		btnNewButton_Reset.setBounds(872, 583, 95, 43);
		add(btnNewButton_Reset);
		
//		JButton btnNewButton_Reset = new JButton("Reset");
//		btnNewButton_Reset.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				textField_Find.setText("");
//				loadInformationBill();
//			}
//		});
//		btnNewButton_Reset.setForeground(new Color(128, 0, 0));
//		btnNewButton_Reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnNewButton_Reset.setBackground(new Color(255, 128, 128));
//		btnNewButton_Reset.setBounds(863, 583, 104, 43);
//		add(btnNewButton_Reset);
		
		

	}
	
	
	private void loadInformationBill() {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDB", "IDC", "Date order", "Date Pay",  "Price", "Goods Purchased"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Long.class, Object.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	
			table.setRowHeight(30);
			bilist = bi.getAll();
			
			for (Bill b:bilist) {
				Object[] row = new Object[6];
					row[0] = b.getIDB();
					row[1] = b.getIDC();
					
					
					row[2]=b.getDateOrder();

					row[3]=b.getDatePay();

					row[4]=b.getPrice();
					
					row[5]=b.getGood();
					
					

					
					model.addRow(row);
				
			}
			
		
	}
	
	public void reseach ( String str) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	
	

}
