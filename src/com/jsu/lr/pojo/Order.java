package com.jsu.lr.pojo;

import java.io.Serializable;

public class Order implements Serializable {
	private int ordernum;
	private String accnum;
	private int pronum;
	public Order() {
		super();
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public String getAccnum() {
		return accnum;
	}
	public void setAccnum(String accnum) {
		this.accnum = accnum;
	}
	public int getPronum() {
		return pronum;
	}
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}

	@Override
	public String toString() {
		return "Order [ordernum=" + ordernum + ", accnum=" + accnum + ", pronum=" + pronum + "]";
	}
	
}
