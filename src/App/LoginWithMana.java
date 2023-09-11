
package App;

import java.awt.EventQueue;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class LoginWithMana extends JFrame {

	private JPanel contentPane;
	public JTextField textField_1;
	public JPasswordField jpassWord;
	public JButton btnNewButton = new JButton("Login");
	public JButton btnNewButton_1_1 = new JButton("Exit");
	ConnectDatabase conDB = new ConnectDatabase();
	public JButton btnNewButton_1 = new JButton("Login");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWithMana frame = new LoginWithMana();
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
	public LoginWithMana() {
		setForeground(new Color(128, 0, 0));
		this.setTitle("HI ADMIN!");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Login.class.getResource("/Image/INFO.png"))));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 223, 208));
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
		
		JLabel lblNewLabel_1 = new JLabel("Login as administrator!");
		lblNewLabel_1.setBounds(128, 114, 243, 34);
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("You are not an admin? Comeback");
		lblNewLabel_1_1.setBounds(10, 428, 272, 34);
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 15));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("--->");
		lblNewLabel_2.setBounds(245, 428, 62, 34);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel_2);
		
		btnNewButton.setBounds(291, 435, 89, 23);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(255, 223, 208));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 11));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3_1 = new JLabel("Admin:");
		lblNewLabel_3_1.setBounds(47, 187, 119, 34);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Password:");
		lblNewLabel_3_2.setBounds(47, 254, 107, 34);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_3_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 188, 243, 41);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		jpassWord = new JPasswordField();
		jpassWord.setBounds(184, 255, 243, 41);
		jpassWord.setColumns(10);
		contentPane.add(jpassWord);
		
		//		btnNewButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		btnNewButton_1.setBounds(126, 354, 107, 41);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 185));
		contentPane.add(btnNewButton_1);
		
		
		
		btnNewButton_1_1.setBounds(245, 354, 107, 41);
//		btnNewButton_1_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//				Home ho = new Home();
//				ho.setVisible(true);
//			}
//		});
		btnNewButton_1_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBackground(new Color(255, 255, 185));
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
		chckbxNewCheckBox.setBackground(new Color(255, 223, 208));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.setBounds(184, 303, 99, 23);
		contentPane.add(chckbxNewCheckBox);
	}
	
	public String checkLoginM(String name, String pass) {
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
	}
	
	public String getPass(char[] pass) {
		String p = "";
		for (char x:pass) {
			p+= x;
		}
		return p;
	}
	
	
		
	}

