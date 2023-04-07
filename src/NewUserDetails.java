import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

public class NewUserDetails extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterTheBelow;
	private JTextField sname;
	private JTextField branch;
	private JTextField phone;
	private JTextField email;
	private JTextField sem;
	private JLabel lblNewLabel_5;
	private JTextField us;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserDetails frame = new NewUserDetails();
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
	public NewUserDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterTheBelow = new JTextField();
		txtEnterTheBelow.setBackground(new Color(128, 128, 192));
		txtEnterTheBelow.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txtEnterTheBelow.setBounds(115, 11, 277, 20);
		txtEnterTheBelow.setText("           Enter the below details.");
		contentPane.add(txtEnterTheBelow);
		txtEnterTheBelow.setColumns(10);
		
		sname = new JTextField();
		sname.setBounds(34, 81, 211, 20);
		contentPane.add(sname);
		sname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student Name:");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.ITALIC, 18));
		lblNewLabel.setBounds(34, 58, 128, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sem:");
		lblNewLabel_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(34, 112, 128, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Branch:");
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(34, 168, 138, 14);
		contentPane.add(lblNewLabel_2);
		
		branch = new JTextField();
		branch.setBounds(31, 193, 214, 20);
		contentPane.add(branch);
		branch.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Phone:");
		lblNewLabel_3.setForeground(new Color(47, 79, 79));
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.ITALIC, 18));
		lblNewLabel_3.setBounds(34, 224, 128, 14);
		contentPane.add(lblNewLabel_3);
		
		phone = new JTextField();
		phone.setBounds(31, 248, 141, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setForeground(new Color(47, 79, 79));
		lblNewLabel_4.setFont(new Font("Tw Cen MT", Font.ITALIC, 18));
		lblNewLabel_4.setBounds(34, 285, 128, 14);
		contentPane.add(lblNewLabel_4);
		
		email = new JTextField();
		email.setBounds(31, 310, 214, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost/skillmanagementdatabase";
					String username = "root";
					String pass = "444888";
					Connection con=DriverManager.getConnection(url,username,pass);
					Statement smt=con.createStatement();
					String name=sname.getText();
					int seme=Integer.parseInt(sem.getText());
					String bch=branch.getText();
				    long  num=Long.parseLong(phone.getText());
					String em=email.getText().toLowerCase();
					String usn=newuser.usn;
					smt.executeUpdate("insert into userdetails values('"+name+"','"+seme+"','"+bch+"','"+num+"','"+em+"','"+usn+"') ");
					System.out.println("added");
					SKILLS S= new SKILLS();
					S.setVisible(true);
					
					con.close();
					smt.close();
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(209, 422, 89, 23);
		contentPane.add(btnNewButton);
		
		sem = new JTextField();
		sem.setBounds(34, 137, 86, 20);
		contentPane.add(sem);
		sem.setColumns(10);
		
		lblNewLabel_5 = new JLabel("USN:");
		lblNewLabel_5.setForeground(new Color(47, 79, 79));
		lblNewLabel_5.setFont(new Font("Tw Cen MT", Font.ITALIC, 18));
		lblNewLabel_5.setBounds(34, 343, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		us = new JTextField();
		us.setBounds(31, 368, 118, 20);
		contentPane.add(us);
		us.setColumns(10);
	}
}
