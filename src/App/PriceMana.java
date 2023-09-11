package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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

public class PriceMana extends JPanel {
	private JTabbedPane tabbedPane;
	private JPanel panelPrice1;
	private JPanel panelPrice2;
	private JTable table_Shape, table_Color, table_Tier, table_Fruit, table_Part, table_Taste;
	private JTextField textField_NameS;
	private JTextField textField_PriceS;
	private JTextField textField_NameC;
	private JTextField textField_PriceC;
	private JTextField textField_NameTI;
	private JTextField textField_PriceTI;
	private JTextField textField_NameF;
	private JTextField textField_PriceF;
	private JTextField textField_NameP;
	private JTextField textField_PriceP;
	private JTextField textField_NameTA;
	private JTextField textField_PriceTA;
	private JTable table;
	private JSeparator separator;
	private JLabel lblNewLabel;
	private JLabel lblPrice;
	private JLabel lblPrice_1;
	private JLabel lblPrice_2;
	private JLabel lblMainColor;
	private JLabel lblTier;
	private JLabel lblNewLabel_1;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_Find1;
	private JTextField textField_Find2;
	private JButton btnNewButton_Del;
	private JButton btnNewButton_Add;
	private JButton btnNewButton_Edit;
	private JButton btnNewButton_Edit_3;
	private JButton btnNewButton_Update;
	private JButton btnNewButton_Update_3;
	private JButton btnNewButton_Del_1;
	private JButton btnNewButton_Add_1;
	private JButton btnNewButton_Edit_1;
	private JButton btnNewButton_Edit_1_1;
	private JButton btnNewButton_Update_1;
	private JButton btnNewButton_Update_1_1;
	private JButton btnNewButton_Del_2;
	private JButton btnNewButton_Add_2;
	private JButton btnNewButton_Edit_2;
	private JButton btnNewButton_Edit_2_1;
	private JButton btnNewButton_Update_2;
	private JButton btnNewButton_Find1;
	private JButton btnNewButton_Find2;
	public JButton btnNewButton_Exit1 = new JButton("Exit");
	public JButton btnNewButton_Exit2 = new JButton("Exit");
	private JLabel lblNewLabel_4;
	private JTextField textField_IDFruit;
	private JTextField textField_IDPart;
	private JTextField textField_IDTaste;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_IDShape;
	private JTextField textField_IDColor;
	private JTextField textField_IDTier;
	private JLabel lblIds;
	private JLabel lblIdc;
	private JLabel lblIdti;
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
	private JButton btnNewButton_ResetAll1;
	
	

	/**
	 * Create the panel.
	 */
	public PriceMana() {
		setBackground(new Color(234, 255, 255));
		setLayout(null);
		setLayout(null);
		setBounds(0, 0, 1156, 652);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(234, 255, 255));
		tabbedPane.setForeground(new Color(128, 0, 0));
		tabbedPane.setFont(new Font("Sylfaen", Font.BOLD, 25));
		tabbedPane.setBounds(0, 0, 1156, 652);
		add(tabbedPane);
		
//-------------------Bang1---------------------
		panelPrice1 = new JPanel();
		panelPrice1.setBackground(new Color(223, 255, 255));
		tabbedPane.addTab("Price 1", null, panelPrice1, null);
		panelPrice1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Price List 1");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(33, 11, 244, 43);
		panelPrice1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						PriceMana.class.getResource("/Image/money.jpg")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(242, 11, 54, 38);
		panelPrice1.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						PriceMana.class.getResource("/Image/money2.jpg")
						)
				).getImage().getScaledInstance(911, 50, Image.SCALE_DEFAULT)));
		lblNewLabel_4.setBounds(5, 554, 911, 50);
		panelPrice1.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						PriceMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(776, 18, 41, 36);
		panelPrice1.add(lblNewLabel_3);
		
		lblNewLabel = new JLabel("Shape:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(54, 397, 92, 35);
		panelPrice1.add(lblNewLabel);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(54, 443, 92, 35);
		panelPrice1.add(lblPrice);
		
		lblPrice_1 = new JLabel("Price:");
		lblPrice_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice_1.setBounds(422, 443, 92, 35);
		panelPrice1.add(lblPrice_1);
		
		lblPrice_2 = new JLabel("Price:");
		lblPrice_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice_2.setBounds(827, 443, 92, 35);
		panelPrice1.add(lblPrice_2);
		
		lblMainColor = new JLabel("Main Color:");
		lblMainColor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMainColor.setBounds(422, 397, 109, 35);
		panelPrice1.add(lblMainColor);
		
		lblTier = new JLabel("Tier:");
		lblTier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTier.setBounds(827, 397, 92, 35);
		panelPrice1.add(lblTier);
		
		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(5, 340, 1140, 1);
		panelPrice1.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 52, 494, 2);
		panelPrice1.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(10, 546, 1140, 1);
		panelPrice1.add(separator_2);
		
		
		
		//???????hinh dang
		slist = sp.getAll();
		table_Shape = new JTable();
		table_Shape.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Shape s = slist.get(table_Shape.getSelectedRow());
				textField_IDShape.setText(""+s.getIDs());
				textField_NameS.setText(s.getShape());
				textField_PriceS.setText(""+s.getPrice());
				
			}
		});
		table_Shape.setBackground(new Color(223, 223, 223));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Shape.setModel(new DefaultTableModel(
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
		table_Shape.getColumnModel().getColumn(0).setPreferredWidth(37);
		
		
		table_Shape.setBounds(375, 91, 889, 422);
		DefaultTableModel model_S = (DefaultTableModel) table_Shape.getModel();

		Object[] rowS = new Object[3];

		for (int i = 0; i < sp.size(); i++) {
			rowS[0]=((Shape) sp.get(i)).getIDs();

		rowS[1]= ((Shape) sp.get(i)).getShape();
		rowS[2]= ((Shape) sp.get(i)).getPrice();
		
		
			
	} table_Shape.setRowHeight(30);
	model_S.addRow(rowS);
	loadInformationShape();
		JScrollPane scrollPane_Shape = new JScrollPane(table_Shape);
		scrollPane_Shape.setBounds(10, 82, 380, 254);
		scrollPane_Shape.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice1.add(scrollPane_Shape);
		
		textField_NameS = new JTextField();
		textField_NameS.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_NameS.setColumns(10);
		textField_NameS.setBounds(123, 393, 210, 35);
		panelPrice1.add(textField_NameS);
		
		textField_PriceS = new JTextField();
		textField_PriceS.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_PriceS.setColumns(10);
		textField_PriceS.setBounds(123, 439, 210, 35);
		panelPrice1.add(textField_PriceS);
		
		//mausac????????
		        clist = co.getAll();
				table_Color = new JTable();
				table_Color.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Colour c = clist.get(table_Color.getSelectedRow());
						textField_IDColor.setText(""+c.getIDc());
						textField_NameC.setText(c.getColor());
						textField_PriceC.setText(""+c.getPrice());
						
					}
				});
				table_Color.setBackground(new Color(255, 198, 198));
