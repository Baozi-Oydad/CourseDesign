package com.jsu.dao;

public class Password {
	 public static int getNum(int start,int end) {//������ط���ָ����Χ�������
	    	//Math.random()�������0.0��1.0֮�����
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	 public static String getPassword() {
		 String mm=new String("KH");
		 String m=new String("GL");
	    	StringBuilder mm1=new StringBuilder(String.valueOf(getNum(0,99999)));//���ȡ��5λ
	    	if(mm1.length()==1) {
	    		mm1=mm1.insert(0, "0000");//�����1λ����ǰ������4��0
	    		mm=mm+mm1;
	    	}else if(mm1.length()==2) {
	    		mm1=mm1.insert(0, "000");//�����2λ����ǰ������3��0
	    		mm=mm+mm1;
	    	}else if(mm1.length()==3) {
	    		mm1=mm1.insert(0, "00");//�����3λ����ǰ������2��0
	    		mm=m+mm1;//�������ù���Ա
	    	}else if(mm1.length()==4) {
	    		mm1=mm1.insert(0, "0");//�����4λ����ǰ������1��0
	    		mm=mm+mm1;
	    	}else {
	    		mm=mm+mm1;
	    	}
	    	return mm;
	 }
	 
}
