import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JPasswordField;

public class EXISTINGUSERLOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	static String uusn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EXISTINGUSERLOGIN frame = new EXISTINGUSERLOGIN();
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
	public EXISTINGUSERLOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("USN:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(109, 52, 69, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(54, 118, 124, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(207, 52, 139, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton =  new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/skillmanagementdatabase";
					String username = "root";
					String pass = "444888";
					Connection con= DriverManager.getConnection(url,username,pass);
					Statement smt=con.createStatement();
				    uusn=textField.getText();
					String passs=passwordField.getText();
					if(passs==null)
					{
						JOptionPane.showMessageDialog(null,"Please Enter Password");
					}
					String chk="select *from logincredentials where usn=?";
					PreparedStatement pst=con.prepareStatement(chk);
					pst.setString(1, uusn);
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
						String password= rs.getString("Password");
						if(passs.equals(password))
						{
							JOptionPane.showMessageDialog(null,"logged in successfully!");
							skillupdate su= new skillupdate();
							
							su.setVisible(true);
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid Password","Login Error",JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"User not Found","Login Error",JOptionPane.ERROR_MESSAGE);
					}
					con.close();
					smt.close();
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(230, 175, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(207, 118, 139, 26);
		contentPane.add(passwordField);
	}
}
