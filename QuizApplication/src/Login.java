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
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user1;
	private JPasswordField pass1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1136, 735);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		user1 = new JTextField();
		user1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		user1.setBounds(206, 245, 291, 41);
	    contentPane.add(user1);
		user1.setColumns(10);
		
		JLabel user = new JLabel("UserName");
		user.setForeground(new Color(255, 255, 0));
		user.setFont(new Font("Tahoma", Font.BOLD, 24));
		user.setBounds(27, 245, 143, 40);
		contentPane.add(user);
		
		JLabel pass = new JLabel("Password");
		pass.setForeground(new Color(255, 255, 0));
		pass.setFont(new Font("Tahoma", Font.BOLD, 24));
		pass.setBounds(27, 309, 143, 40);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Shubham Teke\\Desktop\\Alarm-Tick-icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/RIT", "root", "Dipali@45");
					PreparedStatement ps= conn.prepareStatement("select username, password from User where username=? and password=?");
					ps.setString(1, user1.getText());
					ps.setString(2, pass1.getText());
				
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
                        dispose();
                        Quiz quiz=new Quiz();
                        
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBounds(274, 386, 176, 50);
		contentPane.add(btnNewButton);
		
		pass1 = new JPasswordField();
		pass1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pass1.setBounds(206, 315, 291, 41);
		contentPane.add(pass1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shubham Teke\\Desktop\\JAVA.png"));
		lblNewLabel.setBounds(560, 97, 537, 545);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Don't have an account ? then click the Register button");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 485, 394, 13);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				reg r=new reg();
				r.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(404, 479, 93, 27);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel_2.setBounds(264, 139, 131, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Do you want to delete your account ?");
		lblNewLabel_1_1.setForeground(Color.YELLOW);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 549, 291, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Delete d=new Delete();
				d.setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(291, 543, 93, 27);
		contentPane.add(btnNewButton_1_1);
	}
}
