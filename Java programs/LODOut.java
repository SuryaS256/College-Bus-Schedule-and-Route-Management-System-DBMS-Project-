import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class LODOut {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LODOut window = new LODOut();
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
	public LODOut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnListOfDrivers = new JButton("LIST OF DRIVERS");
		btnListOfDrivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","spoorthi");
					String q="Select fname,lname,phone from driver";
					PreparedStatement p=con.prepareStatement(q);
					ResultSet rs=p.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
					p.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
			}
		});
		btnListOfDrivers.setBackground(Color.BLACK);
		btnListOfDrivers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListOfDrivers.setForeground(Color.CYAN);
		btnListOfDrivers.setBounds(651, 184, 181, 23);
		frame.getContentPane().add(btnListOfDrivers);
		
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
