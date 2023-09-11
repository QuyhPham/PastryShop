package Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Database.ConnectDatabase;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
//import Normal.List;
//import Normal.Employee;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.Icon;


public class Manager extends JFrame {
//	List N;
//	Employee E;

	private JPanel contentPane;
	private JTextField txtWhatDoYou;
	JTable table;
	private JTextField textField_CCCD;
	private JTextField textField_ID;
	private JTextField textField_Name;
	private JTextField textField_Phone;
	private JTextField textField_Exp;
	ConnectDatabase con = new ConnectDatabase();
	private JTextField textField_Date;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_TotalMotor;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_2;
	public DefaultTableModel model;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager() {
//		this.setVisible(true);
//		this.N = new List();
//		this.E = new Employee();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 121));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 200, 200));
		tabbedPane.setForeground(new Color(128, 0, 0));
		tabbedPane.setFont(new Font("Sylfaen", Font.BOLD, 25));
		tabbedPane.setBounds(10, 0, 1389, 652);
		contentPane.add(tabbedPane);
		
		
		//bang nhan vien
		JPanel panelManager = new JPanel();
		panelManager.setBackground(new Color(254, 231, 203));
		tabbedPane.addTab("Employee", null, panelManager, null);
		panelManager.setLayout(null);
		
		JRadioButton jrdBoy = new JRadioButton("Boy");
		jrdBoy.setBackground(new Color(254, 231, 203));
		jrdBoy.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jrdBoy.setBounds(104, 294, 84, 23);
		panelManager.add(jrdBoy);
		
		JRadioButton jrdGirl = new JRadioButton("Girl");
		jrdGirl.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jrdGirl.setBackground(new Color(254, 231, 203));
		jrdGirl.setBounds(212, 294, 84, 23);
		panelManager.add(jrdGirl);
		
		ButtonGroup btnSex = new ButtonGroup();
		btnSex.add(jrdBoy);
		btnSex.add(jrdGirl);
		
		textField_Date = new JTextField();
		textField_Date.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Date.setColumns(10);
		textField_Date.setBounds(106, 230, 236, 35);
		panelManager.add(textField_Date);
		
		
		txtWhatDoYou = new JTextField();
		txtWhatDoYou.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtWhatDoYou.setBounds(823, 11, 327, 36);
		panelManager.add(txtWhatDoYou);
		txtWhatDoYou.setColumns(10);
		
		JButton btnNewButton_Find = new JButton("Find");
		btnNewButton_Find.setBackground(new Color(217, 217, 217));
		btnNewButton_Find.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Find.setBounds(1160, 16, 72, 23);
		panelManager.add(btnNewButton_Find);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Manager.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(772, 11, 41, 36);
		lblNewLabel.setSize(41,36);
		panelManager.add(lblNewLabel);
		
		
		JButton btnNewButton_Update = new JButton("Update");
		btnNewButton_Update.setForeground(new Color(0, 64, 128));
		btnNewButton_Update.setBackground(new Color(230, 255, 255));
		btnNewButton_Update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Update.setBounds(1130, 545, 113, 36);
		panelManager.add(btnNewButton_Update);
		
		JButton btnNewButton_Del = new JButton("Delete");
		btnNewButton_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_CCCD.setText("");
				textField_ID.setText("");
				 textField_Name.setText("");
				 textField_Date.setText("");
				btnSex.clearSelection();
				 textField_Phone.setText("");
				 textField_Exp.setText("");
				 txtWhatDoYou.setText("");
			}
		});
		btnNewButton_Del.setForeground(new Color(0, 64, 128));
		btnNewButton_Del.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Del.setBackground(new Color(230, 255, 255));
		btnNewButton_Del.setBounds(22, 545, 113, 36);
		panelManager.add(btnNewButton_Del);
		
		JButton btnNewButton_Add = new JButton("Add");
