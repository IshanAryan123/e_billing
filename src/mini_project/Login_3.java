package mini_project;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.sql.*;

public class Login_3 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JPasswordField passwordField_3;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_3 window = new Login_3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.desktop);
		frame.setBounds(100, 100, 1025, 737);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 988, 645);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(497, 11, 481, 623);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(162, 180, 260, 38);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 245, 260, 38);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(48, 156, 52, 77);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ImageIcon icon3 = new ImageIcon(this.getClass().getResource("/cust_1.jpg"));
		lblNewLabel_1.setIcon(icon3);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(48, 245, 75, 38);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ImageIcon icon4 = new ImageIcon(this.getClass().getResource("/lck_1.jpg"));
		lblNewLabel_2.setIcon(icon4);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(245, 355, 163, 38);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				/*String uname = textField.getText();
				String pword = passwordField.getText();
				
				if(uname.contains("I") && pword.contains("1"))
				{
					textField.setText(null);
					passwordField.setText(null);
					Customer.main(null);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid login","ERROR",JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
				}*/
				
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","1234");
					Statement stm = con.createStatement();
					String sql = "Select * from Login where Username='"+textField.getText()+"' and Password='"+passwordField.getText().toString()+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next())
					{
						textField.setText(null);
						passwordField.setText(null);
						Customer.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid login","ERROR",JOptionPane.ERROR_MESSAGE);
						textField.setText(null);
						passwordField.setText(null);
					}
				}
				catch(Exception z)
				{
					System.out.println(z);
				}
				
			}
		});
		panel_1.add(btnNewButton);
		ImageIcon icon7 = new ImageIcon(this.getClass().getResource("/blue_1.jpg"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(472, 11, -439, 96);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Customer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(193, 56, 181, 51);
		panel_1.add(lblNewLabel);
		//ImageIcon icon7 = new ImageIcon(this.getClass().getResource("/blue_1.jpg"));
		
	
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 477, 623);
		panel.add(panel_2);
		panel_2.setBackground(new Color(0, 102, 255));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("            ADMIN");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(70, 35, 291, 68);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(57, 248, 105, 40);
		ImageIcon icon6 = new ImageIcon(this.getClass().getResource("/lck_1.jpg"));
		lblNewLabel_4.setIcon(icon6);
		panel_2.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(166, 171, 273, 40);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(57, 171, 99, 37);
		ImageIcon icon5 = new ImageIcon(this.getClass().getResource("/cust_1.jpg"));
		lblNewLabel_5.setIcon(icon5);
		panel_2.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*String uname_a = textField_2.getText();
				String pword_a = passwordField_3.getText();
				
				if(uname_a.contains("A") && pword_a.contains("2"))
				{
					textField_2.setText(null);
					passwordField_3.setText(null);
					Admin.main(null);
				}
				
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid login","ERROR",JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
				}*/
				
				
				 try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_detail","root","1234");
					Statement stm = con.createStatement();
					String sql = "Select * from Login where uname='"+textField_2.getText()+"' and password='"+passwordField_3.getText().toString()+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next())
					{
						textField_2.setText(null);
						passwordField_3.setText(null);
						Admin.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid login","ERROR",JOptionPane.ERROR_MESSAGE);
						textField_2.setText(null);
						passwordField_3.setText(null);
					}
				}
				catch(Exception a)
				{
					System.out.println(a);
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(125, 364, 184, 40);
		panel_2.add(btnNewButton_1);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(172, 248, 267, 40);
		panel_2.add(passwordField_3);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(175, 248, 264, 40);
		panel_2.add(passwordField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(86, 142, 52, 77);
		panel_2.add(lblNewLabel_1_1);

	}
}