//				table.setFont(new Font("Tahoma", Font.PLAIN, 25));
				table_Color.setModel(new DefaultTableModel(
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
				table_Color.getColumnModel().getColumn(0).setPreferredWidth(44);
				DefaultTableModel model_C = (DefaultTableModel) table_Color.getModel();

				Object[] rowC = new Object[3];

				for (int i = 0; i < co.size(); i++) {
					rowC[0]=((Colour) co.get(i)).getIDc();

				rowC[1]= ((Colour) co.get(i)).getColor();
				rowC[2]= ((Colour) co.get(i)).getPrice();
				
				
					
			} table_Color.setRowHeight(30);
			model_C.addRow(rowC);
			loadInformationColor();
				
				table_Color.setBounds(375, 91, 889, 422);
				JScrollPane scrollPane_Color = new JScrollPane(table_Color);
				scrollPane_Color.setBounds(393, 82, 380, 254);
				scrollPane_Color.setFont(new Font("Tahoma", Font.BOLD, 15));
				panelPrice1.add(scrollPane_Color);
				
				textField_NameC = new JTextField();
				textField_NameC.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField_NameC.setColumns(10);
				textField_NameC.setBounds(512, 397, 210, 35);
				panelPrice1.add(textField_NameC);
				
				textField_PriceC = new JTextField();
				textField_PriceC.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField_PriceC.setColumns(10);
				textField_PriceC.setBounds(512, 443, 210, 35);
				panelPrice1.add(textField_PriceC);
				
				
				//@@@@@tang
				tilist = ti.getAll();
				table_Tier = new JTable();
				table_Tier.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Tier tii = tilist.get(table_Tier.getSelectedRow());
						textField_IDTier.setText(""+tii.getIDti());
						textField_NameTI.setText(tii.getTier());
						textField_PriceTI.setText(""+tii.getPrice());
						
					}
				});
				table_Tier.setBackground(new Color(181, 218, 255));
