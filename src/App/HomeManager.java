package App;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeManager extends JFrame {

	private JPanel contentPane;
	JMenu Home, Admin;
	public  JMenuItem Logout, Web_Mana;
	private JLabel lblBackGround;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeManager frame = new HomeManager();
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
	public HomeManager() {
		
		setForeground(new Color(128, 0, 0));
		this.setTitle("Home Manager");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Login.class.getResource("/Image/e.jpg"))));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Hi! Admin!");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
		lblNewLabel_1.setBounds(51, 375, 188, 71);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("PASTRY SHOP");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 67));
		lblNewLabel.setBounds(90, 127, 499, 104);
		contentPane.add(lblNewLabel);
		
		
		lblBackGround = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						HomeManager.class.getResource("/Image/mana.jpg")
						)
				).getImage().getScaledInstance(1283, 625, Image.SCALE_DEFAULT)));
		lblBackGround.setBounds(0, 0, 1283, 625);
		contentPane.add(lblBackGround);
		
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		 menuBar.setBackground(new Color(173, 92, 92));
			setJMenuBar(menuBar);
			
			Home = new JMenu("Home");
			Home.setBackground(new Color(173, 92, 92));
			Home.setFont(new Font("Segoe UI", Font.BOLD, 15));
			Home.setForeground(new Color(0, 0, 0));
			
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
			
			Home.add(Logout);
			menuBar.add(Home);
			
			Admin = new JMenu("Admin");
			Admin.setBackground(new Color(173, 92, 92));
			Admin.setFont(new Font("Segoe UI", Font.BOLD, 15));
			Admin.setForeground(new Color(0, 0, 0));
			
			Web_Mana = new JMenuItem("Web-Mana");
			
			Web_Mana.setBackground(new Color(236, 217, 217));
			Web_Mana.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			Web_Mana.setForeground(new Color(128, 0, 0));
			
			Admin.add(Web_Mana);
			menuBar.add(Admin);

		
	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getSource()== Logout)//lay ten JButton
//			new Home();
//		
//		if(e.getSource()== Web_Mana)//lay ten JButton
//			new Manager1();
//		
//	}
	}


