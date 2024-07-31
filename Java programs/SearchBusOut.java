import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import net.proteanit.sql.DbUtils;
import java.awt.ScrollPane;
import javax.swing.JTextField;

public class SearchBusOut {

	private JFrame frame;
	public static PreparedStatement p;
	private JTable table;
	private JTextField textField;
	Connection cn=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBusOut window = new SearchBusOut();
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
	public SearchBusOut() {
		initialize();
		conn=SqlConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1174, 740);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
frame.getContentPane().setLayout(null);
		
		JButton btnListOfBuses = new JButton("click to see the OUTPUT");
		btnListOfBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.println(SearchBus.t);
					System.out.println(SearchBus.bs);

					String q="SELECT T.BUS_NAME,R1.ROUTE_NAME FROM TIMINGS T,ROUTE1 R1,ROUTE R,STOPS S WHERE T.START_TIME='"+SearchBus.t+"' AND T.ROUTE_ID=R1.ROUTE_ID AND R.ROUTE_ID=R1.ROUTE_ID AND R.STOP_ID=S.STOP_ID AND S.STOP_NAME='"+SearchBus.bs+"'";		 
							System.out.println(q);
					PreparedStatement p=conn.prepareStatement(q);
					
					ResultSet rs=p.executeQuery();
					//System.out.println(rs.next());
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
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
		btnListOfBuses.setBounds(651, 184, 251, 23);
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
