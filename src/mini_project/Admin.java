package mini_project;


import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 884, 649);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton registration = new JButton("Registration");
		registration.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registration.setBounds(29, 37, 150, 52);
		panel.add(registration);
		
		JButton btnNewButton_1 = new JButton("View Customer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(229, 37, 139, 52);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Calculate Bill");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin_CalculateBill.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(421, 37, 139, 52);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update Cost/Unit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Update_cost.main(null);
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(640, 37, 179, 52);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(67, 200, 187, 66);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(300, 210, 179, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(69, 353, 110, 42);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 335, 179, 33);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				
				
				 try 
					{
					 
					    String uname, name, contact, email;
						String password;
						
						uname = textField.getText();
						
					    password = textField_3.getText();
						int pwd = Integer.parseInt(password);
						
						name = textField_1.getText();
						contact = textField_2.getText();
						email = textField_4.getText();
					 
					 	String sql = "insert into register1 values(?,?,?,?,?)";
						//String sql = "insert into unit_cost values('" +uname+"'," +pwd+ ",'" +name+"','" +contact+ "','"+email+"')";
						
					 	
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_detail","root","1234");
						PreparedStatement stm = con.prepareStatement(sql);
						
						stm.setString(1,uname);
						stm.setInt(2,pwd);
						stm.setString(3,name);
						stm.setString(4,contact);
						stm.setString(5,email);
						
						int rs = stm.executeUpdate();
						
					}
					catch(Exception a)
					{
						System.out.println(a);
					}
				
				//JOptionPane.showMessageDialog(null, "Registration Successful");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(612, 274, 207, 60);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Contact No.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(69, 406, 128, 42);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(300, 390, 179, 33);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(69, 290, 110, 33);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(300, 274, 179, 33);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(69, 468, 128, 33);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(300, 452, 179, 33);
		panel.add(textField_4);
		textField_4.setColumns(10);
	}

}
