

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Busdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField4;
	private JTextField textField3;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busdetails frame = new Busdetails();
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
	public Busdetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 704);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUS SCHEDULE AND ROUTE MANAGEMENT SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(460, 137, 658, 51);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Driverupdate.main(new String[] {});
			}
		});
		btnBack.setForeground(Color.CYAN);
		btnBack.setBackground(Color.BLACK);
		Image img=new ImageIcon(this.getClass().getResource("/11.jpg")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.setBounds(679, 653, 128, 37);
		contentPane.add(btnBack);
	
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setBounds(679, 11, 128, 131);
		getContentPane().add(lblNewLabel_2);
		Image im1=new ImageIcon(this.getClass().getResource("/jnn logo.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(im1));
		
		JButton btnListOfDrivers = new JButton("LIST OF BUSES");
		btnListOfDrivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
					String q="Select bus_name,route_id,start_time from timings t";
					PreparedStatement p=con.prepareStatement(q);
					ResultSet rs=p.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch(Exception e)
				{
					
				}
				
				
				
			}
		});
		btnListOfDrivers.setBackground(Color.BLACK);
		btnListOfDrivers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListOfDrivers.setForeground(Color.CYAN);
		btnListOfDrivers.setBounds(650, 183, 181, 23);
		contentPane.add(btnListOfDrivers);
		Image mg=new ImageIcon(this.getClass().getResource("/edit.jpg")).getImage();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(429, 233, 658, 337);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblFname = new JLabel("BUS NAME:");
		lblFname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFname.setBounds(89, 443, 97, 23);
		contentPane.add(lblFname);
		
		
		
	
		textField_4 = new JTextField();
		textField_4.setBounds(236, 276, 109, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(196, 443, 135, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(236, 310, 109, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		JLabel lblEnterTheDriverid = new JLabel("Enter the start time:");
		lblEnterTheDriverid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterTheDriverid.setBounds(44, 272, 182, 23);
		contentPane.add(lblEnterTheDriverid);
		JLabel lblEnterTheRouteid = new JLabel("Enter the route id:");
		lblEnterTheRouteid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterTheRouteid.setBounds(44, 310, 182, 23);
		contentPane.add(lblEnterTheRouteid);


			
			
			JButton btnEdit = new JButton("UPDATE");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
					    String q="update timings set bus_name='"+textField.getText()+"' where start_time='"+textField_4.getText()+"' and route_id="+textField_3.getText();
						PreparedStatement p=con.prepareStatement(q);
						ResultSet rs=p.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						con.close();
						
					}
					
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null,"UPDATED SUCCESSFULLY");
					}	
				}
			});
			Image Img=new ImageIcon(this.getClass().getResource("/edit.jpg")).getImage();
			btnEdit.setIcon(new ImageIcon(Img));	
			btnEdit.setBackground(Color.BLACK);
			btnEdit.setForeground(Color.CYAN);
			btnEdit.setBounds(236, 532, 120, 37);
			contentPane.add(btnEdit);
			
		
			
			
		
		JButton btnGetValuesTo = new JButton("GET VALUES TO EDIT");
		btnGetValuesTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
					String q="Select bus_name from timings where start_time='"+textField_4.getText()+"'and route_id='"+textField_3.getText()+"'";
					PreparedStatement p=con.prepareStatement(q);
					ResultSet rs=p.executeQuery();
					if(rs.next())
					{
						String bn=rs.getString("BUS_NAME");
						textField.setText(bn);
						
						
					}
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			
			}
			
		});
		btnGetValuesTo.setForeground(Color.CYAN);
		btnGetValuesTo.setBackground(Color.BLACK);
		btnGetValuesTo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGetValuesTo.setBounds(44, 532, 173, 37);
		contentPane.add(btnGetValuesTo);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
					String q="Select bus_name,route_id,start_time from timings";
					PreparedStatement p=con.prepareStatement(q);
					ResultSet rs=p.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		btnRefresh.setForeground(Color.CYAN);
		btnRefresh.setBackground(Color.BLACK);
		btnRefresh.setBounds(419, 199, 120, 23);
		contentPane.add(btnRefresh);
		Image img11=new ImageIcon(this.getClass().getResource("/refresh.jpg")).getImage();
		btnRefresh.setIcon(new ImageIcon(img11));
		
		
		JLabel lblUpdateValuesHere = new JLabel("UPDATE VALUES HERE:");
		lblUpdateValuesHere.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUpdateValuesHere.setBounds(95, 375, 220, 23);
		contentPane.add(lblUpdateValuesHere);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(394, 139, 724, 459);
		textPane_1.setEditable(false);
		contentPane.add(textPane_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(31, 221, 344, 377);
		textPane.setEditable(false);
		contentPane.add(textPane);

		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setForeground(Color.CYAN);
		Image img1=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
		 lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(0, 0, 1481, 861);
	contentPane.add(lblNewLabel_1);	
	
	}
}
