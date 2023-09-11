package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Normal.Cakes;
import Normal.Shape;



public class ShapeConnect extends ConnectDatabase{
	public ArrayList<Shape> getAll() {
		ArrayList<Shape> slist = new ArrayList<>();
		
		String sql = "select * from Shapes";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Shape e = new Shape();
				e.setIDs(rs.getInt(1));
				e.setShape(rs.getString(2));
				e.setPrice(rs.getLong(3));
				
				slist.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slist;
	}
	
	public Object[] getShape() {
		
		String sql = "select Name from Shapes";
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
	
	
	
	public boolean add(String name, long price) {
		String sql = "insert into shapes(name, Price) "
			+ "select '"+name+ "', " + price +"";
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
		
		String sql = "delete from shapes where IDShape = " + ID;
		try {
			PreparedStatement kn = con.prepareStatement(sql);
			return kn.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
public boolean update(String name, long price, int IDs) {
		
		try {
			//int row = EmployeeMana.table.getSelectedRow();
			//String value = (EmployeeMana.table.getModel().getValueAt(row, 0).toString());
			String query = "UPDATE shapes SET name=?, Price=? where IDShape=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setLong(2, price);
			pst.setInt(3,IDs);
			
			
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

public ArrayList<Shape> find1(String found)  // vaf nos cx laf cai nay
{
	
	ArrayList<Shape> slist = new ArrayList<>();
	                                                       //cung nhu cai nay oke hieu roai, rk thi ghi found het di, ong ghi find, toi tuong cai khac
	String sql = "select * from Shapes where  name like '%" + found + "%' or Price like '%"+found+"%'";
	try {
		//Cakes co = new Cakes();
		Statement pst = con.createStatement();
		ResultSet rs = pst.executeQuery(sql);
		while (rs.next()) {
			// lay danh sach tim duoc
			Shape e = new Shape();
			e.setIDs(rs.getInt(1));
			e.setShape(rs.getString(2));
			e.setPrice(rs.getLong(3));
			
			slist.add(e);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return slist;
	
		
		
	
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
