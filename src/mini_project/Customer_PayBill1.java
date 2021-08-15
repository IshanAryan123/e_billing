package mini_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Customer_PayBill1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_PayBill1 frame = new Customer_PayBill1();
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
	public Customer_PayBill1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 877, 669);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(91, 87, 154, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(91, 167, 143, 36);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(333, 84, 244, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(333, 164, 244, 39);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Amount");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(91, 273, 154, 36);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(333, 273, 244, 36);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Make Payment");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","1234");
					//To establish connection
					
					
					Statement stm = con.createStatement();
					String sql = "Select * from cust_detail ";
					
					ResultSet rs = stm.executeQuery(sql);
					//rs contains the data of table
					
					
					/*Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_detail","root","1234");
					//To establish connection
					
					
					Statement stm1 = con.createStatement();
					String sql1 = "Select * from unit_cost2 ";
					
					ResultSet rs1 = stm1.executeQuery(sql1);*/
					
					
					while(rs.next())
					{
						String cons_no = rs.getString("connum");
						String tfconno = textField.getText();
						
						if(cons_no.equals(tfconno))
						{
							textField.setText(rs.getString("connum"));
							textField_1.setText(rs.getString("conname"));
							
							String unt = rs.getString("units");
							int un = Integer.parseInt(unt);	
							
							/*String unt1 = rs1.getString("unit");
							int un1 = Integer.parseInt(unt1);*/	
							
							int amt1 = un*9;
							textField_2.setText(""+amt1);
			
							
							
					    }
						else
						{
							//JOptionPane.showMessageDialog(null,"Invalid login","ERROR",JOptionPane.ERROR_MESSAGE);
							//textField.setText(null);
						}
					}
				}
				catch(Exception z)
				{
					System.out.println(z);
				}
				
				JOptionPane.showMessageDialog(null, "Payment Received");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(326, 412, 196, 46);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 877, 669);
		contentPane.add(panel_1);
	}

}
