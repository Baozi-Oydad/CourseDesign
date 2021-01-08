package com.jsu.lr.pojo;

import java.io.Serializable;

public class Product implements Serializable {
	private int pronum;
	private String proname;
	private int prosum;
	private int proprice;
	public Product() {
		super();
	}
	public int getPronum() {
		return pronum;
	}
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getProsum() {
		return prosum;
	}
	public void setProsum(int prosum) {
		this.prosum = prosum;
	}
	public int getProprice() {
		return proprice;
	}
	public void setProprice(int proprice) {
		this.proprice = proprice;
	}
	@Override
	public String toString() {
		return "Product [pronum=" + pronum + ", proname=" + proname + ", prosum=" + prosum + ", proprice=" + proprice
				+ "]";
	}
	
}
