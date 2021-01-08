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
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	
	private Vector<String> titles;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * 定义构造方法创建窗体及组件.
	 */
	public OrderInfo() {
		setTitle("Order System");
		setVisible(true);// 窗体可见
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(OrderInfo.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 810, 820);// 设置窗体位置与大小
		setLocationRelativeTo(null);// 窗体居中
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(44, 140, 693, 493);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "ordernum","accnum","pronum");
		Vector<Vector> stuInfo = new PageController3().getPaegData();//获取第一页的数据

//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(stuInfo, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {//获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
		table.setAutoCreateRowSorter(true);;//设置表格自动排序

		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
		JLabel lblKey = new JLabel("ACCNUM:");
		lblKey.setForeground(Color.WHITE);
		lblKey.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblKey.setBounds(44, 0, 114, 36);
		contentPane.add(lblKey);
		
		//定义插入按钮
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
		btnPre.addActionListener(new ActionListener() {//上一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController3().prePage(),titles);//设置数据模型中的数据为上一页内容
				table.setModel(model);//设置表格的数据模型
				
			}
		});
		btnPre.setBounds(44, 648, 169, 25);
		contentPane.add(btnPre);
		
		JButton btnNext = new JButton("Next Page");
		btnNext.setForeground(Color.BLACK);
		btnNext.setBackground(Color.LIGHT_GRAY);
		btnNext.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
		btnNext.addActionListener(new ActionListener() {//下一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController3().nextPage(),titles);//设置数据模型中的数据为下一页内容
				table.setModel(model);//设置表格的数据模型
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
		comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
				PageController3 pcl=new PageController3();
				pcl.setCountPerpage(pageSize);//设置每页显示记录条数
				model=new DefaultTableModel(pcl.getPaegData(),titles);//设置数据模型
				table.setModel(model);//设置表格数据模型
			}
		});
		comboBox.setSelectedIndex(1);//设置下拉框默认值
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
