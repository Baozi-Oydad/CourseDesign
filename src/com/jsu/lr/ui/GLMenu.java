package com.jsu.lr.ui;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;

public class GLMenu {

	private JFrame frmAdiministratorsMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GLMenu window = new GLMenu();
					window.frmAdiministratorsMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GLMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdiministratorsMenu = new JFrame();
		frmAdiministratorsMenu.setTitle("Adiministrators Menu");
		frmAdiministratorsMenu.getContentPane().setBackground(new Color(0, 0, 0));
		frmAdiministratorsMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(GLMenu.class.getResource("/image/\u56FE\u72471.png")));
		frmAdiministratorsMenu.setBounds(100, 100, 1482, 1051);
		frmAdiministratorsMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
        //通过调用GraphicsEnvironment的getDefaultScreenDevice方法获得当前的屏幕设备了 
        GraphicsDevice gd = ge.getDefaultScreenDevice(); 
        // 全屏设置 
        gd.setFullScreenWindow(frmAdiministratorsMenu); 
        frmAdiministratorsMenu.getContentPane().setLayout(null);
        
        JButton btnNewButton = new JButton("Customer Information");
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
        btnNewButton.setBackground(SystemColor.desktop);
        btnNewButton.setForeground(SystemColor.text);
        btnNewButton.setBounds(318, 621, 259, 44);
        btnNewButton.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				new CustomerInfo();
			}
		});
        frmAdiministratorsMenu.getContentPane().add(btnNewButton);
        
        JButton btnProductInformation = new JButton("Product Information");
        btnProductInformation.setForeground(Color.WHITE);
        btnProductInformation.setFont(new Font("Calibri", Font.BOLD, 18));
        btnProductInformation.setBackground(Color.BLACK);
        btnProductInformation.setBounds(592, 621, 259, 44);
        btnProductInformation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductInfo();
			}
		});
        frmAdiministratorsMenu.getContentPane().add(btnProductInformation);
        
        JButton btnOrderInformation = new JButton("Order Information");
        btnOrderInformation.setForeground(Color.WHITE);
        btnOrderInformation.setFont(new Font("Calibri", Font.BOLD, 18));
        btnOrderInformation.setBackground(Color.BLACK);
        btnOrderInformation.setBounds(866, 621, 259, 44);
        btnOrderInformation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OrderInfo();
			}
		});
        frmAdiministratorsMenu.getContentPane().add(btnOrderInformation);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(GLMenu.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
        lblNewLabel_1.setBounds(693, 782, 79, 84);
        frmAdiministratorsMenu.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(GLMenu.class.getResource("/image/mmexport1609931075701.jpg")));
        lblNewLabel.setBounds(194, 0, 1110, 1057);
        frmAdiministratorsMenu.getContentPane().add(lblNewLabel);
	}

}
