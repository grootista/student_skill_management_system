import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;

public class newuser extends JFrame {

	private JPanel contentPane;
	public static  String usn;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newuser frame = new newuser();
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
	public newuser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student USN(chars in capital):");
		lblNewLabel.setFont(new Font("STXihei", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(42, 21, 303, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(42, 52, 266, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Set Password:");
		lblNewLabel_1.setFont(new Font("STXihei", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(42, 104, 151, 23);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(42, 138, 266, 32);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/skillmanagementdatabase";
					String username = "root";
					String pass = "444888";
					Connection con=DriverManager.getConnection(url,username,pass);
					Statement smt=con.createStatement();
				    usn=textField.getText();
					System.out.println(usn);
					String Password=passwordField.getText();
				    String sql="select * from logincredentials where USN='"+usn+"'  ";
				    ResultSet rs=smt.executeQuery(sql);
				    if(rs.next())
				    {
				    	JOptionPane.showMessageDialog(null,"User already exist....!");
				    }
				    else
				    {
				    	smt.executeUpdate("insert into logincredentials values('"+usn+"','"+Password+"') ");
//						JOptionPane.showMessageDialog(null,"Registered successfully...!");
				    	NewUserDetails nw = new NewUserDetails();
				    	nw.setVisible(true);
					
						System.out.println("added");
						
				    }
				con.close();
				smt.close();
					
					
					}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(151, 201, 102, 32);
		contentPane.add(btnNewButton);
	}
}
