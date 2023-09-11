package App;

import javax.swing.text.MaskFormatter;

import Database.ConnectDatabase;
import Normal.Users;

import java.text.ParseException;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Color panel;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1, checkNewPass;
	public JButton btnNewButton_1_1 = new JButton("Back");
	private JTextField textField_2;
	public JButton btnSignUp = new JButton("SIGN UP");
	private ConnectDatabase conDB = new ConnectDatabase();	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUp frame = new SignUp();
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
	public SignUp() {
		
		setForeground(new Color(128, 0, 0));
		this.setTitle("SIGN UP");
		URL MainIcon = SignUp.class.getResource("/Image/INFO.png");
		Image img = Toolkit.getDefaultToolkit().createImage(MainIcon);
		this.setIconImage(img);
		
		setFont(new Font("Tahoma", Font.BOLD, 25));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 689);
		setSize(989,689);
		setResizable(false);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(182, 182, 254));
		contentPane.setForeground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A. USER INFORMATION ");
		lblNewLabel.setBounds(339, 25, 532, 47);
		lblNewLabel.setForeground(new Color(118, 54, 224));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 25, 272, 184);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(SignUp.class.getResource("/Image/INFO.png"))));
		
		JLabel lblNewLabel_2 = new JLabel("Full Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(349, 83, 133, 47);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(349, 283, 133, 47);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("Sex:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(349, 133, 133, 47);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CCCD:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(349, 183, 133, 47);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(349, 233, 133, 47);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(472, 83, 418, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(472, 233, 418, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(472, 283, 418, 40);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_7 = new JLabel("B. START CREATING AN ACCOUNT");
		lblNewLabel_7.setForeground(new Color(118, 54, 224));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_7.setBounds(59, 341, 532, 47);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Enter user name:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(67, 399, 181, 47);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Enter the password:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(67, 449, 202, 47);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Re-enter the password:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(67, 499, 215, 47);
		contentPane.add(lblNewLabel_10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_5.setColumns(10);
		textField_5.setBounds(293, 399, 520, 40);
		contentPane.add(textField_5);
		
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
		btnNewButton_1.setBounds(690, 133, 97, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("Girl");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand() == "Girl") {
					Sex2();
			}
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_2.setBounds(793, 133, 97, 40);
		contentPane.add(btnNewButton_1_2);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(472, 133, 208, 40);
		contentPane.add(textField_1);
		
		JButton btnClean = new JButton("CLEAN");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
				
				
				
				
			}
		});
		btnClean.setForeground(new Color(128, 0, 0));
		btnClean.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnClean.setBackground(Color.RED);
		btnClean.setBounds(214, 575, 236, 47);
		contentPane.add(btnClean);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(293, 449, 520, 40);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField_1.setBounds(293, 499, 520, 40);
		contentPane.add(passwordField_1);
		
		
		btnSignUp.setForeground(new Color(0, 0, 255));
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSignUp.setBackground(new Color(128, 255, 255));
		btnSignUp.setBounds(520, 575, 236, 47);
		contentPane.add(btnSignUp);
		
		MaskFormatter mf;
		try {
			mf = new MaskFormatter("############");
			mf.setPlaceholderCharacter('#');
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
       
		
		
		
		
		
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1_1.setBackground(new Color(255, 128, 128));
		btnNewButton_1_1.setBounds(895, 622, 70, 23);
		contentPane.add(btnNewButton_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(472, 183, 418, 40);
		contentPane.add(textField_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show password");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxNewCheckBox.setBounds(293, 568, 148, 30);
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					passwordField.setEchoChar((char)0);
					passwordField_1.setEchoChar((char)0);
					checkNewPass.setEchoChar((char)0);
				} else {
					passwordField.setEchoChar('*');
					passwordField_1.setEchoChar('*');
					checkNewPass.setEchoChar('*');
				}
			}
		});
		
		checkNewPass = new JPasswordField();
		checkNewPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
//		lblNewLabel.setIcon(new ImageIcon( new ImageIcon(
//				java.awt.Toolkit.getDefaultToolkit().getImage(
//						SignUp.class.getResource("INFO.png")
//						)
//				).getImage().getScaledInstance(359, 72, Image.SCALE_DEFAULT)));
	
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Boy") {
			Sex1();
	}if(e.getActionCommand() == "Girl") {
		Sex2();
}if(e.getActionCommand()== "CLEAN") {
	Clean();
}
	}
	
	
	
	public void Sex1() {
		//String re = "Boy";
		textField_1.setText("Boy");
	}
	public void Sex2() {
		//String re = "Boy";
		textField_1.setText("Girl");
	}
	public void Clean() {
		textField.setText("");
		textField_1.setText("");
		//textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
	}
	
	public boolean checkSignUp() {
		
		if (textField.getText().isEmpty()||
				textField_1.getText().isEmpty()||
				textField_2.getText().isEmpty()||
				textField_3.getText().isEmpty()||
				textField_4.getText().isEmpty()||
				textField_5.getText().isEmpty()
				) {
			JOptionPane.showMessageDialog(null, "Please enter all text!");
			return false;
		}
		
		Users u = new Users();
		u.setName(textField.getText());
		u.setSex(textField_1.getText());
		u.setCccd(Long.parseLong(textField_2.getText()));
		u.setPhone(Long.parseLong(textField_3.getText()));
		u.setEmail(textField_4.getText());
		u.setUsername(textField_5.getText());
		
		try {
			String sql = "select * from Users where Username = '" + u.getUsername() + "'";
			PreparedStatement ps = conDB.con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Account exists!");
				return false;
			}
			if (!getPass(passwordField.getPassword()).equals(getPass(passwordField_1.getPassword()))) {
				JOptionPane.showMessageDialog(null, "Wrong password !");
				return false;
			}
			sql = "insert into users values (?,?,?,?,?,?,?,?)";
			ps = conDB.con.prepareStatement(sql);
			ps.setString(1, u.getUsername());
			ps.setString(2, getPass(passwordField.getPassword()));
			ps.setString(3, u.getName());
			ps.setString(4, u.getSex());
			ps.setLong(5, u.getCccd());
			ps.setLong(6, u.getPhone());
			ps.setString(7, u.getEmail());
			ps.setString(8, "User");
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public String getPass(char[] pass) {
		String p = "";
		for (char x:pass) {
			p+= x;
		}
		return p;
	}
	
	
	
	
}
