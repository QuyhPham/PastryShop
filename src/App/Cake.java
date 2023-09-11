package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.BillConnect;
import Database.CakeConnect;
import Database.ColorConnect;
import Database.FruitConnect;
import Database.PartConnect;
import Database.ShapeConnect;
import Database.TasteConnect;
import Database.TierConnect;
import Normal.Bill;
import Normal.Colour;
import Normal.Fruit;
import Normal.Part;
import Normal.Shape;
import Normal.Taste;
import Normal.Tier;

import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class Cake extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	public JButton btnExit = new JButton("Exit");
	public JButton btnNewButton = new JButton("Price List");
	public JButton btnIntroduce = new JButton("Introduce");
	private ShapeConnect shape = new ShapeConnect();
	private ColorConnect color = new ColorConnect();
	private TierConnect tier = new TierConnect();
	private FruitConnect fruit = new FruitConnect();
	private PartConnect part = new PartConnect();
	private TasteConnect taste = new TasteConnect();
	public int ID = -1;
	private BillConnect bi = new BillConnect();
	ArrayList<Shape> sli = shape.getAll();
	ArrayList<Colour> cli = color.getAll();
	ArrayList<Tier> tili = tier.getAll();
	ArrayList<Fruit> fli = fruit.getAll();
	ArrayList<Part> pli = part.getAll();
	ArrayList<Taste> tali = taste.getAll();
	ArrayList<Bill> bilist = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cake frame = new Cake();
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
	public Cake() {
		
		setForeground(new Color(128, 0, 0));
		this.setTitle("Pre-Order");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Cake.class.getResource("/Image/cake.jpg"))));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 730);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 202, 202));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 202, 202));
		contentPane.add(panel_1);
		panel_1.setBounds(0, 0, 1186, 329);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shape:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(35, 28, 114, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Color:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 77, 114, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tier:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(35, 126, 114, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fruit:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(35, 175, 114, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Part:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(35, 224, 114, 25);
		panel_1.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(shape.getShape()));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(114, 23, 225, 35);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(color.getColor()));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(114, 72, 225, 35);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(tier.getTier()));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setBounds(114, 121, 225, 35);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(fruit.getFruit()));
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_3.setBounds(114, 170, 225, 35);
		panel_1.add(comboBox_3);
		
		JComboBox comboBox_3_1 = new JComboBox();
		comboBox_3_1.setModel(new DefaultComboBoxModel(part.getPart()));
		comboBox_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_3_1.setBounds(114, 219, 225, 35);
		panel_1.add(comboBox_3_1);
		
		JLabel lblTaste = new JLabel("Taste:");
		lblTaste.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTaste.setBounds(425, 28, 114, 25);
		panel_1.add(lblTaste);
		
		JLabel lblTimeGet = new JLabel("Time get:");
		lblTimeGet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimeGet.setBounds(425, 77, 114, 25);
		panel_1.add(lblTimeGet);
		
		JLabel lblNewLabel_7 = new JLabel("Other requirements:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(425, 126, 204, 25);
		panel_1.add(lblNewLabel_7);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(taste.getTaste()));
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_4.setBounds(506, 23, 225, 35);
		panel_1.add(comboBox_4);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPane.setBounds(425, 150, 306, 104);
		panel_1.add(textPane);
		
		textField = new JTextField();
		textField.setBounds(506, 72, 225, 35);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Cake.class.getResource("/Image/Gato.png")
						)
				).getImage().getScaledInstance(327, 271, Image.SCALE_DEFAULT)));
		lblNewLabel_5.setBounds(810, 23, 327, 271);
		panel_1.add(lblNewLabel_5);
		
		
		
		
		btnNewButton.setForeground(new Color(64, 0, 0));
		btnNewButton.setBackground(new Color(236, 220, 220));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(588, 280, 114, 35);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m =  (DefaultTableModel) table.getModel();
				Object[] row = new Object[9];
				row[0] = sli.get(comboBox.getSelectedIndex()).getShape();
				row[1] = cli.get(comboBox_1.getSelectedIndex()).getColor();
				row[2] = tili.get(comboBox_2.getSelectedIndex()).getTier();
				row[3] = fli.get(comboBox_3.getSelectedIndex()).getFruit();
				row[4] = pli.get(comboBox_3_1.getSelectedIndex()).getPart();
				row[5] = tali.get(comboBox_4.getSelectedIndex()).getTaste();
				row[6] = textField.getText();
				row[7] = textPane.getText();
				long total = sli.get(comboBox.getSelectedIndex()).getPrice() 
						+ cli.get(comboBox_1.getSelectedIndex()).getPrice()
						+ tili.get(comboBox_2.getSelectedIndex()).getPrice()
						+ fli.get(comboBox_3.getSelectedIndex()).getPrice()
						+ pli.get(comboBox_3_1.getSelectedIndex()).getPrice()
						+ tali.get(comboBox_4.getSelectedIndex()).getPrice();
				row[8] = total;
				
				
				m.addRow(row);
			}
		});
		btnNewButton_1.setForeground(new Color(64, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(236, 220, 220));
		btnNewButton_1.setBounds(461, 280, 104, 35);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Note: Payment by bank transfer. Details in");
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_1.setBounds(10, 275, 288, 34);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("--->");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2_1.setBounds(215, 302, 45, 25);
		panel_1.add(lblNewLabel_2_1);
		
		
		
		btnIntroduce.setForeground(new Color(128, 0, 255));
		btnIntroduce.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnIntroduce.setBackground(new Color(255, 202, 202));
		btnIntroduce.setBounds(250, 305, 85, 20);
		panel_1.add(btnIntroduce);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 168, 168));
		panel_2.setBounds(0, 329, 1186, 364);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel m = (DefaultTableModel) table.getModel();
				m.removeRow(table.getSelectedRow());
			}
		});
		btnNewButton_2.setForeground(new Color(128, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBackground(new Color(236, 220, 220));
		btnNewButton_2.setBounds(814, 296, 105, 40);
		panel_2.add(btnNewButton_2);
		
		JButton btnResett = new JButton("Reset");
		btnResett.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Shape", "Color", "Tier", "Fruit", "Part", "Taste", "Time get", "Other requirements", "Total"
						}
							) {
								boolean[] columnEdittables = new boolean[] {
										false, false, false, false, false, false, false, false, false
								};
								public boolean isCellEditable(int row, int column) {
									return columnEdittables[column];
								}
								Class[] columnTypes = new Class[] {
									Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Long.class
								};
								public Class getColumnClass(int columnIndex) {
									return columnTypes[columnIndex];
								}
							} );
			}
		});
		btnResett.setForeground(new Color(128, 0, 0));
		btnResett.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnResett.setBackground(new Color(236, 220, 220));
		btnResett.setBounds(929, 296, 105, 40);
		panel_2.add(btnResett);
		
		
		
		btnExit.setForeground(new Color(128, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBackground(new Color(236, 220, 220));
		btnExit.setBounds(1044, 296, 105, 40);
		panel_2.add(btnExit);
		
		table = new JTable();
		table.setBackground(new Color(193, 193, 255));
		//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Shape", "Color", "Tier", "Fruit", "Part", "Taste", "Time get", "Other requirements", "Total"
					}
						) {
							boolean[] columnEdittables = new boolean[] {
									false, false, false, false, false, false, false, false, false
							};
							public boolean isCellEditable(int row, int column) {
								return columnEdittables[column];
							}
							Class[] columnTypes = new Class[] {
								Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Long.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						} );
				table.getColumnModel().getColumn(0).setPreferredWidth(49);
				table.getColumnModel().getColumn(1).setPreferredWidth(44);
				table.getColumnModel().getColumn(2).setPreferredWidth(23);
				table.getColumnModel().getColumn(3).setPreferredWidth(49);
				table.getColumnModel().getColumn(4).setPreferredWidth(72);
				table.getColumnModel().getColumn(5).setPreferredWidth(52);
				table.getColumnModel().getColumn(7).setPreferredWidth(193);
				table.getColumnModel().getColumn(8).setPreferredWidth(100);
				
				
				table.setBounds(0, 11, 1186, 236);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(0, 0, 1186, 271);
				panel_2.add(scrollPane);
				
				JLabel lblNewLabel_6 = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								Cake.class.getResource("/Image/gato1.jpg")
								)
						).getImage().getScaledInstance(535, 79, Image.SCALE_DEFAULT)));
				lblNewLabel_6.setBounds(70, 282, 535, 79);
				panel_2.add(lblNewLabel_6);
				
				JButton btnNewButton_2_1 = new JButton("Order");
				btnNewButton_2_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bill b = new Bill();
						String name = "";
