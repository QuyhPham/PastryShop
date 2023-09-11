package App;

import java.awt.Color;
import App.CakeCus;
import Database.CakeConnect;
import Database.CookieConnect;
import Database.DrinkConnect;
import Normal.Cakes;
import Normal.Cookie;
import Normal.Drink;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;


public class Customer extends JFrame {

	private JPanel contentPane;
	public OrderCus OrderCus = new OrderCus();
	public CookieCus CookieCus = new CookieCus();	
	public CakeCus CakeCus = new CakeCus();
	public DrinkCus DrinkCus = new DrinkCus();
	public CakeConnect cake = new CakeConnect();
	public DrinkConnect drink = new DrinkConnect();
	public CookieConnect cookie = new CookieConnect();
	public ArrayList<Cakes> cakee = cake.getAll();
	public ArrayList<Drink> drin = drink.getAll();
	public ArrayList<Cookie> cook = cookie.getAll();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Customer frame = new Customer();
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
	public Customer() {
		
		setForeground(new Color(128, 0, 0));
        this.setTitle("Order");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Customer.class.getResource("/Image/Cus.jpg"))));
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		OrderCus.setSize(382, 652);
		OrderCus.setLocation(1, 0);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(202, 255, 202));
		panelMenu.setBounds(0, 0, 191, 652);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Customer.class.getResource("/Image/Cus.jpg")
						)
				).getImage().getScaledInstance(188, 131, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(0, 0, 191, 131);
		panelMenu.add(lblNewLabel);
		
		
		
		//Mua Cake
		JPanel pnCakeCus = new JPanel();
		pnCakeCus.setLayout(null);
		pnCakeCus.setBackground(new Color(255, 202, 202));
		pnCakeCus.setBounds(0, 478, 188, 174);
		panelMenu.add(pnCakeCus);
		pnCakeCus.addMouseListener(new PanelButtonMouseAdapter(pnCakeCus){
			@Override 
			public void mouseClicked (MouseEvent e ) {
				menuClicked(CakeCus);
			}
		});
		
		JLabel lblNewLabel_1_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Customer.class.getResource("/Image/cake.jpg")
						)
				).getImage().getScaledInstance(136, 100, Image.SCALE_DEFAULT)));
		lblNewLabel_1_1.setBounds(27, 20, 136, 100);
		pnCakeCus.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("CAKES");
		lblNewLabel_2_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_2.setBounds(52, 131, 141, 36);
		pnCakeCus.add(lblNewLabel_2_2);
		
		//Mua drink
		JPanel pnDrinkCus = new JPanel();
		pnDrinkCus.setLayout(null);
		pnDrinkCus.setBackground(new Color(255, 242, 242));
		pnDrinkCus.setBounds(0, 131, 188, 174);
		panelMenu.add(pnDrinkCus);
		pnDrinkCus.addMouseListener(new PanelButtonMouseAdapter(pnDrinkCus){
			@Override 
			public void mouseClicked (MouseEvent e ) {
				menuClicked(DrinkCus);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Customer.class.getResource("/Image/drink.jpg")
						)
				).getImage().getScaledInstance(136, 100, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(27, 20, 136, 100);
		pnDrinkCus.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DRINKS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setBounds(45, 127, 141, 36);
		pnDrinkCus.add(lblNewLabel_2);
		
		
		//Mua Cookie
		JPanel pnCookieCus = new JPanel();
		pnCookieCus.setBounds(0, 304, 188, 174);
		panelMenu.add(pnCookieCus);
		pnCookieCus.addMouseListener(new PanelButtonMouseAdapter(pnCookieCus){
			@Override 
			public void mouseClicked (MouseEvent e ) {
				menuClicked(CookieCus);
			}
		});
		pnCookieCus.setBackground(new Color(255, 223, 223));
		pnCookieCus.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Customer.class.getResource("/Image/cookie.jpg")
						)
				).getImage().getScaledInstance(136, 100, Image.SCALE_DEFAULT)));
		lblNewLabel_3.setBounds(27, 20, 136, 100);
		pnCookieCus.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("COOKIES");
		lblNewLabel_2_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(37, 131, 127, 36);
		pnCookieCus.add(lblNewLabel_2_1);
		
		//Bang hien ra nhung thu da chon
		JPanel pnOrderCus = new JPanel();
		pnOrderCus.setLayout(null);
		pnOrderCus.setBackground(new Color(255, 242, 242));
		pnOrderCus.setBounds(1092, 0, 550, 652);
