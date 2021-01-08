package com.jsu.lr.ui;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;

public class SignUpMenu  {

	private JFrame frmLoginScreen;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private  JButton btnSignUp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpMenu window = new SignUpMenu();
					window.frmLoginScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginScreen = new JFrame();
		frmLoginScreen.setTitle("Login Screen");
		frmLoginScreen.setIconImage(Toolkit.getDefaultToolkit().getImage(SignUpMenu.class.getResource("/image/\u56FE\u72471.png")));
		frmLoginScreen.getContentPane().setBackground(Color.BLACK);
		frmLoginScreen.setBounds(100, 100, 1051, 951);
		frmLoginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
         //通过调用GraphicsEnvironment的getDefaultScreenDevice方法获得当前的屏幕设备了 
         GraphicsDevice gd = ge.getDefaultScreenDevice(); 
         // 全屏设置 
         gd.setFullScreenWindow(frmLoginScreen); 
         frmLoginScreen.getContentPane().setLayout(null);
         
         JLabel lblAccount = new JLabel("Account");
         lblAccount.setForeground(Color.WHITE);
         lblAccount.setFont(new Font("Segoe Script", Font.BOLD, 22));
         lblAccount.setBounds(536, 328, 104, 31);
         frmLoginScreen.getContentPane().add(lblAccount);
         
         textField = new JTextField();
         textField.setBounds(655, 328, 210, 31);
         frmLoginScreen.getContentPane().add(textField);
         textField.setColumns(10);
         
         JLabel lblPassword = new JLabel("Password");
         lblPassword.setForeground(Color.WHITE);
         lblPassword.setFont(new Font("Segoe Script", Font.BOLD, 22));
         lblPassword.setBounds(536, 374, 122, 31);
         frmLoginScreen.getContentPane().add(lblPassword);
          
         passwordField = new JPasswordField();
         passwordField.setBounds(655, 374, 210, 31);
         frmLoginScreen.getContentPane().add(passwordField);
         
         JButton btnSignUp = new JButton("Sign Up");
         btnSignUp.setBackground(Color.LIGHT_GRAY);
         btnSignUp.setFont(new Font("Segoe UI Black", Font.BOLD, 23));
         btnSignUp.setForeground(Color.BLACK);
         btnSignUp.setBounds(536, 452, 329, 47);
         btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sqlString="select * from user01 where accnum='"+textField.getText()+"'";
				String pass=passwordField.getText();
					if(textField.getText().length()==0) {
						lblNewLabel_1.setText("NULL VALUES!");
						textField.requestFocus();
					}
					if(textField.getText().length()!=0) {
						lblNewLabel_1.setText("");
					}
					 if(passwordField.getText().length()==0){
						lblNewLabel_2.setText("NULL VALUES!");
						textField.requestFocus();
					}else {
					if(DataOperate.checkPass(sqlString, pass)) {
						if(pass.contains("KH")) {
							 frmLoginScreen.dispose();
							 new KHMenu();
						}else {
							frmLoginScreen.dispose();
							new GLMenu();
						}
						}else {
							lblNewLabel_2.setText("WRONG PASSWORD!");
							passwordField.requestFocus();//取焦
							passwordField.selectAll();//全选
					}}
			}
		});
         frmLoginScreen.getContentPane().add(btnSignUp);
         
         lblNewLabel = new JLabel("");
         lblNewLabel.setIcon(new ImageIcon(SignUpMenu.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
         lblNewLabel.setBounds(669, 240, 152, 73);
         frmLoginScreen.getContentPane().add(lblNewLabel);
         
         lblNewLabel_1 = new JLabel("");
         lblNewLabel_1.setFont(new Font("MS PGothic", Font.PLAIN, 18));
         lblNewLabel_1.setForeground(Color.PINK);
         lblNewLabel_1.setBounds(880, 325, 203, 36);
         frmLoginScreen.getContentPane().add(lblNewLabel_1);
         
         lblNewLabel_2 = new JLabel("");
         lblNewLabel_2.setForeground(Color.PINK);
         lblNewLabel_2.setFont(new Font("MS PGothic", Font.PLAIN, 18));
         lblNewLabel_2.setBounds(880, 371, 192, 36);
         frmLoginScreen.getContentPane().add(lblNewLabel_2);
        
	}

	
}
