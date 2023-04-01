package StudentData;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField n;
	private JTextField p;
	private JTextField m;
	private JTextField m1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.setBounds(100, 100, 455, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(144, 37, 144, 55);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(81, 110, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(81, 145, 107, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Marks");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(81, 182, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		n = new JTextField();
		n.setBounds(154, 109, 86, 20);
		frame.getContentPane().add(n);
		n.setColumns(10);
		
		p = new JTextField();
		p.setBounds(154, 144, 86, 20);
		frame.getContentPane().add(p);
		p.setColumns(10);
		
		m = new JTextField();
		m.setColumns(10);
		m.setBounds(154, 181, 86, 20);
		frame.getContentPane().add(m);
		
		JLabel lblNewLabel_3_1 = new JLabel("Mail Id");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(81, 218, 71, 14);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		m1 = new JTextField();
		m1.setColumns(10);
		m1.setBounds(154, 217, 86, 20);
		frame.getContentPane().add(m1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				String t1 = n.getText(),t2= p.getText(), t3=m.getText(), t4=m1.getText();
				int i1 = Integer.parseInt(t2), i2 = Integer.parseInt(t3);
				try {					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "root", "mrec");
					String q = "Insert into StudentInfo values ('"+t1+"','"+i1+"','"+i2+"','"+t4+"')";
					Statement sta = con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Sarle Nuvellu");
					
				}
				
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(288, 158, 95, 20);
		frame.getContentPane().add(btnNewButton);
	}
}
