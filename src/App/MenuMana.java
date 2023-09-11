package App;
import Normal.Drink;
import Normal.Cakes;
import Normal.Cookie;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Database.CakeConnect;
import Database.ConnectDatabase;
import Database.CookieConnect;
import Database.DrinkConnect;
import Normal.FileTypeFiler;
import Normal.Shape;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuMana extends JPanel {
	private JTable table_Drink;
	private JTable table_Cookie;
	private JTable table_Cake;
	private JTabbedPane tabbedPane;
	private JPanel panelDrink;
	private JPanel panelCookie;
	private JPanel panelCake;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_FindCake;
	private JTextField textField_FindCo;
	private JTextField textField_FindD;
	private JButton btnNewButton_Find;
	private JButton btnNewButton_FindCake;
	private JButton btnNewButton_FindCo;
	private JButton btnNewButton_FindD;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_5;
	private JLabel lblImaD = new JLabel("");
	private JLabel lblImaCoo = new JLabel("");
	private JLabel lblImaCa  = new JLabel("");
	private JTextField textField_1;
	private JTextField textField_NameCake;
	private JTextField textField_NameCo;
	private JTextField textField_NameD;
	private JTextField textField_SizeD;
	private JTextPane textPane;
	private JTextPane textPane_MainIngreCake;
	private JTextPane textPane_MainIngreCo;
	private JTextPane textPane_MainIngreD;
	private JTextField textField_PriceD;
	private JButton btnNewButton_Del;
	private JButton btnNewButton_DelCake;
	private JButton btnNewButton_DelCo;
	private JButton btnNewButton_DelD;
	private JButton btnNewButton_Edit;
	private JButton btnNewButton_EditCake;
	private JButton btnNewButton_EditCo;
	private JButton btnNewButton_EditD;
	private JButton btnNewButton_Add;
	private JButton btnNewButton_AddCake;
	private JButton btnNewButton_AddCo;
	private JButton btnNewButton_AddD;
	private JButton btnNewButton_Update;
	private JButton btnNewButton_UpdateCake;
	private JButton btnNewButton_UpdateCo;
	private JButton btnNewButton_UpdateD;
	ArrayList<Drink> dlist = new ArrayList<Drink>();
	ArrayList<Cookie> colist = new ArrayList<Cookie>();
	ArrayList<Cakes> list = new ArrayList<Cakes>();
	public JButton btnNewButton_ExitCake = new JButton("Exit");
	public JButton btnNewButton_ExitCo = new JButton("Exit");
	public JButton btnNewButton_ExitD = new JButton("Exit");
	
	private JLabel lblNewLabel_2;
	private JTextField textField_4;
	private JTextField textField_PriceCake;
	private JTextField textField_PriceCo;
	private JButton btnFolderD;
	
	public static Statement statement;
	java.sql.Connection conn;
	String pic ="";
	String pic1 = "";
	String pic2 = "";
	private DrinkConnect drink = new DrinkConnect();
	private CookieConnect cookie = new CookieConnect();
	private CakeConnect cakes = new CakeConnect();
	private JButton btnFolderCoo;
	
	private JButton btnFolderCa;
	private String fileNameDrink = null;
	private JTextField textField_IDD;
	private JTextField textField_IDC;
	private JLabel lblNewLabel_4;
	private JTextField textField_IDCa;
	private JLabel lblNewLabel_5;
	private DefaultTableModel modelCa;
	/**
	 * Create the panel.
	 */
	public MenuMana() {
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
		panelDrink = new JPanel();
		panelDrink.setBackground(new Color(255, 236, 236));
		tabbedPane.addTab("Drinks", null, panelDrink, null);
		panelDrink.setLayout(null);
		
		lblNewLabel = new JLabel("Drinks Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(24, 11, 373, 43);
		panelDrink.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						MenuMana.class.getResource("/Image/menu.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(248, 16, 54, 38);
		panelDrink.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						MenuMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(791, 11, 41, 36);
		panelDrink.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(748, 105, 84, 29);
		panelDrink.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2 = new JLabel("Image:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(748, 158, 84, 29);
		panelDrink.add(lblNewLabel_1_2);
		
		lblNewLabel_1_3 = new JLabel("Size:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(748, 329, 84, 29);
		panelDrink.add(lblNewLabel_1_3);
		
		lblNewLabel_1_4 = new JLabel("Main Ingre:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(747, 369, 160, 29);
		panelDrink.add(lblNewLabel_1_4);
		
		lblNewLabel_1_5 = new JLabel("Price:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(748, 454, 84, 29);
		panelDrink.add(lblNewLabel_1_5);
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 52, 304, 2);
		panelDrink.add(separator);
		
		dlist = drink.getAll();
		table_Drink = new JTable();
		table_Drink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Drink d = dlist.get(table_Drink.getSelectedRow());
				textField_IDD.setText(""+d.getID());
				textField_NameD.setText(d.getName());
				textField_PriceD.setText(""+d.getPrice());
				textField_SizeD.setText(d.getSize());
				textPane_MainIngreD.setText(d.getMainIngredients());
				
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(d.getImage()).getImage()
						.getScaledInstance(210, 161, Image.SCALE_SMOOTH));
				lblImaD.setIcon(imageIcon);
				pic = "";
			}
		});
		table_Drink.setBackground(new Color(223, 255, 255));

		table_Drink.setModel(new DefaultTableModel(
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
		} );
		
		//show 
		
		DefaultTableModel model = (DefaultTableModel) table_Drink.getModel();

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
			
	} table_Drink.setRowHeight(100);
	model.addRow(row);
		
		loadInformationDrink();
		
		JScrollPane scrollPane_Drink = new JScrollPane();
		scrollPane_Drink.setBounds(10, 58, 714, 535);
		scrollPane_Drink.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane_Drink.setViewportView(table_Drink);
		panelDrink.add(scrollPane_Drink);
		
		
		lblImaD.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblImaD.setBounds(882, 151, 210, 161);
		panelDrink.add(lblImaD);
		
		
		
		
		textField_FindD = new JTextField();
		textField_FindD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_FindD.setColumns(10);
		textField_FindD.setBounds(836, 11, 238, 36);
		panelDrink.add(textField_FindD);
		
		
		textField_NameD = new JTextField();
		textField_NameD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_NameD.setColumns(10);
		textField_NameD.setBounds(882, 105, 210, 35);
		panelDrink.add(textField_NameD);
		
		
		
		textField_SizeD = new JTextField();
		textField_SizeD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_SizeD.setColumns(10);
		textField_SizeD.setBounds(882, 323, 210, 35);
		panelDrink.add(textField_SizeD);
		
		textPane_MainIngreD = new JTextPane();
		textPane_MainIngreD.setBounds(882, 369, 210, 71);
		panelDrink.add(textPane_MainIngreD);
		
		textField_PriceD = new JTextField();
		textField_PriceD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_PriceD.setColumns(10);
		textField_PriceD.setBounds(882, 451, 210, 35);
		panelDrink.add(textField_PriceD);
		
		
		
		btnNewButton_ExitD.setForeground(new Color(128, 0, 0));
		btnNewButton_ExitD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_ExitD.setBackground(new Color(255, 128, 128));
		btnNewButton_ExitD.setBounds(1046, 505, 72, 61);
		panelDrink.add(btnNewButton_ExitD);
		
		btnNewButton_DelD = new JButton("Delete");
		btnNewButton_DelD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (drink.delete(dlist.get(table_Drink.getSelectedRow()).getID())) {
					JOptionPane.showMessageDialog(null, "Delete success!");
					loadInformationDrink();
				}
			}
		});
		btnNewButton_DelD.setForeground(new Color(0, 64, 128));
		btnNewButton_DelD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_DelD.setBackground(new Color(230, 255, 255));
		btnNewButton_DelD.setBounds(774, 494, 113, 36);
		panelDrink.add(btnNewButton_DelD);
		
		btnNewButton_EditD = new JButton("Reset");
		btnNewButton_EditD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearDrink();
				loadInformationDrink();
			}
		});
		btnNewButton_EditD.setForeground(new Color(0, 64, 128));
		btnNewButton_EditD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_EditD.setBackground(new Color(230, 255, 255));
		btnNewButton_EditD.setBounds(912, 494, 113, 36);
		panelDrink.add(btnNewButton_EditD);
		
		btnNewButton_AddD = new JButton("Add");
		btnNewButton_AddD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_NameD.getText();
				String size = textField_SizeD.getText();
				String ingre = textPane_MainIngreD.getText();
				long price = Long.parseLong(textField_PriceD.getText());
				if(drink.add(name, pic, size, ingre, price)) {
					JOptionPane.showMessageDialog(null, "Add success!");
					clearDrink();
					loadInformationDrink();
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
			}
		});
		btnNewButton_AddD.setForeground(new Color(0, 64, 128));
		btnNewButton_AddD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_AddD.setBackground(new Color(230, 255, 255));
		btnNewButton_AddD.setBounds(774, 541, 113, 36);
		panelDrink.add(btnNewButton_AddD);
		
		btnNewButton_UpdateD = new JButton("Update");
		btnNewButton_UpdateD.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent e) {
				int idd = Integer.parseInt(textField_IDD.getText());
				try {
				String name = textField_NameD.getText();
				String size = textField_SizeD.getText();
                //byte[] b = pic2.getBytes();
				String ingre = textPane_MainIngreD.getText();
				//[] ima = lblImaCa.(convert(ima));
				long price = Long.parseLong(textField_PriceD.getText());
				
				Drink d = new Drink();
				d.setName(name);
				d.setSize(size);
//				caa.setImage(convert(pic2));
				d.setPrice(price);
				d.setID(idd);
				
				
				
				
				if(drink.update(name, size, ingre, price, idd)
						) {
					JOptionPane.showConfirmDialog(null,"Are you sure you want to update?" ,"Update success!",JOptionPane.YES_NO_OPTION);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
				} catch (Exception e1) {
					 //TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e1);
				}
				
				try {
					Drink d = new Drink();
					d.setID(idd);
//					File file = MenuMana.class.jFileChooserCake.getSelectedFile();
//					ImageIcon i = new ImageIcon(file.getAbsolutePath());
//					Image im = i.getImage().getScaledInstance(210, 161, Image.SCALE_DEFAULT);
//					i = new ImageIcon(im);
					if (pic != "") {
						File file = new File(pic);
						FileInputStream fis = new FileInputStream(file);
						
						byte[] image = new byte[(int) file.length()];
						fis.read(image);
						drink.update1(image, idd);
					}
					
						//JOptionPane.showConfirmDialog(null,"Are you sure you want to update?" ,"Update success!",JOptionPane.YES_NO_OPTION);
					
					
					
					
				}catch(Exception e2) {
					//TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e2);
				}
				
				drink.getAll();
				loadInformationDrink();
				clearDrink();
				
			}
		});
		btnNewButton_UpdateD.setForeground(new Color(0, 64, 128));
		btnNewButton_UpdateD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_UpdateD.setBackground(new Color(230, 255, 255));
		btnNewButton_UpdateD.setBounds(912, 541, 113, 36);
		panelDrink.add(btnNewButton_UpdateD);
		
		btnNewButton_FindD = new JButton("Find");
		btnNewButton_FindD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				String found = textField_FindD.getText(); // chinhs laf cai found nay
