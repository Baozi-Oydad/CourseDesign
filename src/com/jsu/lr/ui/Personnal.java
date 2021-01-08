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
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Personnal extends JFrame {
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	
	private Vector<String> titles;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * 定义构造方法创建窗体及组件.
	 */
	public Personnal() {
		setTitle("Personal Center");
		setVisible(true);// 窗体可见
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Personnal.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 607, 493);// 设置窗体位置与大小
		setLocationRelativeTo(null);// 窗体居中
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(44, 281, 490, 77);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		
		JLabel lblAccnum = new JLabel("Accnum:");
		lblAccnum.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblAccnum.setBounds(44, 145, 105, 21);
		contentPane.add(lblAccnum);
		
		textField = new JTextField();
		textField.setBounds(189, 142, 345, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblPassword.setBounds(44, 187, 105, 21);
		contentPane.add(lblPassword);
		
		String accString=textField.getText();
		String accsql="select * from cus where accnum='"+accString+"'";
		
		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "accnum", "name", "sex","adress","phonenum");
		Vector<Vector> stuInfo = new PageController().getMydate(accsql);//获取的数据

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

		scrollPane.setViewportView(table);
		
		JButton btnFind_1_1 = new JButton("LOOKUP");
		btnFind_1_1.setForeground(Color.BLACK);
		btnFind_1_1.setBackground(Color.WHITE);
		btnFind_1_1.setFont(new Font("Candara", Font.BOLD, 18));
		btnFind_1_1.setBounds(66, 239, 145, 27);
		btnFind_1_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String sqlString="select * from user01 where accnum='"+textField.getText()+"'";
				if(DataOperate.checkPass(sqlString,passwordField.getText().trim())) {
					// 使用动态数组数据（列标题与行数据）
					titles = new Vector<String>();// 定义动态数组表示表格标题
					Collections.addAll(titles, "accnum", "name", "sex","adress","phonenum");
					Vector<Vector> stuInfo = new PageController().getPaegData();//获取的数据

//					使用静态数据创建DefaultTableModel数据模型
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

					scrollPane.setViewportView(table);
					String sqlLookString="select * from cus where accnum like'"+textField.getText().trim()+"'";
				PageController pcl=new PageController(sqlLookString);
				model=new DefaultTableModel(pcl.getPaegData(),titles);
				table.setModel(model);
				if(!pcl.setInsert(sqlLookString)) {
					JOptionPane.showMessageDialog(null, "Null Values!");
				}
				}else {
					JOptionPane.showMessageDialog(null, "Wrong Values!");
				}
			}
		});
		contentPane.add(btnFind_1_1);
		
		JButton btnFind_1_2 = new JButton("UPDATE");
		btnFind_1_2.setBackground(Color.WHITE);
		btnFind_1_2.setForeground(Color.BLACK);
		btnFind_1_2.setFont(new Font("Candara", Font.BOLD, 18));
		btnFind_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DataOperate.checkPass(textField.getText().trim(),passwordField.getText().trim())){
					new Update();
				}
			}
		});
		btnFind_1_2.setBounds(372, 239, 137, 27);
		contentPane.add(btnFind_1_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(189, 184, 345, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Personnal.class.getResource("/image/KMSOI(`L]QB24Y@QJ9VFC%G.png")));
		lblNewLabel.setBounds(40, 39, 494, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Personnal.class.getResource("/image/\u56FE\u72471.png")));
		lblNewLabel_1.setBounds(256, 373, 146, 57);
		contentPane.add(lblNewLabel_1);
	
	}
}
