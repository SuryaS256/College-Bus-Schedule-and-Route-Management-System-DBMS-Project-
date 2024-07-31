import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddRemoveBus {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRemoveBus window = new AddRemoveBus();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} 
		});
	}
   Connection conn=null;
   private JTextField textField_6;
	/**
	 * Create the application.
	 */
	public AddRemoveBus() {
		initialize();
		conn=SqlConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1082, 706);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);
		
		JLabel label = new JLabel(" ");
		label.setBounds(601,11,95,120);
		Image img1=new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		frame.getContentPane().setLayout(null);
		label.setIcon(new ImageIcon(img1));
		frame.getContentPane().add(label);
		
		JLabel lblBusScheduleAnd = new JLabel("BUS SCHEDULE AND ROUTE MANAGEMENT SYSTEM");
		lblBusScheduleAnd.setForeground(Color.BLUE);
		lblBusScheduleAnd.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBusScheduleAnd.setBounds(373, 159, 621, 31);
		frame.getContentPane().add(lblBusScheduleAnd);
		
		JLabel lblBusDetails = new JLabel("BUS DETAILS");
		lblBusDetails.setForeground(Color.BLUE);
		lblBusDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBusDetails.setBounds(601, 231, 142, 25);
		frame.getContentPane().add(lblBusDetails);
		
		JLabel lblVehicleNumber = new JLabel("VEHICLE NUMBER:");
		lblVehicleNumber.setForeground(new Color(255, 51, 0));
		lblVehicleNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblVehicleNumber.setBounds(547, 341, 195, 19);
		frame.getContentPane().add(lblVehicleNumber);
		
		JLabel lblBusName = new JLabel("BUS NAME:");
		lblBusName.setForeground(new Color(255, 51, 0));
		lblBusName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBusName.setBounds(547, 371, 133, 19);
		frame.getContentPane().add(lblBusName);
		
		JLabel lblCapacity = new JLabel("CAPACITY:");
		lblCapacity.setForeground(new Color(255, 51, 0));
		lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCapacity.setBounds(547, 400, 109, 19);
		frame.getContentPane().add(lblCapacity);
		
		JLabel lblDriverId = new JLabel("DRIVER ID:");
		lblDriverId.setForeground(new Color(255, 51, 0));
		lblDriverId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDriverId.setBounds(547, 430, 136, 25);
		frame.getContentPane().add(lblDriverId);
		
		JLabel lblRouteId = new JLabel("ROUTE ID:");
		lblRouteId.setForeground(new Color(255, 51, 0));
		lblRouteId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRouteId.setBounds(547, 466, 132, 19);
		frame.getContentPane().add(lblRouteId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(736, 374, 142, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(736, 341, 142, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(736, 405, 142, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(736, 436, 142, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(736, 469, 142, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Driverupdate.main(new String[] {});
			}
		});
		btnBack.setBackground(Color.BLACK);
		btnBack.setForeground(Color.CYAN);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(330, 512, 133, 31);
		Image img5=new ImageIcon(this.getClass().getResource("/11.jpg")).getImage();
		btnBack.setIcon(new ImageIcon(img5));
		frame.getContentPane().add(btnBack);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	try {
					
					String q="insert into bus values(?,?,?,?,?)";
					
					PreparedStatement p=conn.prepareStatement(q);
					p.setString(1,textField_3.getText());
					p.setString(2,textField_2.getText());
					p.setInt(3,Integer.parseInt(textField_4.getText()));
					p.setString(4,textField_5.getText());
					p.setInt(5,Integer.parseInt(textField_6.getText()));
					
					p.execute();
					JOptionPane.showMessageDialog(null,"INSERTED SUCCESSFULLY");
					p.close();
				
				}				catch(Exception e)
				{ 
					
	                     e.printStackTrace();
	                    
	 						JOptionPane.showMessageDialog(null,"NO OF SEATS ENTERED IS NOT PROPER");
	 					
				}

			}	
			
		});
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setForeground(Color.CYAN);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(626, 512, 125, 31);
		Image img4=new ImageIcon(this.getClass().getResource("/add user.jpg")).getImage();
		btnAdd.setIcon(new ImageIcon(img4));
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("REMOVE");
		Image img6=new ImageIcon(this.getClass().getResource("/remove.jpg")).getImage();
		btnRemove.setIcon(new ImageIcon(img6));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					String q="delete from bus where vehicle_no=? and bus_name=? and capacity=? and driver_id=?and route_id=?";
					
					PreparedStatement p=conn.prepareStatement(q);
					p.setString(1,textField_3.getText());
					p.setString(2,textField_2.getText());
					p.setLong(3,Integer.parseInt(textField_4.getText()));
				
					p.setString(4,textField_5.getText());
					p.setLong(5,Integer.parseInt(textField_6.getText()));
					p.execute();
					JOptionPane.showMessageDialog(null,"DELETED SUCCESSFULLY ");
					p.close();
				
				}				
                 catch(Exception e)
				{ 
					if(textField_3.getText().isEmpty()&&textField_2.getText().isEmpty()&&textField_4.getText().isEmpty()&&textField_5.getText().isEmpty()&&textField_6.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null,"FILL ALL THE FIELDS");
					}
				

					
				
				}
			}	
			
		});
		
		
		btnRemove.setBackground(Color.BLACK);
		btnRemove.setForeground(Color.CYAN);
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemove.setBounds(880, 512, 150, 31);
		frame.getContentPane().add(btnRemove);
		Image ig6=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
	

	
	JTextPane textPane = new JTextPane();
	textPane.setEditable(false);
	textPane.setBounds(310, 131, 735, 495);
	frame.getContentPane().add(textPane);	
		
	
	JLabel lblNewLabel_1 = new JLabel(" ");
	lblNewLabel_1.setForeground(Color.CYAN);
	Image img13=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
	 lblNewLabel_1.setIcon(new ImageIcon(img13));
	lblNewLabel_1.setBounds(0, 0, 1481, 861);
frame.getContentPane().add(lblNewLabel_1);	

	}
}
