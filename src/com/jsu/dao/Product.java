package com.jsu.dao;

public class Product {
	 public	static String proname[]= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	  public static int getNum(int start,int end) {//������ط���ָ����Χ�������
	    	//Math.random()�������0.0��1.0֮�����
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	  //������ɲ�Ʒ����
	  public static int getPronum() {
		  return getNum(1,10000);
	  }
	  //������ɲ�Ʒ��
	  public static String getProname() {
		  int index=getNum(0, proname.length-1);
		  int index2=getNum(0, proname.length-1);
		  int index3=getNum(0, proname.length-1);
		  int index4=getNum(0, proname.length-1);

		  String name=proname[index]+proname[index2]+proname[index3]+proname[index4];
		  return name+"��Ʒ";
	  }
	  //���ɲ�Ʒ��������ʼ������
	  public static int getProsum() {
		  int sum=2000;
		  return sum;
	  }
	  //���ɲ�Ʒ����
	  public static int getPrice() {
		  return getNum(100, 500);
	  }
}
