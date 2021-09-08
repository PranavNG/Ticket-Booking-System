package Booking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

import Signup.Sign;

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
	/*public ResultSet displayUsers() throws ClassNotFoundException, SQLException{
		if(con==null){
			getConnection();
		}
		Statement state= con.createStatement();
		ResultSet res=state.executeQuery("SELECT user, from, to, date, price FROM tdetail");
		return res;
	}
	private void getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:Booking.db");
		intialize();
	}

	private void intialize() throws SQLException {
		if(!hasData){
			hasData= true;
			Statement state= con.createStatement();
			ResultSet res= state.executeQuery("SELECT name FROM sqlite_master WHERE type=:table AND name=:tdetail"); 
			if(!res.next())
			{
				Statement state2= con.createStatement();
				state2.execute("CREATE TABLE tdetail(user varchar(22), from varchar(10), to varchar(10), date varchar(15), price varchar(15), primary key(user));");
				PreparedStatement prep= con.prepareStatement("INSERT INTO tdetail values(?,?,?,?,?)");
				prep.setString(2,Sign.usname);
				prep.setString(3,destination);
				prep.setString(4, source);
				prep.setString(5, Total);
				prep.execute();
			}
		}
	}
	public void addUser() throws ClassNotFoundException, SQLException{
		if(con==null)
		{
			getConnection();
		}
		PreparedStatement prep= con.prepareStatement("INSERT INTO detail values(?,?,?,?,?)");
		prep.setString(3, source);
		prep.setString(4, destination);
		prep.execute();
	}*/
	public Booking() {
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
		comboBox.addItem("Bengaluru");
		comboBox.addItem("Chennai");
		comboBox.addItem("Mumbai");
		comboBox.addItem("Kolkata");
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
		comboBox_1.addItem("Kolkata");
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
		
		JCheckBox chckbxReturnJourney = new JCheckBox("Return Journey");
		chckbxReturnJourney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxReturnJourney.setBounds(15, 170, 183, 29);
		frame.getContentPane().add(chckbxReturnJourney);
		
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
					if(chckbxReturnJourney.isSelected())
					{
						lblNewLabel_8.setText("Yes");
					}
					else
					{
						lblNewLabel_8.setText("No");
					}
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
		
		JLabel lblReturn = new JLabel("Return");
		lblReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblReturn.setBounds(281, 432, 69, 20);
		frame.getContentPane().add(lblReturn);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(15, 432, 69, 20);
		frame.getContentPane().add(lblDate);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int adult = Integer.parseInt(textField_10.getText());
				int child = Integer.parseInt(textField_11.getText());
				int subtotal=0;
				destination =lblNewLabel_5.getText();
				source = lblNewLabel_4.getText();
				if(destination.equals("Bengaluru") && source.equals("Chennai") || source.equals("Bengaluru") && destination.equals("Chennai"))
				{
					subtotal= (adult*500)+(child*350);
				}
				else if(destination.equals("Bengaluru") && source.equals("Mumbai") || source.equals("Bengaluru") && destination.equals("Mumbai"))
				{
					subtotal= (adult*700)+(child*450);
				}
				else if(destination.equals("Bengaluru") && source.equals("Delhi") || source.equals("Bengaluru") && destination.equals("Delhi"))
				{
					subtotal= (adult*1100)+(child*700);
				}
				else if(destination.equals("Bengaluru") && source.equals("Kolkata") || source.equals("Bengaluru") && destination.equals("Kolkata"))
				{
					subtotal= (adult*1400)+(child*1000);
				}
				else if(destination.equals("Chennai") && source.equals("Mumbai") || source.equals("Chennai") && destination.equals("Mumbai"))
				{
					subtotal= (adult*1100)+(child*900);
				}
				else if(destination.equals("Chennai") && source.equals("Delhi") || source.equals("Chennai") && destination.equals("Delhi"))
				{
					subtotal= (adult*1250)+(child*920);
				}
				else if(destination.equals("Chennai") && source.equals("Kolkata") || source.equals("Chennai") && destination.equals("Kolkata"))
				{
					subtotal= (adult*1550)+(child*1150);
				}
				else if(destination.equals("Mumbai") &&source.equals("Delhi") || source.equals("Mumbai") && destination.equals("Delhi"))
				{
					subtotal= (adult*500)+(child*350);
				}
				else if(destination.equals("Mumbai") && source.equals("Kolkata") || source.equals("Mumbai") && destination.equals("Kolkata"))
				{
					subtotal= (adult*1100)+(child*700);
				}
				else if(destination.equals("Delhi") && source.equals("Kolkata") || source.equals("Delhi") && destination.equals("Kolkata"))
				{
					subtotal= (adult*700)+(child*450);
				}
				else if(destination.equals("Bengaluru") && source.equals("Mumbai") || source.equals("Bengaluru") && destination.equals("Mumbai"))
				{
					subtotal= (adult*700)+(child*450);
				}
				if(chckbxReturnJourney.isSelected())
				{
					subtotal=subtotal*2;
				}
				String stotal = Integer.toString(subtotal);
				lblNewLabel_10.setText(stotal);
				lblNewLabel_11.setText("5%");
				double total= (0.05*subtotal)+subtotal;
				Total=Double.toString(total);
				lblNewLabel_12.setText(Total);
				count++;
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
				chckbxReturnJourney.setSelected(false);
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
				if(count<1)
					{
					JOptionPane.showMessageDialog(null,"One or More Fields are empty.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				else
				{
					JOptionPane.showMessageDialog(null, "Payment done...","Hurray!", JOptionPane.INFORMATION_MESSAGE);
				}
				/*try {
					addUser();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
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
		lblAdult.setBounds(226, 174, 57, 20);
		frame.getContentPane().add(lblAdult);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				String adult = textField_10.getText();
				int n=adult.length();	
				char b=evt.getKeyChar();
				if(b>='0' && b<='4')
				{
					if(n<1)
					{
						textField_10.setEditable(true);
					}else
					{
						textField_10.setEditable(false);
					}
				}else
				{
					if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode()==KeyEvent.VK_DELETE)
					{
						textField_10.setEditable(true);
					}else
					{
						textField_10.setEditable(false);
					}
				}
			}
		});
		textField_10.setBounds(230, 199, 106, 26);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblChild_1 = new JLabel("Child");
		lblChild_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChild_1.setBounds(365, 176, 69, 20);
		frame.getContentPane().add(lblChild_1);
		
		textField_11 = new JTextField();
		textField_11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String child = textField_11.getText();
				int n=child.length();	
				char b=e.getKeyChar();
				if(b>='0' && b<='4')
				{
					if(n<1)
					{
						textField_11.setEditable(true);
					}else
					{
						textField_11.setEditable(false);
					}
				}else
				{
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE)
					{
						textField_11.setEditable(true);
					}else
					{
						textField_11.setEditable(false);
					}
				}
			}
		});
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_11.setBounds(375, 198, 106, 26);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnDetails = new JButton("Details");
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*try {
					displayUsers();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ResultSet rs;
				try {
					rs = displayUsers();
					while(rs.next()){
						System.out.println(rs.getString("user")+ " "+ rs.getString("from")+" "+ rs.getString("to"));
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}*/
				
			}
			
		});
		btnDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDetails.setBounds(577, 476, 94, 29);
		frame.getContentPane().add(btnDetails);
		
				
	}
}