//				table.setFont(new Font("Tahoma", Font.PLAIN, 25));
				table_Tier.setModel(new DefaultTableModel(
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
				table_Tier.getColumnModel().getColumn(0).setPreferredWidth(49);
				DefaultTableModel model_Ti = (DefaultTableModel) table_Tier.getModel();

				Object[] rowTi = new Object[3];

				for (int i = 0; i < ti.size(); i++) {
					rowTi[0]=((Tier) ti.get(i)).getIDti();

				rowTi[1]= ((Tier) ti.get(i)).getTier();
				rowTi[2]= ((Tier) ti.get(i)).getPrice();
				
				
					
			} table_Tier.setRowHeight(30);
			model_Ti.addRow(rowTi);
			loadInformationTier();
				
				table_Tier.setBounds(375, 91, 889, 422);
				JScrollPane scrollPane_Tier = new JScrollPane(table_Tier);
				scrollPane_Tier.setBounds(776, 82, 365, 254);
				scrollPane_Tier.setFont(new Font("Tahoma", Font.BOLD, 15));
				panelPrice1.add(scrollPane_Tier);
				
				textField_NameTI = new JTextField();
				textField_NameTI.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField_NameTI.setColumns(10);
				textField_NameTI.setBounds(884, 397, 210, 35);
				panelPrice1.add(textField_NameTI);
				
				textField_PriceTI = new JTextField();
				textField_PriceTI.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField_PriceTI.setColumns(10);
				textField_PriceTI.setBounds(884, 443, 210, 35);
				panelPrice1.add(textField_PriceTI);
				
				
				
				textField_Find1 = new JTextField();
				textField_Find1.setFont(new Font("Tahoma", Font.PLAIN, 17));
				textField_Find1.setColumns(10);
				textField_Find1.setBounds(821, 18, 238, 36);
				panelPrice1.add(textField_Find1);
				
				btnNewButton_Del = new JButton("Delete");
				btnNewButton_Del.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (sp.delete(slist.get(table_Shape.getSelectedRow()).getIDs())) {
							JOptionPane.showMessageDialog(null, "Delete success!");
							loadInformationShape();
						}
					}
				});
				btnNewButton_Del.setForeground(new Color(0, 64, 128));
				btnNewButton_Del.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Del.setBackground(new Color(255, 221, 221));
				btnNewButton_Del.setBounds(5, 485, 98, 36);
				panelPrice1.add(btnNewButton_Del);
				
				btnNewButton_Del_1 = new JButton("Delete");
				btnNewButton_Del_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (co.delete(clist.get(table_Color.getSelectedRow()).getIDc())) {
							JOptionPane.showMessageDialog(null, "Delete success!");
							loadInformationColor();
						}
					}
				});
				btnNewButton_Del_1.setForeground(new Color(0, 64, 128));
				btnNewButton_Del_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Del_1.setBackground(new Color(255, 221, 221));
				btnNewButton_Del_1.setBounds(393, 485, 98, 36);
				panelPrice1.add(btnNewButton_Del_1);
				
				btnNewButton_Del_2 = new JButton("Delete");
				btnNewButton_Del_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (ti.delete(tilist.get(table_Tier.getSelectedRow()).getIDti())) {
							JOptionPane.showMessageDialog(null, "Delete success!");
							loadInformationTier();
						}
					}
				});
				btnNewButton_Del_2.setForeground(new Color(0, 64, 128));
				btnNewButton_Del_2.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Del_2.setBackground(new Color(255, 221, 221));
				btnNewButton_Del_2.setBounds(776, 485, 111, 36);
				panelPrice1.add(btnNewButton_Del_2);
				
				btnNewButton_Add = new JButton("Add");
				btnNewButton_Add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String shape = textField_NameS.getText();
						
						long price = Long.parseLong(textField_PriceS.getText());
						
						
						if(sp.add(shape, price)) {
							JOptionPane.showMessageDialog(null, "Add success!");
							loadInformationShape();
						} else {
							JOptionPane.showMessageDialog(null, "Error!");
						}
					}
				});
				btnNewButton_Add.setForeground(new Color(0, 64, 128));
				btnNewButton_Add.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Add.setBackground(new Color(255, 221, 221));
				btnNewButton_Add.setBounds(104, 485, 71, 36);
				panelPrice1.add(btnNewButton_Add);
				
				btnNewButton_Add_1 = new JButton("Add");
				btnNewButton_Add_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String color = textField_NameC.getText();
						
						long price = Long.parseLong(textField_PriceC.getText());
						
						
						if(co.add(color, price)) {
							JOptionPane.showMessageDialog(null, "Add success!");
							loadInformationColor();
						} else {
							JOptionPane.showMessageDialog(null, "Error!");
						}
					}
				});
				btnNewButton_Add_1.setForeground(new Color(0, 64, 128));
				btnNewButton_Add_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Add_1.setBackground(new Color(255, 221, 221));
				btnNewButton_Add_1.setBounds(501, 485, 71, 36);
				panelPrice1.add(btnNewButton_Add_1);
				
				btnNewButton_Add_2 = new JButton("Add");
				btnNewButton_Add_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String tier = textField_NameTI.getText();
						
						long price = Long.parseLong(textField_PriceTI.getText());
						
						
						if(ti.add(tier, price)) {
							JOptionPane.showMessageDialog(null, "Add success!");
							loadInformationTier();
						} else {
							JOptionPane.showMessageDialog(null, "Error!");
						}
					}
				});
				btnNewButton_Add_2.setForeground(new Color(0, 64, 128));
				btnNewButton_Add_2.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Add_2.setBackground(new Color(255, 221, 221));
				btnNewButton_Add_2.setBounds(897, 485, 71, 36);
				panelPrice1.add(btnNewButton_Add_2);
				
				btnNewButton_Edit = new JButton("Reset");
				btnNewButton_Edit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField_IDShape.setText("");
						textField_NameS.setText("");
						textField_PriceS.setText("");
						loadInformationShape();
						
					}
				});
				btnNewButton_Edit.setForeground(new Color(0, 64, 128));
				btnNewButton_Edit.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Edit.setBackground(new Color(255, 221, 221));
				btnNewButton_Edit.setBounds(175, 485, 87, 36);
				panelPrice1.add(btnNewButton_Edit);
				
				btnNewButton_Edit_1 = new JButton("Reset");
				btnNewButton_Edit_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField_IDColor.setText("");
						textField_NameC.setText("");
						textField_PriceC.setText("");
						loadInformationColor();
						
					}
				});
				btnNewButton_Edit_1.setForeground(new Color(0, 64, 128));
				btnNewButton_Edit_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Edit_1.setBackground(new Color(255, 221, 221));
				btnNewButton_Edit_1.setBounds(576, 485, 92, 36);
				panelPrice1.add(btnNewButton_Edit_1);
				
				btnNewButton_Edit_2 = new JButton("Reset");
				btnNewButton_Edit_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField_IDTier.setText("");
						textField_NameTI.setText("");
						textField_PriceTI.setText("");
						loadInformationTier();
						
					}
				});
				btnNewButton_Edit_2.setForeground(new Color(0, 64, 128));
				btnNewButton_Edit_2.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Edit_2.setBackground(new Color(255, 221, 221));
				btnNewButton_Edit_2.setBounds(971, 485, 88, 36);
				panelPrice1.add(btnNewButton_Edit_2);
				
				btnNewButton_Update = new JButton("Update");
				btnNewButton_Update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nameS = textField_NameS.getText();
						long priceS = Long.parseLong(textField_PriceS.getText());
						int idS = Integer.parseInt(textField_IDShape.getText());
						Shape s = new Shape();
						s.setShape(nameS);
						s.setPrice(priceS);
						s.setIDs(idS);
						
						
						
						if(sp.update(nameS, priceS, idS)
								) {
							JOptionPane.showMessageDialog(null, "Update success!");
							sp.getAll();
							loadInformationShape();
							clearShape();
						} else {
							JOptionPane.showMessageDialog(null, "Error!");
						}
						
					}
				});
				btnNewButton_Update.setForeground(new Color(0, 64, 128));
				btnNewButton_Update.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Update.setBackground(new Color(255, 221, 221));
				btnNewButton_Update.setBounds(266, 485, 92, 36);
				panelPrice1.add(btnNewButton_Update);
				
				btnNewButton_Update_1 = new JButton("Update");
				btnNewButton_Update_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nameC = textField_NameC.getText();
						long priceC = Long.parseLong(textField_PriceC.getText());
						int idC = Integer.parseInt(textField_IDColor.getText());
						Colour c = new Colour();
						c.setColor(nameC);
						c.setPrice(priceC);
						c.setIDc(idC);
						
						
						
						if(co.update(nameC, priceC, idC)
								) {
							JOptionPane.showMessageDialog(null, "Update success!");
							co.getAll();
							loadInformationColor();
							clearColor();
						} else {
							JOptionPane.showMessageDialog(null, "Error!");
						}
						
					}
				});
				btnNewButton_Update_1.setForeground(new Color(0, 64, 128));
				btnNewButton_Update_1.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Update_1.setBackground(new Color(255, 221, 221));
				btnNewButton_Update_1.setBounds(663, 485, 92, 36);
				panelPrice1.add(btnNewButton_Update_1);
				
				btnNewButton_Update_2 = new JButton("Update");
				btnNewButton_Update_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nameTi = textField_NameTI.getText();
						long priceTi = Long.parseLong(textField_PriceTI.getText());
						int idTi = Integer.parseInt(textField_IDTier.getText());
						Tier tii = new Tier();
						tii.setTier(nameTi);
						tii.setPrice(priceTi);
						tii.setIDti(idTi);
						
						
						
						if(ti.update(nameTi, priceTi, idTi)
								) {
							JOptionPane.showMessageDialog(null, "Update success!");
							ti.getAll();
							loadInformationTier();
							clearTier();
						} else {
							JOptionPane.showMessageDialog(null, "Error!");
						}
						
					}
				});
				btnNewButton_Update_2.setForeground(new Color(0, 64, 128));
				btnNewButton_Update_2.setFont(new Font("Tahoma", Font.BOLD, 15));
				btnNewButton_Update_2.setBackground(new Color(255, 221, 221));
				btnNewButton_Update_2.setBounds(1056, 485, 92, 36);
				panelPrice1.add(btnNewButton_Update_2);
				
				btnNewButton_Find1 = new JButton("Find");
				btnNewButton_Find1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							
						String found = textField_Find1.getText(); // chinhs laf cai found nay
