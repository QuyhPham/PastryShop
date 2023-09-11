package App;

import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.CakeConnect;
import Database.CookieConnect;
import Database.DrinkConnect;
import Normal.Cakes;
import Normal.Cookie;
import Normal.Drink;

import javax.swing.JScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CakeCus extends JPanel {
	private JTable table;
	public CakeConnect cake = new CakeConnect();
	public ArrayList<Cakes> cakee = cake.getAll();
	private CakeConnect cakes = new CakeConnect();
	ArrayList<Cakes> list = new ArrayList<Cakes>();
	
	public JButton btnNewButton_Cake = new JButton("Add");
	public JComboBox comboBox;
	public JComboBox comboBox_1;
	/**
	 * Create the panel.
	 */	
	public CakeCus() {
		        setVisible(true);
				setBackground(new Color(255, 202, 202));
				setBounds(0, 0, 711, 652);
				setLayout(null);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(10, 250, 685, 2);
				add(separator);
				
				JLabel lblNewLabel_Cookie = new JLabel("Cake Name:");
				lblNewLabel_Cookie.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_Cookie.setBounds(10, 52, 120, 32);
				add(lblNewLabel_Cookie);
				
				JLabel lblNewLabel_Cookie_1 = new JLabel("Quantity:");
				lblNewLabel_Cookie_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblNewLabel_Cookie_1.setBounds(10, 128, 87, 32);
				add(lblNewLabel_Cookie_1);
				
			    comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(cake.getCakes()));
				
				comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
				comboBox.setBounds(119, 46, 304, 45);
				add(comboBox);
				
			    comboBox_1 = new JComboBox();
				comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
				comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
				comboBox_1.setBounds(119, 122, 304, 45);
				add(comboBox_1);
				
				JLabel lblNewLabel = new JLabel("Refer to the cakes in the following table.");
				lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
				lblNewLabel.setBounds(25, 230, 516, 21);
				add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								CakeCus.class.getResource("/Image/cake.jpg")
								)
						).getImage().getScaledInstance(198, 169, Image.SCALE_DEFAULT)));
				lblNewLabel_1.setBounds(490, 47, 198, 169);
				add(lblNewLabel_1);
				
				list = cakes.getAll();
				table = new JTable();
				table.setBackground(new Color(193, 193, 255));
//				table.setFont(new Font("Tahoma", Font.PLAIN, 25));
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
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
				table.getColumnModel().getColumn(0).setPreferredWidth(23);
				table.getColumnModel().getColumn(1).setPreferredWidth(86);
				table.getColumnModel().getColumn(2).setPreferredWidth(113);
				table.getColumnModel().getColumn(3).setPreferredWidth(135);
				table.getColumnModel().getColumn(4).setPreferredWidth(86);
					
					
					//
					DefaultTableModel modelCa = (DefaultTableModel) table.getModel();

					Object[] rowCa = new Object[4];

					for (int i = 0; i < list.size(); i++) {

					rowCa[0]= (list.get(i).getName());

					if((list.get(i)).getImage()!=null) {

						ImageIcon imageIcon = new ImageIcon(new ImageIcon(list.get(i).getImage()).getImage()
								.getScaledInstance(100, 100, Image.SCALE_SMOOTH));

					rowCa[1]=imageIcon;

					}
					else 
						rowCa[1]= null;

					rowCa[2]=(list.get(i)).getMainIngredients();

					rowCa[3]=(list.get(i)).getPrice();
						
				}
					 table.setRowHeight(100);
				     modelCa.addRow(rowCa);
				     loadInformationCakeCus();
				table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
				table.setBounds(39, 620, 889, 422);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 256, 691, 390);
				add(scrollPane);
				
				// 3.

				btnNewButton_Cake.setForeground(new Color(128, 0, 0));
				btnNewButton_Cake.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton_Cake.setBackground(new Color(213, 255, 255));
				btnNewButton_Cake.setBounds(323, 182, 100, 32);
				add(btnNewButton_Cake);
				
				
				
			}
		
	public void loadInformationCakeCus() {
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
		DefaultTableModel modelCa = (DefaultTableModel) table.getModel();
		 table.setRowHeight(80);
			list = cakes.getAll();
			table.setRowSorter(null);
			for (Cakes ca:list) {
				
				Object[] rowCa = new Object[5];
					rowCa[0] = ca.getID();
					rowCa[1] = ca.getName();
					
					rowCa[3] = ca.getMainIngredients();
					rowCa[4] = ca.getPrice();
					if (ca.getImage() != null) {
						ImageIcon imageIcon = new ImageIcon(new ImageIcon(ca.getImage()).getImage()
								.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
						rowCa[2] = imageIcon;
					} else {
						rowCa[2] = null;

					}
					modelCa.addRow(rowCa);
					
				
			}
		
	}
	
	
		
	}




	


