package App;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import java.awt.Font;
import java.awt.Image;

public class Manager1 extends JFrame {

	private JPanel contentPane;

	public EmployeeMana EmployeeMana;
	public ClientMana ClientMana;
	public BillMana BillMana;
	public MenuMana MenuMana;
	public PriceMana PriceMana;
	public StatisticMana StatisticMana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager1 frame = new Manager1();
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
	public Manager1() {

		setForeground(new Color(128, 0, 0));
		this.setTitle("Management");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(Manager1.class.getResource("/Image/e.jpg"))));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		EmployeeMana = new EmployeeMana();

		ClientMana = new ClientMana();

		BillMana = new BillMana();

		MenuMana = new MenuMana();

		PriceMana = new PriceMana();

		StatisticMana = new StatisticMana();

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(202, 255, 202));
		panelMenu.setBounds(0, 0, 135, 652);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Manager1.class.getResource("/Image/Gato.png")))
						.getImage().getScaledInstance(135, 100, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(0, 0, 135, 100);
		panelMenu.add(lblNewLabel);

		// Nhan vien
		JPanel pnEmployee = new JPanel();
		pnEmployee.setLayout(null);
		pnEmployee.setBackground(new Color(255, 223, 208));
		pnEmployee.setBounds(0, 101, 135, 93);
		panelMenu.add(pnEmployee);
		pnEmployee.addMouseListener(new PanelButtonMouseAdapter(pnEmployee) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(EmployeeMana);
			}
		});

		JLabel lblNewLabel_2_2 = new JLabel("EMPLOYEE");
		lblNewLabel_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2_2.setBounds(7, 2, 68, 21);
		pnEmployee.add(lblNewLabel_2_2);

		JLabel lblNewLabel_1_1 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Manager1.class.getResource("/Image/employ.jpg")))
						.getImage().getScaledInstance(121, 83, Image.SCALE_DEFAULT)));
		
		lblNewLabel_1_1.setBounds(7, 5, 121, 83);
		pnEmployee.add(lblNewLabel_1_1);

		// khach hang
		JPanel pnClient = new JPanel();
		pnClient.setLayout(null);
		pnClient.setBackground(new Color(255, 203, 179));
		pnClient.setBounds(0, 192, 135, 93);
		panelMenu.add(pnClient);
		pnClient.addMouseListener(new PanelButtonMouseAdapter(pnClient) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(ClientMana);
			}
		});

		JLabel lblNewLabel_1 = new JLabel("CLIENT");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(7, 2, 68, 21);
		pnClient.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Manager1.class.getResource("/Image/client1.jpg")))
						.getImage().getScaledInstance(121, 83, Image.SCALE_DEFAULT)));
		lblNewLabel_2.setBounds(7, 5, 121, 83);
		pnClient.add(lblNewLabel_2);

		// hoa don
		JPanel pnBill = new JPanel();
		pnBill.setBounds(0, 285, 135, 93);
		panelMenu.add(pnBill);
		pnBill.addMouseListener(new PanelButtonMouseAdapter(pnBill) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(BillMana);
			}
		});
		pnBill.setBackground(new Color(255, 182, 147));
		pnBill.setLayout(null);

		JLabel lblNewLabel_1_3 = new JLabel("BILL");
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_3.setBounds(7, 2, 68, 21);
		pnBill.add(lblNewLabel_1_3);

		JLabel lblNewLabel_2_3 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Manager1.class.getResource("/Image/bil2.jpg")))
						.getImage().getScaledInstance(121, 83, Image.SCALE_DEFAULT)));
		lblNewLabel_2_3.setBounds(7, 5, 121, 83);
		pnBill.add(lblNewLabel_2_3);

		// Cai bang co may cai banh, nuoc,... de chon
		JPanel pnMenu = new JPanel();
		pnMenu.addMouseListener(new PanelButtonMouseAdapter(pnMenu) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(MenuMana);
			}
		});
		pnMenu.setLayout(null);
		pnMenu.setBackground(new Color(255, 166, 123));
		pnMenu.setBounds(0, 376, 135, 93);
		panelMenu.add(pnMenu);

		JLabel lblNewLabel_1_2 = new JLabel("MENU");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_2.setBounds(7, 2, 68, 21);
		pnMenu.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Manager1.class.getResource("/Image/menu1.jpg")))
						.getImage().getScaledInstance(121, 83, Image.SCALE_DEFAULT)));
		lblNewLabel_1_1_1.setBounds(7, 5, 121, 83);
		pnMenu.add(lblNewLabel_1_1_1);

		// Gia hinh dang, mau sac jj do
		JPanel pnPrice = new JPanel();
		pnPrice.addMouseListener(new PanelButtonMouseAdapter(pnPrice) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(PriceMana);
			}
		});
		pnPrice.setLayout(null);
		pnPrice.setBackground(new Color(255, 156, 108));
		pnPrice.setBounds(0, 467, 135, 93);
		panelMenu.add(pnPrice);

		JLabel lblNewLabel_1_4 = new JLabel("PRICE");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_4.setBounds(7, 2, 68, 21);
		pnPrice.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_1_1_1 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Manager1.class.getResource("/Image/money1.jpg")))
						.getImage().getScaledInstance(121, 83, Image.SCALE_DEFAULT)));
		lblNewLabel_1_1_1_1.setBounds(7, 5, 121, 83);
		pnPrice.add(lblNewLabel_1_1_1_1);

		// Doanh thu
		JPanel pnStatis = new JPanel();
		pnStatis.addMouseListener(new PanelButtonMouseAdapter(pnStatis) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(StatisticMana);
			}
		});
		pnStatis.setLayout(null);
		pnStatis.setBackground(new Color(255, 140, 85));
		pnStatis.setBounds(0, 559, 135, 93);
		panelMenu.add(pnStatis);

		JLabel lblNewLabel_1_5 = new JLabel("REVENUE");
		lblNewLabel_1_5.setForeground(Color.BLACK);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_5.setBounds(7, 2, 68, 21);
		pnStatis.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_1_1_2 = new JLabel(new ImageIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(Manager1.class.getResource("/Image/money4.jpg")))
						.getImage().getScaledInstance(121, 83, Image.SCALE_DEFAULT)));
		lblNewLabel_1_1_1_2.setBounds(7, 5, 121, 83);
		pnStatis.add(lblNewLabel_1_1_1_2);

		JPanel panelMain1 = new JPanel();
		panelMain1.setBounds(135, 0, 1156, 652);
		contentPane.add(panelMain1);
		panelMain1.setLayout(null);

		panelMain1.add(EmployeeMana);
		panelMain1.add(ClientMana);
		panelMain1.add(BillMana);
		panelMain1.add(MenuMana);
		panelMain1.add(PriceMana);
		panelMain1.add(StatisticMana);
		menuClicked(EmployeeMana);
		
		

	}

	public void menuClicked(JPanel panel) {
		EmployeeMana.setVisible(false);
		ClientMana.setVisible(false);
		BillMana.setVisible(false);
		MenuMana.setVisible(false);
		PriceMana.setVisible(false);
		StatisticMana.setVisible(false);
		panel.setVisible(true);
	}
	
	
	

	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;

		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(255, 223, 223));
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
	}
}