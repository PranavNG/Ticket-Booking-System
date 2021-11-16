package Signup;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Sign {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	public JTextField textField_2;
	public JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public int ln;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign window = new Sign();
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
	public Sign() 
	{
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 541, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("SignUp");
				
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(15, 37, 69, 20);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(173, 34, 211, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDob = new JLabel("Mail ID");
		lblDob.setBackground(new Color(240, 240, 240));
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDob.setBounds(15, 87, 103, 20);
		frame.getContentPane().add(lblDob);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(326, 149, 178, 20);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(173, 112, 103, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setBounds(173, 84, 211, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(15, 147, 103, 20);
		frame.getContentPane().add(lblUsername);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_2.setBounds(133, 146, 178, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(15, 192, 103, 20);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(98, 354, 291, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setForeground(Color.BLACK);
		btnCreate.setBackground(Color.GREEN);
		btnCreate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent args0) 
			{
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?useSSL=false", "root","mini_project1");
					String name = textField.getText();
					String email = textField_1.getText();
					String usname = textField_2.getText();
					String password1 = new String(passwordField_1.getPassword());
					String password = new String(passwordField.getPassword());
					if(password.equals(password1))
					{
						Statement st = con.createStatement();
			        		String sql ="insert into Customer values(1, '"+name+"', '"+email+"', '"+usname+"', '"+password+"')";
			        		st.executeUpdate(sql);
			        		frame.dispose();
					}
					if(name.isEmpty()|| usname.isEmpty() || password.isEmpty() || password1.isEmpty())
					{
						JOptionPane.showMessageDialog(null,"One or more Fields are empty.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						lblNewLabel_2.setText("Passwords do not match");
					}
					}
				catch(Exception e)
				{
					System.out.println(e.getMessage());	
				}
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreate.setBounds(196, 304, 115, 44);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(15, 257, 168, 20);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setEchoChar('*');
		passwordField.setBounds(196, 256, 178, 26);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(133, 191, 178, 26);
		frame.getContentPane().add(passwordField_1);
		
	}
}
