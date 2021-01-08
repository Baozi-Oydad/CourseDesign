package com.jsu.lr.pojo;

import java.io.Serializable;

public class Customer implements Serializable {
	private String accnum;
	private String name;
	private String sex;
	private String address;
	private String phonenum;
	public Customer() {
		super();
	}
	public String getAccnum() {
		return accnum;
	}
	public void setAccnum(String accnum) {
		this.accnum = accnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	@Override
	public String toString() {
		return "Customer [accnum=" + accnum + ", name=" + name + ", sex=" + sex + ", address=" + address + ", phonenum="
				+ phonenum + "]";
	}
	
}
