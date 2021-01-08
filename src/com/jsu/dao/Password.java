package com.jsu.dao;

public class Password {
	 public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
	    	//Math.random()随机返回0.0至1.0之间的数
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	 public static String getPassword() {
		 String mm=new String("KH");
		 String m=new String("GL");
	    	StringBuilder mm1=new StringBuilder(String.valueOf(getNum(0,99999)));//随机取后5位
	    	if(mm1.length()==1) {
	    		mm1=mm1.insert(0, "0000");//如果是1位数，前面增加4个0
	    		mm=mm+mm1;
	    	}else if(mm1.length()==2) {
	    		mm1=mm1.insert(0, "000");//如果是2位数，前面增加3个0
	    		mm=mm+mm1;
	    	}else if(mm1.length()==3) {
	    		mm1=mm1.insert(0, "00");//如果是3位数，前面增加2个0
	    		mm=m+mm1;//悄悄设置管理员
	    	}else if(mm1.length()==4) {
	    		mm1=mm1.insert(0, "0");//如果是4位数，前面增加1个0
	    		mm=mm+mm1;
	    	}else {
	    		mm=mm+mm1;
	    	}
	    	return mm;
	 }
	 
}
