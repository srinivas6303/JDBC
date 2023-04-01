package StudentData;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;

public class Login {

	private JFrame frame;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 255));
		frame.setBounds(100, 100, 654, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblLogin.setBounds(294, 11, 144, 55);
		frame.getContentPane().add(lblLogin);
		
		t2 = new JTextField();
		t2.setBounds(267, 111, 171, 34);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PIN");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(202, 103, 106, 55);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lb1 = new JLabel("");
		lb1.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lb1.setBounds(272, 170, 292, 55);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("");
		lb2.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lb2.setBounds(282, 222, 303, 55);
		frame.getContentPane().add(lb2);
		
		
		
		
		
		JButton btnNewButton = new JButton("GET MARKS");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String t1 = t2.getText();
				int i = Integer.parseInt(t1);
				try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "root", "mrec");
				String q="select Name,Marks from StudentInfo where PIN=? ";
				PreparedStatement ps = con.prepareStatement(q);
				ps.setInt(1, i);
				
				
				ResultSet rs = ps.executeQuery();
				rs.next();
				
				lb1.setText(rs.getString(1));
				lb2.setText(rs.getString(2));
				
				
				
				
				
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(275, 303, 115, 41);
		frame.getContentPane().add(btnNewButton);
		
	}

}
