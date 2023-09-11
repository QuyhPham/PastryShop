package App;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Database.BillConnect;
import Database.ClientConnect;
import Normal.Bill;
import Normal.Users;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ClientMana extends JPanel {
	private JTable table;
	ArrayList<Users> ulist = new ArrayList<Users>();
	private ClientConnect u = new ClientConnect();
	public JButton btnNewButton_Exit = new JButton("Exit");

	/**
	 * Create the panel.
	 */
	public ClientMana() {
		setBackground(new Color(255, 255, 221));
		setLayout(null);
		setBounds(0, 0, 1156, 652);
		
		JLabel lblNewLabel_2 = new JLabel("The list of Customer");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2.setBounds(27, 11, 373, 43);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						ClientMana.class.getResource("/Image/client.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(399, 11, 54, 38);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						ClientMana.class.getResource("/Image/clien1.jpg")
						)
				).getImage().getScaledInstance(712, 132, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(43, 509, 712, 132);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						ClientMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(824, 11, 41, 36);
		add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 49, 494, 2);
		add(separator);
		
		table = new JTable();
		table.setBackground(new Color(255, 198, 198));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Name", "Sex", "Email", "CCCD", "Phone", "User Name"
			}
				) {
					boolean[] columnEdittables = new boolean[] {
							false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEdittables[column];
					}
					Class[] columnTypes = new Class[] {
						Object.class, Object.class, Object.class, Object.class, Long.class, Long.class, Object.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				} );
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(47);
		table.getColumnModel().getColumn(3).setPreferredWidth(93);
		table.getColumnModel().getColumn(4).setPreferredWidth(117);
		
		
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setBounds(375, 91, 889, 422);
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		Object[] row = new Object[7];

		for (int i = 0; i < u.size(); i++) {
			row[0]=((Users) u.get(i)).getID();
			row[1]=((Users) u.get(i)).getName();

		row[2]= ((Users) u.get(i)).getSex();
		row[3]= ((Users) u.get(i)).getEmail();
		
		row[4]=((Users) u.get(i)).getCccd();

		row[5]=((Users) u.get(i)).getPhone();

		row[6]=((Users) u.get(i)).getUsername();
		
		
		
			
	} table.setRowHeight(30);
	model.addRow(row);
		
		loadInformationClient();
		
		
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
		textField_Find.setBounds(875, 11, 255, 36);
		add(textField_Find);
		
		
		
		btnNewButton_Exit.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit.setBounds(988, 581, 104, 43);
		add(btnNewButton_Exit);
		
		JButton btnNewButton_Reset = new JButton("Reset");
		btnNewButton_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadInformationClient();
			}
		});
		btnNewButton_Reset.setForeground(new Color(128, 0, 0));
		btnNewButton_Reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Reset.setBackground(new Color(255, 128, 128));
		btnNewButton_Reset.setBounds(883, 581, 95, 43);
		add(btnNewButton_Reset);
		
		
		
		

	}
	
	
	
	private void loadInformationClient() {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"ID", "Name", "Sex", "Email", "CCCD", "Phone", "User Name"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Long.class, Long.class, Object.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	
			table.setRowHeight(30);
			ulist = u.getAll();
			
			for (Users us:ulist) {
				Object[] row = new Object[7];
					row[0] = us.getID();
					row[1] = us.getName();
					row[2] =us.getSex();
					
					row[3]=us.getEmail();

					row[4]=us.getCccd();

					row[5]=us.getPhone();
					row[6]=us.getUsername();
					
					
					

					
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
