package App;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Database.BillConnect;
import Database.RevDConnect;
import Normal.Bill;
import Normal.Drink;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class StatisticMana extends JPanel {
	private JTable table_GetNow;
	private JTabbedPane tabbedPane;
	private JPanel panelGetNow;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	
	private JTextField textField_FindCake;
	private JTextField textField_FindGN;

//	private JButton btnNewButton_Exit_1;
//	private JButton btnNewButton_Exit_2;
//	private JButton btnNewButton_ExitCake_3;
	
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	private JTextField txtTotalCake = new JTextField();
	private JTextField txtTotalGetNow = new JTextField();
	private JLabel lblNewLabel_4;
	private JPanel panelPre;
	private JTable table_Pre;
	ArrayList<Bill> bilist = new ArrayList<Bill>();
	
	private RevDConnect po = new RevDConnect();
	public JButton btnNewButton_Exit_1 = new JButton("Exit");
	public JButton btnNewButton_ExitCake_31 = new JButton("Exit");
	private JButton btnNewButton_Reset_1;
	/**
	 * Create the panel.
	 */
	public StatisticMana() {
		setBackground(new Color(255, 244, 244));
		setLayout(null);
		setBounds(0, 0, 1156, 652);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 200, 200));
		tabbedPane.setForeground(new Color(128, 0, 0));
		tabbedPane.setFont(new Font("Sylfaen", Font.BOLD, 25));
		tabbedPane.setBounds(0, 0, 1156, 652);
		add(tabbedPane);
		
		//Drink
		panelGetNow = new JPanel();
		panelGetNow.setBackground(new Color(223, 223, 223));
		tabbedPane.addTab("Revenue Get-Now", null, panelGetNow, null);
		panelGetNow.setLayout(null);
		
		lblNewLabel = new JLabel("Revenue Statistics Get-Now");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(10, 11, 503, 43);
		panelGetNow.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/thongke1.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(523, 11, 54, 38);
		panelGetNow.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(791, 11, 41, 36);
		panelGetNow.add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						StatisticMana.class.getResource("/Image/thongke2.jpg")
						)
				).getImage().getScaledInstance(621, 129, Image.SCALE_DEFAULT)));
		lblNewLabel_4.setBounds(10, 464, 621, 129);
		panelGetNow.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel("Total Revenue:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(641, 476, 174, 38);
		panelGetNow.add(lblNewLabel_3);
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 52, 692, 2);
		panelGetNow.add(separator);
		
		
		table_GetNow = new JTable();
		
		table_GetNow.setBackground(new Color(223, 255, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_GetNow.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
					"IDB", "Goods Purchased", "Date", "Money"
			}
				) {
					boolean[] columnEdittables = new boolean[] {
							false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEdittables[column];
					}
					Class[] columnTypes = new Class[] {
						Object.class, Object.class, Object.class, Long.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				} );
		
		
		table_GetNow.getColumnModel().getColumn(0).setPreferredWidth(42);
		table_GetNow.getColumnModel().getColumn(1).setPreferredWidth(111);
		table_GetNow.getColumnModel().getColumn(3).setPreferredWidth(87);
		
		
		table_GetNow.setBounds(375, 91, 889, 422);
		//DefaultTableModel model = (DefaultTableModel) table_GetNow.getModel();

