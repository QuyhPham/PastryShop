package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Normal.Users;

public class ClientConnect extends ConnectDatabase {
	//ham find la se nhu cai duoi nay ne
	public ArrayList<Users> getAll() {
		ArrayList<Users> ulist = new ArrayList<>();
		
		String sql = "select ID, Name, Sex, Email, CCCD, Phone, Username from Users where Position = 'User'";//nho doi khuc nay thanh cai khuc trong sql nha ma
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Users u = new Users();
				u.setID(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setSex(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setCccd(rs.getLong(5));
				u.setPhone(rs.getLong(6));
				u.setUsername(rs.getString(7));
				ulist.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ulist;
	}
	
	
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object get(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
