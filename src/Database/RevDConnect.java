package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Normal.Bill;

public class RevDConnect extends ConnectDatabase {
	public ArrayList<Bill> getRevenueGN() {
		ArrayList<Bill> bilist = new ArrayList<>();
		String sql = "select IDB, GoodsPurchased, DateOrder, Price from Bill where item = 'GetNow'";//nho doi khuc nay thanh cai khuc trong sql nha ma
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Bill b = new Bill();
				b.setIDB(rs.getInt(1));
				//b.setIDC(rs.getInt(2));
				//b.setNameClient(rs.getString(3));
				b.setDateOrder(rs.getString(3));
				//b.setDatePay(rs.getString(5));
				b.setPrice(rs.getLong(4));
				//b.setPaymentMethod(rs.getString(7));
				b.setGood(rs.getString(2));
				bilist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bilist;
	
		
	}
	
	
	
	public ArrayList<Bill> getRevenuePO() {
		ArrayList<Bill> bilist = new ArrayList<>();
		String sql = "select IDB, GoodsPurchased, DateOrder, Price from Bill where item = 'PreOrder'";//nho doi khuc nay thanh cai khuc trong sql nha ma
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Bill b = new Bill();
				b.setIDB(rs.getInt(1));
				//b.setIDC(rs.getInt(2));
				//b.setNameClient(rs.getString(3));
				b.setDateOrder(rs.getString(3));
				//b.setDatePay(rs.getString(5));
				b.setPrice(rs.getLong(4));
				//b.setPaymentMethod(rs.getString(7));
				b.setGood(rs.getString(2));
				bilist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bilist;
	
		
	}



	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}



	public Bill get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
