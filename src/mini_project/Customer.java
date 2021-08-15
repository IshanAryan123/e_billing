package mini_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Customer extends JFrame {

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
					Customer frame = new Customer();
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
	public Customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 966, 664);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("View Bill");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(107, 23, 170, 55);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Pay Bill");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//connect to pay bill frame
				Customer_PayBill1.main(null);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(416, 23, 170, 55);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Feedback");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FeedBack.main(null);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(689, 23, 170, 55);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Customer Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(216, 222, 150, 41);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(216, 297, 136, 44);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Unit");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(224, 386, 128, 47);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(419, 219, 150, 41);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(419, 297, 150, 34);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(419, 386, 150, 35);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("View Bill");
		btnNewButton_4.addActionListener(new ActionListener() 
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
					
					
					while(rs.next())
					{
						String cons_no = rs.getString("connum");
						String tfconno = textField.getText();
						
						if(cons_no.equals(tfconno))
						{
							textField.setText(rs.getString("connum"));
							textField_1.setText(rs.getString("conname"));
							textField_2.setText(rs.getString("units"));
							
							
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
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBounds(385, 504, 253, 55);
		panel.add(btnNewButton_4);
	}
}
