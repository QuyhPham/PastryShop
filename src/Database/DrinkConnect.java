package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Normal.Cakes;
import Normal.Drink;



public class DrinkConnect extends ConnectDatabase {
	
	public ArrayList<Drink> getAll() {
		ArrayList<Drink> dlist = new ArrayList<>();
		
		String sql = "select * from Drinks";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Drink d = new Drink();
				d.setID(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setImage(rs.getBytes(3));
				d.setSize(rs.getString(4));
				d.setMainIngredients(rs.getString(5));
				d.setPrice(rs.getLong(6));
				
				dlist.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlist;
	}
	
	public Object[] getDrinks() {
		String sql = "select name from Drinks";
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
	
	public boolean add(String name, String pic, String size, String ingre, long price) {
		String sql = "insert into drinks(name, size, mainingredients, price, image) "
				+ "select '"+name+ "', '"+ size + "', '" +ingre+ "'," + price
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
		
		String sql = "delete from drinks where iddr = " + ID;
		try {
			PreparedStatement kn = con.prepareStatement(sql);
			return kn.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
	public boolean update(String name, String size, String ingre, long price, int IDd) {
		
		try {
			//int row = EmployeeMana.table.getSelectedRow();
			//String value = (EmployeeMana.table.getModel().getValueAt(row, 0).toString());
			String query = "UPDATE drinks SET name=?, size=?, mainingredients=?, price=? where IDDr=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, size);
			pst.setString(3, ingre);
			pst.setLong(4, price);
			pst.setInt(5,IDd);
			
			
//			DefaultTableModel model = (DefaultTableModel)EmployeeMana.table.getModel();
//			model.setRowCount(0);
		    pst.executeUpdate();
		    return true;
			
			//JOptionPane.showConfirmDialog(null, "Update sucessfully!");
			
		} catch (SQLException e1) {
			 //TODO Auto-generated catch block
			JOptionPane.showConfirmDialog(null, e1);
		}
		return false;
		}

	public boolean update1(byte[] image, int IDd) {
		try {
			String sql = "update drinks SET Image=? where IDDr =? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setBytes(1, image);
			pst.setInt(2, IDd);
			pst.executeUpdate();
			pst.close();
		
		}catch(SQLException e2){
			//TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null, e2);
		}
		return false;
	}
	
	public ArrayList<Drink> find(String found)  // vaf nos cx laf cai nay
	{
		
		ArrayList<Drink> dlist = new ArrayList<>();
		                                                       //cung nhu cai nay oke hieu roai, rk thi ghi found het di, ong ghi find, toi tuong cai khac
		String sql = "select * from Drinks where  name like '%" + found + "%' or size like '%"+ found+"%' or MainIngredients like '%"+ found+"%' or Price like '%"+found+"%'";
		try {
			//Cakes co = new Cakes();
			Statement pst = con.createStatement();
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				// lay danh sach tim duoc
				Drink d = new Drink();
				d.setID(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setImage(rs.getBytes(3));
				d.setSize(rs.getString(4));
				d.setMainIngredients(rs.getString(5));
				d.setPrice(rs.getLong(6));
				
				dlist.add(d);
			}
//			pst.setString(1, found);
//			pst.execute();
//			pst.close();
			//list.add(pst);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dlist;
		
			
			
		
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
