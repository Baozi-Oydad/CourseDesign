package com.jsu.dao;

public class Order {
	  public static int getNum(int start,int end) {//������ط���ָ����Χ�������
	    	//Math.random()�������0.0��1.0֮�����
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	  public static int getOrderNum() {
		  return getNum(1, 10000);
	  }
}
