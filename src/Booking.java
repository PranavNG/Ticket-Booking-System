package Booking;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import loginsys.loginsys;

public class Booking {

	private JFrame frame;
	private JTextField textField_10;
	private JTextField textField_11;
	private JDateChooser dateChooser;
	public int count;
	public Connection con;
	public boolean hasData = false;
	protected String destination;
	protected String source;
	protected int adult,child;
	protected String Total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking window = new Booking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Booking()
	{
		initialize();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1004, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Welcome");
		
		JLabel lblNewLabel = new JLabel("Source");
		lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		lblNewLabel.setBounds(15, 67, 83, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.addItem("Bangalore");
		comboBox.addItem("Chennai");
		comboBox.addItem("Mumbai");
		comboBox.addItem("Trivandrum");
		comboBox.addItem("Delhi");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(28, 103, 170, 26);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Destination");
		lblNewLabel_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(226, 67, 150, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.addItem("Bengaluru");
		comboBox_1.addItem("Chennai");
		comboBox_1.addItem("Mumbai");
		comboBox_1.addItem("Trivandrum");
		comboBox_1.addItem("Delhi");
		comboBox_1.setSelectedItem(null);
		comboBox_1.setBounds(257, 103, 170, 26);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Journey Date");
		lblNewLabel_2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(468, 67, 161, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 150, 657, 2);
		frame.getContentPane().add(separator);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBounds(0, 0, 982, 51);
		frame.getContentPane().add(panel);
		
		JLabel lblTicketBooking = new JLabel("Ticket Booking");
		lblTicketBooking.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 25));
		panel.add(lblTicketBooking);
		

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(74, 334, 170, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setBounds(78, 385, 170, 26);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setBounds(365, 385, 146, 26);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setBounds(365, 334, 146, 26);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setBounds(365, 432, 146, 26);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBackground(Color.WHITE);
		lblNewLabel_9.setBounds(78, 432, 146, 26);
		frame.getContentPane().add(lblNewLabel_9);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(491, 103, 170, 26);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBackground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_10.setBounds(821, 174, 146, 50);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_11.setBounds(821, 243, 146, 50);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_12.setBounds(821, 312, 146, 50);
		frame.getContentPane().add(lblNewLabel_12);

		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) 
			{
				String destination=(String)comboBox_1.getSelectedItem();
				String source=(String)comboBox.getSelectedItem();
				String adult = textField_10.getText();
				lblNewLabel_6.setText(adult);
				String child = textField_11.getText();
				lblNewLabel_7.setText(child);
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				Date date;
				date=dateChooser.getDate();
				lblNewLabel_9.setText(df.format(date));
				if(source.isEmpty()|| destination.isEmpty() || adult.isEmpty() || child.isEmpty() || date==null ){
					JOptionPane.showMessageDialog(null,"One or More Fields are empty.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(source==destination)
					{
						JOptionPane.showMessageDialog(null,"Source and Destination cannot be same.", "Error", JOptionPane.ERROR_MESSAGE);
						comboBox_1.setSelectedItem(null);
					}
					else
					{	
						lblNewLabel_4.setText(source);
						lblNewLabel_5.setText(destination);
					}
					if(adult.isEmpty() && child.isEmpty())
					{
						JOptionPane.showMessageDialog(null,"Enter number of travellers.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if(adult.isEmpty()){
						lblNewLabel_6.setText("0");
					}
					else if(child.isEmpty()){
						lblNewLabel_7.setText("0");
					}
				}
			}
		});
		btnGo.setForeground(Color.WHITE);
		btnGo.setBackground(Color.BLUE);
		btnGo.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		btnGo.setBounds(557, 196, 115, 29);
		frame.getContentPane().add(btnGo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(687, 67, 8, 383);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 241, 657, 2);
		frame.getContentPane().add(separator_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.ORANGE, 4, true));
		panel_1.setBounds(15, 262, 657, 45);
		frame.getContentPane().add(panel_1);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(lblDetails);
		
