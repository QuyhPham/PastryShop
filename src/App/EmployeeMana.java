package App;

import com.toedter.calendar.JDateChooser;

//

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Database.ConnectDatabase;
import Database.DrinkConnect;
import Database.EmployeeConnect;
import Normal.Cakes;
import Normal.Drink;
import Normal.Employee;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class EmployeeMana extends JPanel {
	private  JTable table;
	private JTextField textField_ID;
	private JTextField textField_Name;
	private JTextField textField_Date;
	private JTextField textField_Sex;
	private JTextField textField_CCCD;
	private JTextField textField_Phone;
	private JTextField textField_Salary;
	private JTextField textField_Find;
	private JTextPane textPane_Note = new JTextPane();
	public JButton btnNewButton_Exit = new JButton("Exit");
	private JTextField textField_Shift;
	ArrayList<Employee> elist = new ArrayList<Employee>();
	private EmployeeConnect em = new EmployeeConnect();
	private JButton btnNewButton_Del;
	private JButton btnNewButton_Add;
	private JDateChooser dateChooser;
	private DefaultTableModel model;
	//ConnectDatabase conDB = new ConnectDatabase();
	
	/**
	 * Create the panel.
	 */
	public EmployeeMana() {
		setBackground(new Color(206, 206, 255));
		setLayout(null);
		setBounds(0, 0, 1156, 652);
		
		JLabel lblNewLabel_2 = new JLabel("The list of Employee");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_2.setBounds(24, 11, 373, 43);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						EmployeeMana.class.getResource("/Image/employ1.jpg")
						)
				).getImage().getScaledInstance(54, 38, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(393, 11, 54, 38);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						EmployeeMana.class.getResource("/Image/kinhlup.png")
						)
				).getImage().getScaledInstance(41, 36, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(787, 11, 41, 36);
		lblNewLabel.setSize(41,36);
		add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(24, 52, 494, 2);
		add(separator);
		
		elist = em.getAll();
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Employee emp = elist.get(table.getSelectedRow());
				textField_ID.setText(""+emp.getID());
				textField_Name.setText(emp.getName());
				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)emp.getDate());
					dateChooser.setDate(date);
				} catch (Exception e5) {
					e5.printStackTrace();
				}
				textField_Sex.setText(emp.getSex());
				textField_CCCD.setText(""+emp.getCCCD());
				textField_Phone.setText(""+emp.getPhone());
			    textField_Salary.setText(""+emp.getSalary());
				textField_Shift.setText(emp.getShifts());
				textPane_Note.setText(emp.getNote());
				
			}
		});
		table.setBackground(new Color(223, 255, 255));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"ID", "Name", "Date", "Sex", "CCCD", "Phone", "Salary", "Shifts", "Note"
			}
				) {
					boolean[] columnEdittables = new boolean[] {
							false, false, false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEdittables[column];
					}
					Class[] columnTypes = new Class[] {
						Object.class, Object.class, Object.class, Object.class, Long.class, Long.class, Long.class, Object.class, Object.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				} );
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(65);
		table.getColumnModel().getColumn(2).setPreferredWidth(61);
		table.getColumnModel().getColumn(3).setPreferredWidth(27);
		table.getColumnModel().getColumn(7).setPreferredWidth(53);
		table.getColumnModel().getColumn(8).setPreferredWidth(106);
		
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setBounds(375, 91, 889, 422);
		
		 model = (DefaultTableModel) table.getModel();

		Object[] row = new Object[9];

		for (int i = 0; i < em.size(); i++) {
			row[0]=((Employee) em.get(i)).getID();

		row[1]= ((Employee) em.get(i)).getName();
		row[2]= ((Employee) em.get(i)).getDate();
		
		row[3]=((Employee) em.get(i)).getSex();

		row[4]=((Employee) em.get(i)).getCCCD();
//		try {
//			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(row, 2));
//			dateChooser.setDate(date);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		row[5]=((Employee) em.get(i)).getPhone();
		row[6]=((Employee) em.get(i)).getSalary();
		row[7]=((Employee) em.get(i)).getShifts();
		row[8]=((Employee) em.get(i)).getNote();
		
			
	} table.setRowHeight(30);
	model.addRow(row);
		
		loadInformationEmployee();
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBounds(10, 60, 1136, 332);
		add(scrollPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 398, 952, 2);
		add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(24, 414, 72, 29);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(24, 477, 84, 29);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_2.setBounds(24, 539, 72, 29);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Sex:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4.setBounds(24, 599, 72, 29);
		add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_3 = new JLabel("CCCD:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3.setBounds(409, 414, 72, 29);
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_5 = new JLabel("Phone:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5.setBackground(SystemColor.menu);
		lblNewLabel_1_5.setBounds(409, 477, 104, 29);
		add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Salary:");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5_1.setBackground(SystemColor.menu);
		lblNewLabel_1_5_1.setBounds(409, 539, 104, 29);
		add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Shifts:");
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_5_2.setBackground(SystemColor.menu);
		lblNewLabel_1_5_2.setBounds(409, 599, 104, 29);
		add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Note:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_3_1.setBounds(798, 414, 72, 29);
		add(lblNewLabel_1_3_1);
		
		textField_ID = new JTextField();
		textField_ID.setEditable(false);
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_ID.setColumns(10);
		textField_ID.setBounds(106, 411, 238, 35);
		add(textField_ID);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Name.setColumns(10);
		textField_Name.setBounds(106, 471, 238, 35);
		add(textField_Name);
		/*
		 * 
		textField_Date = new JTextField();
		textField_Date.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Date.setColumns(10);
		textField_Date.setBounds(106, 533, 238, 35);
		add(textField_Date);
		 * */
		dateChooser = new JDateChooser();
		 dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(106, 533, 238, 35);
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(dateChooser);
		
		
		textField_Sex = new JTextField();
		textField_Sex.setEditable(false);
		textField_Sex.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_Sex.setColumns(10);
		textField_Sex.setBounds(106, 593, 90, 35);
		add(textField_Sex);
		
		textField_CCCD = new JTextField();
		textField_CCCD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_CCCD.setColumns(10);
		textField_CCCD.setBounds(491, 408, 261, 35);
		add(textField_CCCD);
		
		textField_Phone = new JTextField();
		textField_Phone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(491, 471, 261, 35);
		add(textField_Phone);
		
		textField_Salary = new JTextField();
		textField_Salary.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField_Salary.setColumns(10);
		textField_Salary.setBounds(491, 533, 261, 35);
		add(textField_Salary);
		
		
		textPane_Note.setBounds(880, 411, 239, 124);
		add(textPane_Note);
		
		JButton btnNewButton_1 = new JButton("Boy");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Boy") {
					Sex1();
			}if(e.getActionCommand() == "Girl") {
				Sex2();
		}
			}});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(200, 593, 70, 34);
		add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("Girl");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Girl") {
					Sex2();
			}
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_2.setBounds(273, 593, 70, 34);
		add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Morn");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Morn") {
					Morn();
			}if(e.getActionCommand() == "Even") {
				Even();
				
			}
			}});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(583, 593, 74, 34);
		add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2_1 = new JButton("Even");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Even") {
					Even();
				}
				
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1_2_1.setBounds(659, 593, 93, 34);
		add(btnNewButton_1_2_1);
	
		
		textField_Find = new JTextField();
		textField_Find.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_Find.setColumns(10);
		textField_Find.setBounds(833, 11, 238, 36);
		add(textField_Find);
		
		 btnNewButton_Del = new JButton("Delete");
		 btnNewButton_Del.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (em.delete(elist.get(table.getSelectedRow()).getID())) {
						JOptionPane.showMessageDialog(null, "Delete success!");
						loadInformationEmployee();
						clearEmployee();
					}
				}
			});
		btnNewButton_Del.setForeground(new Color(0, 64, 128));
		btnNewButton_Del.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Del.setBackground(new Color(230, 255, 255));
		btnNewButton_Del.setBounds(811, 548, 113, 36);
		add(btnNewButton_Del);
		
		 btnNewButton_Add = new JButton("Add");
		 btnNewButton_Add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = textField_Name.getText();
					//String date = textField_Date.getText();
					String sex = textField_Sex.getText();
					long cccd = Long.parseLong(textField_CCCD.getText());
					long phone = Long.parseLong(textField_Phone.getText());
					long salary = Long.parseLong(textField_Salary.getText());
					String shift = textField_Shift.getText();
					String note = textPane_Note.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(dateChooser.getDate());
					//em.setDate(date);
					
					if(em.add(name, date, sex, cccd, phone, salary, shift, note)) {
						JOptionPane.showMessageDialog(null, "Add success!");
						loadInformationEmployee();
						clearEmployee();
					} else {
						JOptionPane.showMessageDialog(null, "Error!");
					}
				}
			});
		btnNewButton_Add.setForeground(new Color(0, 64, 128));
		btnNewButton_Add.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Add.setBackground(new Color(230, 255, 255));
		btnNewButton_Add.setBounds(811, 608, 113, 36);
		add(btnNewButton_Add);
		
		JButton btnNewButton_Edit = new JButton("Reset");
		btnNewButton_Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearEmployee();
				loadInformationEmployee();
			}
		});
		btnNewButton_Edit.setForeground(new Color(0, 64, 128));
		btnNewButton_Edit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Edit.setBackground(new Color(230, 255, 255));
		btnNewButton_Edit.setBounds(934, 548, 113, 36);
		add(btnNewButton_Edit);
		
		JButton btnNewButton_Update = new JButton("Update");
		btnNewButton_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField_Name.getText();
			//	String date = textField_Date.getText();
				String sex = textField_Sex.getText();
				long cccd = Long.parseLong(textField_CCCD.getText());
				long phone = Long.parseLong(textField_Phone.getText());
				long salary = Long.parseLong(textField_Salary.getText());
				String shift = textField_Shift.getText();
				String note = textPane_Note.getText();
				int id = Integer.parseInt(textField_ID.getText());
				Employee emp = new Employee();
				emp.setName(name);
			//	emp.setDate(date);
				emp.setSex(sex);
				emp.setCCCD(cccd);
				emp.setPhone(phone);
				emp.setSalary(salary);
				emp.setShifts(shift);
				emp.setNote(note);
				emp.setID(id);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(dateChooser.getDate());
				emp.setDate(date);
				
				if(em.update(name, date, sex, cccd, phone, salary, shift, note, id)
						) {
					JOptionPane.showMessageDialog(null, "Update success!");
					em.getAll();
					loadInformationEmployee();
					clearEmployee();
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
				
			}
		});
		btnNewButton_Update.setForeground(new Color(0, 64, 128));
		btnNewButton_Update.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Update.setBackground(new Color(230, 255, 255));
		btnNewButton_Update.setBounds(934, 608, 113, 36);
		add(btnNewButton_Update);
		
		//Exit
		
		btnNewButton_Exit.setForeground(new Color(128, 0, 0));
		btnNewButton_Exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Exit.setBackground(new Color(255, 128, 128));
		btnNewButton_Exit.setBounds(1057, 567, 72, 61);
		add(btnNewButton_Exit);
		
		
		JButton btnNewButton_Find = new JButton("Find");
		btnNewButton_Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				String found = textField_Find.getText(); // chinhs laf cai found nay
