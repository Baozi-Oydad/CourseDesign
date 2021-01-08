package com.jsu.lr.ui;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KHMenu {

	private JFrame frmCustomermenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KHMenu window = new KHMenu();
					window.frmCustomermenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KHMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCustomermenu = new JFrame();
		frmCustomermenu.setTitle("Customer Menu");
		frmCustomermenu.getContentPane().setBackground(SystemColor.desktop);
		frmCustomermenu.setIconImage(Toolkit.getDefaultToolkit().getImage(KHMenu.class.getResource("/image/\u56FE\u72471.png")));
		frmCustomermenu.setBounds(100, 100, 1425, 1062);
		frmCustomermenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
        //通过调用GraphicsEnvironment的getDefaultScreenDevice方法获得当前的屏幕设备了 
        GraphicsDevice gd = ge.getDefaultScreenDevice(); 
        // 全屏设置 
        gd.setFullScreenWindow(frmCustomermenu); 
        frmCustomermenu.getContentPane().setLayout(null);
        
        JButton btnPersonalCenter_1 = new JButton("Personal Center");
        btnPersonalCenter_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Personnal();
        	}
        });
        btnPersonalCenter_1.setIcon(new ImageIcon(KHMenu.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
        btnPersonalCenter_1.setForeground(SystemColor.text);
        btnPersonalCenter_1.setFont(new Font("Impact", Font.BOLD, 25));
        btnPersonalCenter_1.setBackground(SystemColor.desktop);
        btnPersonalCenter_1.setBounds(791, 231, 320, 105);
        frmCustomermenu.getContentPane().add(btnPersonalCenter_1);
        
        JButton btnPersonalCenter_2 = new JButton("My Order                ");
        btnPersonalCenter_2.setIcon(new ImageIcon(KHMenu.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
        btnPersonalCenter_2.setForeground(SystemColor.text);
        btnPersonalCenter_2.setFont(new Font("Impact", Font.BOLD, 25));
        btnPersonalCenter_2.setBackground(SystemColor.desktop);
        btnPersonalCenter_2.setBounds(791, 560, 320, 105);
        btnPersonalCenter_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Order();
			}
		});
        frmCustomermenu.getContentPane().add(btnPersonalCenter_2);
        
        JButton btnPersonalCenter_1_1 = new JButton("Product Inquiry ");
        btnPersonalCenter_1_1.setIcon(new ImageIcon(KHMenu.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
        btnPersonalCenter_1_1.setForeground(SystemColor.text);
        btnPersonalCenter_1_1.setFont(new Font("Impact", Font.BOLD, 25));
        btnPersonalCenter_1_1.setBackground(SystemColor.desktop);
        btnPersonalCenter_1_1.setBounds(791, 399, 320, 105);
        btnPersonalCenter_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AllProduct();
			}
		});
        frmCustomermenu.getContentPane().add(btnPersonalCenter_1_1);
        
        JLabel lblNewLabel_1 = new JLabel("WELCOME TO BURNIN HOOD");
        lblNewLabel_1.setFont(new Font("Gabriola", Font.BOLD, 70));
        lblNewLabel_1.setForeground(SystemColor.text);
        lblNewLabel_1.setBounds(317, 15, 794, 249);
        frmCustomermenu.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(KHMenu.class.getResource("/image/~XW~%0(5``~O0)%C]3K({X0.png")));
        lblNewLabel.setBounds(0, 0, 718, 1223);
        frmCustomermenu.getContentPane().add(lblNewLabel);
	}

}
