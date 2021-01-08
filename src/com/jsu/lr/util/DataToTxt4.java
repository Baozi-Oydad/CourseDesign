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

public class DataToTxt4 {
	static Connection conn = new DatabaseConnectionSql().getConnection();
	public static List<User> getAllDAta() {
		String sql = "select * from user01";
		List<User> list = null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			list = new ArrayList<User>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setAccnum(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setOrdernum(rs.getInt(3));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("D:\\JAVA\\øŒ≥Ã…Ëº∆\\datd.txt");) {
			List<User > list = getAllDAta();
			for(User s:list) {
				fw.write(s.toString()+"\r\n");
			}
			JOptionPane.showMessageDialog(null, "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
