package com.jsu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class DatabaseOperate{
	    public static void main(String[] args) {
	    	addDataCus();
	    	addDataPro();
	    	addDataOrder();
	    	addDataUser();
	    }
	    public static void addDataCus() {//增加客户信息
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	String sql="insert into cus(accnum,name,sex,address,phonenum) values(?,?,?,?,?)";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	        	ArrayList<String> alist=new ArrayList<String>();//定义集合
	    		for(int i=1;i<=10000;) {
	    			String zh=Customer.getAccnum().toString();//随机获取学号
	    			if(!alist.contains(zh)) {//判断账号是否唯一
	    				alist.add(zh);//将账号加入集合
	    				String xm=Customer.getChineseName();//随机获取姓名
	    				String xb=Customer.getSex();
	    				String dz=Customer.getProCity();
	    				String dh=Customer.getMobile();
	    				pstmt.setString(1, zh);//定义第1个占位符的内容
	    	    		pstmt.setString(2, xm);//定义第2个占位符的内容
	    	    		pstmt.setString(3, xb);//定义第3个占位符的内容
	    	    		pstmt.setString(4, dz);//定义第4个占位符的内容
	    	    		pstmt.setString(5, dh);
	    	    		pstmt.addBatch();//加入批处理等待执行
	    				i++;//账号唯一，循环继续往下执行
	    			}
	    		}
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "Cussucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static void addDataPro() {//增加产品信息
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	String sql="insert into pro(pronum,proname,prosum,proprice) values(?,?,?,?)";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	        	ArrayList alist=new ArrayList();//定义集合
	        	for(int i=1;i<=10000;) {
	        		int cn=Product.getPronum();
	        		if(!alist.contains(cn)) {
	        			alist.add(cn);
	        			String cm=Product.getProname();
	        			int sum=Product.getProsum();
	        			int pri=Product.getPrice();
	        			pstmt.setInt(1, cn);
	        			pstmt.setString(2, cm);
	        			pstmt.setInt(3, sum);
	        			pstmt.setInt(4, pri);
	        			pstmt.addBatch();
	        			i++;
	        		}
	        	}
	        	pstmt.executeBatch();
	    		JOptionPane.showMessageDialog(null, "Prosucess");
	    } catch (SQLException e) {
			e.printStackTrace();
			}
	    }
	    
	    public static void addDataOrder() {//建立Order
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	String sql="insert into order01(ordernum,accnum,pronum) values(?,?,?)";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	        	ArrayList alist=new ArrayList();//定义集合
	    		for(int i=1;i<=10000;) {
	    			int odn=Order.getOrderNum();//随机获取
	    			if(!alist.contains(odn)) {//判断账号是否唯一
	    				alist.add(odn);//将账号加入集合
	    				String ac=Customer.getAccnum();
	    				int num=Product.getPronum();
	    				pstmt.setInt(1, odn);//定义第1个占位符的内容
	    	    		pstmt.setString(2, ac);//定义第2个占位符的内容
	    	    		pstmt.setInt(3, num);//定义第3个占位符的内容
	    	    		pstmt.addBatch();//加入批处理等待执行
	    				i++;//账号唯一，循环继续往下执行
	    			}
	    		}
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "Ordersucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static void addDataUser() {
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
	    	String sql1="insert into user01(accnum,password,ordernum) values(?,?,?)";
	    	try (Connection conn=dbcs.getConnection();
	    		PreparedStatement pstmt1=conn.prepareStatement(sql1);
	    		){
	    		ArrayList alist=new ArrayList();//定义集合
	    		for(int i=1;i<=10000;) {
	    			String accnu=Customer.getAccnum();
	    			if(!alist.contains(accnu)) {//判断账号是否唯一
	    				alist.add(accnu);
	    			String ps=Password.getPassword();
	    			int onn=Order.getOrderNum();
	    			pstmt1.setString(1, accnu);
	    			pstmt1.setString(2, ps);
	    			pstmt1.setInt(3, onn);
	    			pstmt1.addBatch();
	    			i++;
	    		}
	    		}
	    		pstmt1.executeBatch();
	    		JOptionPane.showMessageDialog(null, "Usersucess");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	    
	  
}