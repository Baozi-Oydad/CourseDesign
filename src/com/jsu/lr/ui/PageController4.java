package com.jsu.lr.ui;

import java.util.Vector;

import com.jsu.dao.DatabaseOperate;

public class PageController4 {
	private static Vector<Vector> bigList ; // �󼯺ϣ�������ȡ����
	private Vector<Vector> smallList = new Vector<Vector>(); // С���ϣ����ظ�����������
	private static int curentPageIndex = 1; // ��ǰҳ��
	private static int  countPerpage = 5; // ÿҳ��ʾ����
	private int pageCount; // ��ҳ��
	private int recordCount; // �ܼ�¼����
	{// ��ʼ�������
		if(PageController4.bigList==null) {
			PageController4.bigList=DataOperate.getSelectAll4("select * from order01");// ���ò�ѯ���ݿ�ķ������������е���
		}
		//��ȡ��ҳ��
		if(bigList.size()%countPerpage==0) {
			pageCount=bigList.size()/countPerpage;
		}else {
			pageCount=bigList.size()/countPerpage+1;
		}
	}
	public PageController4() {}//�޲ι��췽��
	
	public PageController4(String sql) {//ִ��sql���
		PageController4.bigList=DataOperate.getSelectAll4(sql);
	}
	
	public void dataDelete(String sql) {
		DataOperate.getDelete(sql);
	}
	
	public void dataUpdate(String sql) {
		DataOperate.getUpdate(sql);
	}
	
	public boolean setInsert(String sql) {//�ж�sql������н������ֵ�Ƿ�Ϊ��
		PageController4.bigList=DataOperate.getSelectAll4(sql);
		if(bigList.size()!=0) {
			return true;
		}else {
			return false ;
		}
	}
	
	public PageController4(int curentPageIndex) {//���췽�����õ�ǰҳ
		this.curentPageIndex = curentPageIndex;
	}
	public void setCountPerpage(int countPerpage) {//����ÿҳ��ʾ�ļ�¼��
		this.countPerpage=countPerpage;
	}
	public Vector<Vector> getPaegData() {// ���ݵ�ǰҳ����ɸѡ��¼
		recordCount = bigList.size();//�����¼��Ϊ���ݿ��б����������
		for (int i = (curentPageIndex - 1) * countPerpage; i < curentPageIndex * countPerpage && i < recordCount; i++) {//ȡ�õ�ǰҳ���ļ�¼��curentPageIndex��ǰҳ����countPerpageÿҳ��ʾ�ļ�¼��
			smallList.add(bigList.get(i));//����¼���뵽С������
		}
		return smallList;//����С���ϣ���ǰҳ�����ݣ�
	}
	public Vector<Vector> nextPage(){//��һҳ
		if(curentPageIndex<pageCount) {
			curentPageIndex++;
		}else {
			curentPageIndex=1;
		}
		return getPaegData();//������һҳ������
	}
	public Vector<Vector> prePage(){//��һҳ
		if(curentPageIndex>1) {
			curentPageIndex--;
		}else {
			curentPageIndex=pageCount;
		}
		return getPaegData();//������һҳ������
	}
	public Vector<Vector> getMydate(String acc) {
		smallList=DataOperate.getSelectAll(acc);
		return smallList;
	}
}