		JLabel lblNewLabel_3 = new JLabel("From");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(15, 334, 57, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTo.setBounds(15, 385, 48, 20);
		frame.getContentPane().add(lblTo);
		
		JLabel lblAdults = new JLabel("Adult");
		lblAdults.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdults.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdults.setBounds(281, 385, 69, 20);
		frame.getContentPane().add(lblAdults);
		
		JLabel lblChild = new JLabel("Child");
		lblChild.setHorizontalAlignment(SwingConstants.LEFT);
		lblChild.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChild.setBounds(281, 334, 69, 20);
		frame.getContentPane().add(lblChild);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(15, 432, 69, 20);
		frame.getContentPane().add(lblDate);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					adult = Integer.parseInt(textField_10.getText());
					child = Integer.parseInt(textField_11.getText());
					int cost=0;double subtotal;
					destination =lblNewLabel_5.getText();
					source = lblNewLabel_4.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?useSSL=false", "root","mini_project1");
					String sq ="select * from Train where Source = '"+source +"' and Destination = '"+destination+"'";
					PreparedStatement p = con.prepareStatement(sq);
					ResultSet rs = p.executeQuery();
					if(rs.next())
					{
						cost = rs.getInt("Cost");
					}
					subtotal = adult*cost + child *(cost- cost*0.25);
					String stotal = Double.toString(subtotal);
					lblNewLabel_10.setText(stotal);
					lblNewLabel_11.setText("5%");
					double total= (0.05*subtotal)+subtotal;
					Total=Double.toString(total);
					lblNewLabel_12.setText(Total);
					count++;
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		});
		btnSubmit.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		btnSubmit.setBounds(183, 474, 115, 29);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				lblNewLabel_4.setText(null);
				lblNewLabel_5.setText(null);
				lblNewLabel_6.setText(null);
				lblNewLabel_7.setText(null);
				lblNewLabel_8.setText(null);
				lblNewLabel_9.setText(null);
				comboBox_1.setSelectedItem(null);
				comboBox.setSelectedItem(null);
				dateChooser.setDate(null);
				textField_10.setText(null);
				textField_11.setText(null);
				lblNewLabel_10.setText(null);
				lblNewLabel_11.setText(null);
				lblNewLabel_12.setText(null);
				
			}
		});
		btnReset.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		btnReset.setBounds(365, 474, 115, 29);
		frame.getContentPane().add(btnReset);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.ORANGE, 4, true));
		panel_2.setBounds(710, 67, 257, 62);
		frame.getContentPane().add(panel_2);
		
		JLabel lblBill = new JLabel("Bill");
		lblBill.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_2.add(lblBill);
		
		JLabel lblSubtotal = new JLabel("SubTotal");
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubtotal.setBounds(710, 174, 88, 20);
		frame.getContentPane().add(lblSubtotal);
		
		JLabel lblTax = new JLabel("TAX");
		lblTax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTax.setBounds(710, 243, 88, 20);
		frame.getContentPane().add(lblTax);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(710, 455, 257, 51);
		frame.getContentPane().add(panel_3);
		
		JButton btnPay = new JButton("PAY");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					loginsys obj = new loginsys();
					String uname = obj.username;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject?useSSL=false", "root","mini_project1");
					int bid = (int)Math.random();
					int tid = 0, cid=0;
					if(count >= 1){
						String sq ="select Train_ID from Train where Source = '"+source +"' and Destination = '"+destination+"'";
			        	String s = "select Cust_ID from Customer where Username = '"+uname+"'";
						PreparedStatement p = con.prepareStatement(sq);
						PreparedStatement ps = con.prepareStatement(s);
						ResultSet rs = p.executeQuery();
						if(rs.next())
						{
							tid = rs.getInt("Train_ID");
						}
						ResultSet r = ps.executeQuery();
						if(r.next())
						{
							cid = r.getInt("Cust_ID");
						}
						LocalDate date =java.time.LocalDate.now(); 
						Statement st = con.createStatement();
			        	String sql ="insert into Booking values('"+bid+"','"+cid+"','"+tid+"','"+source+"','"+ destination+"','"+adult +"','"+child +"', '"+Total +"','"+date+"' )";
			        	st.executeUpdate(sql);
			        	JOptionPane.showMessageDialog(null, "Payment done...","Hurray!", JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(SQLException | ClassNotFoundException er)
				{
					System.out.println(er.getMessage());
				}
			}
		});
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(btnPay);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotal.setBounds(710, 312, 88, 20);
		frame.getContentPane().add(lblTotal);
		
		JLabel lblAdult = new JLabel("Adult");
		lblAdult.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdult.setBounds(28, 174, 57, 20);
		frame.getContentPane().add(lblAdult);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_10.setBounds(38, 198, 106, 26);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblChild_1 = new JLabel("Child");
		lblChild_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChild_1.setBounds(226, 174, 69, 20);
		frame.getContentPane().add(lblChild_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_11.setBounds(257, 198, 106, 26);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnDetails = new JButton("Details");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDetails.setBounds(577, 476, 94, 29);
		frame.getContentPane().add(btnDetails);	
	}
}
