package com.jsu.lr.util;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.jsu.dao.DatabaseConnectionSql;
import com.jsu.lr.pojo.*;

public class DataToTxt3 {
	static Connection conn = new DatabaseConnectionSql().getConnection();
	public static List<Order> getAllDAta() {
		String sql = "select * from order01";
		List<Order> list = null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			list = new ArrayList<Order>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Order order=new Order();
				order.setOrdernum(rs.getInt(1));
				order.setAccnum(rs.getString(2));
				order.setPronum(rs.getInt(3));
				list.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("D:\\JAVA\\øŒ≥Ã…Ëº∆\\datc.txt");) {
			List<Order > list = getAllDAta();
			for(Order s:list) {
				fw.write(s.toString()+"\r\n");
			}
			JOptionPane.showMessageDialog(null, "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
