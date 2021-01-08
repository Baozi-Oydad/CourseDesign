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
	    public static void addDataCus() {//���ӿͻ���Ϣ
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	String sql="insert into cus(accnum,name,sex,address,phonenum) values(?,?,?,?,?)";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	        	ArrayList<String> alist=new ArrayList<String>();//���弯��
	    		for(int i=1;i<=10000;) {
	    			String zh=Customer.getAccnum().toString();//�����ȡѧ��
	    			if(!alist.contains(zh)) {//�ж��˺��Ƿ�Ψһ
	    				alist.add(zh);//���˺ż��뼯��
	    				String xm=Customer.getChineseName();//�����ȡ����
	    				String xb=Customer.getSex();
	    				String dz=Customer.getProCity();
	    				String dh=Customer.getMobile();
	    				pstmt.setString(1, zh);//�����1��ռλ��������
	    	    		pstmt.setString(2, xm);//�����2��ռλ��������
	    	    		pstmt.setString(3, xb);//�����3��ռλ��������
	    	    		pstmt.setString(4, dz);//�����4��ռλ��������
	    	    		pstmt.setString(5, dh);
	    	    		pstmt.addBatch();//����������ȴ�ִ��
	    				i++;//�˺�Ψһ��ѭ����������ִ��
	    			}
	    		}
	    		pstmt.executeBatch();//����ִ�в������
	    		JOptionPane.showMessageDialog(null, "Cussucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static void addDataPro() {//���Ӳ�Ʒ��Ϣ
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	String sql="insert into pro(pronum,proname,prosum,proprice) values(?,?,?,?)";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	        	ArrayList alist=new ArrayList();//���弯��
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
	    
	    public static void addDataOrder() {//����Order
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	String sql="insert into order01(ordernum,accnum,pronum) values(?,?,?)";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	        	ArrayList alist=new ArrayList();//���弯��
	    		for(int i=1;i<=10000;) {
	    			int odn=Order.getOrderNum();//�����ȡ
	    			if(!alist.contains(odn)) {//�ж��˺��Ƿ�Ψһ
	    				alist.add(odn);//���˺ż��뼯��
	    				String ac=Customer.getAccnum();
	    				int num=Product.getPronum();
	    				pstmt.setInt(1, odn);//�����1��ռλ��������
	    	    		pstmt.setString(2, ac);//�����2��ռλ��������
	    	    		pstmt.setInt(3, num);//�����3��ռλ��������
	    	    		pstmt.addBatch();//����������ȴ�ִ��
	    				i++;//�˺�Ψһ��ѭ����������ִ��
	    			}
	    		}
	    		pstmt.executeBatch();//����ִ�в������
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
	    		ArrayList alist=new ArrayList();//���弯��
	    		for(int i=1;i<=10000;) {
	    			String accnu=Customer.getAccnum();
	    			if(!alist.contains(accnu)) {//�ж��˺��Ƿ�Ψһ
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