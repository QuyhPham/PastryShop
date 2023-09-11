package App;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Database.BillConnect;
import Normal.Bill;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class HistoryCus extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Bill> bilist = new ArrayList<Bill>();
	private BillConnect bi = new BillConnect();
	public JButton btnNewButton = new JButton("Exit");
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HistoryCus frame = new HistoryCus();
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
	public HistoryCus() {
		
		setForeground(new Color(128, 0, 0));
        this.setTitle("History");
		this.setIconImage((Toolkit.getDefaultToolkit().createImage(HistoryCus.class.getResource("/Image/banggia.png"))));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 198, 198));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon( new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(
						HistoryCus.class.getResource("/Image/gato1.jpg")
						)
				).getImage().getScaledInstance(836, 200, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(0, 0, 836, 200);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(10, 248, 434, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Purchase History");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(10, 223, 265, 27);
		contentPane.add(lblNewLabel_1);
		
		bilist = bi.getHis();
		table = new JTable();
		table.setBackground(new Color(255, 255, 221));
//		table.setFont(new Font("Tahoma", Font.PLAIN, 25));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IDB", "Date order", "Date Pay", "Price", "Goods Purchased"
			}
		) );
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(230);
			
			
			
			
			table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
			table.setBounds(375, 91, 889, 422);
			DefaultTableModel model = (DefaultTableModel) table.getModel();

			Object[] row = new Object[5];

			for (int i = 0; i < bi.size(); i++) {
				row[0]=((Bill) bi.get(i)).getIDB();
				//row[1]=((Bill) bi.get(i)).getIDC();

			
			row[1]= ((Bill) bi.get(i)).getDateOrder();
			
			row[2]=((Bill) bi.get(i)).getDatePay();

			row[3]=((Bill) bi.get(i)).getPrice();

			
			row[4]=((Bill) bi.get(i)).getGood();
			
			
				
		} table.setRowHeight(30);
		model.addRow(row);
		loadInformationBill();
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 20));
		table.setBounds(375, 91, 889, 422);
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		scrollPane.setBounds(0, 257, 836, 347);
		contentPane.add(scrollPane);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(206, 206, 255));
		btnNewButton.setBounds(703, 615, 95, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadInformationBill();
			}
		});
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(206, 206, 255));
		btnNewButton_1.setBounds(598, 615, 95, 37);
		contentPane.add(btnNewButton_1);
	}
	
	private void loadInformationBill() {
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {
					"IDB", "Date order", "Date Pay",  "Price", "Goods Purchased"
				}
					) {
						boolean[] columnEdittables = new boolean[] {
								false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEdittables[column];
						}
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Long.class, Object.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					} );
		DefaultTableModel model = (DefaultTableModel) table.getModel();
	
			table.setRowHeight(30);
			bilist = bi.getHis();
			
			for (Bill b:bilist) {
				Object[] row = new Object[5];
					row[0] = b.getIDB();
					//row[1] = b.getIDC();
					
					
					row[1]=b.getDateOrder();

					row[2]=b.getDatePay();

					row[3]=b.getPrice();
					
					row[4]=b.getGood();
					
					

					
					model.addRow(row);
				
			}
			
		
	}
}
