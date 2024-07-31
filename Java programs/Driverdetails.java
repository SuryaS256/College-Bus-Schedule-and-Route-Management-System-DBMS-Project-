

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
class innerClass extends MouseAdapter{
	public void MouseClicked(MouseEvent e) {

		int selectedRow=Driverdetails.table.getSelectedRow();
		DefaultTableModel model=(DefaultTableModel)Driverdetails.table.getModel();
		Driverdetails.textField.setText(model.getValueAt(selectedRow, 0).toString());
		Driverdetails.textField_1.setText(model.getValueAt(selectedRow, 1).toString());
		Driverdetails.textField_2.setText(model.getValueAt(selectedRow,2).toString());
		Driverdetails.textField_3.setText(model.getValueAt(selectedRow, 3).toString());
	}
}
public class Driverdetails extends JFrame {

	private JPanel contentPane;
	static JTable table;
	public static String q,q1;

	/**
	 * Launch the application.
	 */Connection conn=null;
	static JTextField textField;
	static JTextField textField_1;
	static JTextField textField_2;
	static JTextField textField_3;
	private JTextField textField_4;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driverdetails frame = new Driverdetails();
					frame.setVisible(true);
				} catch (Exception e) {
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public Driverdetails() {
		conn=SqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1260, 893);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("BUS SCHEDULE AND ROUTE MANAGMENT SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(460, 139, 658, 51);
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
		
		JButton btnListOfDrivers = new JButton("LIST OF DRIVERS");
		btnListOfDrivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
					String q="Select driver_id,fname,lname,phone,address from driver";
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
		btnListOfDrivers.setBounds(651, 184, 181, 23);
		contentPane.add(btnListOfDrivers);
		
		JButton btnEdit = new JButton("UPDATE");
		Image mg=new ImageIcon(this.getClass().getResource("/edit.jpg")).getImage();
		btnEdit.setIcon(new ImageIcon(mg));
		
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
					String q="update driver set fname='"+textField.getText()+"',lname='"+textField_1.getText()+"',phone='"+textField_2.getText()+"',address='"+textField_3.getText()+"'where driver_id='"+textField_4.getText()+"'";
					PreparedStatement p=con.prepareStatement(q);
					ResultSet rs=p.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"UPDATED SUCCESSFULLY");
				}
			}});
		btnEdit.setBackground(Color.BLACK);
		btnEdit.setForeground(Color.CYAN);
		btnEdit.setBounds(242, 502, 120, 37);
		contentPane.add(btnEdit);
		
		textField_4 = new JTextField();
		textField_4.setBounds(236, 253, 109, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(196, 349, 135, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 383, 135, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 418, 135, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(196, 452, 135, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(460, 233, 604, 337);
		contentPane.add(scrollPane);
		
		table = new JTable();
	
		addMouseListener(new innerClass());
		scrollPane.setViewportView(table);
		
	JButton btnRefresh = new JButton("REFRESH");
	btnRefresh.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
				String q="Select driver_id,fname,lname,phone,address from driver";
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
	btnRefresh.setForeground(Color.CYAN);
	btnRefresh.setBackground(Color.BLACK);
	btnRefresh.setBounds(419, 199, 120, 23);
	contentPane.add(btnRefresh);
	Image img11=new ImageIcon(this.getClass().getResource("/refresh.jpg")).getImage();
	btnRefresh.setIcon(new ImageIcon(img11));
	
	JLabel lblFname = new JLabel("FNAME:");
	lblFname.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblFname.setBounds(89, 350, 62, 23);
	contentPane.add(lblFname);
	
	JLabel lblLname = new JLabel("LNAME:");
	lblLname.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblLname.setBounds(89, 384, 62, 23);
	contentPane.add(lblLname);
	
	JLabel lblPhone = new JLabel("PHONE:");
	lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblPhone.setBounds(89, 418, 72, 23);
	contentPane.add(lblPhone);
	
	JLabel lblAddress = new JLabel("ADDRESS:");
	lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblAddress.setBounds(89, 452, 82, 23);
	contentPane.add(lblAddress);
	
	
	
	
JLabel lblEnterTheDriverid = new JLabel("Enter the Driver_id:");
lblEnterTheDriverid.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblEnterTheDriverid.setBounds(56, 253, 182, 23);
contentPane.add(lblEnterTheDriverid);


	JTextPane textPane_1 = new JTextPane();
	textPane_1.setBounds(394, 139, 724, 459);
	textPane_1.setEditable(false);
	contentPane.add(textPane_1);
	
	
	
	JLabel lblUpdateValuesHere = new JLabel("UPDATE VALUES HERE: ");
	lblUpdateValuesHere.setFont(new Font("Tahoma", Font.PLAIN, 22));
	lblUpdateValuesHere.setBounds(89, 303, 254, 23);
	contentPane.add(lblUpdateValuesHere);
	
	JButton btnNewButton = new JButton("GET VALUES TO EDIT");
	btnNewButton.setForeground(Color.CYAN);
	btnNewButton.setBackground(Color.BLACK);
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
				String q="Select fname,lname,phone,address from driver where driver_id='"+textField_4.getText()+"'";
				PreparedStatement p=con.prepareStatement(q);
				ResultSet rs=p.executeQuery();
				if(rs.next())
				{
					String fn=rs.getString("FNAME");
					textField.setText(fn);
					String ln=rs.getString("LNAME");
					textField_1.setText(ln);
					String ph=rs.getString("PHONE");
					textField_2.setText(ph);
					String address=rs.getString("ADDRESS");
					textField_3.setText(address);
				}
				con.close();
			}
			catch(Exception e)
			{
				
			}
		}
	});
	btnNewButton.setBounds(62, 502, 154, 37);
	contentPane.add(btnNewButton);
	Image img1=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
	
	JTextPane textPane = new JTextPane();
	
	textPane.setBounds(44, 233, 329, 365);
	textPane.setEditable(false);
	contentPane.add(textPane);
	
	
	JLabel lblNewLabel_1 = new JLabel(" ");
	lblNewLabel_1.setForeground(Color.CYAN);
	Image img14=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
	 lblNewLabel_1.setIcon(new ImageIcon(img14));
	lblNewLabel_1.setBounds(0, 0, 1481, 861);
contentPane.add(lblNewLabel_1);	
	
	
}}