//		table_GetNow.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				ArrayList<Bill> list = po.getRevenueGN();
//				loadInformationGetnow();
//				long price = 0;
//				for (Bill b:list) {
//					price += b.getPrice();
//				}
//				txtTotalGetNow.setText(Long.toString(price));
//				//Revenue: lay nguyen khuc 4. vut cai a di, doi table bang cai table cua revenue, (i,?)
//				
//				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//				
//				
//			}
//		});
		
		
		
		
//		Object[] row = new Object[4];
//
//		for (int i = 0; i < po.size(); i++) {
//			row[0]=((Bill) po.get(i)).getIDB();
//			row[1]=((Bill) po.get(i)).getGood();
//
//		row[2]= ((Bill) po.get(i)).getDateOrder();
//		row[3]= ((Bill) po.get(i)).getPrice();
//		
//		
//		
//			
//	} table_GetNow.setRowHeight(30);
//	model.addRow(row);
		
		loadInformationGetnow();
		JScrollPane scrollPane_GetNow = new JScrollPane(table_GetNow);
		scrollPane_GetNow.setBounds(10, 58, 1131, 395);
		scrollPane_GetNow.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelGetNow.add(scrollPane_GetNow);
		
		
		txtTotalGetNow.setEditable(false);
		txtTotalGetNow.setBounds(806, 476, 312, 38);
		panelGetNow.add(txtTotalGetNow);
		txtTotalGetNow.setColumns(10);
		
		textField_FindGN = new JTextField();
		textField_FindGN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String  searchString = textField_FindGN.getText();
				reseachGN(searchString);
				
			}
		});
		textField_FindGN.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_FindGN.setColumns(10);
		textField_FindGN.setBounds(836, 11, 282, 36);
		panelGetNow.add(textField_FindGN);
	
		
		
		btnNewButton_Exit_1.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit_1.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit_1.setBounds(1023, 550, 95, 43);
		panelGetNow.add(btnNewButton_Exit_1);
		
		JButton btnNewButton_Reset = new JButton("Reset");
		btnNewButton_Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadInformationGetnow();
			}
		});
		btnNewButton_Reset.setForeground(new Color(128, 0, 0));
		btnNewButton_Reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Reset.setBackground(new Color(255, 128, 128));
		btnNewButton_Reset.setBounds(918, 550, 95, 43);
		panelGetNow.add(btnNewButton_Reset);
		
		
		
		
		//Dat hang truoc
				panelPre = new JPanel();
				panelPre.setBackground(new Color(223, 223, 223));
				tabbedPane.addTab("Revenue Pre-Order", null, panelPre, null);
				panelPre.setLayout(null);
				
				lblNewLabel = new JLabel("Revenue Statistics Pre-Ord");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
				lblNewLabel.setBounds(34, 11, 491, 43);
				panelPre.add(lblNewLabel);
				
				lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								StatisticMana.class.getResource("/Image/thongke1.jpg")
								)
						).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
				lblNewLabel_2.setBounds(535, 11, 54, 38);
				panelPre.add(lblNewLabel_2);
				
				lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								StatisticMana.class.getResource("/Image/kinhlup.png")
								)
						).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
				lblNewLabel_1.setBounds(791, 11, 41, 36);
				panelPre.add(lblNewLabel_1);
				
				lblNewLabel_4 = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								StatisticMana.class.getResource("/Image/thongke2.jpg")
								)
						).getImage().getScaledInstance(621, 129, Image.SCALE_DEFAULT)));
				lblNewLabel_4.setBounds(10, 464, 621, 129);
				panelPre.add(lblNewLabel_4);
				
				lblNewLabel_3 = new JLabel("Total Revenue:");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel_3.setBounds(641, 476, 174, 38);
				panelPre.add(lblNewLabel_3);
				
				
				
				separator = new JSeparator();
				separator.setBackground(Color.BLACK);
				separator.setBounds(10, 52, 678, 2);
				panelPre.add(separator);
				
				
				table_Pre = new JTable();
				table_Pre.setBackground(new Color(255, 221, 221));
