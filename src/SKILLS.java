import java.awt.EventQueue;

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

public class SKILLS extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SKILLS frame = new SKILLS();
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
   
	public SKILLS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("     Enter your skills....!");
		lblNewLabel.setBounds(69, 10, 296, 33);
		lblNewLabel.setFont(new Font("Verdana", Font.ITALIC, 22));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(146, 64, 131, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add New Skill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SKILLS S= new SKILLS();
				S.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(43, 168, 137, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Skills added successfully!");
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(225, 168, 121, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add this skill");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/skillmanagementdatabase";
					String username = "root";
					String pass = "******";
					Connection con= DriverManager.getConnection(url,username,pass);
					Statement smt=con.createStatement();
					String skill=textField.getText();
					String usn=newuser.usn;
					smt.executeUpdate("insert into skills values('"+usn+"','"+skill+"')");
					JOptionPane.showMessageDialog(null,"Skill added!");
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
		btnNewButton_2.setBounds(156, 112, 109, 23);
		contentPane.add(btnNewButton_2);
	}

}
