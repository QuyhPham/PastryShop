package App;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Database.ColorConnect;
import Database.FruitConnect;
import Database.PartConnect;
import Database.ShapeConnect;
import Database.TasteConnect;
import Database.TierConnect;
import Normal.Colour;
import Normal.Fruit;
import Normal.Part;
import Normal.Shape;
import Normal.Taste;
import Normal.Tier;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.RowFilter;

public class CakePrice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTextField textField;
	ArrayList<Shape> slist = new ArrayList<Shape>();
	private ShapeConnect sp = new ShapeConnect();
	
	ArrayList<Colour> clist = new ArrayList<Colour>();
	private ColorConnect co = new ColorConnect();
	
	ArrayList<Tier> tilist = new ArrayList<Tier>();
	private TierConnect ti = new TierConnect();
	
	ArrayList<Fruit> flist = new ArrayList<Fruit>();
	private FruitConnect fu = new FruitConnect();
	
	ArrayList<Part> plist = new ArrayList<Part>();
	private PartConnect pa = new PartConnect();
	
	ArrayList<Taste> talist = new ArrayList<Taste>();
	private TasteConnect ta = new TasteConnect();
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CakePrice frame = new CakePrice();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CakePrice() {
		
		setForeground(new Color(128, 0, 0));
		this.setTitle("List Price");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(CakePrice.class.getResource("/Image/money1.jpg"))));
		
		setBounds(100, 100, 1400, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 206, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//bang hinh dang
		slist = sp.getAll();
		table = new JTable();
		table.setBackground(new Color(217, 217, 217));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDS", "Shape", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
			table.getColumnModel().getColumn(0).setPreferredWidth(37);
			
			
			table.setBounds(375, 91, 889, 422);
			DefaultTableModel model_S = (DefaultTableModel) table.getModel();

			Object[] rowS = new Object[3];

			for (int i = 0; i < sp.size(); i++) {
				rowS[0]=((Shape) sp.get(i)).getIDs();

			rowS[1]= ((Shape) sp.get(i)).getShape();
			rowS[2]= ((Shape) sp.get(i)).getPrice();
			
			
				
		} table.setRowHeight(30);
		model_S.addRow(rowS);
		loadInformationShape();
		
		//table.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 5, 329, 325);
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane);
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 336, 1008, 3);
		contentPane.add(separator);
		
		//bang mau
		clist = co.getAll();
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 196, 196));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_1.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDC", "Main Color", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
			table_1.getColumnModel().getColumn(0).setPreferredWidth(44);
			DefaultTableModel model_C = (DefaultTableModel) table_1.getModel();

			Object[] rowC = new Object[3];

			for (int i = 0; i < co.size(); i++) {
				rowC[0]=((Colour) co.get(i)).getIDc();

			rowC[1]= ((Colour) co.get(i)).getColor();
			rowC[2]= ((Colour) co.get(i)).getPrice();
			
			
				
		} table_1.setRowHeight(30);
		model_C.addRow(rowC);
		loadInformationColor();
		
		
		table_1.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(343, 5, 337, 325);
		scrollPane_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane_1);
		
        //bang tang
		table_2 = new JTable();
		tilist = ti.getAll();
		table_2.setBackground(new Color(200, 255, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_2.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDTI", "Tier", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
			table_2.getColumnModel().getColumn(0).setPreferredWidth(49);
			DefaultTableModel model_Ti = (DefaultTableModel) table_2.getModel();

			Object[] rowTi = new Object[3];

			for (int i = 0; i < ti.size(); i++) {
				rowTi[0]=((Tier) ti.get(i)).getIDti();

			rowTi[1]= ((Tier) ti.get(i)).getTier();
			rowTi[2]= ((Tier) ti.get(i)).getPrice();
			
			
				
		} table_2.setRowHeight(30);
		model_Ti.addRow(rowTi);
		loadInformationTier();
		
		table_2.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		scrollPane_2.setBounds(685, 5, 322, 325);
		scrollPane_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane_2);
		
		//bang hoa qua
		flist = fu.getAll();
		table_3 = new JTable();
		table_3.setBackground(new Color(198, 255, 198));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_3.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDF", "Fruit", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
			table_3.getColumnModel().getColumn(0).setPreferredWidth(41);
			DefaultTableModel model_F = (DefaultTableModel) table_3.getModel();

			Object[] rowF = new Object[3];

			for (int i = 0; i < fu.size(); i++) {
				rowF[0]=((Fruit) fu.get(i)).getIDf();

			rowF[1]= ((Fruit) fu.get(i)).getFruit();
			rowF[2]= ((Fruit) fu.get(i)).getPrice();
			
			
				
		} table_3.setRowHeight(30);
		model_F.addRow(rowF);
		loadInformationFruit();
		
		table_3.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_3 = new JScrollPane(table_3);
		scrollPane_3.setBounds(10, 344, 329, 318);
		scrollPane_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane_3);
		
		//bang phu kien
		plist = pa.getAll();
		table_4 = new JTable();
		table_4.setBackground(new Color(255, 255, 187));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_4.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDP", "Part", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
			table_4.getColumnModel().getColumn(0).setPreferredWidth(35);
			DefaultTableModel model_P = (DefaultTableModel) table_4.getModel();

			Object[] rowP = new Object[3];

			for (int i = 0; i < pa.size(); i++) {
				rowP[0]=((Part) pa.get(i)).getIDp();

			rowP[1]= ((Part) pa.get(i)).getPart();
			rowP[2]= ((Part) pa.get(i)).getPrice();
			
			
				
		} table_4.setRowHeight(30);
		model_P.addRow(rowP);
		loadInformationPart();
		
		table_4.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_4 = new JScrollPane(table_4);
		scrollPane_4.setBounds(343, 344, 337, 318);
		scrollPane_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane_4);
		
		//bang_phu huong vi
		talist = ta.getAll();
		table_5 = new JTable();
		table_5.setBackground(new Color(206, 206, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_5.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDTA", "Taste", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
			table_5.getColumnModel().getColumn(0).setPreferredWidth(50);
			DefaultTableModel model_Ta = (DefaultTableModel) table_5.getModel();

			Object[] rowTa = new Object[3];

			for (int i = 0; i < ta.size(); i++) {
				rowTa[0]=((Taste) ta.get(i)).getIDta();

			rowTa[1]= ((Taste) ta.get(i)).getTaste();
			rowTa[2]= ((Taste) ta.get(i)).getPrice();
			
			
				
		} table_5.setRowHeight(30);
		model_Ta.addRow(rowTa);
		loadInformationTaste();
		
		table_5.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_5 = new JScrollPane(table_5);
		scrollPane_5.setBounds(685, 344, 322, 318);
		scrollPane_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(scrollPane_5);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String  searchString = textField.getText();
				reseach(searchString);
				reseach1(searchString);
				reseach2(searchString);
				reseach3(searchString);
				reseach4(searchString);
				reseach5(searchString);
				
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBounds(1060, 12, 214, 36);
		contentPane.add(textField);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						CakePrice.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(1015, 12, 41, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						CakePrice.class.getResource("/Image/giphy.gif")
						)
				).getImage().getScaledInstance(256, 569, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setText("");
		lblNewLabel_1.setBounds(1018, 78, 256, 569);
		contentPane.add(lblNewLabel_1);
		
		
		
		
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setBackground(new Color(255, 200, 200));
//		tabbedPane.setForeground(new Color(128, 0, 0));
//		tabbedPane.setFont(new Font("Sylfaen", Font.BOLD, 25));
//		tabbedPane.setBounds(10, 0, 1389, 652);
//		contentPane.add(tabbedPane);
	}
	
	
	private void loadInformationShape() {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDS", "Shape", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model_S = (DefaultTableModel) table.getModel();
	
			table.setRowHeight(30);
			slist = sp.getAll();
			
			for (Shape s:slist) {
				Object[] rowS = new Object[3];
					rowS[0] = s.getIDs();
					rowS[1] = s.getShape();
					rowS[2] =s.getPrice();
					//375, 91, 889, 422
					
					

					
					model_S.addRow(rowS);
				
			}
			
		
	}
	
	private void loadInformationColor() {
		table_1.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDC", "Main Color", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model_C = (DefaultTableModel) table_1.getModel();
	
			table_1.setRowHeight(30);
			clist = co.getAll();
			
			for (Colour c:clist) {
				Object[] rowC = new Object[3];
					rowC[0] = c.getIDc();
					rowC[1] = c.getColor();
					rowC[2] =c.getPrice();
					
					
					

					
					model_C.addRow(rowC);
				
			}
			
			
			
		
	}
	
	private void loadInformationTier() {
		table_2.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDTI", "Tier", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model_Ti = (DefaultTableModel) table_2.getModel();
	
			table_2.setRowHeight(30);
			tilist = ti.getAll();
			
			for (Tier tii:tilist) {
				Object[] rowTi = new Object[3];
					rowTi[0] = tii.getIDti();
					rowTi[1] = tii.getTier();
					rowTi[2] =tii.getPrice();
					
					
					

					
					model_Ti.addRow(rowTi);
				
			}
			
			
			
		
	}
	
	
	private void loadInformationFruit() {
		table_3.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDF", "Fruit", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model_F = (DefaultTableModel) table_3.getModel();
	
			table_3.setRowHeight(30);
			flist = fu.getAll();
			
			for (Fruit f:flist) {
				Object[] rowF = new Object[3];
					rowF[0] = f.getIDf();
					rowF[1] = f.getFruit();
					rowF[2] =f.getPrice();
					
					
					

					
					model_F.addRow(rowF);
				
			}
			
			
			
		
	}
	
	
	private void loadInformationPart() {
		table_4.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDP", "Part", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model_P = (DefaultTableModel) table_4.getModel();
	
			table_4.setRowHeight(30);
			plist = pa.getAll();
			
			for (Part p:plist) {
				Object[] rowP = new Object[3];
					rowP[0] = p.getIDp();
					rowP[1] = p.getPart();
					rowP[2] =p.getPrice();
					
					
					

					
					model_P.addRow(rowP);
				
			}
			
			
			
		
	}
	
	private void loadInformationTaste() {
		table_5.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDTA", "Taste", "Price"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Long.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model_Ta = (DefaultTableModel) table_5.getModel();
	
			table_5.setRowHeight(30);
			talist = ta.getAll();
			
			for (Taste taa:talist) {
				Object[] rowTa = new Object[3];
					rowTa[0] = taa.getIDta();
					rowTa[1] = taa.getTaste();
					rowTa[2] =taa.getPrice();
					
					
					

					
					model_Ta.addRow(rowTa);
				
			}
			
			
			
			
			
		
	}
	
	
	public void reseach ( String str) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	
	public void reseach1 ( String str) {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_1.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	
	public void reseach2 ( String str) {
		DefaultTableModel model = (DefaultTableModel) table_2.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_2.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	
	public void reseach3 ( String str) {
		DefaultTableModel model = (DefaultTableModel) table_3.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_3.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	
	public void reseach4 ( String str) {
		DefaultTableModel model = (DefaultTableModel) table_4.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_4.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	
	public void reseach5 ( String str) {
		DefaultTableModel model = (DefaultTableModel) table_5.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table_5.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	
	

}