//				table.setFont(new Font("Tahoma", Font.PLAIN, 25));
				table_Pre.setModel(new DefaultTableModel(
					new Object[][] {},
					new String[] {
							"IDB", "Goods Purchased", "Date", "Money"
					}
						) {
							boolean[] columnEdittables = new boolean[] {
									false, false, false, false
							};
							public boolean isCellEditable(int row, int column) {
								return columnEdittables[column];
							}
							Class[] columnTypes = new Class[] {
								Object.class, Object.class, Object.class, Long.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						} );
				
				
				table_Pre.setBounds(375, 91, 889, 422);
				DefaultTableModel modelp = (DefaultTableModel) table_Pre.getModel();

				Object[] rowp = new Object[4];

				for (int i = 0; i < po.size(); i++) {
					rowp[0]=((Bill) po.get(i)).getIDB();
					rowp[1]=((Bill) po.get(i)).getGood();

				rowp[2]= ((Bill) po.get(i)).getDateOrder();
				rowp[3]= ((Bill) po.get(i)).getPrice();
				
				
				
					
			} table_Pre.setRowHeight(30);
			modelp.addRow(rowp);
			loadInformationPreOrder();
				
				
				JScrollPane scrollPane_Pre = new JScrollPane(table_Pre);
				scrollPane_Pre.setBounds(10, 58, 1131, 392);
				scrollPane_Pre.setFont(new Font("Tahoma", Font.BOLD, 15));
				panelPre.add(scrollPane_Pre);
				
				txtTotalCake = new JTextField();
				txtTotalCake.setEditable(false);
				txtTotalCake.setBounds(806, 476, 312, 38);
				panelPre.add(txtTotalCake);
				txtTotalCake.setColumns(10);
				
				textField_FindCake = new JTextField();
				textField_FindCake.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						String  searchString = textField_FindCake.getText();
						reseachPO(searchString);
						
					}
				});
				textField_FindCake.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textField_FindCake.setColumns(10);
				textField_FindCake.setBounds(836, 11, 282, 36);
				panelPre.add(textField_FindCake);
			
				
//				btnNewButton_ExitCake_3 = new JButton("Exit");
//				btnNewButton_ExitCake_3.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//					}
//				});
				btnNewButton_ExitCake_31.setForeground(new Color(128, 0, 0));
				btnNewButton_ExitCake_31.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnNewButton_ExitCake_31.setBackground(new Color(255, 128, 128));
				btnNewButton_ExitCake_31.setBounds(1023, 550, 84, 43);
				panelPre.add(btnNewButton_ExitCake_31);
				
				btnNewButton_Reset_1 = new JButton("Reset");
				btnNewButton_Reset_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadInformationPreOrder();
					}
				});
				btnNewButton_Reset_1.setForeground(new Color(128, 0, 0));
				btnNewButton_Reset_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnNewButton_Reset_1.setBackground(new Color(255, 128, 128));
				btnNewButton_Reset_1.setBounds(918, 550, 95, 43);
				panelPre.add(btnNewButton_Reset_1);
				//loadInformationPreOrder();
	}
	
	
	
	private void loadInformationGetnow() {
		table_GetNow.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"IDB", "Goods Purchased", "Date", "Money"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model = (DefaultTableModel) table_GetNow.getModel();
	
			table_GetNow.setRowHeight(30);
			bilist = po.getRevenueGN();
			long price = 0;
			for (Bill b:bilist) {
				Object[] row = new Object[4];
					row[0] = b.getIDB();
					
					row[2]=b.getDateOrder();
					row[3]=b.getPrice();
					row[1]=b.getGood();
					
					

					
					model.addRow(row);
					price += b.getPrice();
				
			}
			
			
			txtTotalGetNow.setText(Long.toString(price));
			
		
	}
	
	
	private void loadInformationPreOrder() {
		table_Pre.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
						"IDB", "Goods Purchased", "Date", "Money"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model = (DefaultTableModel) table_Pre.getModel();
	
			table_Pre.setRowHeight(30);
			bilist = po.getRevenuePO();
			long price = 0;
			for (Bill b:bilist) {
				Object[] row = new Object[4];
					row[0] = b.getIDB();
					
					row[2]=b.getDateOrder();
					row[3]=b.getPrice();
					row[1]=b.getGood();
					
					

					
					model.addRow(row);
					price += b.getPrice();
			}
			
			txtTotalCake.setText(Long.toString(price));
		
	}
	
	public String tostring(Long l ) {
		return l.toString();
	}
	
	
	public void reseachGN ( String str) {
		DefaultTableModel model = (DefaultTableModel) table_GetNow.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_GetNow.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	
	public void reseachPO ( String str) {
		DefaultTableModel model = (DefaultTableModel) table_Pre.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_Pre.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
}
