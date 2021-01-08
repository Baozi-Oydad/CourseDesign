package com.jsu.lr.util;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.jsu.dao.DatabaseConnectionSql;
import com.jsu.lr.pojo.Customer;

public class DataToTxt {
	static Connection conn = new DatabaseConnectionSql().getConnection();
	public static List<Customer> getAllDAta() {
		String sql = "select * from cus";
		List<Customer> list = null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			list = new ArrayList<Customer>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Customer customer=new Customer();
				customer.setAccnum(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setSex(rs.getString(3));
				customer.setAddress(rs.getString(4));
				customer.setPhonenum(rs.getString(5));
				list.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("D:\\JAVA\\øŒ≥Ã…Ëº∆\\data.txt");) {
			List<Customer> list = getAllDAta();
			for(Customer s:list) {
				fw.write(s.toString()+"\r\n");
			}
			JOptionPane.showMessageDialog(null, "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
