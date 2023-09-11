package App;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

import Database.ConnectDatabase;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginWithCus extends JFrame {

	private JPanel contentPane;
	public JTextField textField_1;
	public JPasswordField jpassWord;
	public JButton btnNewButton = new JButton("Sign Up");
	public JButton btnNewButton_1_1 = new JButton("Exit");
	ConnectDatabase conDB = new ConnectDatabase();
	public JButton btnNewButton_1 = new JButton("Login");

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginWithCus frame = new LoginWithCus();
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
	public LoginWithCus() {
		setForeground(new Color(128, 0, 0));
		this.setTitle("WELCOM TO PASTRY SHOP");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Login.class.getResource("/Image/INFO.png"))));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 193, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						LoginWithCus.class.getResource("/Image/smile.gif")
						)
				).getImage().getScaledInstance(149, 106, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(169, 11, 149, 106);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login with your account!");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblNewLabel_1.setBounds(128, 114, 243, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Do not have an account? Come to ");
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(10, 428, 272, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("--->");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(245, 428, 62, 34);
		contentPane.add(lblNewLabel_2);
		
		
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(193, 193, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnNewButton.setBounds(291, 435, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3_1 = new JLabel("User Name:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(47, 187, 119, 34);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Password:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(47, 254, 107, 34);
		contentPane.add(lblNewLabel_3_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(184, 188, 243, 41);
		contentPane.add(textField_1);
		
		jpassWord = new JPasswordField();
		jpassWord.setColumns(10);
		jpassWord.setBounds(184, 255, 243, 41);
		contentPane.add(jpassWord);
		
		
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 185));
		btnNewButton_1.setBounds(126, 354, 107, 41);
		contentPane.add(btnNewButton_1);
		
		
		
		btnNewButton_1_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(255, 255, 185));
		btnNewButton_1_1.setBounds(245, 354, 107, 41);
		contentPane.add(btnNewButton_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Pass");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					jpassWord.setEchoChar((char)0);
				} else {
					jpassWord.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.setBackground(new Color(193, 193, 255));
		chckbxNewCheckBox.setBounds(184, 303, 99, 23);
		contentPane.add(chckbxNewCheckBox);
		
		

	}
	
	public int getID(String user) {
		int ID = -1;
		
		try {
				String sql = "select ID from Users where Username = ? ";
				PreparedStatement pre = conDB.con.prepareStatement(sql);
				pre.setString(1, user);
				ResultSet rs = pre.executeQuery();
				if (rs.next()) {
					ID = rs.getInt(1);
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		
		return ID;
	}
	
	public String checkLoginC(String name, String pass) {
		String pos = "";
        // Connection con ;
		try {
		//	con = ConnectDatabase.getConnection();
			String sql = "select password,position from Users where Username = ? ";
			PreparedStatement pre = conDB.con.prepareStatement(sql);
			pre.setString(1, name);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				if (pass.equals(rs.getString("Password"))) {
					pos = rs.getString("Position");
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No exits this account!");
			}

		} catch (Exception e) {
//e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
		return pos;
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//		if (e.getActionCommand()=="Login") {
//			
//			if (textField_1.equals("")) {
//				JOptionPane.showMessageDialog(null, "Bạn chưa điền tên đăng nhập!");
//			} else if (jpassWord.equals("")) {
//				JOptionPane.showMessageDialog(null, "Bạn chưa điền mật khẩu!");
//			} else if(con.checkLogin(textField_1, jpassWord) == false) {
//				JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
//			} else {
//				
//				LuuDuLieu luu = new LuuDuLieu();
//				luu.setTenDangNhap(txtTenDangNhap.getText());
//				luu.setQuyen(con.getQuyen(tdn));
//				luu.setHoTen(con.selectHoten(tdn));
//				new Menu();
//				frame.setVisible(false);
//				
//			}
//		}
	}
	
	public String getPass(char[] pass) {
		String p = "";
		for (char x:pass) {
			p+= x;
		}
		return p;
	}
	
}
