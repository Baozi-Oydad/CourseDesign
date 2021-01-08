package com.jsu.lr.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Update {

	private JFrame frmUpdate;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update window = new Update();
					window.frmUpdate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdate = new JFrame();
		frmUpdate.getContentPane().setBackground(Color.BLACK);
		frmUpdate.setTitle("Update");
		frmUpdate.setIconImage(Toolkit.getDefaultToolkit().getImage(Update.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
		frmUpdate.setBounds(100, 100, 533, 405);
		frmUpdate.setLocationRelativeTo(null);// ´°Ìå¾ÓÖÐ                   
		frmUpdate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdate.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Accnum:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNewLabel.setBounds(53, 59, 95, 24);
		frmUpdate.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(205, 59, 224, 24);
		frmUpdate.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblOldPassword = new JLabel("Old Password:");
		lblOldPassword.setForeground(Color.WHITE);
		lblOldPassword.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblOldPassword.setBounds(53, 98, 137, 24);
		frmUpdate.getContentPane().add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblNewPassword.setBounds(53, 137, 137, 24);
		frmUpdate.getContentPane().add(lblNewPassword);
		
		JLabel lblReconfirm = new JLabel("Reconfirm:");
		lblReconfirm.setForeground(Color.WHITE);
		lblReconfirm.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		lblReconfirm.setBounds(53, 176, 137, 24);
		frmUpdate.getContentPane().add(lblReconfirm);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 98, 224, 25);
		frmUpdate.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(205, 136, 224, 25);
		frmUpdate.getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(205, 175, 224, 25);
		frmUpdate.getContentPane().add(passwordField_2);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 23));
		btnNewButton.setBounds(176, 215, 161, 39);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sqlString="select * from user01 where accnum='"+textField.getText()+"'";
				if(DataOperate.checkPass(sqlString,passwordField.getText().trim())) {
					if(passwordField_1.getText().trim().equals(passwordField_2.getText().trim())) {
						String sqlLookString="select * from user01 where accnum like'"+textField.getText().trim()+"%'";
						String sqlLookString2="update user01 set password='"+passwordField_2.getText().trim()+"' where accnum='"+textField.getText().trim()+"'";
						PageController4 pcl=new PageController4();
						if(pcl.setInsert(sqlLookString)) {
							PageController4 pcl2=new PageController4();
							pcl2.dataUpdate(sqlLookString2);
							JOptionPane.showMessageDialog(null,"Update Success!");
							frmUpdate.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Data duplication!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "The two inputs aer inconsistent");
					passwordField_1.requestFocus();
					passwordField_1.selectAll();
					passwordField_2.setText("");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Wrong Values!");
			}
			}
		});
		frmUpdate.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Update.class.getResource("/image/B8B96FA3ACDD9993E82261635838FA8E.png")));
		lblNewLabel_1.setBounds(212, 258, 85, 91);
		frmUpdate.getContentPane().add(lblNewLabel_1);
	}
}
