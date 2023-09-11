package App;

import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.CakeConnect;
import Database.CookieConnect;
import Normal.Cookie;
import Normal.Drink;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class CookieCus extends JPanel {
	private JTable table;
	private CookieConnect cookie = new CookieConnect();
	public JButton btnNewButton_Cookie;
	public JComboBox comboBox_1;
	public JComboBox comboBox;
	ArrayList<Cookie> colist = new ArrayList<Cookie>();

	/**
	 * Create the panel.
	 */
	public CookieCus() {
		setVisible(true);
		setBackground(new Color(255, 225, 225));
		setBounds(0, 0, 711, 652);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 250, 685, 2);
		add(separator);
		
		JLabel lblNewLabel_Cookie = new JLabel("Cookie Name:");
		lblNewLabel_Cookie.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Cookie.setBounds(10, 52, 120, 32);
		add(lblNewLabel_Cookie);
		
		JLabel lblNewLabel_Cookie_1 = new JLabel("Quantity:");
		lblNewLabel_Cookie_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_Cookie_1.setBounds(10, 128, 87, 32);
		add(lblNewLabel_Cookie_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(cookie.getCookies()));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(119, 46, 304, 45);
		add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		
		comboBox_1.setBounds(119, 122, 304, 45);
		add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Refer to the cookies in the following table.");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(25, 230, 516, 21);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						CookieCus.class.getResource("/Image/cookie.jpg")
						)
				).getImage().getScaledInstance(198, 169, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(490, 47, 198, 169);
		add(lblNewLabel_1);
		colist = cookie.getAll();
		table = new JTable();
		table.setBackground(new Color(193, 193, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Name", "Image", "Main Ingredients", "Price"
			}
				) {
					boolean[] columnEdittables = new boolean[] {
							false, false, false, false, false
						};
					public boolean isCellEditable(int row, int column) {
						return columnEdittables[column];
					}
					Class[] columnTypes = new Class[] {
						Object.class, Object.class, ImageIcon.class, Object.class, Long.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				} );
					 // 
				
				
				
				DefaultTableModel modelCoo = (DefaultTableModel) table.getModel();

				Object[] rowCoo = new Object[4];

				for (int i = 0; i < cookie.size(); i++) {

				rowCoo[0]= ((Cookie) cookie.get(i)).getName();

				

				if(((Cookie) cookie.get(i)).getImage()!=null) {

				ImageIcon imageIcon= new ImageIcon(new ImageIcon (((Cookie) cookie.get(i)).getImage()).getImage() .getScaledInstance(50, 50, Image.SCALE_SMOOTH)); 

				rowCoo[1]=imageIcon;

				}
				else 
					rowCoo[1]= null;

				rowCoo[2]=((Cookie) cookie.get(i)).getMainIngredients();

				rowCoo[3]=((Cookie) cookie.get(i)).getPrice();
					
			} table.setRowHeight(100);
			modelCoo.addRow(rowCoo);
			loadInformationCookie();
		table.getColumnModel().getColumn(0).setPreferredWidth(47);
		table.getColumnModel().getColumn(1).setPreferredWidth(124);
		table.getColumnModel().getColumn(2).setPreferredWidth(99);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setBounds(39, 620, 889, 422);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 256, 691, 390);
		add(scrollPane);
		
		btnNewButton_Cookie = new JButton("Add");
		btnNewButton_Cookie.setForeground(new Color(128, 0, 0));
		btnNewButton_Cookie.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_Cookie.setBackground(new Color(213, 255, 255));
		btnNewButton_Cookie.setBounds(323, 182, 100, 32);
		add(btnNewButton_Cookie);

	}
	
	private void loadInformationCookie() {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Name", "Image", "Main Ingredients", "Price"
				}
			) {
			boolean[] columnEdittables = new boolean[] {
					false, false, false, false, false
				};
			public boolean isCellEditable(int row, int column) {
				return columnEdittables[column];
			}
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, ImageIcon.class, Object.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		} );
		DefaultTableModel modelCookie = (DefaultTableModel) table.getModel();
		
		table.setRowHeight(80);
		colist = cookie.getAll();
		
		for (Cookie co:colist) {
			Object[] rowCo = new Object[5];
				rowCo[0] = co.getID();
				rowCo[1] = co.getName();
				
				rowCo[3] = co.getMainIngredients();
				rowCo[4] = co.getPrice();
				if (co.getImage() != null) {
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(co.getImage()).getImage()
							.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
					rowCo[2] = imageIcon;
				} else {
					rowCo[2] = null;

				}
				modelCookie.addRow(rowCo);
			
		}
	}

}
