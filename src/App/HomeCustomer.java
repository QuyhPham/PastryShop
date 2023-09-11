package App;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;

public class HomeCustomer extends JFrame{

	JMenu Home, Order, History;
	public JMenuItem Introduce, Logout, Get_now, Pre_Order, history;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPastryShop;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeCustomer frame = new HomeCustomer();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//	}

	/**
	 * Create the frame.
	 */
	public HomeCustomer() {
		setForeground(new Color(128, 0, 0));
		this.setTitle("Home Client");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Login.class.getResource("/Image/client.jpg"))));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel = new JLabel("WELCOM TO");
		lblNewLabel.setForeground(new Color(64, 0, 0));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 45));
		lblNewLabel.setBounds(268, 226, 327, 80);
		contentPane.add(lblNewLabel);
		lblPastryShop = new JLabel("PASTRY SHOP!");
		lblPastryShop.setForeground(new Color(64, 0, 0));
		lblPastryShop.setFont(new Font("Tempus Sans ITC", Font.BOLD, 45));
		lblPastryShop.setBounds(426, 303, 327, 80);
		contentPane.add(lblPastryShop);
		
		lblNewLabel_2 = new JLabel("Sweet");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
		lblNewLabel_2.setBounds(126, 485, 107, 28);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_5 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						HomeCustomer.class.getResource("/Image/Sweet.jpg")
						)
				).getImage().getScaledInstance(45, 36, Image.SCALE_DEFAULT)));
		lblNewLabel_5.setBounds(77, 477, 45, 36);
		contentPane.add(lblNewLabel_5);
		JLabel lblNewLabel_3 = new JLabel("Beauty");
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
		lblNewLabel_3.setBounds(96, 381, 137, 36);
		contentPane.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Delicious");
		lblNewLabel_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 33));
		lblNewLabel_4.setBounds(109, 565, 160, 36);
		contentPane.add(lblNewLabel_4);
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						HomeCustomer.class.getResource("/Image/WCC.jpg")
						)
				).getImage().getScaledInstance(1283, 625, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setText("");
		lblNewLabel_1.setBounds(10, -2, 1283, 625);
		contentPane.add(lblNewLabel_1);
		
		
		
		 JMenuBar menuBar = new JMenuBar();
		 menuBar.setBackground(new Color(173, 92, 92));
			setJMenuBar(menuBar);
			

			Home = new JMenu("Home");
			Home.setBackground(new Color(173, 92, 92));
			Home.setFont(new Font("Segoe UI", Font.BOLD, 15));
			Home.setForeground(new Color(0, 0, 0));
			Introduce = new JMenuItem("Introduce");
			
			Introduce.setBackground(new Color(236, 217, 217));
			Introduce.setForeground(new Color(128, 0, 0));
			Introduce.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			Logout = new JMenuItem("Log Out");
//			Logout.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					setVisible(false);
//					Home ho = new Home();
//					ho.setVisible(true);
//				}});
			Logout.setBackground(new Color(236, 217, 217));
			Logout.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			Logout.setForeground(new Color(128, 0, 0));
			
			Home.add(Introduce);
			
			JSeparator separator = new JSeparator();
			Home.add(separator);
			Home.add(Logout);
			
			Order = new JMenu("Order");
			Order.setBackground(new Color(173, 92, 92));
			Order.setForeground(new Color(0, 0, 0));
			Order.setFont(new Font("Segoe UI", Font.BOLD, 15));
			Get_now = new JMenuItem("Get Now");
//			Get_now.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					setVisible(false);
//					Customer cus = new Customer();
//					cus.setVisible(true);
//				}});
			Get_now.setBackground(new Color(236, 220, 220));
			Get_now.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			Get_now.setForeground(new Color(128, 0, 0));
			Pre_Order = new JMenuItem("Pre-Order");
//			Pre_Order.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					setVisible(false);
//					Cake ck = new Cake();
//					ck.setVisible(true);
//				}});
			Pre_Order.setBackground(new Color(236, 220, 220));
			Pre_Order.setForeground(new Color(128, 0, 0));
			Pre_Order.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			Order.add(Get_now);
			
			JSeparator separator_1 = new JSeparator();
			Order.add(separator_1);
			Order.add(Pre_Order);
			menuBar.add(Home);
			menuBar.add(Order);
			
			History = new JMenu("History");
			History.setBackground(new Color(173, 92, 92));
			History.setFont(new Font("Segoe UI", Font.BOLD, 15));
			History.setForeground(new Color(0, 0, 0));
			history = new JMenuItem("Purchase History");
//			history.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					setVisible(false);
//					HistoryCus hi = new HistoryCus();
//					hi.setVisible(true);
//				}});
			history.setBackground(new Color(236, 220, 220));
			history.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			history.setForeground(new Color(128, 0, 0));
			History.add(history);
			
			menuBar.add(History);
			//contentPane.add(menuBar);
//			contentPane.add(Home);
//			contentPane.add(Order);
//			contentPane.add(History);
			
	}
	

	//@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource()== Logout)//lay ten JButton
//			new Home();//call class(constructor)
//		
//		if(e.getSource()== Get_now)
//			new Customer();
//		
//		if(e.getSource()== Introduce)
//			new Introduce();
//		
//		if(e.getSource()== Pre_Order)
//			new Cake();
//		
//		if(e.getSource()== history)
//			new HistoryCus();
//	}

}
