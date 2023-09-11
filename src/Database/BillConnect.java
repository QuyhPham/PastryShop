package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Normal.Bill;



public class BillConnect extends ConnectDatabase {
	//ham find la se nhu cai duoi nay ne
	public ArrayList<Bill> getAll() {
		ArrayList<Bill> bilist = new ArrayList<>();
		
		String sql = "select * from Bill";//nho doi khuc nay thanh cai khuc trong sql nha ma
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Bill b = new Bill();
				b.setIDB(rs.getInt(1));
				b.setIDC(rs.getInt(2));
				
				b.setDateOrder(rs.getString(3));
				b.setDatePay(rs.getString(4));
				b.setPrice(rs.getLong(5));
				
				b.setGood(rs.getString(6));
				bilist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bilist;
	}
	
	
	public ArrayList<Bill> getHis() {
		ArrayList<Bill> bilist = new ArrayList<>();
		
		String sql = "select  Bill.IDB, Bill.DateOrder, Bill.DatePay, Bill.Price, Bill.GoodsPurchased from Bill";//nho doi khuc nay thanh cai khuc trong sql nha ma
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Bill b = new Bill();
				b.setIDB(rs.getInt(1));
				
				
				b.setDateOrder(rs.getString(2));
				b.setDatePay(rs.getString(3));
				b.setPrice(rs.getLong(4));
				
				b.setGood(rs.getString(5));
				bilist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bilist;
	}
	
	
	
	public boolean addbillGetNow(Bill b) {
		try {
			String sql = "INSERT INTO Bill VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, b.getIDC());
			pst.setString(2, b.getDateOrder().toString());
			pst.setString(3, b.getDatePay().toString());
			pst.setLong(4, b.getPrice());
			pst.setString(5, b.getGood());
			pst.setString(6, b.getItem());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
//	public int addidc(int idc) {
//	
//			Statement stm;
//			try {
//				String sql = "select idc from users ";
//				stm = con.createStatement();
//				return stm.executeUpdate(sql) > 0;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
////			
////				int mhd = rs.getInt("MaHoaDon");
////				return mhd;
////		
//		return 0;
//	
//	}
		
		
	
//		String sql = "select  Bill.IDB, Bill.IDC, Bill.DateOrder, Bill.DatePay, Bill.Price, Bill.GoodsPurchased from Bill inner join Users on Bill.IDC = Users.ID";
//		Statement stm;
//		try {
//			stm = con.createStatement();
//			return stm.executeUpdate(sql) > 0;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//		
//	}
	
	
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