//						String name = textField_NameCake.getText();
//					
//					
						FindShape(found);
						FindColor(found);
						FindTier(found);
						
					}catch(Exception e2) {
							//TODO Auto-generated catch block
							JOptionPane.showConfirmDialog(null, e2);
					}
						
						
			    }
			});
				btnNewButton_Find1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnNewButton_Find1.setBackground(new Color(217, 217, 217));
				btnNewButton_Find1.setBounds(1063, 26, 72, 23);
				panelPrice1.add(btnNewButton_Find1);
				
				
				btnNewButton_Exit1.setForeground(new Color(128, 0, 0));
				btnNewButton_Exit1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnNewButton_Exit1.setBackground(new Color(255, 128, 128));
				btnNewButton_Exit1.setBounds(1043, 554, 98, 43);
				panelPrice1.add(btnNewButton_Exit1);
				
				textField_IDShape = new JTextField();
				textField_IDShape.setEditable(false);
				textField_IDShape.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField_IDShape.setColumns(10);
				textField_IDShape.setBounds(123, 351, 210, 35);
				panelPrice1.add(textField_IDShape);
				
				textField_IDColor = new JTextField();
				textField_IDColor.setEditable(false);
				textField_IDColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField_IDColor.setColumns(10);
				textField_IDColor.setBounds(512, 351, 210, 35);
				panelPrice1.add(textField_IDColor);
				
				textField_IDTier = new JTextField();
				textField_IDTier.setEditable(false);
				textField_IDTier.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField_IDTier.setColumns(10);
				textField_IDTier.setBounds(884, 351, 210, 35);
				panelPrice1.add(textField_IDTier);
				
				lblIds = new JLabel("IDS:");
				lblIds.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblIds.setBounds(54, 352, 92, 35);
				panelPrice1.add(lblIds);
				
				lblIdc = new JLabel("IDC:");
				lblIdc.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblIdc.setBounds(422, 352, 92, 35);
				panelPrice1.add(lblIdc);
				
				lblIdti = new JLabel("IDTI:");
				lblIdti.setFont(new Font("Tahoma", Font.BOLD, 15));
				lblIdti.setBounds(827, 352, 92, 35);
				panelPrice1.add(lblIdti);
				
				btnNewButton_ResetAll1 = new JButton("Reset");
				btnNewButton_ResetAll1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadInformationShape();
						loadInformationColor();
						loadInformationTier();
						
						clearShape();
						clearColor();
						clearTier();
						
					}
				});
				btnNewButton_ResetAll1.setForeground(new Color(128, 0, 0));
				btnNewButton_ResetAll1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnNewButton_ResetAll1.setBackground(new Color(255, 128, 128));
				btnNewButton_ResetAll1.setBounds(944, 554, 95, 43);
				panelPrice1.add(btnNewButton_ResetAll1);
				
				
				
				
				
				
				
				
			
		
