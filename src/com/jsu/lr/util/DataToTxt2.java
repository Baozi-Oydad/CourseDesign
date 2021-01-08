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

public class DataToTxt2 {
	static Connection conn = new DatabaseConnectionSql().getConnection();
	public static List<Product> getAllDAta() {
		String sql = "select * from pro";
		List<Product> list = null;
		try(PreparedStatement pstmt=conn.prepareStatement(sql);) {
			list = new ArrayList<Product>();
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Product product=new Product();
				product.setPronum(rs.getInt(1));
				product.setProname(rs.getString(2));
				product.setProsum(rs.getInt(3));
				product.setProprice(rs.getInt(4));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		try(FileWriter fw = new FileWriter("D:\\JAVA\\øŒ≥Ã…Ëº∆\\datb.txt");) {
			List<Product> list = getAllDAta();
			for(Product s:list) {
				fw.write(s.toString()+"\r\n");
			}
			JOptionPane.showMessageDialog(null, "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
