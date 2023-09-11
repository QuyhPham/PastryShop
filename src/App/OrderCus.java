package App;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.BillConnect;
import Normal.Bill;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class OrderCus extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private BillConnect bi = new BillConnect();
	ArrayList<Bill> bilist = new ArrayList<>();
	public JButton btnNewButton_1 = new JButton("Exit");
	public JTable table = new JTable();
	public int ID = -1;
	
	public OrderCus() {
		setBackground(new Color(255, 202, 202));
		
				
				setBounds(100, 100, 382, 652);
				setLayout(null);
//				contentPane = new JPanel();
//				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//
//				setContentPane(contentPane);
				
				table.setBackground(new Color(213, 255, 255));
//				table.setFont(new Font("Tahoma", Font.PLAIN, 25));
				
				//1.
				table.setModel(new DefaultTableModel(
						new Object[][] {},
						new String[] {
							 "Name", "Quantity", "Price"
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
				// tu khuc 1 cham den day la copy lai sau nhet vao trong nut button reset cua customer
				
				table.getColumnModel().getColumn(0).setPreferredWidth(131);
				table.getColumnModel().getColumn(1).setPreferredWidth(57);
				table.getColumnModel().getColumn(2).setPreferredWidth(122);
				table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
				table.setBounds(39, 620, 382, 600);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(0, 191, 382, 393);
				add(scrollPane);
				
				JButton btnNewButton = new JButton("Order");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Bill b = new Bill();
						String name = "";
						long price = 0;
						//4.
						DefaultTableModel m = (DefaultTableModel) table.getModel();
						for (int i = 0; i < m.getRowCount(); i++) {
							name += m.getValueAt(i, 0) +": "+ m.getValueAt(i, 1) + ", ";//a
							price += Long.parseLong(m.getValueAt(i, 2).toString());// (i,2)
						}
						//Revenue: lay nguyen khuc 4. vut cai a di, doi table bang cai table cua revenue, (i,?)
						// TextField: nametxt.setText(price); con neu loi, thi hay .to?
						String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
						b.setIDC(ID);
						b.setDateOrder(timeStamp);
						b.setDatePay(timeStamp);
						b.setPrice(price);
						b.setGood(name);
//						
						b.setItem("GetNow");
						if (bi.addbillGetNow(b)) {
							String msg = "";
							msg += "------------------------------\n";
							JOptionPane.showMessageDialog(btnNewButton, "Goods Purchased: " + name + "\n"+ msg + "Total: " + price + "\n Date :" + timeStamp);
							
						}
						
							
						
						
							
						
						// goi ham add trong billconnect
						
					}
				});
				btnNewButton.setForeground(new Color(128, 0, 0));
				btnNewButton.setBackground(new Color(193, 193, 255));
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnNewButton.setBounds(10, 597, 85, 31);
				add(btnNewButton);
				
				JButton btnDelete = new JButton("Delete");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						khuc nay la sau do nhet vao trong button delete cua ben customer la se xoa dc cai hang ma minh chon 
						DefaultTableModel m = (DefaultTableModel) table.getModel();
						m.removeRow(table.getSelectedRow());
						
					}
				});
				btnDelete.setForeground(new Color(128, 0, 0));
				btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnDelete.setBackground(new Color(193, 193, 255));
				btnDelete.setBounds(105, 595, 94, 33);
				add(btnDelete);
				
				JButton btnReset = new JButton("Reset");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						table.setModel(new DefaultTableModel(
								new Object[][] {},
								new String[] {
									 "Name", "Quantity", "Price"
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
					}
				});
				btnReset.setForeground(new Color(128, 0, 0));
				btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnReset.setBackground(new Color(193, 193, 255));
				btnReset.setBounds(209, 595, 85, 33);
				add(btnReset);
				
				JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(
								OrderCus.class.getResource("/Image/OrderCus.jpg")
								)
						).getImage().getScaledInstance(382, 191, Image.SCALE_DEFAULT)));
				lblNewLabel.setBounds(0, 0, 382, 191);
				add(lblNewLabel);
				
//				JButton btnNewButton_1 = new JButton("Exit");
//				btnNewButton_1.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent e) {
//						if ( JOptionPane.showConfirmDialog(null, "Any information will not be saved. Do you still want to get out?") == 0) {
//							
//							OrderCus.this.dispose();
//							Customer cus = new Customer();
//						cus.setVisible(false);
//						HomeCustomer ho = new HomeCustomer();
//						ho.setVisible(true);
//					}
//					}});
				btnNewButton_1.setForeground(new Color(128, 0, 0));
				btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnNewButton_1.setBackground(new Color(193, 193, 255));
				btnNewButton_1.setBounds(304, 594, 68, 34);
				add(btnNewButton_1);
			}
	
	

	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public void dispose() {
		// TODO Auto-generated method stub
		
	}

		}

