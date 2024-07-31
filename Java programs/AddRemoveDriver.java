import java.awt.Color;
import java.math.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddRemoveDriver {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static String val1,val2,val3,val5;
	public static int val4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRemoveDriver window = new AddRemoveDriver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection conn=null;
	/**
	 * Create the application.
	 */
	public AddRemoveDriver() {
		initialize();
		conn=SqlConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1075, 703);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JLabel label = new JLabel(" ");
		label.setBounds(602,0,95,120);
		Image img1=new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		frame.getContentPane().setLayout(null);
		label.setIcon(new ImageIcon(img1));
		frame.getContentPane().add(label);
		
		JLabel lblBusScheduleAnd = new JLabel("BUS SCHEDULE AND ROUTE MANAGEMENT SYSTEM");
		lblBusScheduleAnd.setForeground(Color.BLUE);
		lblBusScheduleAnd.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBusScheduleAnd.setBounds(376, 145, 621, 31);
		frame.getContentPane().add(lblBusScheduleAnd);
		
		JLabel lblDriverId = new JLabel("DRIVER ID:");
		lblDriverId.setForeground(new Color(255, 51, 0));
		lblDriverId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDriverId.setBounds(481, 252, 125, 25);
		frame.getContentPane().add(lblDriverId);
		
		JLabel lblDriverName = new JLabel("FNAME:");
		lblDriverName.setForeground(new Color(255, 51, 0));
		lblDriverName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDriverName.setBounds(481, 296, 153, 19);
		frame.getContentPane().add(lblDriverName);
		
		JLabel lblDriverDetails = new JLabel("DRIVER DETAILS");
		lblDriverDetails.setForeground(Color.BLUE);
		lblDriverDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDriverDetails.setBounds(580, 186, 174, 25);
		frame.getContentPane().add(lblDriverDetails);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER:");
		lblPhoneNumber.setForeground(new Color(255, 51, 0));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPhoneNumber.setBounds(481, 367, 174, 19);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblAddress = new JLabel("ADDRESS:");
		lblAddress.setForeground(new Color(255, 51, 0));
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(481, 403, 112, 19);
		frame.getContentPane().add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(709, 256, 134, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(709, 297, 134, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(709, 368, 134, 25);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(709, 404, 134, 25);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblLname = new JLabel("LNAME:");
		lblLname.setForeground(new Color(255, 51, 0));
		lblLname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLname.setBounds(481, 331, 86, 25);
		frame.getContentPane().add(lblLname);
		
		textField_4 = new JTextField();
		textField_4.setBounds(709, 333, 134, 24);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Driverupdate.main(new String[] {});
			}
		});
		btnBack.setForeground(Color.CYAN);
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(363, 484, 125, 31);
		Image img5=new ImageIcon(this.getClass().getResource("/11.jpg")).getImage();
		btnBack.setIcon(new ImageIcon(img5));
		frame.getContentPane().add(btnBack);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty()&&textField_1.getText().isEmpty()&&textField_4.getText().isEmpty()&&textField_2.getText().isEmpty()&&textField_3.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null,"FILL ALL THE FIELDS");
				}
				else{try {
					
					String q="insert into driver values(?,?,?,?,?)";
					
					PreparedStatement p=conn.prepareStatement(q);
					p.setString(1,textField.getText());
					p.setString(2,textField_1.getText());
					p.setString(3,textField_4.getText());
					p.setDouble(4,Double.parseDouble(textField_2.getText()));
					
					
					p.setString(5,textField_3.getText());
					
					p.execute();
					JOptionPane.showMessageDialog(null,"INSERTED SUCCESSFULLY ");
					frame.repaint();
					
				
				}				catch(Exception e)
				{ 
					
						e.printStackTrace();
					}
				}

			}	
		});
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setForeground(Color.CYAN);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(602, 484, 134, 31);
		Image img4=new ImageIcon(this.getClass().getResource("/add user.jpg")).getImage();
		btnAdd.setIcon(new ImageIcon(img4));
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("REMOVE");
		Image img6=new ImageIcon(this.getClass().getResource("/remove.jpg")).getImage();
		btnRemove.setIcon(new ImageIcon(img6));
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					String q="delete from driver where driver_id=? and fname=? and lname=? and phone=? and address=?";
					
					PreparedStatement p=conn.prepareStatement(q);
					p.setString(1,textField.getText());
					p.setString(2,textField_1.getText());
					p.setString(3,textField_4.getText());
					p.setDouble(4,Double.parseDouble(textField_2.getText()));
					p.setString(5,textField_3.getText());
					
					p.execute();
					JOptionPane.showMessageDialog(null,"DELETED SUCCESSFULLY ");
					p.close();
				
				}				
                 catch(Exception e)
				{ 
					if(textField.getText().isEmpty()&&textField_1.getText().isEmpty()&&textField_4.getText().isEmpty()&&textField_2.getText().isEmpty()&&textField_3.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null,"FILL ALL THE FIELDS");
					}
				

					
				}
			}	
				
			
		});
		btnRemove.setForeground(Color.CYAN);
		btnRemove.setBackground(Color.BLACK);
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemove.setBounds(856, 484, 153, 31);
		
		frame.getContentPane().add(btnRemove);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(265, 128, 888, 525);
		frame.getContentPane().add(textPane);	
		
	
	
	
	JLabel lblNewLabel_1 = new JLabel(" ");
	lblNewLabel_1.setForeground(Color.CYAN);
	Image ig1=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
	 lblNewLabel_1.setIcon(new ImageIcon(ig1));
	lblNewLabel_1.setBounds(0, -14, 1481, 861);
frame.getContentPane().add(lblNewLabel_1);
	}

}
