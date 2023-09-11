package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Normal.Cakes;


public class CakeConnect extends ConnectDatabase {
	
	
	public ArrayList<Cakes> getAll() {
		ArrayList<Cakes> list = new ArrayList<>();
		
		String sql = "select * from Cakes";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Cakes co = new Cakes();
				co.setID(rs.getInt(1));
				co.setName(rs.getString(2));
				co.setImage(rs.getBytes(3));
				
				co.setMainIngredients(rs.getString(4));
				co.setPrice(rs.getLong(5));
				
				list.add(co);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Object[] getCakes() {
		
		String sql = "select name from Cakes";
		try {
		Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stm.executeQuery(sql);
		int i = 0;
		rs.last();
		Object list [] = new Object[rs.getRow()];
		rs.beforeFirst();
		while (rs.next()) {
			
			list[i] = rs.getString(1);
			i++;
				
		}
		return list;
	} catch (Exception e) {
		e.printStackTrace();
	}
		return null;
	}
	
	public boolean add(String name, String pic, String ingre, long price) {
		String sql = "insert into cakes(name, mainingredients, price, image) "
				+ "select '"+name+ "',  '" +ingre+ "'," + price
				+ ", BulkColumn from OPENROWSET(BULK N'"+pic+"', SINGLE_BLOB) image;";
		//System.out.println(sql);
		Statement stm;
		try {
			stm = con.createStatement();
			return stm.executeUpdate(sql) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
public boolean delete(int ID) {
		
		String sql = "delete from cakes where idce = " + ID;
		try {
			PreparedStatement kn = con.prepareStatement(sql);
			return kn.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}

public boolean update(String name, String ingre, long price, int IDca) {
	
	try {
		//int row = EmployeeMana.table.getSelectedRow();
		//String value = (EmployeeMana.table.getModel().getValueAt(row, 0).toString());
		String query = "UPDATE cakes SET name=?, mainingredients=?, price=? where IDCe=?";
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, name);
		//pst.setString(2, pic2);
		pst.setString(2, ingre);
		pst.setLong(3, price);
		pst.setInt(4,IDca);
		
		
//		DefaultTableModel model = (DefaultTableModel)EmployeeMana.table.getModel();
//		model.setRowCount(0);
	    pst.executeUpdate();
	    return true;
		
		//JOptionPane.showConfirmDialog(null, "Update sucessfully!");
		
	} catch (SQLException e1) {
		 //TODO Auto-generated catch block
		JOptionPane.showConfirmDialog(null, e1);
	}
	return false;
	}

public boolean update1(byte[] image, int IDCa) {
	try {
		String sql = "update cakes SET Image=? where IDCe =? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setBytes(1, image);
		pst.setInt(2, IDCa);
		pst.executeUpdate();
		pst.close();
	
	}catch(SQLException e2){
		//TODO Auto-generated catch block
				JOptionPane.showConfirmDialog(null, e2);
	}
	return false;
}

public ArrayList<Cakes> find(String found)  // vaf nos cx laf cai nay
{
	
	ArrayList<Cakes> list = new ArrayList<>();
	                                                       //cung nhu cai nay oke hieu roai, rk thi ghi found het di, ong ghi find, toi tuong cai khac
	String sql = "select * from Cakes where  name like '%" + found + "%' or MainIngredients like '%"+ found+"%' or Price like '%"+found+"%'";
	try {
		//Cakes co = new Cakes();
		Statement pst = con.createStatement();
		ResultSet rs = pst.executeQuery(sql);
		while (rs.next()) {
			// lay danh sach tim duoc
			Cakes co = new Cakes();
			co.setID(rs.getInt(1));
			co.setName(rs.getString(2));
			co.setImage(rs.getBytes(3));	
			co.setMainIngredients(rs.getString(4));
			co.setPrice(rs.getLong(5));
			
			list.add(co);
		}
//		pst.setString(1, found);
//		pst.execute();
//		pst.close();
		//list.add(pst);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
		
		
	
}

	public Cakes get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
