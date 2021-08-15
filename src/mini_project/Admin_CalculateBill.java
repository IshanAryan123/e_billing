package mini_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Admin_CalculateBill extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_CalculateBill frame = new Admin_CalculateBill();
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
	public Admin_CalculateBill() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consumer No.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(103, 73, 111, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(103, 167, 141, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Units Consumed");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(103, 395, 175, 38);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(334, 73, 156, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(334, 164, 156, 42);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(334, 395, 156, 42);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Bill Amount");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(112, 472, 132, 42);
		contentPane.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(343, 474, 147, 42);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				
				/*String Updation = textField.getText();
				int amt = Integer.parseInt(Updation);*/
				
				
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","1234");
					//To establish connection
					
					
					Statement stm = con.createStatement();
					String sql = "Select * from cust_detail ";
					
					ResultSet rs = stm.executeQuery(sql);
					//rs contains the data of table
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_detail","root","1234");
					//To establish connection
					
					
					Statement stm1 = con1.createStatement();
					String sql1 = "Select * from unit_cost1 ";
					
					ResultSet rs1 = stm1.executeQuery(sql1);
					
					
					while(rs.next())
					{
						String cons_no = rs.getString("connum");
						String tfconno = textField.getText();
						
						if(cons_no.equals(tfconno))
						{
							textField.setText(rs.getString("connum"));
							textField_1.setText(rs.getString("conname"));
							textField_3.setText(rs.getString("units"));
							
							String unt = rs.getString("units");
							int un = Integer.parseInt(unt);	
							
							int amt1 = un*9;
							textField_4.setText(""+amt1);
			
							
							//calculate cost
							
							/*//Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_detail","root","1234");
							//To establish connection
							
							
							Statement stm1 = con1.createStatement();
							String sql1 = "Select * from unit_cost ";
							
							ResultSet rs1 = stm1.executeQuery(sql1);
							
							String price = rs1.getString("unit");
							textField_4.setText(price);
							int a = Integer.parseInt(price);
							
							int cost = a*un;
							
							textField_4.setText(""+cost);
							textField_4.setText("hello");*/
							
							
							
							
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
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(334, 287, 156, 41);
		contentPane.add(btnNewButton);
	}
	
	/*public Admin_CalculateBill(String Para)
	{
		initComponents();
	}*/

}
