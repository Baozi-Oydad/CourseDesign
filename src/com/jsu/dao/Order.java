package com.jsu.dao;

public class Order {
	  public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
	    	//Math.random()随机返回0.0至1.0之间的数
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	  public static int getOrderNum() {
		  return getNum(1, 10000);
	  }
}
