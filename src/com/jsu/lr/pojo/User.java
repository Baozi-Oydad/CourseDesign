package com.jsu.lr.pojo;

import java.io.Serializable;

public class User implements Serializable{
	private String accnum;
	private String password;
	private int ordernum;
	public User() {
		super();
	}
	public String getAccnum() {
		return accnum;
	}
	public void setAccnum(String accnum) {
		this.accnum = accnum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	@Override
	public String toString() {
		return "User [accnum=" + accnum + ", password=" + password + ", ordernum=" + ordernum + "]";
	}
	
}