//		pnOrderCus.addMouseListener(new PanelButtonMouseAdapter(pnOrderCus){
//			@Override 
//			public void mouseClicked (MouseEvent e ) {
//				menuClicked(pnOrderCus);
//			}
//		});
		
		
		JPanel panelMain1 = new JPanel();
		panelMain1.setBounds(191, 0, 711, 652);
		contentPane.add(panelMain1);
		panelMain1.setLayout(null);
		
		panelMain1.add(CakeCus);
		panelMain1.add(DrinkCus);
		panelMain1.add(CookieCus);
		
		
		JPanel panelMain2 = new JPanel();
		panelMain2.setBounds(901, 0, 382, 652);
		contentPane.add(panelMain2);
		panelMain2.setLayout(null);
		panelMain2.add(OrderCus);
		
		addcake();
		addrink();
		addcookie();
	}
	
	public void menuClicked ( JPanel panel ) {
		CookieCus.setVisible(false);
		CakeCus.setVisible(false);
		DrinkCus.setVisible(false);
		panel.setVisible(true);
}
	
	

	public void addcake() {
		//2. khong can nua, xoa di, khoi ghi
		//3. ghi cai nay vao ne
		CakeCus.btnNewButton_Cake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//2.nho la xoa sysout ddi, vi no in ra tren consule thoai, khou can
				
//				OrderCus.table.setModel(new DefaultTableModel(
//						new Object[][] {},
//						new String[] {
//							 "Name", "Quantity", "Price"
//						}
//					));
//				
			
				DefaultTableModel m =  (DefaultTableModel) OrderCus.table.getModel();
				Object[] row = new Object[3];
				row[0] = cakee.get(CakeCus.comboBox.getSelectedIndex()).getName();
				row[1] = CakeCus.comboBox_1.getSelectedItem();
				
				row[2] = cakee.get(CakeCus.comboBox.getSelectedIndex()).getPrice() * Long.parseLong(CakeCus.comboBox_1.getSelectedItem().toString());
				
				
				m.addRow(row);
		
			}
		});
		};
		
		public void addrink() {
			DrinkCus.btnNewButton_Drink.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//2.nho la xoa sysout ddi, vi no in ra tren consule thoai, khou can			
					DefaultTableModel m =  (DefaultTableModel) OrderCus.table.getModel();
					Object[] row = new Object[3];
					row[0] = drin.get(DrinkCus.comboBox.getSelectedIndex()).getName();
					row[1] = DrinkCus.comboBox_1.getSelectedItem();
					
					row[2] = drin.get(DrinkCus.comboBox.getSelectedIndex()).getPrice() * Long.parseLong(DrinkCus.comboBox_1.getSelectedItem().toString());
					
					
					m.addRow(row);
			
				}
			});
			
		}
		
		public void addcookie() {
			CookieCus.btnNewButton_Cookie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//2.nho la xoa sysout ddi, vi no in ra tren consule thoai, khou can			
					DefaultTableModel m =  (DefaultTableModel) OrderCus.table.getModel();
					Object[] row = new Object[3];
					row[0] = cook.get(CookieCus.comboBox.getSelectedIndex()).getName();
					row[1] = CookieCus.comboBox_1.getSelectedItem();
					
					row[2] = cook.get(CookieCus.comboBox.getSelectedIndex()).getPrice() * Long.parseLong(CookieCus.comboBox_1.getSelectedItem().toString());
					
					
					m.addRow(row);
			
				}
			});
			
		}

		
		
		
	

	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel ;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel ;
		}
		@Override 
		public void mouseEntered( MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		@Override 
		public void mouseExited( MouseEvent e) {
			panel.setBackground(new Color(255, 223, 223));
		}
		@Override 
		public void mousePressed( MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		@Override 
		public void mouseReleased( MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
	}
}
