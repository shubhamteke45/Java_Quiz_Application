import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField user2;
	private JPasswordField pass2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Delete Account");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("DejaVu Sans", Font.BOLD, 40));
		lblNewLabel.setBounds(176, 73, 360, 39);
		contentPane.add(lblNewLabel);
		
		user2 = new JTextField();
		user2.setBounds(237, 189, 298, 39);
		contentPane.add(user2);
		user2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(102, 189, 125, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(102, 273, 125, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RIT", "root", "Dipali@45");
					PreparedStatement ps= conn.prepareStatement("delete from User where username=? and password=?");
					ps.setString(1, user2.getText());
					ps.setString(2, pass2.getText());
					//ResultSet rs = ps.executeQuery();
					ps.execute();
					JOptionPane.showConfirmDialog(null, "Do you really want to Delete?");
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBounds(162, 353, 137, 54);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setForeground(new Color(255, 255, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login h=new Login();
				h.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(428, 353, 137, 54);
		contentPane.add(btnBack);
		
		pass2 = new JPasswordField();
		pass2.setBounds(237, 273, 299, 39);
		contentPane.add(pass2);
	}

}
