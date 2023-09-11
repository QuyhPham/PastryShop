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
import Database.DrinkConnect;
import Normal.Cakes;
import Normal.Drink;

import javax.swing.JScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class DrinkCus extends JPanel {
	private JTable table;
	private DrinkConnect drink = new DrinkConnect();
	public JButton btnNewButton_Drink = new JButton("Add");
	public JComboBox comboBox;
	public JComboBox comboBox_1;
	
	ArrayList<Drink> dlist = new ArrayList<Drink>();
	/**
	 * Create the panel.
	 */
	public DrinkCus() {
		
		
		                setVisible(true);
	                    setBackground(new Color(255, 240, 240));
						setBounds(0, 0, 711, 652);
						setLayout(null);
						
						JSeparator separator = new JSeparator();
						separator.setBounds(10, 250, 685, 2);
						add(separator);
						
						JLabel lblNewLabel_Cookie = new JLabel("Drinks Name:");
						lblNewLabel_Cookie.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblNewLabel_Cookie.setBounds(10, 52, 120, 32);
						add(lblNewLabel_Cookie);
						
						JLabel lblNewLabel_Cookie_1 = new JLabel("Quantity:");
						lblNewLabel_Cookie_1.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblNewLabel_Cookie_1.setBounds(10, 128, 87, 32);
						add(lblNewLabel_Cookie_1);
						
						 comboBox = new JComboBox();
						comboBox.setModel(new DefaultComboBoxModel(drink.getDrinks()));
						comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
						comboBox.setBounds(119, 46, 304, 45);
						add(comboBox);
						
						 comboBox_1 = new JComboBox();
						comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
						comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
						comboBox_1.setBounds(119, 122, 304, 45);
						add(comboBox_1);
						
						JLabel lblNewLabel = new JLabel("Refer to the drinks in the following table.");
						lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
						lblNewLabel.setBounds(25, 230, 516, 21);
						add(lblNewLabel);
						
						JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
								Toolkit.getDefaultToolkit().getImage(
										DrinkCus.class.getResource("/Image/drink.jpg")
										)
								).getImage().getScaledInstance(198, 169, Image.SCALE_DEFAULT)));
						lblNewLabel_1.setBounds(490, 47, 198, 169);
						add(lblNewLabel_1);

						dlist = drink.getAll();
						table = new JTable();
						table.setBackground(new Color(193, 193, 255));
//						table.setFont(new Font("Tahoma", Font.PLAIN, 25));
						table.setModel(new DefaultTableModel(
							new Object[][] {},
							new String[] {
								"Name", "Image", "Size", "Main Ingredients", "Price"
							}
								) {
									boolean[] columnEdittables = new boolean[] {
											false, false, false, false, false, false
									};
									public boolean isCellEditable(int row, int column) {
										return columnEdittables[column];
									}
									Class[] columnTypes = new Class[] {
										Object.class, Object.class, ImageIcon.class, Object.class, Object.class, Long.class
									};
									public Class getColumnClass(int columnIndex) {
										return columnTypes[columnIndex];
									}
								} );
						
						DefaultTableModel model = (DefaultTableModel) table.getModel();

						Object[] row = new Object[5];

						for (int i = 0; i < drink.size(); i++) {

						row[0]= ((Drink) drink.get(i)).getName();

						

						if(((Drink) drink.get(i)).getImage()!=null) {

						ImageIcon imageIcon= new ImageIcon(new ImageIcon (((Drink) drink.get(i)).getImage()).getImage() .getScaledInstance(50, 50, Image.SCALE_SMOOTH)); 

						row[1]=imageIcon;

						}
						else 
							row[1]= null;
						
						row[2]=((Drink) drink.get(i)).getSize();

						row[3]=((Drink) drink.get(i)).getMainIngredients();

						row[4]=((Drink) drink.get(i)).getPrice();
							
					} table.setRowHeight(100);
					model.addRow(row);
						
						loadInformationDrink();
						table.getColumnModel().getColumn(0).setPreferredWidth(54);
						table.getColumnModel().getColumn(1).setPreferredWidth(190);
						table.getColumnModel().getColumn(2).setPreferredWidth(38);
						table.getColumnModel().getColumn(3).setPreferredWidth(109);
						table.getColumnModel().getColumn(4).setPreferredWidth(113);
						table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
						
						table.setBounds(39, 620, 889, 422);
						
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setBounds(10, 256, 691, 390);
						add(scrollPane);
						
						
						btnNewButton_Drink.setBackground(new Color(213, 255, 255));
						btnNewButton_Drink.setForeground(new Color(128, 0, 0));
						btnNewButton_Drink.setFont(new Font("Tahoma", Font.BOLD, 18));
						btnNewButton_Drink.setBounds(323, 182, 100, 32);
						add(btnNewButton_Drink);
						
					
				

			}
	
	
	private void loadInformationDrink() {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Name", "Image", "Size", "Main Ingredients", "Price"
				}
			) {
				boolean[] columnEdittables = new boolean[] {
						false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEdittables[column];
				}
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, ImageIcon.class, Object.class, Object.class, Long.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		DefaultTableModel modelDrink = (DefaultTableModel) table.getModel();
	
			table.setRowHeight(80);
			dlist = drink.getAll();//chu y 1: doi dlist = drink.find(), find nay la ham viet ben drinkConnect
			
			for (Drink d:dlist) {
				Object[] rowD = new Object[6];
					rowD[0] = d.getID();
					rowD[1] = d.getName();
					rowD[3] = d.getSize();
					rowD[4] = d.getMainIngredients();
					rowD[5] = d.getPrice();
					if (d.getImage() != null) {
						ImageIcon imageIcon = new ImageIcon(new ImageIcon(d.getImage()).getImage()
								.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
						rowD[2] = imageIcon;
					} else {
						rowD[2] = null;

					}
					modelDrink.addRow(rowD);
				
			}
			
		
		
	}

		}


	


