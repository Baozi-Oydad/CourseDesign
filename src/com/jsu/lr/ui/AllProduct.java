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
import java.awt.Color;
import javax.swing.ImageIcon;

public class AllProduct extends JFrame {
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private TableRowSorter sorter;//定义排序器
	private ArrayList<RowSorter.SortKey> sortKeys;//设置排序规则
	
	private Vector<String> titles;
	private JTextField textField;

	/**
	 * 定义构造方法创建窗体及组件.
	 */
	public AllProduct() {
		setTitle("Select Product");
		setVisible(true);// 窗体可见
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProductInfo.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 603, 707);// 设置窗体位置与大小
		setLocationRelativeTo(null);// 窗体居中
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(32, 82, 518, 438);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "pronum","proname","prosum","proprice");
		Vector<Vector> stuInfo = new PageController2().getPaegData();//获取第一页的数据

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
		
		JLabel lblKey = new JLabel("Proname:");
		lblKey.setForeground(Color.WHITE);
		lblKey.setFont(new Font("Impact", Font.PLAIN, 19));
		lblKey.setBounds(32, 31, 191, 36);
		contentPane.add(lblKey);
		
		JButton btnPre = new JButton("Previous Page");
		btnPre.setForeground(Color.BLACK);
		btnPre.setBackground(Color.LIGHT_GRAY);
		btnPre.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		btnPre.addActionListener(new ActionListener() {//上一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController2().prePage(),titles);//设置数据模型中的数据为上一页内容
				table.setModel(model);//设置表格的数据模型
				
			}
		});
		btnPre.setBounds(30, 535, 156, 25);
		contentPane.add(btnPre);
		
		JButton btnNext = new JButton("Next Page");
		btnNext.setForeground(Color.BLACK);
		btnNext.setBackground(Color.LIGHT_GRAY);
		btnNext.setFont(new Font("Leelawadee UI", Font.BOLD, 16));
		btnNext.addActionListener(new ActionListener() {//下一页单击事件
			@Override
			public void actionPerformed(ActionEvent e) {
				model=new DefaultTableModel(new PageController2().nextPage(),titles);//设置数据模型中的数据为下一页内容
				table.setModel(model);//设置表格的数据模型
			}
		});
		btnNext.setBounds(199, 535, 156, 25);
		contentPane.add(btnNext);
		
		JLabel lblMsg = new JLabel(" date in page:");
		lblMsg.setForeground(Color.WHITE);
		lblMsg.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblMsg.setBounds(362, 535, 161, 25);
		contentPane.add(lblMsg);
		
		JComboBox comboBox = new JComboBox(new Integer[] {10,20,50,100,150,200});
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setForeground(Color.BLACK);
		comboBox.addItemListener(new ItemListener() {//页数下拉框选择改变事件
			public void itemStateChanged(ItemEvent e) {
				int pageSize=Integer.valueOf(comboBox.getSelectedItem().toString());//获取下拉框所选的值
				PageController2 pcl=new PageController2();
				pcl.setCountPerpage(pageSize);//设置每页显示记录条数
				model=new DefaultTableModel(pcl.getPaegData(),titles);//设置数据模型
				table.setModel(model);//设置表格数据模型
			}
		});
		comboBox.setSelectedIndex(1);//设置下拉框默认值
		comboBox.setBounds(495, 536, 55, 23);
		contentPane.add(comboBox);
		
		JButton btnFind_1_1 = new JButton("LOOKUP");
		btnFind_1_1.setForeground(Color.BLACK);
		btnFind_1_1.setBackground(Color.LIGHT_GRAY);
		btnFind_1_1.setFont(new Font("Impact", Font.PLAIN, 20));
		btnFind_1_1.setBounds(408, 29, 145, 41);
		btnFind_1_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				String sqlLookString2="select * from pro where proname like'"+textField.getText().trim()+"%'";
				PageController2 pcl2=new PageController2(sqlLookString2);
				model=new DefaultTableModel(pcl2.getPaegData(),titles);
				table.setModel(model);
				if(!pcl2.setInsert(sqlLookString2)) {
					JOptionPane.showMessageDialog(null, "Null Values!");
				}
			}
		});
		contentPane.add(btnFind_1_1);
		
		textField = new JTextField();
		textField.setBounds(112, 32, 285, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AllProduct.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
		lblNewLabel.setBounds(263, 575, 152, 67);
		contentPane.add(lblNewLabel);
	}
}
