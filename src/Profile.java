package Details;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import loginsys.loginsys;

public class Profile {

	private JFrame frame;
	private JTable table;
	private String uname;
	private String name;
	private String email;
	private int cid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile window = new Profile();
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
	public Profile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 929, 566);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try{
			loginsys obj=new loginsys();
			uname = obj.username;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?useSSL=false","root","pword");
			Statement st = con.createStatement();
			String q="select Cust_ID,Name,Email_ID from Customer where Username='"+uname+"'";
			ResultSet res=st.executeQuery(q);
			if(res.next())
			{
				name=res.getString("Name");
				email=res.getString("Email_ID");
				cid=res.getInt("Cust_ID");
			}
		}catch(SQLException | ClassNotFoundException er)
		{
			System.out.println(er.getMessage());
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(10, 10, 895, 55);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("User Profile");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(30, 91, 104, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(30, 126, 104, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email ID: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(30, 161, 104, 25);
		frame.getContentPane().add(lblNewLabel_3);
		

		JLabel lblNewLabel_8 = new JLabel("User ID: ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(30, 196, 104, 25);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_4 = new JLabel(name);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(158, 93, 80, 25);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(uname);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(158, 128, 80, 25);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(email);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(158, 161, 143, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_9 = new JLabel(Integer.toString(cid));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(158, 196, 80, 25);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_7 = new JLabel("Previous Booking Record");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(28, 231, 233, 25);
		frame.getContentPane().add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 266, 851, 239);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainbookings?useSSL=false","root","mini_project1");
			Statement s = con.createStatement();
			String sql="select * from Booking where Cust_ID='"+cid+"'";
			ResultSet rs=s.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(SQLException | ClassNotFoundException er)
		{
			System.out.println(er.getMessage());
		}
	}

}
