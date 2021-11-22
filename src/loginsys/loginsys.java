package loginsys;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import Home.Home;
import Signup.Sign;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class loginsys {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JSeparator separator;
	private JLabel lblOr;
	private JSeparator separator_1;
	public int ln;
	public String line;
	public static String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginsys window = new loginsys();
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
	public loginsys() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ticket Booking");
		frame.setBounds(100, 100, 628, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 89, 126, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(34, 153, 126, 54);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(194, 103, 215, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(194, 167, 215, 26);
		frame.getContentPane().add(passwordField);
		
		btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) 
			{
				Sign.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(233, 353, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainbookings?useSSL=false","root","pword");
					username = textField.getText();
					String password = new String(passwordField.getPassword());
			        	if(password.isEmpty() || username.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Please enter Login Details","Login Error", JOptionPane.ERROR_MESSAGE);
					}
			        	else{
			        		Statement st = con.createStatement();
			        		String sql ="select * from Customer where username='"+username+"' and password = '"+password+"'";
			        		ResultSet rs = st.executeQuery(sql);
			        		if(rs.next())
			        		{
							Home.main(null);
							passwordField.setText(null);
							textField.setText(null);
			        		}
			        		else 
						{
							JOptionPane.showMessageDialog(null, "Username or Password incorrect!","Login Error", JOptionPane.INFORMATION_MESSAGE);
							passwordField.setText(null);
							textField.setText(null);
						}
			        	}
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
		        }
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(233, 236, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		separator = new JSeparator();
		separator.setBounds(34, 309, 215, 2);
		frame.getContentPane().add(separator);
		
		lblOr = new JLabel("Or");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(251, 291, 69, 20);
		frame.getContentPane().add(lblOr);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(330, 309, 215, 2);
		frame.getContentPane().add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(10, 10, 594, 54);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Ticket Booking");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel.add(lblNewLabel_2);
	}
	
	public String get_username()
	{
		return username;
	}
}