import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class reg extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField name;
	private JTextField email;
	private JTextField num;
	private JTextField add;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reg frame = new reg();
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
	public reg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 733);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 13));
		user.setBounds(167, 203, 257, 34);
		contentPane.add(user);
		user.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 13));
		name.setColumns(10);
		name.setBounds(167, 334, 252, 34);
		contentPane.add(name);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 13));
		email.setColumns(10);
		email.setBounds(167, 399, 252, 34);
		contentPane.add(email);
		
		num = new JTextField();
		num.setFont(new Font("Tahoma", Font.PLAIN, 13));
		num.setColumns(10);
		num.setBounds(167, 468, 252, 34);
		contentPane.add(num);
		
		add = new JTextField();
		add.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add.setColumns(10);
		add.setBounds(167, 538, 252, 34);
		contentPane.add(add);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(28, 208, 100, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(28, 277, 100, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Full Name");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(28, 339, 100, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(28, 543, 100, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contact No.");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(28, 473, 100, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(28, 404, 100, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Registration");
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7.setBackground(new Color(255, 0, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_7.setBounds(121, 98, 245, 40);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RIT", "root", "Dipali@45");
					PreparedStatement ps= conn.prepareStatement("insert into User(username,password,fullname,email,contact,address) values(?,?,?,?,?,?);");
					ps.setString(1, user.getText());
					ps.setString(2, pass.getText());
					ps.setString(3, name.getText());
					ps.setString(4, email.getText());
					ps.setString(5, num.getText());
					ps.setString(6, add.getText());
					int x = ps.executeUpdate();
					if(x > 0) {
						System.out.println("Registration Done Sucessfully....");
						JOptionPane.showMessageDialog(null,"Welcome To Quiz App Created By Shubham");  
						Login h=new Login();
						h.setVisible(true);
						dispose();
					}
					else {
						System.out.println("Registration Failed....");
					}
				
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBounds(39, 624, 165, 40);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 0));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Login h=new Login();
				h.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(293, 624, 165, 40);
		contentPane.add(btnBack);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pass.setBounds(167, 269, 257, 34);
		contentPane.add(pass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 0));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shubham Teke\\Desktop\\java_logo.png"));
		lblNewLabel.setBounds(469, 116, 445, 475);
		contentPane.add(lblNewLabel);
		
		
	}
}