//				String name = textField_NameCake.getText();
//			
//			
				FindDrink(found);
			}catch(Exception e2) {
					//TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e2);
			}
				
				
	    }
	});
		btnNewButton_FindD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_FindD.setBackground(new Color(217, 217, 217));
		btnNewButton_FindD.setBounds(1075, 20, 72, 23);
		panelDrink.add(btnNewButton_FindD);
		
		btnFolderD = new JButton("Add image");
		btnFolderD.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(64, 0, 0)));
		btnFolderD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooserDrink = new JFileChooser();
				jFileChooserDrink.setDialogTitle("ADD IMAGE");
				jFileChooserDrink.setMultiSelectionEnabled(false);
				jFileChooserDrink.setFileFilter(new FileTypeFiler(".gif",".GIF"));
				jFileChooserDrink.setFileFilter(new FileTypeFiler(".jpg",".JPG"));
				jFileChooserDrink.setFileFilter(new FileTypeFiler(".png",".PNG"));
				
				int result = jFileChooserDrink.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooserDrink.getSelectedFile();
					ImageIcon i = new ImageIcon(file.getAbsolutePath());
					Image im = i.getImage().getScaledInstance(210, 161, Image.SCALE_DEFAULT);
					i = new ImageIcon(im);
					lblImaD.setIcon(i);
					pic = file.getAbsolutePath().replace("/", "//");
					
				}
			}
		});
		btnFolderD.setBackground(new Color(223, 223, 223));
		btnFolderD.setForeground(new Color(128, 0, 0));
		btnFolderD.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 13));
		btnFolderD.setBounds(736, 194, 113, 38);
		panelDrink.add(btnFolderD);
		
		textField_IDD = new JTextField();
		textField_IDD.setEditable(false);
		textField_IDD.setBounds(882, 58, 210, 36);
		panelDrink.add(textField_IDD);
		textField_IDD.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setBounds(748, 69, 84, 29);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelDrink.add(lblNewLabel_3);
		
		
		//Cookie
		panelCookie = new JPanel();
		panelCookie.setBackground(new Color(255, 221, 221));
		tabbedPane.addTab("Cookies", null, panelCookie, null);
		panelCookie.setLayout(null);
		
		
		lblNewLabel = new JLabel("Cookies Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(25, 11, 274, 43);
		panelCookie.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						MenuMana.class.getResource("/Image/menu.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(282, 11, 54, 38);
		panelCookie.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						MenuMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(791, 11, 41, 36);
		panelCookie.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(748, 105, 84, 29);
		panelCookie.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2 = new JLabel("Image:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(748, 158, 84, 29);
		panelCookie.add(lblNewLabel_1_2);
		
		lblNewLabel_1_4 = new JLabel("Main Ingre:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(748, 313, 160, 29);
		panelCookie.add(lblNewLabel_1_4);
		
		lblNewLabel_1_5 = new JLabel("Price:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(748, 454, 84, 29);
		panelCookie.add(lblNewLabel_1_5);
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 52, 364, 2);
		panelCookie.add(separator);
        
		colist = cookie.getAll();
		table_Cookie = new JTable();
		table_Cookie.setBackground(new Color(206, 206, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Cookie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cookie co = colist.get(table_Cookie.getSelectedRow());
				textField_IDC.setText(""+co.getID());
				textField_NameCo.setText(co.getName());
				textField_PriceCo.setText(""+co.getPrice());
				
				textPane_MainIngreCo.setText(co.getMainIngredients());
				
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(co.getImage()).getImage()
						.getScaledInstance(210, 161, Image.SCALE_SMOOTH));
				lblImaCoo.setIcon(imageIcon);
				pic1 = "";
			}
		});
	
		table_Cookie.setModel(new DefaultTableModel(
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
			 // 
		
		
		
		DefaultTableModel modelCoo = (DefaultTableModel) table_Cookie.getModel();

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
			
	} table_Cookie.setRowHeight(100);
	modelCoo.addRow(rowCoo);
	loadInformationCookie();
		
		table_Cookie.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Cookie = new JScrollPane(table_Cookie);
		scrollPane_Cookie.setBounds(10, 58, 714, 535);
		scrollPane_Cookie.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCookie.add(scrollPane_Cookie);
		
		
		
		textField_FindCo = new JTextField();
//		textField_FindCo.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				String  searchString = textField_FindCo.getText();
//				reseach(searchString);
//				
//			}
//		});
		textField_FindCo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_FindCo.setColumns(10);
		textField_FindCo.setBounds(836, 11, 238, 36);
		panelCookie.add(textField_FindCo);
		
		
		textField_NameCo = new JTextField();
		textField_NameCo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_NameCo.setColumns(10);
		textField_NameCo.setBounds(842, 105, 250, 35);
		panelCookie.add(textField_NameCo);
		
		textPane_MainIngreCo = new JTextPane();
		textPane_MainIngreCo.setBounds(748, 349, 380, 88);
		panelCookie.add(textPane_MainIngreCo);
		
		textField_PriceCo = new JTextField();
		textField_PriceCo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_PriceCo.setColumns(10);
		textField_PriceCo.setBounds(842, 448, 250, 35);
		panelCookie.add(textField_PriceCo);
		
		
		btnNewButton_ExitCo.setForeground(new Color(128, 0, 0));
		btnNewButton_ExitCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_ExitCo.setBackground(new Color(255, 128, 128));
		btnNewButton_ExitCo.setBounds(1046, 505, 72, 61);
		panelCookie.add(btnNewButton_ExitCo);
		
		btnNewButton_DelCo = new JButton("Delete");
		btnNewButton_DelCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cookie.delete(colist.get(table_Cookie.getSelectedRow()).getID())) {
					JOptionPane.showMessageDialog(null, "Delete success!");
					loadInformationCookie();
				}
			}
		});
		btnNewButton_DelCo.setForeground(new Color(0, 64, 128));
		btnNewButton_DelCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_DelCo.setBackground(new Color(230, 255, 255));
		btnNewButton_DelCo.setBounds(774, 494, 113, 36);
		panelCookie.add(btnNewButton_DelCo);
		
		btnNewButton_EditCo = new JButton("Reset");
		btnNewButton_EditCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearCookie();
				loadInformationCookie();
			}
		});
		btnNewButton_EditCo.setForeground(new Color(0, 64, 128));
		btnNewButton_EditCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_EditCo.setBackground(new Color(230, 255, 255));
		btnNewButton_EditCo.setBounds(912, 494, 113, 36);
		panelCookie.add(btnNewButton_EditCo);
		
		btnNewButton_AddCo = new JButton("Add");
		btnNewButton_AddCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_NameCo.getText();
				
				String ingre = textPane_MainIngreCo.getText();
				long price = Long.parseLong(textField_PriceCo.getText());
				if(cookie.add(name, pic1, ingre, price)) {
					JOptionPane.showMessageDialog(null, "Add success!");
					clearCookie();
					loadInformationCookie();
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
			
				
			}
		});
		btnNewButton_AddCo.setForeground(new Color(0, 64, 128));
		btnNewButton_AddCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_AddCo.setBackground(new Color(230, 255, 255));
		btnNewButton_AddCo.setBounds(774, 541, 113, 36);
		panelCookie.add(btnNewButton_AddCo);
		
		btnNewButton_UpdateCo = new JButton("Update");
		btnNewButton_UpdateCo.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent e) {
				int idco = Integer.parseInt(textField_IDC.getText());
				try {
				String name = textField_NameCo.getText();
                //byte[] b = pic2.getBytes();
				String ingre = textPane_MainIngreCo.getText();
				//[] ima = lblImaCa.(convert(ima));
				long price = Long.parseLong(textField_PriceCo.getText());
				
				Cookie coo = new Cookie();
				coo.setName(name);
//				caa.setImage(convert(pic2));
				coo.setPrice(price);
				coo.setID(idco);
				
				
				
				
				if(cookie.update(name, ingre, price, idco)
						) {
					JOptionPane.showConfirmDialog(null,"Are you sure you want to update?" ,"Update success!",JOptionPane.YES_NO_OPTION);
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
				} catch (Exception e1) {
					 //TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e1);
				}
				
				try {
					Cookie coo = new Cookie();
					coo.setID(idco);
//					File file = MenuMana.class.jFileChooserCake.getSelectedFile();
//					ImageIcon i = new ImageIcon(file.getAbsolutePath());
//					Image im = i.getImage().getScaledInstance(210, 161, Image.SCALE_DEFAULT);
//					i = new ImageIcon(im);
					if(pic1 != "") {
						File file = new File(pic1);
						FileInputStream fis = new FileInputStream(file);
						
						byte[] image = new byte[(int) file.length()];
						fis.read(image);
						
					cookie.update1(image, idco);
					}
					
						//JOptionPane.showConfirmDialog(null,"Are you sure you want to update?" ,"Update success!",JOptionPane.YES_NO_OPTION);
					
					
					
					
				}catch(Exception e2) {
					//TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e2);
				}
				
				cookie.getAll();
				loadInformationCookie();
				clearCookie();
				
			}
		});
		btnNewButton_UpdateCo.setForeground(new Color(0, 64, 128));
		btnNewButton_UpdateCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_UpdateCo.setBackground(new Color(230, 255, 255));
		btnNewButton_UpdateCo.setBounds(912, 541, 113, 36);
		panelCookie.add(btnNewButton_UpdateCo);
		
		btnNewButton_FindCo = new JButton("Find");
		btnNewButton_FindCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				String found = textField_FindCo.getText(); // chinhs laf cai found nay