//---------------------------------Bang2--------------------------------
		panelPrice2 = new JPanel();
		panelPrice2.setBackground(new Color(185, 255, 255));
		tabbedPane.addTab("Price 2", null, panelPrice2, null);
		panelPrice2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Price List 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_1.setBounds(33, 11, 244, 43);
		panelPrice2.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						PriceMana.class.getResource("/Image/money.jpg")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(242, 11, 54, 38);
		panelPrice2.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						PriceMana.class.getResource("/Image/money3.jpg")
						)
				).getImage().getScaledInstance(911, 50, Image.SCALE_DEFAULT)));
		lblNewLabel_4.setBounds(5, 547, 911, 50);
		panelPrice2.add(lblNewLabel_4);
		
		lblNewLabel_3 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						PriceMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(776, 18, 41, 36);
		panelPrice2.add(lblNewLabel_3);
		
		lblNewLabel = new JLabel("Fruit:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(52, 393, 64, 35);
		panelPrice2.add(lblNewLabel);
		
		lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(52, 439, 64, 35);
		panelPrice2.add(lblPrice);
		
		lblPrice_1 = new JLabel("Price:");
		lblPrice_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice_1.setBounds(462, 439, 64, 35);
		panelPrice2.add(lblPrice_1);
		
		lblPrice_2 = new JLabel("Price:");
		lblPrice_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice_2.setBounds(827, 439, 64, 35);
		panelPrice2.add(lblPrice_2);
		
		lblMainColor = new JLabel("Part:");
		lblMainColor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMainColor.setBounds(462, 393, 64, 35);
		panelPrice2.add(lblMainColor);
		
		lblTier = new JLabel("Taste:");
		lblTier.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTier.setBounds(827, 393, 64, 35);
		panelPrice2.add(lblTier);
		
		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(5, 340, 1140, 1);
		panelPrice2.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(10, 52, 494, 2);
		panelPrice2.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(10, 546, 1140, 1);
		panelPrice2.add(separator_2);
		
		//???????????trai con
		flist = fu.getAll();
		table_Fruit = new JTable();
		table_Fruit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Fruit f = flist.get(table_Fruit.getSelectedRow());
				textField_IDFruit.setText(""+f.getIDf());
				textField_NameF.setText(f.getFruit());
				textField_PriceF.setText(""+f.getPrice());
				
			}
		});
		table_Fruit.setBackground(new Color(193, 255, 193));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Fruit.setModel(new DefaultTableModel(
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
		table_Fruit.getColumnModel().getColumn(0).setPreferredWidth(41);
		DefaultTableModel model_F = (DefaultTableModel) table_Fruit.getModel();

		Object[] rowF = new Object[3];

		for (int i = 0; i < fu.size(); i++) {
			rowF[0]=((Fruit) fu.get(i)).getIDf();

		rowF[1]= ((Fruit) fu.get(i)).getFruit();
		rowF[2]= ((Fruit) fu.get(i)).getPrice();
		
		
			
	} table_Fruit.setRowHeight(30);
	model_F.addRow(rowF);
	loadInformationFruit();
		
		table_Fruit.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Fruit = new JScrollPane(table_Fruit);
		scrollPane_Fruit.setBounds(10, 82, 380, 254);
		scrollPane_Fruit.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice2.add(scrollPane_Fruit);
		
		textField_NameF = new JTextField();
		textField_NameF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_NameF.setColumns(10);
		textField_NameF.setBounds(102, 393, 210, 35);
		panelPrice2.add(textField_NameF);
		
		textField_PriceF = new JTextField();
		textField_PriceF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_PriceF.setColumns(10);
		textField_PriceF.setBounds(102, 439, 210, 35);
		panelPrice2.add(textField_PriceF);
		
		//phu kien????????
		plist = pa.getAll();
		table_Part = new JTable();
		table_Part.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Part p = plist.get(table_Part.getSelectedRow());
				textField_IDPart.setText(""+p.getIDp());
				textField_NameP.setText(p.getPart());
				textField_PriceP.setText(""+p.getPrice());
				
			}
		});
		table_Part.setBackground(new Color(255, 255, 221));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Part.setModel(new DefaultTableModel(
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
		table_Part.getColumnModel().getColumn(0).setPreferredWidth(35);
		DefaultTableModel model_P = (DefaultTableModel) table_Part.getModel();

		Object[] rowP = new Object[3];

		for (int i = 0; i < pa.size(); i++) {
			rowP[0]=((Part) pa.get(i)).getIDp();

		rowP[1]= ((Part) pa.get(i)).getPart();
		rowP[2]= ((Part) pa.get(i)).getPrice();
		
		
			
	} table_Part.setRowHeight(30);
	model_P.addRow(rowP);
	loadInformationPart();
		
		table_Part.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Part = new JScrollPane(table_Part);
		scrollPane_Part.setBounds(393, 82, 380, 254);
		scrollPane_Part.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice2.add(scrollPane_Part);
		
		textField_NameP = new JTextField();
		textField_NameP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_NameP.setColumns(10);
		textField_NameP.setBounds(512, 393, 210, 35);
		panelPrice2.add(textField_NameP);
		
		textField_PriceP = new JTextField();
		textField_PriceP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_PriceP.setColumns(10);
		textField_PriceP.setBounds(512, 439, 210, 35);
		panelPrice2.add(textField_PriceP);
		
		
		//@@@@@huong vi
		talist = ta.getAll();
		table_Taste = new JTable();
		table_Taste.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Taste taa = talist.get(table_Taste.getSelectedRow());
				textField_IDTaste.setText(""+taa.getIDta());
				textField_NameTA.setText(taa.getTaste());
				textField_PriceTA.setText(""+taa.getPrice());
				
			}
		});
		table_Taste.setBackground(new Color(206, 206, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Taste.setModel(new DefaultTableModel(
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
		table_Taste.getColumnModel().getColumn(0).setPreferredWidth(50);
		DefaultTableModel model_Ta = (DefaultTableModel) table_Taste.getModel();

		Object[] rowTa = new Object[3];

		for (int i = 0; i < ta.size(); i++) {
			rowTa[0]=((Taste) ta.get(i)).getIDta();

		rowTa[1]= ((Taste) ta.get(i)).getTaste();
		rowTa[2]= ((Taste) ta.get(i)).getPrice();
		
		
			
	} table_Taste.setRowHeight(30);
	model_Ta.addRow(rowTa);
	loadInformationTaste();
		
		
		table_Taste.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Taste = new JScrollPane(table_Taste);
		scrollPane_Taste.setBounds(776, 82, 365, 254);
		scrollPane_Taste.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelPrice2.add(scrollPane_Taste);
		
		textField_NameTA = new JTextField();
		textField_NameTA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_NameTA.setColumns(10);
		textField_NameTA.setBounds(884, 393, 210, 35);
		panelPrice2.add(textField_NameTA);
		
		textField_PriceTA = new JTextField();
		textField_PriceTA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_PriceTA.setColumns(10);
		textField_PriceTA.setBounds(884, 439, 210, 35);
		panelPrice2.add(textField_PriceTA);
		
		
		textField_Find2 = new JTextField();
		textField_Find2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Find2.setColumns(10);
		textField_Find2.setBounds(821, 18, 238, 36);
		panelPrice2.add(textField_Find2);
		
		btnNewButton_Del = new JButton("Delete");
		btnNewButton_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fu.delete(flist.get(table_Fruit.getSelectedRow()).getIDf())) {
					JOptionPane.showMessageDialog(null, "Delete success!");
					loadInformationFruit();
				}
			}
		});
		btnNewButton_Del.setForeground(new Color(0, 64, 128));
		btnNewButton_Del.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Del.setBackground(new Color(255, 221, 221));
		btnNewButton_Del.setBounds(5, 485, 98, 36);
		panelPrice2.add(btnNewButton_Del);
		
		btnNewButton_Del_1 = new JButton("Delete");
		btnNewButton_Del_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pa.delete(plist.get(table_Part.getSelectedRow()).getIDp())) {
					JOptionPane.showMessageDialog(null, "Delete success!");
					loadInformationPart();
				}
			}
		});
		btnNewButton_Del_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Del_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Del_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Del_1.setBounds(393, 485, 98, 36);
		panelPrice2.add(btnNewButton_Del_1);
		
		btnNewButton_Del_2 = new JButton("Delete");
		btnNewButton_Del_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ta.delete(talist.get(table_Taste.getSelectedRow()).getIDta())) {
					JOptionPane.showMessageDialog(null, "Delete success!");
					loadInformationTaste();
				}
			}
		});
		btnNewButton_Del_2.setForeground(new Color(0, 64, 128));
		btnNewButton_Del_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Del_2.setBackground(new Color(255, 221, 221));
		btnNewButton_Del_2.setBounds(776, 485, 111, 36);
		panelPrice2.add(btnNewButton_Del_2);
		
		btnNewButton_Add = new JButton("Add");
		btnNewButton_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fruit = textField_NameF.getText();
				
				long price = Long.parseLong(textField_PriceF.getText());
				
				
				if(fu.add(fruit, price)) {
					JOptionPane.showMessageDialog(null, "Add success!");
					loadInformationFruit();
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
			}
		});
		btnNewButton_Add.setForeground(new Color(0, 64, 128));
		btnNewButton_Add.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Add.setBackground(new Color(255, 221, 221));
		btnNewButton_Add.setBounds(104, 485, 71, 36);
		panelPrice2.add(btnNewButton_Add);
		
		btnNewButton_Add_1 = new JButton("Add");
		btnNewButton_Add_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String part = textField_NameP.getText();
				
				long price = Long.parseLong(textField_PriceP.getText());
				
				
				if(pa.add(part, price)) {
					JOptionPane.showMessageDialog(null, "Add success!");
					loadInformationPart();
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
			}
		});
		btnNewButton_Add_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Add_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Add_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Add_1.setBounds(501, 485, 71, 36);
		panelPrice2.add(btnNewButton_Add_1);
		
		btnNewButton_Add_2 = new JButton("Add");
		btnNewButton_Add_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String taste = textField_NameTA.getText();
				
				long price = Long.parseLong(textField_PriceTA.getText());
				
				
				if(ta.add(taste, price)) {
					JOptionPane.showMessageDialog(null, "Add success!");
					loadInformationTaste();
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
			}
		});
		btnNewButton_Add_2.setForeground(new Color(0, 64, 128));
		btnNewButton_Add_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Add_2.setBackground(new Color(255, 221, 221));
		btnNewButton_Add_2.setBounds(897, 485, 71, 36);
		panelPrice2.add(btnNewButton_Add_2);
		
		btnNewButton_Edit_3 = new JButton("Reset");
		btnNewButton_Edit_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_IDFruit.setText("");
				textField_NameF.setText("");
				textField_PriceF.setText("");
				loadInformationFruit();
			}
		});
		btnNewButton_Edit_3.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Edit_3.setBackground(new Color(255, 221, 221));
		btnNewButton_Edit_3.setBounds(179, 485, 85, 36);
		panelPrice2.add(btnNewButton_Edit_3);
		
		btnNewButton_Edit_1_1 = new JButton("Reset");
		btnNewButton_Edit_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_IDPart.setText("");
				textField_NameP.setText("");
				textField_PriceP.setText("");
				loadInformationPart();
			}
		});
		btnNewButton_Edit_1_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Edit_1_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Edit_1_1.setBounds(576, 485, 85, 36);
		panelPrice2.add(btnNewButton_Edit_1_1);
		
		btnNewButton_Edit_2_1 = new JButton("Reset");
		btnNewButton_Edit_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_IDTaste.setText("");
				textField_NameTA.setText("");
				textField_PriceTA.setText("");
				loadInformationTaste();
				
			}
		});
		btnNewButton_Edit_2_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Edit_2_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Edit_2_1.setBounds(971, 485, 88, 36);
		panelPrice2.add(btnNewButton_Edit_2_1);
		
		btnNewButton_Update_3 = new JButton("Update");
		btnNewButton_Update_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameF = textField_NameF.getText();
				long priceF = Long.parseLong(textField_PriceF.getText());
				int idF = Integer.parseInt(textField_IDFruit.getText());
				Fruit f = new Fruit();
				f.setFruit(nameF);
				f.setPrice(priceF);
				f.setIDf(idF);
				
				
				
				if(fu.update(nameF, priceF, idF)
						) {
					JOptionPane.showMessageDialog(null, "Update success!");
					fu.getAll();
					loadInformationFruit();
					clearFruit();
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
				
			}
		});
		btnNewButton_Update_3.setForeground(new Color(0, 64, 128));
		btnNewButton_Update_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Update_3.setBackground(new Color(255, 221, 221));
		btnNewButton_Update_3.setBounds(266, 485, 92, 36);
		panelPrice2.add(btnNewButton_Update_3);
		
		btnNewButton_Update_1_1 = new JButton("Update");
		btnNewButton_Update_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameP = textField_NameP.getText();
				long priceP = Long.parseLong(textField_PriceP.getText());
				int idP = Integer.parseInt(textField_IDPart.getText());
				Part p = new Part();
				p.setPart(nameP);
				p.setPrice(priceP);
				p.setIDp(idP);
				
				
				
				if(pa.update(nameP, priceP, idP)
						) {
					JOptionPane.showMessageDialog(null, "Update success!");
					pa.getAll();
					loadInformationPart();
					clearPart();
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
				
			}
		});
		btnNewButton_Update_1_1.setForeground(new Color(0, 64, 128));
		btnNewButton_Update_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Update_1_1.setBackground(new Color(255, 221, 221));
		btnNewButton_Update_1_1.setBounds(663, 485, 92, 36);
		panelPrice2.add(btnNewButton_Update_1_1);
		
		btnNewButton_Update_2 = new JButton("Update");
		btnNewButton_Update_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameTa = textField_NameTA.getText();
				long priceTa = Long.parseLong(textField_PriceTA.getText());
				int idTa = Integer.parseInt(textField_IDTaste.getText());
				Taste taa = new Taste();
				taa.setTaste(nameTa);
				taa.setPrice(priceTa);
				taa.setIDta(idTa);
				
				
				
				if(ta.update(nameTa, priceTa, idTa)
						) {
					JOptionPane.showMessageDialog(null, "Update success!");
					ta.getAll();
					loadInformationTaste();
					clearTaste();
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
				
			}
		});
		btnNewButton_Update_2.setForeground(new Color(0, 64, 128));
		btnNewButton_Update_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_Update_2.setBackground(new Color(255, 221, 221));
		btnNewButton_Update_2.setBounds(1056, 485, 92, 36);
		panelPrice2.add(btnNewButton_Update_2);
		
		btnNewButton_Find2 = new JButton("Find");
		btnNewButton_Find2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				String found = textField_Find2.getText(); // chinhs laf cai found nay
