package mini_project;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Update_cost extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_cost frame = new Update_cost();
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
	public Update_cost() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New KiloWatt per hour Rate");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(37, 85, 258, 52);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(336, 85, 205, 52);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*String Updation;
				
				Updation = textField.getText();
				
				int amt = Integer.parseInt(Updation); 
				
				JOptionPane.showMessageDialog(null, "Cost Updated");*/
				
				String Updation = textField.getText();
				int amt = Integer.parseInt(Updation);
				
				 try 
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin_detail","root","1234");
						/*String sql = "update unit_cost2 set unit=? where refer=2";
						PreparedStatement stm = con.prepareStatement(sql);
						stm.setInt(2, amt);*/
						
						Statement stm = con.createStatement();
						
						//String query1 = "update unit_cost2 set unit='+amt+' " + "where refer=2";
						
							
				        stm.executeUpdate(query1);
						
					}
					catch(Exception a)
					{
						System.out.println(a);
					}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(229, 200, 178, 58);
		contentPane.add(btnNewButton);
	}

}
