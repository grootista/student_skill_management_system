import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class skillupdate extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton nskill;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					skillupdate frame = new skillupdate();
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
	public skillupdate() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 507, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Current Skills:");
		lblNewLabel.setBackground(new Color(102, 205, 170));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel.setBounds(20, 29, 161, 26);
		contentPane.add(lblNewLabel);
		
		
		String[] columns= {"skills"};
		DefaultTableModel model= new DefaultTableModel(columns,0);
		table = new JTable(model);
		table.setBounds(20, 66, 138, 176);
		JScrollPane sc=new JScrollPane(table);
		sc.setBounds(20, 66, 138, 176);
		contentPane.add(sc);
		
		nskill = new JButton("Add New Skills");
		nskill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldskillupdate s= new oldskillupdate();
				s.setVisible(true);
			}
		});
		nskill.setBounds(266, 69, 145, 33);
		contentPane.add(nskill);
		
		btnNewButton = new JButton("Delete skill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setBounds(266, 135, 145, 33);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(266, 199, 145, 33);
		contentPane.add(btnNewButton_1);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/skillmanagementdatabase";
			String username = "root";
			String pass = "444888";
			Connection con= DriverManager.getConnection(url,username,pass);
			Statement smt=con.createStatement();
			String usn=EXISTINGUSERLOGIN.uusn;
			String query="select skill from skills where usn='"+usn+"'  ";
			ResultSet rs=smt.executeQuery(query);
			while(rs.next())
			{
				String skill=rs.getString("skill");
				model.addRow(new Object[]{skill});
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
}
