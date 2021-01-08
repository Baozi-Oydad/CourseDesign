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
     * ȡ��ָ��sql��ѯ���ļ�¼
     * @param sql ��ѯ���
     * @return ��ѯ���Ľ����������ΪVectorǶ�׼��ϣ��������DefaultTableModel����ģ��
     */
    public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ����䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
    			row.add(rs.getString(3));//��ȡ�������ֶ�
    			row.add(rs.getString(4));
    			row.add(rs.getString(5));
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//��������������
    }
    public static Vector<Vector> getSelectAll2(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ����䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
    			row.add(rs.getString(3));//��ȡ�������ֶ�
    			row.add(rs.getString(4));
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//��������������
    }
    public static Vector<Vector> getSelectAll3(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ����䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
    			row.add(rs.getString(3));//��ȡ�������ֶ�
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//��������������
    }
    public static Vector<Vector> getSelectAll4(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ����䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//��ȡ��һ���ֶ�
    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
    			row.add(rs.getString(3));//��ȡ�������ֶ�
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
			return rows;//��������������
    }
    public static  void getDelete(String sql){
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		pstmt.executeUpdate();//ִ����䣬����ŵ����ݼ���
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public static  void getUpdate(String sql){
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		pstmt.executeUpdate();//ִ����䣬����ŵ����ݼ���
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public static boolean checkPass(String sql,String pass) {//��������Ƿ�ƥ��
    	int i=0;
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
        		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
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
			pstmt.setString(1, accnu);//�����1��ռλ��������
    		pstmt.setString(2, namenu);//�����2��ռλ��������
    		pstmt.setString(3, sexnu);//�����3��ռλ��������
    		pstmt.setString(4, addressnu);//�����4��ռλ��������
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
			pstmt.setInt(1, odrnu);//�����1��ռλ��������
    		pstmt.setString(2, accnu);//�����2��ռλ��������
    		pstmt.setInt(3, pronu);//�����3��ռλ��������
    		pstmt.executeUpdate();
    		}
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}