//				String name = textField_NameCake.getText();
//			
//			
				Find(found);
			}catch(Exception e2) {
					//TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e2);
			}
				
				
	    }
	});
		btnNewButton_Find.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_Find.setBackground(new Color(217, 217, 217));
		btnNewButton_Find.setBounds(1074, 20, 72, 23);
		add(btnNewButton_Find);
		
		textField_Shift = new JTextField();
		textField_Shift.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Shift.setEditable(false);
		textField_Shift.setColumns(10);
		textField_Shift.setBounds(491, 593, 90, 35);
		add(textField_Shift);
		
		
		
		
		
		

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Boy") {
			Sex1();
	}if(e.getActionCommand() == "Girl") {
		Sex2();
}
	
	if(e.getActionCommand() == "Morn") {
		Morn();
}if(e.getActionCommand() == "Even") {
	Even();
}
	}
	
	public void Sex1() {
		//String re = "Boy";
		textField_Sex.setText("Boy");
	}
	public void Sex2() {
		//String re = "Boy";
		textField_Sex.setText("Girl");
	}
	
	public void Morn() {
		//String re = "Boy";
		textField_Shift.setText("Morn");
	}
	public void Even() {
		//String re = "Boy";
		textField_Shift.setText("Even");
	}

	
	
	
	
	private void loadInformationEmployee() {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Name", "Date", "Sex", "CCCD", "Phone", "Salary", "Shifts", "Note"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false, false, false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Long.class, Long.class, Long.class, Object.class, Object.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	
			table.setRowHeight(30);
			elist = em.getAll();
			
			for (Employee e:elist) {
				Object[] row = new Object[9];
					row[0] = e.getID();
					row[1] = e.getName();
					row[2] =e.getDate();
					
					row[3]=e.getSex();

					row[4]=e.getCCCD();

					row[5]=e.getPhone();
					row[6]=e.getSalary();
					row[7]=e.getShifts();
					row[8]=e.getNote();
					

					
					model.addRow(row);
				
			}
			
		
	}
	
	
	private void Find(String found) // find nayf 
	{
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"ID", "Name", "Date", "Sex", "CCCD", "Phone", "Salary", "Shifts", "Note"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false, false, false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Long.class, Long.class, Long.class, Object.class, Object.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	
			table.setRowHeight(30);
			elist = em.find(found);
			table.setRowSorter(null);
			
			for (Employee e:elist) {
				Object[] row = new Object[9];
					row[0] = e.getID();
					row[1] = e.getName();
					row[2] =e.getDate();
					
					row[3]=e.getSex();

					row[4]=e.getCCCD();

					row[5]=e.getPhone();
					row[6]=e.getSalary();
					row[7]=e.getShifts();
					row[8]=e.getNote();
					

					
					model.addRow(row);
				
			}
			
		
	}
	
	
	
	
	void clearEmployee() {
		textField_ID.setText("");
		textField_Name.setText("");
		dateChooser.setCalendar(null);
		textField_Sex.setText("");
		textField_CCCD.setText("");
		textField_Phone.setText("");
		textField_Salary.setText("");
		textField_Shift.setText("");
		textPane_Note.setText("");
		textField_Find.setText("");
	}
	
}
