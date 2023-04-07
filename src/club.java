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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class club extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static int  cid;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					club frame = new club();
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
	public club() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Club ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(32, 65, 137, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(32, 129, 137, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(179, 65, 108, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/skillmanagementdatabase";
					String username = "root";
					String pass = "444888";
					Connection con= DriverManager.getConnection(url,username,pass);
					Statement smt=con.createStatement();
				    cid=Integer.parseInt(textField.getText());
					String passs=passwordField.getText();
					if(passs==null)
					{
						JOptionPane.showMessageDialog(null,"Please Enter Password");
					}
					String chk="select *from club where clubid=?";
					PreparedStatement pst=con.prepareStatement(chk);
					pst.setInt(1, cid);
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
						String password= rs.getString("Password");
						if(passs.equals(password))
						{
							JOptionPane.showMessageDialog(null,"logged in successfully!");
							searchonskill sk = new searchonskill();
							sk.setVisible(true);
							
							
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
		
		btnNewButton.setBounds(189, 178, 89, 23);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(179, 129, 108, 27);
		contentPane.add(passwordField);
	}

}
