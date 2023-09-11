package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import App.EmployeeMana;
import Normal.Cakes;
import Normal.Employee;



public class EmployeeConnect extends ConnectDatabase {
	
	public ArrayList<Employee> getAll() {
		ArrayList<Employee> elist = new ArrayList<>();
		
		String sql = "select * from Employee";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Employee e = new Employee();
				e.setID(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDate(rs.getString(3));
				e.setSex(rs.getString(4));
				e.setCCCD(rs.getLong(5));
				e.setPhone(rs.getLong(6));
				e.setSalary(rs.getLong(7));
				e.setShifts(rs.getString(8));
				e.setNote(rs.getString(9));
				elist.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return elist;
	}
	
//	public Object[] getEmployee() {
//	String sql = "select name from Employee";
//	try {
//		Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//		ResultSet rs = stm.executeQuery(sql);
//		int i = 0;
//		rs.last();
//		Object list [] = new Object[rs.getRow()];
//		rs.beforeFirst();
//		while (rs.next()) {
//			
//			list[i] = rs.getString(1);
//			i++;
//				
//		}
//		return list;
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//		return null;
//}
	
	public boolean add(String name, String date, String sex, long cccd, long phone, long salary, String shifts, String note) {
		String sql = "insert into employee(name, date, sex, cccd, phone, salary, shifts, note) "
			+ "select '"+name+ "', '"+ date + "', '"+sex+"'," + cccd +", "+phone+", "+salary+" ,'" +shifts+ "','"+ note+"'";
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
		
		String sql = "delete from employee where ide = " + ID;
		try {
			PreparedStatement kn = con.prepareStatement(sql);
			return kn.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
public boolean update(String name, String date, String sex, long cccd, long phone, long salary, String shifts, String note, int ID) {
		
		try {
			//int row = EmployeeMana.table.getSelectedRow();
			//String value = (EmployeeMana.table.getModel().getValueAt(row, 0).toString());
			String query = "UPDATE employee SET Name=?, Date=?, Sex=?, CCCD=?, Phone=?, Salary=?, Shifts=?, Note=? where IDE=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, date);
			pst.setString(3, sex);
			pst.setLong(4, cccd);
			pst.setLong(5, phone);
			pst.setLong(6, salary);
			pst.setString(7, shifts);
			pst.setString(8, note);
			pst.setInt(9,ID);
			
			
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


public ArrayList<Employee> find(String found)  // vaf nos cx laf cai nay
{
	
	ArrayList<Employee> elist = new ArrayList<>();
	                                                       //cung nhu cai nay oke hieu roai, rk thi ghi found het di, ong ghi find, toi tuong cai khac
	String sql = "select * from Employee where  name like '%" + found + "%' or Date like '%"+ found+"%' or Sex like '%"+found+"%' or CCCD like '%"+found
			+"%' or Phone like '%"+found+"%' or Salary like '%"+found+"%' or Shifts like '%"+found+"%' or Note like '%"+found+"%'";
	try {
		//Cakes co = new Cakes();
		Statement pst = con.createStatement();
		ResultSet rs = pst.executeQuery(sql);
		while (rs.next()) {
			// lay danh sach tim duoc
			Employee e = new Employee();
			e.setID(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setDate(rs.getString(3));
			e.setSex(rs.getString(4));
			e.setCCCD(rs.getLong(5));
			e.setPhone(rs.getLong(6));
			e.setSalary(rs.getLong(7));
			e.setShifts(rs.getString(8));
			e.setNote(rs.getString(9));
			elist.add(e);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return elist;
	
		
		
	
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