//						String shap = "";
//						String clo = "";
//						String tie = "";
//						String frut = "";
//						String par = "";
//						String tast = "";
						String timeget = "";
						long price = 0;
						//4.
						DefaultTableModel m = (DefaultTableModel) table.getModel();
						for (int i = 0; i < m.getRowCount(); i++) {
							name +=i+1 + ":" +  m.getValueAt(i, 0) + ", "
							 + m.getValueAt(i, 1) + ", "
							 + m.getValueAt(i, 2) + ", "
							 + m.getValueAt(i, 3) + ", "
							 + m.getValueAt(i, 4) + ", "
							 + m.getValueAt(i, 5) + "; ";
							timeget += i+1 + ":" + m.getValueAt(i, 6) + ";";
							price += Long.parseLong(m.getValueAt(i, 8).toString());// (i,2)
							
						}
//						String good = shap + clo + tie + frut + par +tast;
						//Revenue: lay nguyen khuc 4. vut cai a di, doi table bang cai table cua revenue, (i,?)
						// TextField: nametxt.setText(price); con neu loi, thi hay .to?
						String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
						b.setIDC(ID);
						b.setDateOrder(timeStamp);
						b.setDatePay(timeStamp);
						b.setPrice(price);
						b.setGood(name);
//						
						b.setItem("PreOrder");
						bi.addbillGetNow(b);
							String msg = "";
							msg += "------------------------------\n";
							JOptionPane.showMessageDialog(null, "Goods Purchased: " + name +"\n"+ timeget  + "\n"+ msg + "Total: " + price + "\n Date :" + timeStamp);
					}
				});
				btnNewButton_2_1.setForeground(new Color(128, 0, 0));
				btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton_2_1.setBackground(new Color(236, 220, 220));
				btnNewButton_2_1.setBounds(699, 296, 105, 40);
				panel_2.add(btnNewButton_2_1);
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	

}