//				String name = textField_NameCake.getText();
//			
//			
				FindCookie(found);
			}catch(Exception e2) {
					//TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e2);
			}
				
				
	    }
	});
		btnNewButton_FindCo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_FindCo.setBackground(new Color(217, 217, 217));
		btnNewButton_FindCo.setBounds(1075, 20, 72, 23);
		panelCookie.add(btnNewButton_FindCo);
		
		
		lblImaCoo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblImaCoo.setBounds(875, 151, 210, 161);
		panelCookie.add(lblImaCoo);
		
		btnFolderCoo = new JButton("Get image");
		btnFolderCoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser_Cookie = new JFileChooser();
				jFileChooser_Cookie.setDialogTitle("ADD IMAGE");
				jFileChooser_Cookie.setMultiSelectionEnabled(false);
				jFileChooser_Cookie.setFileFilter(new FileTypeFiler(".gif",".GIF"));
				jFileChooser_Cookie.setFileFilter(new FileTypeFiler(".jpg",".JPG"));
				jFileChooser_Cookie.setFileFilter(new FileTypeFiler(".png",".PNG"));
				
				int result = jFileChooser_Cookie.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser_Cookie.getSelectedFile();
					ImageIcon i = new ImageIcon(file.getAbsolutePath());
					Image im = i.getImage().getScaledInstance(210, 161, Image.SCALE_DEFAULT);
					i = new ImageIcon(im);
					lblImaCoo.setIcon(i);
					pic1 = file.getAbsolutePath().replace("/", "//");
					
				}
			}
		});
		btnFolderCoo.setForeground(new Color(128, 0, 0));
		btnFolderCoo.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 13));
		btnFolderCoo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(64, 0, 0)));
		btnFolderCoo.setBackground(new Color(223, 223, 223));
		btnFolderCoo.setBounds(730, 186, 113, 38);
		panelCookie.add(btnFolderCoo);
		
		textField_IDC = new JTextField();
		textField_IDC.setEditable(false);
		textField_IDC.setColumns(10);
		textField_IDC.setBounds(844, 58, 246, 36);
		panelCookie.add(textField_IDC);
		
		lblNewLabel_4 = new JLabel("ID:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(748, 58, 84, 29);
		panelCookie.add(lblNewLabel_4);
		
		
		
		
		
		
		//Cake
		panelCake = new JPanel();
		panelCake.setBackground(new Color(255, 198, 198));
		tabbedPane.addTab("Cakes", null, panelCake, null);
		panelCake.setLayout(null);
		
		lblNewLabel = new JLabel("Cakes Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(34, 11, 274, 43);
		panelCake.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						MenuMana.class.getResource("/Image/menu.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(254, 11, 54, 38);
		panelCake.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						MenuMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(791, 11, 41, 36);
		panelCake.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(748, 105, 84, 29);
		panelCake.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2 = new JLabel("Image:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(748, 162, 84, 29);
		panelCake.add(lblNewLabel_1_2);
		
		lblNewLabel_1_4 = new JLabel("Main Ingre:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(746, 326, 160, 29);
		panelCake.add(lblNewLabel_1_4);
		
		lblNewLabel_1_5 = new JLabel("Price:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(748, 454, 84, 29);
		panelCake.add(lblNewLabel_1_5);
		
		separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(10, 52, 364, 2);
		panelCake.add(separator);
		
		list = cakes.getAll();
		table_Cake = new JTable();
		table_Cake.setBackground(new Color(198, 255, 198));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_Cake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Cakes ca = list.get(table_Cake.getSelectedRow());
				textField_IDCa.setText(""+ca.getID());
				textField_NameCake.setText(ca.getName());
				textField_PriceCake.setText(""+ca.getPrice());
			
				textPane_MainIngreCake.setText(ca.getMainIngredients());
				
				ImageIcon imageIcon = new ImageIcon(new ImageIcon(ca.getImage()).getImage()
						.getScaledInstance(210, 161, Image.SCALE_SMOOTH));
				
				lblImaCa.setIcon(imageIcon);
				pic2 = "";
			}
		});
		
		
		table_Cake.setModel(new DefaultTableModel(
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
		
		
		//
		DefaultTableModel modelCa = (DefaultTableModel) table_Cake.getModel();

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
		 table_Cake.setRowHeight(100);
	     modelCa.addRow(rowCa);
	     loadInformationCake();
		table_Cake.setBounds(375, 91, 889, 422);
		JScrollPane scrollPane_Cake = new JScrollPane(table_Cake);
		scrollPane_Cake.setBounds(10, 58, 714, 535);
		scrollPane_Cake.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelCake.add(scrollPane_Cake);
		
		
		
		textField_FindCake = new JTextField();
//		textField_FindCake.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				String  searchString = textField_FindCake.getText();
//				reseach(searchString);
//				
//			}
//		});
		textField_FindCake.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_FindCake.setColumns(10);
		textField_FindCake.setBounds(836, 11, 238, 36);
		panelCake.add(textField_FindCake);
		
		
		textField_NameCake = new JTextField();
		textField_NameCake.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_NameCake.setColumns(10);
		textField_NameCake.setBounds(842, 105, 250, 35);
		panelCake.add(textField_NameCake);
		
		textPane_MainIngreCake = new JTextPane();
		textPane_MainIngreCake.setBounds(748, 357, 380, 86);
		panelCake.add(textPane_MainIngreCake);
		
		textField_PriceCake = new JTextField();
		textField_PriceCake.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_PriceCake.setColumns(10);
		textField_PriceCake.setBounds(842, 451, 250, 35);
		panelCake.add(textField_PriceCake);
		
		
		btnNewButton_ExitCake.setForeground(new Color(128, 0, 0));
		btnNewButton_ExitCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_ExitCake.setBackground(new Color(255, 128, 128));
		btnNewButton_ExitCake.setBounds(1046, 505, 72, 61);
		panelCake.add(btnNewButton_ExitCake);
		
		btnNewButton_DelCake = new JButton("Delete");
		btnNewButton_DelCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cakes.delete(list.get(table_Cake.getSelectedRow()).getID())) {
					JOptionPane.showMessageDialog(null, "Delete success!");
					loadInformationCake();
				}
			}
				
			
		});
		btnNewButton_DelCake.setForeground(new Color(0, 64, 128));
		btnNewButton_DelCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_DelCake.setBackground(new Color(230, 255, 255));
		btnNewButton_DelCake.setBounds(774, 494, 113, 36);
		panelCake.add(btnNewButton_DelCake);
		
		btnNewButton_EditCake = new JButton("Reset");
		btnNewButton_EditCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField_FindCake.setText("");
				clearCake();
//				cakes.getAll();
				loadInformationCake();
				
			}
		});
		btnNewButton_EditCake.setForeground(new Color(0, 64, 128));
		btnNewButton_EditCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_EditCake.setBackground(new Color(230, 255, 255));
		btnNewButton_EditCake.setBounds(912, 494, 113, 36);
		panelCake.add(btnNewButton_EditCake);
		
		btnNewButton_AddCake = new JButton("Add");
		btnNewButton_AddCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_NameCake.getText();
				
				String ingre = textPane_MainIngreCake.getText();
				long price = Long.parseLong(textField_PriceCake.getText());
				if(cakes.add(name, pic2, ingre, price)) {
					JOptionPane.showMessageDialog(null, "Add success!");
					clearCake();
					loadInformationCake();
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}}
		});
		btnNewButton_AddCake.setForeground(new Color(0, 64, 128));
		btnNewButton_AddCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_AddCake.setBackground(new Color(230, 255, 255));
		btnNewButton_AddCake.setBounds(774, 541, 113, 36);
		panelCake.add(btnNewButton_AddCake);
		
		btnNewButton_UpdateCake = new JButton("Update");
		btnNewButton_UpdateCake.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent e) {
				int idca = Integer.parseInt(textField_IDCa.getText());
				try {
				String name = textField_NameCake.getText();
                //byte[] b = pic2.getBytes();
				String ingre = textPane_MainIngreCake.getText();
				//[] ima = lblImaCa.(convert(ima));
				long price = Long.parseLong(textField_PriceCake.getText());
				
				Cakes caa = new Cakes();
				caa.setName(name);
//				caa.setImage(convert(pic2));
				caa.setPrice(price);
				caa.setID(idca);
				
				
				
				
				if(cakes.update(name, ingre, price, idca)
						) {
					JOptionPane.showConfirmDialog(null,"Are you sure you want to update?" ,"Update success!",JOptionPane.YES_NO_OPTION);
					 
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
				} catch (Exception e1) {
					 //TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e1);
				}
				
				try {
					Cakes caa = new Cakes();
					caa.setID(idca);
//					File file = MenuMana.class.jFileChooserCake.getSelectedFile();
//					ImageIcon i = new ImageIcon(file.getAbsolutePath());
//					Image im = i.getImage().getScaledInstance(210, 161, Image.SCALE_DEFAULT);
//					i = new ImageIcon(im)
					if (pic2 != "") {
						File file = new File(pic2);
						FileInputStream fis = new FileInputStream(file);
						
						byte[] image = new byte[(int) file.length()];
						fis.read(image);
						
						cakes.update1(image, idca);
					}
					
						//JOptionPane.showConfirmDialog(null,"Are you sure you want to update?" ,"Update success!",JOptionPane.YES_NO_OPTION);
					
					
					
					
				}catch(Exception e2) {
					//TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e2);
				}
				
				cakes.getAll();
				loadInformationCake();
				clearCake();
				
			}
		});

               
		btnNewButton_UpdateCake.setForeground(new Color(0, 64, 128));
		btnNewButton_UpdateCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_UpdateCake.setBackground(new Color(230, 255, 255));
		btnNewButton_UpdateCake.setBounds(912, 541, 113, 36);
		panelCake.add(btnNewButton_UpdateCake);
		
		btnNewButton_FindCake = new JButton("Find");
		btnNewButton_FindCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				String found = textField_FindCake.getText(); // chinhs laf cai found nay
