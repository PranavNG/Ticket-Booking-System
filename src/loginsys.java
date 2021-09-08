package loginsys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Booking.Booking;
import java.io.*;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import Signup.Sign;

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
	void checkdata(String username, String password)
	{
		String search=textField.getText();
		int count=0;
		File f= new File("D:\\Pranav\\Java workspace\\Login_System\\creds.txt");
		try 
		{
			RandomAccessFile raf=new RandomAccessFile(f,"rw");
			while((line=raf.readLine()) != null )
			{
				String[]words = line.split(" ");
				for(String word: words)
				{
					if (word.equals(search)) 
					{
						count++;
					}
				}
			}
			if(count>0)
			{
				int countline=0,countbuffer=0;
				int b=0;String text="";
				try 
				{
					raf = new RandomAccessFile(f,"rw");
					while((line=raf.readLine()) != null )
					{
						countline++;
						String[]words = line.split(" ");
						for(String word: words)
						{
							if (word.equals(search)) 
							{
			                    countbuffer++;
							}
							if(countbuffer>0)
							{
								countbuffer=0;
								b+=countline;
							}
						}
					}
			        raf = new RandomAccessFile(f,"rw");
					for(int a=1;a<12;a++)
					{
						if(a == b)
						{
							text =raf.readLine(); 
						}
						else{
							raf.readLine();
						}
					}
					int c=search.length();
					String check=text.substring(c+1);
					if(password.equals(check))
					{
						@SuppressWarnings("unused")
						Booking site= new Booking();
						Booking.main(null);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Password incorrect!","Login Error", JOptionPane.INFORMATION_MESSAGE);
						passwordField.setText(null);
					}
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Account not Found.","Login Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		catch(IOException e){
			e.printStackTrace();

		}
	}
	void countlines(){
		File f= new File("D:\\Pranav\\Java workspace\\Login_System.txt");
		try {
			ln=0;
			RandomAccessFile raf=new RandomAccessFile(f,"rw");
			for(int i=0;raf.readLine()!=null;i++){
				ln++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Ticket Booking");
		frame.setBounds(100, 100, 599, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(34, 41, 126, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(34, 111, 126, 54);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(194, 55, 215, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(194, 125, 215, 26);
		frame.getContentPane().add(passwordField);
		
		btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) 
			{
				@SuppressWarnings("unused")
				Sign info = new Sign();
				Sign.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(233, 322, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
		        countlines();
		        if(password.isEmpty() || username.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter Login Details","Login Error", JOptionPane.ERROR_MESSAGE);
					textField.setText(null);
					passwordField.setText(null);
				}
		        else{
				checkdata(username,password);
		        }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(233, 195, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		separator = new JSeparator();
		separator.setBounds(34, 265, 215, 2);
		frame.getContentPane().add(separator);
		
		lblOr = new JLabel("Or");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(253, 253, 69, 20);
		frame.getContentPane().add(lblOr);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(321, 265, 215, 2);
		frame.getContentPane().add(separator_1);
	}
}
