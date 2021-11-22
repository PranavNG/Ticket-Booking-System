package Home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import loginsys.loginsys;
import Booking.Booking;
import Profile.Profile;

public class Home {

	private JFrame frmWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome");
		frmWelcome.setBounds(100, 100, 702, 536);
		frmWelcome.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(10, 10, 663, 51);
		frmWelcome.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Ticket Booking");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		loginsys obj=new loginsys();
		JLabel lblNewLabel_1 = new JLabel("Welcome "+obj.get_username());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(31, 104, 257, 33);
		frmWelcome.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Book a Ticket");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Booking.main(null);
			}
		});
		btnNewButton.setBounds(250, 174, 160, 44);
		frmWelcome.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Profile");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile.main(null);
			}
		});
		btnNewButton_1.setBounds(250, 285, 160, 44);
		frmWelcome.getContentPane().add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 253, 600, 2);
		frmWelcome.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 360, 600, 2);
		frmWelcome.getContentPane().add(separator_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWelcome.dispose();
				JOptionPane.showMessageDialog(null, "Successfully logged out!","Logout", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnNewButton_2.setBounds(250, 395, 160, 44);
		frmWelcome.getContentPane().add(btnNewButton_2);
		
		
		
	}
}
