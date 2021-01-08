package com.jsu.lr.ui;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class OrderInfo extends JFrame {
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private TableRowSorter sorter;//����������
	private ArrayList<RowSorter.SortKey> sortKeys;//�����������
	
	private Vector<String> titles;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * ���幹�췽���������弰���.
	 */
	public OrderInfo() {
		setTitle("Order System");
		setVisible(true);// ����ɼ�
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(OrderInfo.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 810, 820);// ���ô���λ�����С
		setLocationRelativeTo(null);// �������
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(44, 140, 693, 493);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "ordernum","accnum","pronum");
		Vector<Vector> stuInfo = new PageController3().getPaegData();//��ȡ��һҳ������

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(stuInfo, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setAutoCreateRowSorter(true);;//���ñ���Զ�����

		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		JLabel lblKey = new JLabel("ACCNUM:");
		lblKey.setForeground(Color.WHITE);
		lblKey.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblKey.setBounds(44, 0, 114, 36);
		contentPane.add(lblKey);
		
		//������밴ť
		JButton btnFind = new JButton("INSERT");
		btnFind.setForeground(Color.BLACK);
		btnFind.setBackground(Color.LIGHT_GRAY);
		btnFind.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlLookString="select * from order01 where ordernum like'"+textField.getText().trim()+"'";
				PageController3 pcl=new PageController3();

				String accnumString=textField_1.getText().trim();
				int order=Integer.parseInt(textField.getText().trim());
				int pronum=Integer.parseInt(textField_2.getText().trim());
				
				if(pcl.setInsert(sqlLookString)) {
					JOptionPane.showMessageDialog(null, "Data duplication!");
				}else {
					DataOperate.add3(order,accnumString,pronum);
					JOptionPane.showMessageDialog(null, "Insert Success!");
				}
			}
		});
		btnFind.setBounds(44, 82, 140, 42);
		contentPane.add(btnFind);
		
		JButton btnPre = new JButton("Previous Page");
		btnPre.setForeground(Color.BLACK);
		btnPre.setBackground(Color.LIGHT_GRAY);
		btnPre.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
		btnPre.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController3().prePage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
				
			}
		});
		btnPre.setBounds(44, 648, 169, 25);
		contentPane.add(btnPre);
		
		JButton btnNext = new JButton("Next Page");
		btnNext.setForeground(Color.BLACK);
		btnNext.setBackground(Color.LIGHT_GRAY);
		btnNext.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
		btnNext.addActionListener(new ActionListener() {//��һҳ�����¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController3().nextPage(),titles);//��������ģ���е�����Ϊ��һҳ����
				table.setModel(model);//���ñ�������ģ��
			}
		});
		btnNext.setBounds(228, 648, 169, 25);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel("Display on each page:");
		lblMsg.setForeground(Color.WHITE);
		lblMsg.setFont(new Font("Lucida Console", Font.BOLD, 14));
		lblMsg.setBounds(474, 648, 210, 25);
		contentPane.add(lblMsg);
		
		JComboBox comboBox = new JComboBox(new Integer[] {10,20,50,100,150,200});
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		comboBox.addItemListener(new ItemListener() {//ҳ��������ѡ��ı��¼�
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//��ȡ��������ѡ��ֵ
				PageController3 pcl=new PageController3();
				pcl.setCountPerpage(pageSize);//����ÿҳ��ʾ��¼����
				model=new DefaultTableModel(pcl.getPaegData(),titles);//��������ģ��
				table.setModel(model);//���ñ������ģ��
			}
		});
		comboBox.setSelectedIndex(1);//����������Ĭ��ֵ
		comboBox.setBounds(672, 649, 55, 23);
		contentPane.add(comboBox);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(Color.LIGHT_GRAY);
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnDelete.setBounds(228, 83, 137, 42);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sqlLookString="delete from order01 where ordernum='"+textField.getText().trim()+"'";
				String sqlLookString2="select * from order01 where ordernum like'"+textField.getText().trim()+"%'";
				PageController3 pcl2=new PageController3();
				if(pcl2.setInsert(sqlLookString2)) {
				PageController3 pcl=new PageController3();
				pcl.dataDelete(sqlLookString);
				JOptionPane.showMessageDialog(null, "Deletion successful!");}
				else {
					JOptionPane.showMessageDialog(null, "Null Values!");
				}
				
			}
		});
		contentPane.add(btnDelete);
		
		JButton btnFind_1_1 = new JButton("LOOKUP");
		btnFind_1_1.setForeground(Color.BLACK);
		btnFind_1_1.setBackground(Color.LIGHT_GRAY);
		btnFind_1_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnFind_1_1.setBounds(412, 83, 145, 41);
		btnFind_1_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String sqlLookString="select * from order01 where ordernum like'"+textField.getText().trim()+"%'";
				PageController3 pcl=new PageController3(sqlLookString);
				model=new DefaultTableModel(pcl.getPaegData(),titles);
				table.setModel(model);
				if(!pcl.setInsert(sqlLookString)) {
					JOptionPane.showMessageDialog(null, "Null Values!");
				}
			}
		});
		contentPane.add(btnFind_1_1);
		
		JButton btnFind_1_2 = new JButton("UPDATE");
		btnFind_1_2.setForeground(Color.BLACK);
		btnFind_1_2.setBackground(Color.LIGHT_GRAY);
		btnFind_1_2.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnFind_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlLookString="select * from order01 where ordernum like'"+textField.getText().trim()+"%'";
				String sqlLookString2="delete from order01 where ordernum='"+textField.getText().trim()+"'";
				PageController3 pcl=new PageController3();

				String accnumString=textField_1.getText().trim();
				int order=Integer.parseInt(textField.getText().trim());
				int pronum=Integer.parseInt(textField_2.getText().trim());
				
				if(pcl.setInsert(sqlLookString)) {
					PageController3 pcl2=new PageController3();
					pcl2.dataDelete(sqlLookString2);
					DataOperate.add3(order,accnumString,pronum);
					JOptionPane.showMessageDialog(null,"Update Success!");
				}else {
						JOptionPane.showMessageDialog(null, "Null Values!");
					}
			}
		});
		btnFind_1_2.setBounds(597, 83, 140, 42);
		contentPane.add(btnFind_1_2);
		
		textField = new JTextField();
		textField.setBounds(334, 31, 169, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(OrderInfo.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
		lblNewLabel.setBounds(359, 688, 152, 67);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(44, 31, 275, 36);
		contentPane.add(textField_1);
		
		JLabel lblOrdernum = new JLabel("ORDERNUM:");
		lblOrdernum.setForeground(Color.WHITE);
		lblOrdernum.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblOrdernum.setBounds(334, 0, 137, 36);
		contentPane.add(lblOrdernum);
		
		JLabel lblPronum = new JLabel("PRONUM:");
		lblPronum.setForeground(Color.WHITE);
		lblPronum.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblPronum.setBounds(518, 0, 114, 36);
		contentPane.add(lblPronum);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(518, 31, 219, 36);
		contentPane.add(textField_2);
	}
}
