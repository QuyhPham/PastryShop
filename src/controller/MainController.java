package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ClientInfoStatus;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import App.BillMana;
import App.Cake;
import App.CakePrice;
import App.ClientMana;
import App.Customer;
import App.EmployeeMana;
import App.HistoryCus;
import App.Home;
import App.HomeCustomer;
import App.HomeManager;
import App.IntroCus;
import App.Introduce;
import App.Login;
import App.LoginWithCus;
import App.LoginWithMana;
import App.Manager1;
import App.MenuMana;
import App.OrderCus;
import App.PriceMana;
import App.SignUp;
import App.StatisticMana;
import Normal.Users;


public class MainController {
    static Home ho = new Home();
    static SignUp si = new SignUp();
    static Login lo = new Login();
    static Introduce in = new Introduce();
    static int ID = -1;
	static HomeCustomer hc =  new HomeCustomer();
	static HomeManager hm = new HomeManager();
	static Customer c = new Customer();
	static HistoryCus hi = new HistoryCus();
	static IntroCus ic = new IntroCus();
	static Manager1 ma = new Manager1();
	static EmployeeMana em = new EmployeeMana();
	static ClientMana cli = new ClientMana();
	static BillMana bi = new BillMana();
	static MenuMana me = new MenuMana();
	static PriceMana p = new PriceMana();
	static StatisticMana st = new StatisticMana();
	static Cake ca = new Cake();
	static CakePrice pr = new CakePrice();
	static LoginWithCus lowc = new LoginWithCus();
	static LoginWithMana lowm = new LoginWithMana();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		controllerCus();
		controllerMana();
		controllerHome();
		controllerSignUp();
		controllerLogin();
		ho.setVisible(true);
//		hc.setVisible(true);
//		hm.setVisible(true);
//		hi.setVisible(true);
		
		
	}
	
	public static void controllerHome() {
		
		
		ho.btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ho.setVisible(false);
			si.setVisible(true);
			}
		});
		
		ho.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ho.setVisible(false);
			lo.setVisible(true);
			}
				
		});
		
		ho.btnIntroduce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ho.setVisible(false);
			in.setVisible(true);
			
			
			}
		});
		
		in.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    
					
					in.setVisible(false);
					ho.setVisible(true);
					
				
				
			}
		});
		
		
		lowm.btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if ( JOptionPane.showConfirmDialog(null, "Are you sure you want to out?") == 0) {
					
					
					lowm.setVisible(false);
					
					ho.setVisible(true);
			}}
		});
		
		
		lowc.btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if ( JOptionPane.showConfirmDialog(null, "Are you sure you want to out?") == 0) {
					
					
					lowc.setVisible(false);
					
					ho.setVisible(true);
			}
			}});
		
	}
		
	public static void controllerSignUp() {
		si.btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    if ( JOptionPane.showConfirmDialog(null, "Any information will not be saved. Do you still want to get out?") == 0) {
					
					si.setVisible(false);
					ho.setVisible(true);
					
				}
				
			}
		});
		
		
		lowc.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lowc.setVisible(false);
				
				
			si.setVisible(true);
			}
		});
		
		si.btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (si.checkSignUp()) {
					si.setVisible(false);
					
					ho.setVisible(true);
				} 
				
				
				
			}
		});
	}
		
		public static void controllerLogin() {
		
		lo.btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    if ( JOptionPane.showConfirmDialog(null, "Any information will not be saved. Do you still want to get out?") == 0) {
					
					lo.setVisible(false);
					ho.setVisible(true);
					
				}
				
			}
		});
		
		
		lo.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lo.setVisible(false);
				
				lowc.setVisible(true);
			}
		});
		
		
		lo.btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lo.setVisible(false);
				
				lowm.setVisible(true);
			}
		});
		
		
		
		lowm.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lowm.setVisible(false);
				
				lo.setVisible(true);
			}
		});
		
		
		lowc.btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = lowc.textField_1.getText();
				String Password = lowc.getPass(lowc.jpassWord.getPassword());
			     
			    String Position =  lowc.checkLoginC(Username, Password);
			    
		
				 if ( Position.equals("User")){
					c.OrderCus.setID(lowc.getID(Username)); 
					ca.setID(lowc.getID(Username));
					hc.setVisible(true);
					hc.setLocationRelativeTo(null);
					
					
				} else {
					JOptionPane.showConfirmDialog(null, "You haven't position!");
				}
				lowc.textField_1.setText("");
				lowc.jpassWord.setText("");
				lowc.setVisible(false);
			}
		});
		
		lowm.btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = lowm.textField_1.getText();
				String Password = lowm.getPass(lowm.jpassWord.getPassword());
			     
			    String Position =  lowm.checkLoginM(Username, Password);
			
		
				if ( Position.equals("Admin")){
					
					hm.setVisible(true);
					hm.setLocationRelativeTo(null);
					
				}else {
					JOptionPane.showConfirmDialog(null, "You haven't position!");
				}
				lowm.textField_1.setText("");
				lowm.jpassWord.setText("");
				lowm.setVisible(false);
			}
		});
	
		
	}
	
	
	public static void controllerCus() {
		hc.Get_now.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hc.setVisible(false);
				
				c.setVisible(true);
			}});
		
		hc.Pre_Order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hc.setVisible(false);
				
				ca.setVisible(true);
			}});
		
		hc.history.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hc.setVisible(false);
				
				hi.setVisible(true);
			}});
		
		hi.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hi.setVisible(false);
				
				hc.setVisible(true);
			}
		});
		
		hc.Introduce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hc.setVisible(false);
				
				ic.setVisible(true);
			}});
		
		hc.Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Are you sure you want to out?") == 0) {
				hc.setVisible(false);
				
				ho.setVisible(true);
				}}});
		
