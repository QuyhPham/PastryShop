package App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
 public JButton btnNewButton_1 = new JButton("Back");
 public JButton btnNewButton = new JButton("Customer");
 public JButton btnManager = new JButton("Manager");

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login frame = new Login();
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
	public Login() {
		setForeground(new Color(128, 0, 0));
		this.setTitle("LOGIN");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Login.class.getResource("/Image/INFO.png"))));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(164, 164, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(247, 205, 96));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(60, 54, 264, 63);
		contentPane.add(btnNewButton);
		
		
		btnManager.setForeground(new Color(0, 111, 55));
		btnManager.setBackground(new Color(177, 242, 168));
		btnManager.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnManager.setBounds(60, 141, 264, 63);
		contentPane.add(btnManager);
		
		
		btnNewButton_1.setBackground(new Color(255, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_1.setBounds(306, 229, 70, 23);
		contentPane.add(btnNewButton_1);
	}

}