//				String name = textField_NameCake.getText();
//			
//			
				FindCake(found);
			}catch(Exception e2) {
					//TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e2);
			}
				
				
	    }
	});
		btnNewButton_FindCake.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_FindCake.setBackground(new Color(217, 217, 217));
		btnNewButton_FindCake.setBounds(1075, 20, 72, 23);
		panelCake.add(btnNewButton_FindCake);
		
		
		lblImaCa.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblImaCa.setBounds(882, 151, 210, 161);
		panelCake.add(lblImaCa);
		
		btnFolderCa = new JButton("Get image");
		btnFolderCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooserCake = new JFileChooser();
				jFileChooserCake.setDialogTitle("ADD IMAGE");
				jFileChooserCake.setMultiSelectionEnabled(false);
				jFileChooserCake.setFileFilter(new FileTypeFiler(".gif",".GIF"));
				jFileChooserCake.setFileFilter(new FileTypeFiler(".jpg",".JPG"));
				jFileChooserCake.setFileFilter(new FileTypeFiler(".png",".PNG"));
				
				int result = jFileChooserCake.showOpenDialog(null);
				
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooserCake.getSelectedFile();
					ImageIcon i = new ImageIcon(file.getAbsolutePath());
					Image im = i.getImage().getScaledInstance(210, 161, Image.SCALE_DEFAULT);
					i = new ImageIcon(im);
					lblImaCa.setIcon(i);
					pic2 = file.getAbsolutePath().replace("/", "//");
					
					
				}
				
			}
		});
		btnFolderCa.setForeground(new Color(128, 0, 0));
		btnFolderCa.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 13));
		btnFolderCa.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(64, 0, 0)));
		btnFolderCa.setBackground(new Color(223, 223, 223));
		btnFolderCa.setBounds(734, 189, 113, 38);
		panelCake.add(btnFolderCa);
		
		textField_IDCa = new JTextField();
		textField_IDCa.setEditable(false);
		textField_IDCa.setColumns(10);
		textField_IDCa.setBounds(846, 58, 246, 36);
		panelCake.add(textField_IDCa);
		
		lblNewLabel_5 = new JLabel("ID:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(748, 65, 84, 29);
		panelCake.add(lblNewLabel_5);
		
		
		
		
	}
	
	//cai ham load nay, sau copy r ghi la ham loadFindD, chu y 1
	private void loadInformationDrink() {
		table_Drink.setModel(new DefaultTableModel(
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
		DefaultTableModel modelDrink = (DefaultTableModel) table_Drink.getModel();
	
			table_Drink.setRowHeight(80);
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
	
	private void loadInformationCookie() {
		table_Cookie.setModel(new DefaultTableModel(
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
		DefaultTableModel modelCookie = (DefaultTableModel) table_Cookie.getModel();
		
		table_Cookie.setRowHeight(80);
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
	
	private void loadInformationCake() {
		table_Cake.setModel(new DefaultTableModel(
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
		  modelCa = (DefaultTableModel) table_Cake.getModel();
		 table_Cake.setRowHeight(80);
			list = cakes.getAll();
			table_Cake.setRowSorter(null);
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
	
	
	
	private void FindDrink(String found) // find nayf 
	{
		table_Drink.setModel(new DefaultTableModel(
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
		DefaultTableModel modelDrink = (DefaultTableModel) table_Drink.getModel();
	
			table_Drink.setRowHeight(80);
			dlist = drink.find(found); // goi ham tim kiem bang sql. cai ham do tra ve 1 mang da tim dc. r them cai du lieu do vao bang hien tai
			table_Drink.setRowSorter(null);
			
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
	
	private void FindCookie(String found) // find nayf 
	{
		table_Cookie.setModel(new DefaultTableModel(
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
		DefaultTableModel modelCookie = (DefaultTableModel) table_Cookie.getModel();
		
		table_Cookie.setRowHeight(80);
		colist = cookie.find(found); // goi ham tim kiem bang sql. cai ham do tra ve 1 mang da tim dc. r them cai du lieu do vao bang hien tai
		table_Cookie.setRowSorter(null);
		
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
	
	
	// ham do du lieu tim duoc vao bang
	private void FindCake(String found) // find nayf 
	{
		table_Cake.setModel(new DefaultTableModel(
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
		  modelCa = (DefaultTableModel) table_Cake.getModel();
		 table_Cake.setRowHeight(80);
			list = cakes.find(found); // goi ham tim kiem bang sql. cai ham do tra ve 1 mang da tim dc. r them cai du lieu do vao bang hien tai
			table_Cake.setRowSorter(null);
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
	
	void clearCake() {
		textField_IDCa.setText("");
		lblImaCa.setIcon(null);
		textField_NameCake.setText("");
		textPane_MainIngreCake.setText("");
		textField_PriceCake.setText("");
		textField_FindCake.setText("");
		
	}
	void clearCookie() {
		textField_IDC.setText("");
		lblImaCoo.setIcon(null);
		textField_NameCo.setText("");
		textPane_MainIngreCo.setText("");
		textField_PriceCo.setText("");
		textField_FindCo.setText("");
	}
	void clearDrink() {
		textField_IDD.setText("");
		lblImaD.setIcon(null);
		textField_NameD.setText("");
		textField_SizeD.setText("");
		textPane_MainIngreD.setText("");
		textField_PriceD.setText("");
		textField_FindD.setText("");
	
	}
	
	public void reseach ( String str) {
		modelCa = (DefaultTableModel) table_Cake.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelCa);
		table_Cake.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
	}
	

}
