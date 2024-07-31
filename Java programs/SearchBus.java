import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JToolBar;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBus {

	private JFrame frame;
	public static String t;
	public static String bs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBus window = new SearchBus();
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
	public SearchBus() {
		initialize();
		conn=SqlConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1319, 725);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel(" ");
		label.setBounds(601,0,94,129);
		Image img1=new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		label.setIcon(new ImageIcon(img1));
		frame.getContentPane().add(label);
		
		JLabel lblBusScheduleAnd = new JLabel("BUS SCHEDULE AND ROUTE MANAGEMENT SYSTEM");
		lblBusScheduleAnd.setForeground(new Color(0, 0, 153));
		lblBusScheduleAnd.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBusScheduleAnd.setBounds(374, 182, 621, 25);
		frame.getContentPane().add(lblBusScheduleAnd);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(Color.CYAN);
		toolBar.setBackground(Color.DARK_GRAY);
		toolBar.setBounds(421, 256, 554, 24);
		frame.getContentPane().add(toolBar);
		
		JButton btnListOfBuses = new JButton("        LIST OF BUSES");
		btnListOfBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LOBOut.main(new String[] {});
			}
		});
		btnListOfBuses.setFont(new Font("Tahoma", Font.BOLD, 16));
		toolBar.add(btnListOfBuses);
		btnListOfBuses.setBackground(Color.DARK_GRAY);
		btnListOfBuses.setForeground(Color.CYAN);
		
		JButton btnListOfDrivers = new JButton("     LIST OF DRIVERS");
		btnListOfDrivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LODOut.main(new String[] {});
			}
		});
		btnListOfDrivers.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnListOfDrivers.setForeground(Color.CYAN);
		btnListOfDrivers.setBackground(Color.DARK_GRAY);
		toolBar.add(btnListOfDrivers);
		
		
		
		JLabel lblTimings = new JLabel("TIMINGS:");
		lblTimings.setForeground(new Color(255, 51, 0));
		lblTimings.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTimings.setBounds(504, 338, 113, 25);
		frame.getContentPane().add(lblTimings);
		
		JLabel lblBusStop = new JLabel("BUS STOP:");
		lblBusStop.setForeground(new Color(255, 51, 0));
		lblBusStop.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBusStop.setBounds(504, 374, 113, 25);
		frame.getContentPane().add(lblBusStop);
		
		
	
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage.main(new String[] {});
			}
		});
		btnLogout.setBackground(Color.BLACK);
		btnLogout.setForeground(Color.CYAN);
		btnLogout.setBounds(890, 218, 125, 27);
		frame.getContentPane().add(btnLogout);
		Image img7=new ImageIcon(this.getClass().getResource("/logout.jpg")).getImage();
		btnLogout.setIcon(new ImageIcon(img7));
		
	
	 JComboBox comboBox = new JComboBox();
	comboBox.setBounds(667, 344, 162, 20);
	comboBox.addItem("7:00 a.m");
	comboBox.addItem("7:55 a.m");
	comboBox.addItem("10:15 a.m");
	comboBox.addItem("12:45 p.m");
	comboBox.addItem("1:45 p.m");
	comboBox.addItem("5:30 p.m");
	comboBox.setSelectedItem(null);
	frame.getContentPane().add(comboBox);
	
	JComboBox comboBox_1 = new JComboBox();
	comboBox_1.setBounds(667, 380, 162, 20);
	comboBox_1.addItem("SAHYADRI COLLEGE");
	comboBox_1.addItem("SANDAL COLONY");
	comboBox_1.addItem("GANESH BHAVAN");
	comboBox_1.addItem("HOLE BUS STOP");
	comboBox_1.addItem("S.R.CIRCLE");
	comboBox_1.addItem("K.E.B. CIRCLE");
	comboBox_1.addItem("TANK MOHALLA");
	comboBox_1.addItem("MAHAVEER CIRCLE");
	comboBox_1.addItem("SHIVMURTHY CIRCLE");
	comboBox_1.addItem("KAMALA NURSING HOME");
	comboBox_1.addItem("USHA NURSING HOME");
	comboBox_1.addItem("L.B.S.NAGAR");
	comboBox_1.addItem("NAVALE");
	comboBox_1.addItem("JNNCE");
	comboBox_1.addItem("MARI GADDIGE");
	comboBox_1.addItem("POLICE STATION");
	comboBox_1.addItem("KRISHNA CAFE");
	comboBox_1.addItem("S.N.MARKET");
	comboBox_1.addItem("GOPI CIRCLE");
	comboBox_1.addItem("SHIMOGA OPTICALS(J.P.N ROAD)");
	comboBox_1.addItem("JYOTHI GARDEN");
	comboBox_1.addItem("JAIL CIRCLE");
	comboBox_1.addItem("KARNATAKA SANGHA");
	comboBox_1.addItem("GAJNUR");
	comboBox_1.addItem("TVS SHOWROOM");
	comboBox_1.addItem("TEMPO STAND");
	comboBox_1.addItem("BUS STAND");
	comboBox_1.addItem("MC GANN HOSPITAL");
	comboBox_1.addItem("CIRCUIT HOUSE CIRCLE");
	comboBox_1.addItem("ADICHUNCHANGIRI PETROL BUNK");
	comboBox_1.addItem("SHARAVATHI NAGAR");
	comboBox_1.addItem("60 FEET ROAD");
	comboBox_1.addItem("AUTOSTAND");
	comboBox_1.addItem("LAKSHMI TALKIES");
	comboBox_1.addItem("NIRMALA NURSING HOME");
	comboBox_1.addItem("GANDHI NAGAR");
	comboBox_1.addItem("PURDAL");
	comboBox_1.addItem("GOPALA BUS STAND");
	comboBox_1.addItem("DROWPADAMMA CIRCLE");
	comboBox_1.addItem("NETHAJI CIRCLE");
	comboBox_1.addItem("KUVEMPU ROAD");
	comboBox_1.addItem("IT OFFICE");
	comboBox_1.addItem("GOOD LUCK CIRCLE");
	comboBox_1.addItem("LAGAAN");
	comboBox_1.addItem("ALKOLA");
	comboBox_1.addItem("KATTESUBBANNA");
	comboBox_1.addItem("RMC(BACK GATE)");
	comboBox_1.addItem("SAVI BAKERY");
	comboBox_1.addItem("KARIYANNA BUILDING");
	comboBox_1.addItem("CAMBRIDGE SCHOOL");
	comboBox_1.addItem("KALHALLI");
	comboBox_1.addItem("P&T COLONY");
	comboBox_1.addItem("POLICE CHOWKI");
	comboBox_1.addItem("SOMINKOPPA");
	comboBox_1.addItem("J.H.PATEL NAGAR");
	comboBox_1.addItem("SAHYADRI NAGAR");
	comboBox_1.addItem("DEVARAJ URS NAGAR");
	comboBox_1.addItem("LADIES HOSTEL");
	comboBox_1.setSelectedItem(null);
	
	frame.getContentPane().add(comboBox_1);
		
		
	JButton btnSearchBus = new JButton("SEARCH BUS");
	btnSearchBus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(comboBox.getSelectedItem()==null||comboBox_1.getSelectedItem()==null)
			{JOptionPane.showMessageDialog(null, "FILL BOTH THE FIELDS");}
			else
			
			{ 	
				t=comboBox.getSelectedItem().toString();
				
				bs=comboBox_1.getSelectedItem().toString();
				frame.setVisible(false);
				SearchBusOut.main(new String[] {});
			}
			
	}});
	btnSearchBus.setForeground(Color.CYAN);
	btnSearchBus.setBackground(Color.BLACK);
	btnSearchBus.setFont(new Font("Tahoma", Font.PLAIN, 18));
	btnSearchBus.setBounds(557, 451, 205, 32);
	Image img5=new ImageIcon(this.getClass().getResource("/search.jpg")).getImage();
	btnSearchBus.setIcon(new ImageIcon(img5));
	frame.getContentPane().add(btnSearchBus);
	
	JTextPane textPane = new JTextPane();
	textPane.setEditable(false);
	textPane.setBounds(302, 140, 761, 428);
	frame.getContentPane().add(textPane);	
	
	JLabel lblNewLabel_1 = new JLabel(" ");
	lblNewLabel_1.setForeground(Color.CYAN);
	Image img12=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
	 lblNewLabel_1.setIcon(new ImageIcon(img12));
	lblNewLabel_1.setBounds(0, 0, 1481, 861);
frame.getContentPane().add(lblNewLabel_1);	


	
	

	
	}
	}