//		Logout.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if ( JOptionPane.showConfirmDialog(null, "Are you sure you want to out?") == 0) {
//					
//					HomeManager.this.dispose();
//				setVisible(false);
//				Home ho = new Home();
//				ho.setVisible(true);
//			}}});
		
		hm.Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Are you sure you want to out?") == 0) {
				hm.setVisible(false);
				
				ho.setVisible(true);
				}}});
		
		
		ic.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ic.setVisible(false);
				
				hc.setVisible(true);
			}
		});
		
		
		c.OrderCus.btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Any information will not be saved. Do you still want to get out?") == 0) {
					
					c.OrderCus.dispose();
				c.setVisible(false);
				hc.setVisible(true);
			}
			}});
		
		ca.btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ca.setVisible(false);
				hc.setVisible(true);
			}
		});
		
		ca.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				ca.setVisible(false);
				pr.setVisible(true);;
			}
		});
		
		
		ca.btnIntroduce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ca.setVisible(false);
				
				ic.setVisible(true);
			}
		});
		
	}
	
	public static void controllerMana() {
		
		hm.Web_Mana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hm.setVisible(false);
				
				ma.setVisible(true);
			}});
		
		//exit cua nhan vien
		ma.EmployeeMana.btnNewButton_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if ( JOptionPane.showConfirmDialog(null, "Any information will not be saved. Do you still want to get out?") == 0) {
					
				
				ma.setVisible(false);
				
				hm.setVisible(true);
			}
			}});
		
		//exit khach hang
		ma.ClientMana.btnNewButton_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Do you still want to get out?") == 0) {
				ma.setVisible(false);
				hm.setVisible(true);
			}
			}});
		
		//exit cua hoa don bill
		ma.BillMana.btnNewButton_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Do you still want to get out?") == 0) {
				ma.setVisible(false);
				hm.setVisible(true);
			}
			}});
		
		//exit cua menu
		ma.MenuMana.btnNewButton_ExitD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Any information will not be saved. Do you still want to get out?") == 0) {
				ma.setVisible(false);
				hm.setVisible(true);
			}}
		});
		
		ma.MenuMana.btnNewButton_ExitCo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Any information will not be saved. Do you still want to get out?") == 0) {
				ma.setVisible(false);
				hm.setVisible(true);
			}}
		});
		
		ma.MenuMana.btnNewButton_ExitCake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Any information will not be saved. Do you still want to get out?") == 0) {
				ma.setVisible(false);
				hm.setVisible(true);
			}}
		});
		
		//exit cua price gia tien hinh dang hay jj do
		ma.PriceMana.btnNewButton_Exit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Any information will not be saved. Do you still want to get out?") == 0) {
				ma.setVisible(false);
				hm.setVisible(true);
			}}
		});
		
		ma.PriceMana.btnNewButton_Exit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Any information will not be saved. Do you still want to get out?") == 0) {
				ma.setVisible(false);
				hm.setVisible(true);
			}}
		});
		
		
		ma.StatisticMana.btnNewButton_Exit_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Do you still want to get out?") == 0) {
				ma.setVisible(false);
				hm.setVisible(true);
			}}
		});
		
		
		
		ma.StatisticMana.btnNewButton_ExitCake_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( JOptionPane.showConfirmDialog(null, "Do you still want to get out?") == 0) {
				ma.setVisible(false);
				hm.setVisible(true);
			}}
		});
		
		
		
		
	}
}
