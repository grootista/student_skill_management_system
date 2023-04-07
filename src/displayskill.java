import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class displayskill extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayskill frame = new displayskill();
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
	public displayskill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultTableModel tableModel = new DefaultTableModel();
	    tableModel.addColumn("Name");
	    tableModel.addColumn("Email");
	    tableModel.addColumn("Phone");
		
		JLabel lblNewLabel = new JLabel("Details of Students who have  "+searchonskill.sl+"  skills: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(27, 11, 362, 29);
		contentPane.add(lblNewLabel);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/skillmanagementdatabase";
			String username = "root";
			String pass = "444888";
			Connection con= DriverManager.getConnection(url,username,pass);
			Statement smt=con.createStatement();
			
			String query="SELECT studentname, email, phone "
					+ "FROM userdetails  "
					+ "INNER JOIN skills s ON userdetails.usn = s.usn "
					+ "WHERE s.skill = '"+searchonskill.sl+"'";
					
			ResultSet rs=smt.executeQuery(query);
			 while (rs.next()) {
		            String name = rs.getString("studentname");
		            String email = rs.getString("email");
		            String phone = rs.getString("phone");

		            Object[] row = { name, email, phone };
		            tableModel.addRow(row);
		        }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 63, 397, 187);
		contentPane.add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 saveToPDF();
			}
		});
		btnNewButton.setBounds(171, 271, 89, 23);
		contentPane.add(btnNewButton);
	}
	private void saveToPDF() {
	    try {
	        // Create a new PDF document
	        Document document = new Document();
	        PdfWriter.getInstance(document, new FileOutputStream("student_details.pdf"));
	        document.open();
	        
	        // Add a title to the document
	        Paragraph title = new Paragraph("Student Details");
	        title.setAlignment(Element.ALIGN_CENTER);
	        document.add(title);
	        
	        // Add the table to the document
	        PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
	        // Add the column names to the table
	        for (int i = 0; i < table.getColumnCount(); i++) {
	            pdfTable.addCell(table.getColumnName(i));
	        }
	        // Add the table data to the table
	        for (int i = 0; i < table.getRowCount(); i++) {
	            for (int j = 0; j < table.getColumnCount(); j++) {
	                pdfTable.addCell(table.getValueAt(i, j).toString());
	            }
	        }
	        document.add(pdfTable);
	        
	        document.close();
	        JOptionPane.showMessageDialog(this, "PDF file saved successfully.");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Error saving PDF file: " + e.getMessage());
	    }
	}


}
