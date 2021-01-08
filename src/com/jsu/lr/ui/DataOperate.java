package com.jsu.lr.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.jsu.dao.Customer;
import com.jsu.dao.DatabaseConnectionSql;
import com.jsu.dao.Product;

public class DataOperate{
	/**
     * 取得指定sql查询语句的记录
     * @param sql 查询语句
     * @return 查询语句的结果集，类型为Vector嵌套集合，用于填充DefaultTableModel数据模型
     */
    public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//获取第一个字段
    			row.add(rs.getString(2));//获取第二个字段
    			row.add(rs.getString(3));//获取第三个字段
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//返回所有行数据
    }
    public static Vector<Vector> getSelectAll2(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//获取第一个字段
    			row.add(rs.getString(2));//获取第二个字段
    			row.add(rs.getString(3));//获取第三个字段
    			row.add(rs.getString(4));
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//返回所有行数据
    }
    public static Vector<Vector> getSelectAll3(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//获取第一个字段
    			row.add(rs.getString(2));//获取第二个字段
    			row.add(rs.getString(3));//获取第三个字段
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//返回所有行数据
    }
    public static Vector<Vector> getSelectAll4(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//获取第一个字段
    			row.add(rs.getString(2));//获取第二个字段
    			row.add(rs.getString(3));//获取第三个字段
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//返回所有行数据
    }
    public static  void getDelete(String sql){
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		pstmt.executeUpdate();//执行语句，结果放到数据集中
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public static  void getUpdate(String sql){
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		pstmt.executeUpdate();//执行语句，结果放到数据集中
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public static boolean checkPass(String sql,String pass) {//检查密码是否匹配
    	int i=0;
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//获取数据库接
        		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
        		ResultSet rs=pstmt.executeQuery();
        while(rs.next()) {		if(rs.getString(2).equals(pass)) {
        			i=1;
        		}else {
					i=0;
				}}
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	if(i==1) {
    		return true;
    	}else {
			return false;
		}
	}
    public static void add(String accnu,String namenu,String sexnu,String addressnu,String phonenu) {
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	String sql="insert into cus(accnum,name,sex,address,phonenum) values(?,?,?,?,?)";
    	try (Connection conn=dbcs.getConnection();
    		PreparedStatement pstmt=conn.prepareStatement(sql);
    		){
			pstmt.setString(1, accnu);//定义第1个占位符的内容
    		pstmt.setString(2, namenu);//定义第2个占位符的内容
    		pstmt.setString(3, sexnu);//定义第3个占位符的内容
    		pstmt.setString(4, addressnu);//定义第4个占位符的内容
    		pstmt.setString(5, phonenu);
    		pstmt.executeUpdate();
    		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    public static void add2(int pronu,String proname,int prosum,int proprice) {
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	String sql="insert into pro(pronum,proname,prosum,proprice) values(?,?,?,?)";
    	try (Connection conn=dbcs.getConnection();
    		PreparedStatement pstmt=conn.prepareStatement(sql);
    		){
			pstmt.setInt(1, pronu);
			pstmt.setString(2, proname);
			pstmt.setInt(3, prosum);
			pstmt.setInt(4, proprice);
    		pstmt.executeUpdate();
    		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    public static void add3(int odrnu,String accnu,int pronu) {
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	String sql="insert into order01(ordernum,accnum,pronum) values(?,?,?)";
    	try (Connection conn=dbcs.getConnection();
    		PreparedStatement pstmt=conn.prepareStatement(sql);
    		){
			pstmt.setInt(1, odrnu);//定义第1个占位符的内容
    		pstmt.setString(2, accnu);//定义第2个占位符的内容
    		pstmt.setInt(3, pronu);//定义第3个占位符的内容
    		pstmt.executeUpdate();
    		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}