//		btnNewButton_Add.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (e.getActionCommand()=="Add") {
////					Employee em = new Employee();
////					em.setID(textField_ID.getText());
////					em.setName(textField_Name.getText());
////					
////					try {
////					em.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(textField_Date.getText())); 
////					} catch (ParseException ex) { 
////						ex.printStackTrace();}
////					em.setSex(jrdBoy.isSelected());
////					em.setCCCD(Float.parseFloat(textField_CCCD.getText()));
////					em.setPhone(Float.parseFloat(textField_Phone.getText()));
////					em.setExp(textField_Exp.getText());
////					
////					if(addEmployee(em)) {
////						refesh();
////					} else {
////						System.out.println("Error");
////					}
////				}
//			}
//		});
		btnNewButton_Add.setForeground(new Color(0, 64, 128));
		btnNewButton_Add.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Add.setBackground(new Color(230, 255, 255));
		btnNewButton_Add.setBounds(145, 545, 113, 36);
		panelManager.add(btnNewButton_Add);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(22, 117, 72, 29);
		panelManager.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(22, 174, 84, 29);
		panelManager.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(22, 231, 72, 29);
		panelManager.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CCCD:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(22, 345, 72, 29);
		panelManager.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Sex:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(22, 288, 72, 29);
		panelManager.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Phone:");
		lblNewLabel_1_5.setBackground(new Color(240, 240, 240));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBounds(22, 402, 104, 29);
		panelManager.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Exp:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_6.setBounds(22, 459, 149, 29);
		panelManager.add(lblNewLabel_1_6);
		
		textField_CCCD = new JTextField();
		textField_CCCD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_CCCD.setBounds(104, 342, 238, 35);
		panelManager.add(textField_CCCD);
		textField_CCCD.setColumns(10);
		
		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_ID.setColumns(10);
		textField_ID.setBounds(104, 114, 238, 35);
		panelManager.add(textField_ID);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Name.setColumns(10);
		textField_Name.setBounds(104, 171, 238, 35);
		panelManager.add(textField_Name);
		
		textField_Phone = new JTextField();
		textField_Phone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(104, 399, 238, 35);
		panelManager.add(textField_Phone);
		
		textField_Exp = new JTextField();
		textField_Exp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Exp.setColumns(10);
		textField_Exp.setBounds(104, 456, 238, 35);
		panelManager.add(textField_Exp);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("The list of Employee");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2.setBounds(70, 20, 373, 43);
		panelManager.add(lblNewLabel_2);
		
		JButton btnNewButton_Edit = new JButton("Edit");
		btnNewButton_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_Edit.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Edit.setBackground(new Color(230, 255, 255));
		btnNewButton_Edit.setBounds(268, 545, 113, 36);
		panelManager.add(btnNewButton_Edit);
		
		table = new JTable();
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Date", "Sex", "CCCD", "Phone", "Exp"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setPreferredWidth(145);
		table.getColumnModel().getColumn(3).setPreferredWidth(54);
		table.getColumnModel().getColumn(6).setPreferredWidth(147);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
		table.setBounds(375, 91, 889, 422);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBounds(375, 91, 889, 422);
		panelManager.add(scrollPane);
		
		
		
		//bang thong ke
		
		JPanel panelManager_1 = new JPanel();
		panelManager_1.setBackground(new Color(207, 248, 250));
		panelManager.setBackground(new Color(254, 231, 203));
		tabbedPane.addTab("Statistic", null, panelManager_1, null);
		panelManager_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Manager.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));;
		lblNewLabel_3.setBounds(772, 11, 41, 36);
		panelManager_1.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBounds(823, 11, 327, 36);
		panelManager_1.add(textField);
		
		JButton btnNewButton_Find_1 = new JButton("Find");
		btnNewButton_Find_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Find_1.setBackground(new Color(217, 217, 217));
		btnNewButton_Find_1.setBounds(1160, 20, 72, 23);
		panelManager_1.add(btnNewButton_Find_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"No", "Code Bill", "Date", "Vehicle", "Code Driver", "Pay", "Detail"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(20);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(72);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(95);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(145);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(121);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(147);
		table_1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
		table_1.setBounds(375, 91, 889, 422);
		
		
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(9, 91, 909, 451);
		panelManager_1.add(scrollPane_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Revenue Statistics");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2_1.setBounds(65, 24, 373, 43);
		panelManager_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_7 = new JLabel("Motorcycle:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_7.setBounds(940, 164, 130, 29);
		panelManager_1.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_4 = new JLabel("- Summary -");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_4.setBounds(1012, 91, 199, 36);
		panelManager_1.add(lblNewLabel_4);
		
		textField_TotalMotor = new JTextField();
		textField_TotalMotor.setEditable(false);
		textField_TotalMotor.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_TotalMotor.setColumns(10);
		textField_TotalMotor.setBounds(1062, 160, 205, 35);
		panelManager_1.add(textField_TotalMotor);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Car:");
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_7_1.setBounds(940, 236, 130, 29);
		panelManager_1.add(lblNewLabel_1_7_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(1062, 230, 205, 35);
		panelManager_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(1062, 301, 205, 35);
		panelManager_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_3.setColumns(10);
		textField_3.setBounds(1062, 370, 205, 35);
		panelManager_1.add(textField_3);
		
		JLabel lblNewLabel_4_1 = new JLabel("- Total Revenue -");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_4_1.setBounds(964, 444, 283, 36);
		panelManager_1.add(lblNewLabel_4_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField_4.setColumns(10);
		textField_4.setBounds(964, 512, 283, 51);
		panelManager_1.add(textField_4);
		
		JLabel lblNewLabel_1_7_2 = new JLabel("Bus:");
		lblNewLabel_1_7_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_7_2.setBounds(940, 307, 130, 29);
		panelManager_1.add(lblNewLabel_1_7_2);
		
		JLabel lblNewLabel_1_7_3 = new JLabel("Truck:");
		lblNewLabel_1_7_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1_7_3.setBounds(940, 376, 130, 29);
		panelManager_1.add(lblNewLabel_1_7_3);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(254, 231, 203));
		btnNewButton.setBounds(57, 553, 124, 40);
		panelManager_1.add(btnNewButton);
		
		//bang bill
		JPanel panelManager_2 = new JPanel();
		panelManager_2.setBackground(new Color(193, 247, 179));
		tabbedPane.addTab("Bill", null, panelManager_2, null);
		panelManager_2.setLayout(null);
		
		JLabel lblNewLabel_FindBill = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Manager.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));;
				lblNewLabel_FindBill .setBounds(772, 11, 41, 36);
		panelManager_2.add(lblNewLabel_FindBill );
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBounds(823, 11, 327, 36);
		panelManager_2.add(textField);
		
		JButton btnNewButton_Find_2 = new JButton("Find");
		btnNewButton_Find_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Find_2.setBackground(new Color(217, 217, 217));
		btnNewButton_Find_2.setBounds(1160, 20, 72, 23);
		panelManager_2.add(btnNewButton_Find_2);
		
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"No", "Code Bill", "Code Client", "Name Client", "Vehicle", "Code Driver", "Duty", "Start Address", "End Address", "Date", "Total Time", "Pay"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(15);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(35);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(93);
		table_2.getColumnModel().getColumn(5).setPreferredWidth(50);
		table_2.getColumnModel().getColumn(6).setPreferredWidth(40);
		table_2.getColumnModel().getColumn(7).setPreferredWidth(180);
		table_2.getColumnModel().getColumn(8).setPreferredWidth(180);
		table_2.getColumnModel().getColumn(9).setPreferredWidth(55);
		table_2.getColumnModel().getColumn(10).setPreferredWidth(28);
		table_2.getColumnModel().getColumn(11).setPreferredWidth(45);
		table_2.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 10));
		table_2.setBounds(375, 91, 8, 422);
		
		
		JScrollPane scrollPane_2 = new JScrollPane(table_2);
		scrollPane_2.setBounds(7, 91, 1256, 451);
		panelManager_2.add(scrollPane_2);
		
		JButton btnAddBill = new JButton("Add");
		btnAddBill.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddBill.setBackground(new Color(214, 172, 255));
		btnAddBill.setForeground(new Color(0, 0, 0));
		btnAddBill.setBounds(70, 553, 126, 35);
		panelManager_2.add(btnAddBill);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBackground(new Color(214, 172, 255));
		btnReset.setBounds(217, 553, 126, 35);
		panelManager_2.add(btnReset);
		
		JLabel lblNewLabel_2_2 = new JLabel("The Bill");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2_2.setBounds(75, 28, 373, 43);
		panelManager_2.add(lblNewLabel_2_2);
		
//		refesh();
		
	}
	
//	public void refesh() {
//		table.setModel(new DefaultTableModel(
//				new Object[][] {
//				},
//				new String[] {
//					"ID", "Name", "Date", "Sex", "CCCD", "Phone", "Exp"
//				}
//			)
//				);
//		ArrayList<Employee> list = con.getEmployees();
//		model = (DefaultTableModel) table.getModel();
//		for (Employee e : list) {
//			model.addRow(new Object[] {
//					e.getID(), e.getName(), e.getDate(), e.isSex(), e.getCCCD(), e.getPhone(), e.getExp()
//			});
//		}
//	}
//	
//	public boolean addEmployee (Employee e) {
//		
//		
//		
//		return con.AddEm(e);
//	}
//	
//	public void delEmployee (Employee e) {
//		e.setID(textField_ID.getText());
//		//return con.DeleteEm(textField_ID);
//	}
//	
}


