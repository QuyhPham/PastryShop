package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.PrintGraphics;
import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import javax.lang.model.element.NestingKind;
import javax.swing.JOptionPane;

public class ConnectDatabase {
	PreparedStatement ps = null;
	Statement stm = null;
	ResultSet rs = null;
	public static String userName = "sa";
	public static String password = "12345";
	public static String url = "jdbc:sqlserver://LAPTOP-OHRLA2L2\\SQLEXPRESS:1433;databaseName=PastryShop";
	public Connection con = null;
	public ConnectDatabase() {
		try {//phai co url truoc, sau do nhap ten, roi cuoi cung la nhap password
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url , userName , password);
			System.out.println(" connected sucessfuly !");
		} catch (Exception e) {
			System.out.println(" Connected error !");
		}
	}
	
//	//Tài Khoản
//		public boolean checkLogin(String Username, String Password) {
//			try {
//				ps = con.prepareStatement("SELECT Username, Password FROM Users WHERE Username = ? AND Password = ?");
//				ps.setString(1, Username);
//				ps.setString(2, Password);
//				rs = ps.executeQuery();
//				while (rs.next()) {
//					if (rs.getString("Username").equals(Username) && rs.getString("Password").equals(Password)) {
//						return true;
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return false;
//		}
//		public String getPos(String Username) {
//			try {
//				stm = con.createStatement();
//				rs = stm.executeQuery("SELECT Position FROM Users WHERE Username = '"+Username+"'");
//				while (rs.next()) {
//					String posi = rs.getString("Position");
//					return posi;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return null;
//		}
//		public int getID(int IDEm) {
//			try {
//				stm = con.createStatement();
//				rs = stm.executeQuery("SELECT IDE FROM Employee WHERE IDE = " + IDEm);
//				while (rs.next()) {
//					return rs.getInt("MaTaiKhoan"); 
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return 0;
//		}
//		public String getUserName(int IDa) {
//			try {
//				stm = con.createStatement();
//				rs = stm.executeQuery("SELECT Username FROM Users WHERE ID = " + IDa);
//				while (rs.next()) {
//					String Username = rs.getString("Username");
//					return Username;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return null;
//		}
//		public ResultSet getTaiKhoan() {
//			try {
//				stm = con.createStatement();
//				rs = stm.executeQuery("SELECT TenDangNhap FROM TaiKhoan");
//				return rs;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return null;
//		}
//		public void themTaiKhoan(int mtk ,String tdn ,String mk,String q) {
//			try {
//				ps = con.prepareStatement("INSERT INTO TaiKhoan VALUES(?, ?, ?, ?)");
//				ps.setInt(1, mtk);
//				ps.setString(2, tdn);
//				ps.setString(3, mk);
//				ps.setString(4, q);
//				ps.executeUpdate();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}

		public static Connection getConnection() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		
		
		
		
		
		
		
		
//	public boolean AddEm(Employee em) {
//		try {
//			ps = con.prepareStatement("INSERT INTO EMPLOYEE VALUES(?, ?, ?, ?, ?, ?, ?)");
//			ps.setString(1, em.getID());
//			ps.setString(2, em.getName());
////			ps.setDate(3,(Date) em.getDate());
//			ps.setDate(3, new Date(em.getDate().getTime()));
//			ps.setBoolean(4, em.isSex());
//			ps.setFloat(5, em.getCCCD());
//			ps.setFloat(6, em.getPhone());
//			ps.setString(7, em.getExp());
//			ps.executeUpdate();
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//	
//	public void DeleteEm(String ID) {
//		try {
//			ps = con.prepareStatement("DELETE FROM EMPLOYEE WHERE ID = ?");
//			ps.setString(1, ID);
//			ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public ArrayList<Employee> getEmployees(){
//		ArrayList<Employee> list = new ArrayList<>();
//		String sql = "select * from employee";
//		try {
//			PreparedStatement rl = con.prepareStatement(sql);
//			ResultSet rs = rl.executeQuery();
//			while (rs.next()) {
//				Employee e = new Employee();
//				e.setID(rs.getString(1));
//				e.setName(rs.getString(2));
//				e.setDate(rs.getDate(3));
//				e.setSex(rs.getBoolean(4));
//				e.setCCCD(rs.getFloat(5));
//				e.setPhone(rs.getFloat(6));
//				e.setExp(rs.getString(7));
//				list.add(e);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
//	
}