//				String name = textField_NameCake.getText();
//			
				FindFruit(found);
				FindPart(found);
				FindTaste(found);
			}catch(Exception e2) {
					//TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e2);
			}
				
				
	    }
	});
		btnNewButton_Find2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Find2.setBackground(new Color(217, 217, 217));
		btnNewButton_Find2.setBounds(1063, 26, 72, 23);
		panelPrice2.add(btnNewButton_Find2);
		
		btnNewButton_Exit2 = new JButton("Exit");
		btnNewButton_Exit2.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit2.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit2.setBounds(1047, 554, 88, 43);
		panelPrice2.add(btnNewButton_Exit2);
		
		textField_IDFruit = new JTextField();
		textField_IDFruit.setEditable(false);
		textField_IDFruit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_IDFruit.setColumns(10);
		textField_IDFruit.setBounds(102, 347, 210, 35);
		panelPrice2.add(textField_IDFruit);
		
		textField_IDPart = new JTextField();
		textField_IDPart.setEditable(false);
		textField_IDPart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_IDPart.setColumns(10);
		textField_IDPart.setBounds(512, 347, 210, 35);
		panelPrice2.add(textField_IDPart);
		
		textField_IDTaste = new JTextField();
		textField_IDTaste.setEditable(false);
		textField_IDTaste.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_IDTaste.setColumns(10);
		textField_IDTaste.setBounds(884, 352, 210, 35);
		panelPrice2.add(textField_IDTaste);
		
		lblNewLabel_5 = new JLabel("IDF:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(52, 347, 64, 35);
		panelPrice2.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("IDP:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(462, 347, 64, 35);
		panelPrice2.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("IDTA:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(827, 352, 64, 35);
		panelPrice2.add(lblNewLabel_7);
		
		JButton btnNewButton_ResetAll2 = new JButton("Reset");
		btnNewButton_ResetAll2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadInformationFruit();
				loadInformationPart();
				loadInformationTaste();
				clearFruit();
				clearPart();
				clearTaste();
				
				
				
			}
		});
		btnNewButton_ResetAll2.setForeground(new Color(128, 0, 0));
		btnNewButton_ResetAll2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_ResetAll2.setBackground(new Color(255, 128, 128));
		btnNewButton_ResetAll2.setBounds(942, 554, 95, 43);
		panelPrice2.add(btnNewButton_ResetAll2);

	}
	
	
	private void loadInformationShape() {
		table_Shape.setModel(new DefaultTableModel(
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
		DefaultTableModel model_S = (DefaultTableModel) table_Shape.getModel();
	
			table_Shape.setRowHeight(30);
			slist = sp.getAll();
			
			for (Shape s:slist) {
				Object[] rowS = new Object[3];
					rowS[0] = s.getIDs();
					rowS[1] = s.getShape();
					rowS[2] =s.getPrice();
					
					
					

					
					model_S.addRow(rowS);
				
			}
			
		
	}
	
	private void loadInformationColor() {
		table_Color.setModel(new DefaultTableModel(
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
		DefaultTableModel model_C = (DefaultTableModel) table_Color.getModel();
	
			table_Color.setRowHeight(30);
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
		table_Tier.setModel(new DefaultTableModel(
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
		DefaultTableModel model_Ti = (DefaultTableModel) table_Tier.getModel();
	
			table_Tier.setRowHeight(30);
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
		table_Fruit.setModel(new DefaultTableModel(
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
		DefaultTableModel model_F = (DefaultTableModel) table_Fruit.getModel();
	
			table_Fruit.setRowHeight(30);
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
		table_Part.setModel(new DefaultTableModel(
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
		DefaultTableModel model_P = (DefaultTableModel) table_Part.getModel();
	
			table_Part.setRowHeight(30);
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
		table_Taste.setModel(new DefaultTableModel(
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
		DefaultTableModel model_Ta = (DefaultTableModel) table_Taste.getModel();
	
			table_Taste.setRowHeight(30);
			talist = ta.getAll();
			
			for (Taste taa:talist) {
				Object[] rowTa = new Object[3];
					rowTa[0] = taa.getIDta();
					rowTa[1] = taa.getTaste();
					rowTa[2] =taa.getPrice();
					
					
					

					
					model_Ta.addRow(rowTa);
				
			}
			
			
			
			
			
		
	}
	
	
	
	private void FindShape(String found) // find nayf 
	{
		table_Shape.setModel(new DefaultTableModel(
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
		DefaultTableModel model_S = (DefaultTableModel) table_Shape.getModel();
	
			table_Shape.setRowHeight(30);
			slist = sp.find1(found); 
			table_Shape.setRowSorter(null);
			
			for (Shape s:slist) {
				Object[] rowS = new Object[3];
					rowS[0] = s.getIDs();
					rowS[1] = s.getShape();
					rowS[2] =s.getPrice();
					
					
					

					
					model_S.addRow(rowS);
				
			}
			
		
	}
	
	private void FindColor(String found) // find nayf 
	{
		table_Color.setModel(new DefaultTableModel(
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
		DefaultTableModel model_C = (DefaultTableModel) table_Color.getModel();
	
			table_Color.setRowHeight(30);
			clist = co.find2(found); 
			table_Color.setRowSorter(null);
			
			for (Colour c:clist) {
				Object[] rowC = new Object[3];
					rowC[0] = c.getIDc();
					rowC[1] = c.getColor();
					rowC[2] =c.getPrice();
					
					
					

					
					model_C.addRow(rowC);
				
			}
			
			
			
		
	}
	
	
	private void FindTier(String found) // find nayf 
	{
		table_Tier.setModel(new DefaultTableModel(
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
		DefaultTableModel model_Ti = (DefaultTableModel) table_Tier.getModel();
	
			table_Tier.setRowHeight(30);
			tilist = ti.find3(found);
			table_Shape.setRowSorter(null);
			
			for (Tier tii:tilist) {
				Object[] rowTi = new Object[3];
					rowTi[0] = tii.getIDti();
					rowTi[1] = tii.getTier();
					rowTi[2] =tii.getPrice();
					
					
					

					
					model_Ti.addRow(rowTi);
				
			}
			
			
			
		
	}
	
	private void FindFruit(String found) // find nayf 
	{
		table_Fruit.setModel(new DefaultTableModel(
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
		DefaultTableModel model_F = (DefaultTableModel) table_Fruit.getModel();
	
			table_Fruit.setRowHeight(30);
			flist = fu.find4(found);
			table_Fruit.setRowSorter(null);
			
			for (Fruit f:flist) {
				Object[] rowF = new Object[3];
					rowF[0] = f.getIDf();
					rowF[1] = f.getFruit();
					rowF[2] =f.getPrice();
					
					
					

					
					model_F.addRow(rowF);
				
			}
			
			
			
		
	}
	
	
	private void FindPart(String found) // find nayf 
	{
		table_Part.setModel(new DefaultTableModel(
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
		DefaultTableModel model_P = (DefaultTableModel) table_Part.getModel();
	
			table_Part.setRowHeight(30);
			plist = pa.find5(found);
			table_Part.setRowSorter(null);
			
			for (Part p:plist) {
				Object[] rowP = new Object[3];
					rowP[0] = p.getIDp();
					rowP[1] = p.getPart();
					rowP[2] =p.getPrice();
					
					
					

					
					model_P.addRow(rowP);
				
			}
			
			
			
		
	}
	
	private void FindTaste(String found) // find nayf 
	{
		table_Taste.setModel(new DefaultTableModel(
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
		DefaultTableModel model_Ta = (DefaultTableModel) table_Taste.getModel();
	
			table_Taste.setRowHeight(30);
			talist = ta.find6(found);
			table_Taste.setRowSorter(null);
			
			for (Taste taa:talist) {
				Object[] rowTa = new Object[3];
					rowTa[0] = taa.getIDta();
					rowTa[1] = taa.getTaste();
					rowTa[2] =taa.getPrice();
					
					
					

					
					model_Ta.addRow(rowTa);
				
			}
			
			
			
			
			
		
	}
	
	
	void clearShape() {
		textField_IDShape.setText("");
		textField_NameS.setText("");
		textField_PriceS.setText("");
		textField_Find1.setText("");
		
	}
	void clearColor() {
		textField_IDColor.setText("");
		textField_NameC.setText("");
		textField_PriceC.setText("");
		textField_Find1.setText("");
	}
	void clearTier() {
		textField_IDTier.setText("");
		textField_NameTI.setText("");
		textField_PriceTI.setText("");
		textField_Find1.setText("");
	}
	void clearFruit() {
		textField_IDFruit.setText("");
		textField_NameF.setText("");
		textField_PriceF.setText("");
		textField_Find2.setText("");
	}
	void clearPart() {
		textField_IDPart.setText("");
		textField_NameP.setText("");
		textField_PriceP.setText("");
		textField_Find2.setText("");
	}
	void clearTaste() {
		textField_IDTaste.setText("");
		textField_NameTA.setText("");
		textField_PriceTA.setText("");
		textField_Find2.setText("");
	}
}
