import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LOBOut {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOBOut window = new LOBOut();
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
	public LOBOut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 925, 780);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnListOfBuses = new JButton("LIST OF BUSES");
		btnListOfBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
					String q="Select b.bus_name,r.route_name from bus b,route1 r where b.route_id=r.route_id";
					PreparedStatement p=con.prepareStatement(q);
					ResultSet rs=p.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					p.close();
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
		});
		btnListOfBuses.setBackground(Color.BLACK);
		btnListOfBuses.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListOfBuses.setForeground(Color.CYAN);
		btnListOfBuses.setBounds(651, 184, 181, 23);
		frame.getContentPane().add(btnListOfBuses);
		
		JButton btnOK = new JButton("OK");
		
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchBus.main(new String[] {});
			}
		});
		btnOK.setBackground(Color.BLACK);
		btnOK.setForeground(Color.CYAN);
		btnOK.setBounds(696, 596, 93, 37);
		frame.getContentPane().add(btnOK);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(460, 233, 604, 337);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(397, 139, 731, 503);
		frame.getContentPane().add(textPane);	
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setForeground(Color.CYAN);
		Image img1=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
		 lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(0, 0, 1481, 861);
	frame.getContentPane().add(lblNewLabel_1);	
		

	}

}
