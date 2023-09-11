package App;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Introduce extends JFrame {

	private JPanel contentPane;
	public JButton btnNewButton = new JButton("PASTRY SHOP");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Introduce frame = new Introduce();
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
	public Introduce() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 1400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnNewButton.setBackground(new Color(198, 255, 255));
		btnNewButton.setFont(new Font("Tempus Sans ITC", Font.BOLD, 9));
		btnNewButton.setBounds(1061, 598, 98, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Introduce.class.getResource("/Image/intro1.png")
						)
				).getImage().getScaledInstance(700, 343, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(0, 0, 700, 343);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Introduce.class.getResource("/Image/intro3.png")
						)
				).getImage().getScaledInstance(583, 343, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(700, 0, 583, 343);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Introduce.class.getResource("/Image/intro2.png")
						)
				).getImage().getScaledInstance(700, 357, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(0, 343, 700, 357);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						Introduce.class.getResource("/Image/intro4.png")
						)
				).getImage().getScaledInstance(583, 357, Image.SCALE_DEFAULT)));
		lblNewLabel_1_1.setBounds(700, 343, 583, 357);
		contentPane.add(lblNewLabel_1_1);
		
		
	}

}
