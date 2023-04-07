import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                 SELECT USER TYPE");
		lblNewLabel.setFont(new Font("STZhongsong", Font.ITALIC, 20));
		lblNewLabel.setBounds(0, 39, 434, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New Student Registration");
		btnNewButton.setBounds(96, 90, 217, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				newuser n= new newuser();
				n.setVisible(true);
			}
				});
		
		JButton btnNewButton_1 = new JButton("Existing Student Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EXISTINGUSERLOGIN EU= new EXISTINGUSERLOGIN();
				EU.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(96, 137, 217, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Club Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				club cl= new club();
				cl.setVisible(true);
			}
			
		});
		btnNewButton_2.setBounds(96, 183, 217, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Admin");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminpage ad=new adminpage();
				ad.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(339, 0, 95, 28);
		frame.getContentPane().add(btnNewButton_3);
	}

}
