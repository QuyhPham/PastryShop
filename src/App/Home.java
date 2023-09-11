package App;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {
	private JPanel contentPane;
	public JButton btnNewButton_1 = new JButton("SIGN UP");
	public JButton btnIntroduce  = new JButton("INTRODUCE");
	public JButton btnNewButton = new JButton("LOGIN");
	
	//JFrame f;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Home frame = new Home();
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
	public Home() {
		
//		//f.setContentPane(new JLabel(new ImageIcon("D:\\JAVA\\windowbuilder\\src\\image\\h1.jpg" + "")));
//	
//		f.setContentPane(new JLabel(
//				 new ImageIcon( new ImageIcon(
//						java.awt.Toolkit.getDefaultToolkit().getImage(
//								Home.class.getResource("/image/nha.png")
//								)
//						).getImage().getScaledInstance(989, 689, Image.SCALE_DEFAULT))));
		

		setForeground(new Color(128, 0, 0));
		setTitle("HOME");
		URL MainIcon = SignUp.class.getResource("/Image/Home.jpg");
		Image img = Toolkit.getDefaultToolkit().createImage(MainIcon);
		this.setIconImage(img);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 689);
		setSize(989, 689);
		setResizable(false);
		getContentPane().setLayout(null);
		//setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(255, 199, 142));
		btnNewButton.setBounds(131, 341, 206, 53);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBackground(new Color(255, 199, 142));
		btnNewButton_1.setBounds(131, 256, 206, 53);
		contentPane.add(btnNewButton_1);
		
		
		btnIntroduce.setForeground(new Color(128, 0, 0));
		btnIntroduce.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnIntroduce.setBackground(new Color(255, 199, 142));
		btnIntroduce.setBounds(131, 426, 206, 53);
		contentPane.add(btnIntroduce);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Home.class.getResource("/Image/Poster.png")
						)
				).getImage().getScaledInstance(989, 652, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(0, 0, 989, 652);
		//lblNewLabel_1.setSize(1400, 500);
		contentPane.add(lblNewLabel_1);
		
	}
}
