package com.jsu.dao;

public class Product {
	 public	static String proname[]= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	  public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
	    	//Math.random()随机返回0.0至1.0之间的数
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	  //随机生成产品代码
	  public static int getPronum() {
		  return getNum(1,10000);
	  }
	  //随机生成产品名
	  public static String getProname() {
		  int index=getNum(0, proname.length-1);
		  int index2=getNum(0, proname.length-1);
		  int index3=getNum(0, proname.length-1);
		  int index4=getNum(0, proname.length-1);

		  String name=proname[index]+proname[index2]+proname[index3]+proname[index4];
		  return name+"产品";
	  }
	  //生成产品数量（起始数量）
	  public static int getProsum() {
		  int sum=2000;
		  return sum;
	  }
	  //生成产品单价
	  public static int getPrice() {
		  return getNum(100, 500);
	  }
}
