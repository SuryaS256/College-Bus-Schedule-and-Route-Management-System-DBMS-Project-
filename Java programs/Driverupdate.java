
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Driverupdate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driverupdate frame = new Driverupdate();
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
	public Driverupdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 703);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUS SCHEDULE AND ROUTE MANAGEMENT SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(370, 185, 658, 51);
		contentPane.add(lblNewLabel);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.DARK_GRAY);
		toolBar.setBounds(416, 269, 514, 23);
		contentPane.add(toolBar);
		
		JButton btnAddremoveDriver = new JButton("       ADD/REMOVE DRIVER");
		btnAddremoveDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddRemoveDriver.main(new String[] {});
			}
		});
		btnAddremoveDriver.setForeground(Color.CYAN);
		btnAddremoveDriver.setBackground(Color.DARK_GRAY);
		btnAddremoveDriver.setFont(new Font("Tahoma", Font.BOLD, 16));
		toolBar.add(btnAddremoveDriver);
		
		JButton btnAddremoveBus = new JButton("              ADD/REMOVE BUS");
		btnAddremoveBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddRemoveBus.main(new String[] {});
			}
		});
		btnAddremoveBus.setBackground(Color.DARK_GRAY);
		btnAddremoveBus.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddremoveBus.setForeground(Color.CYAN);
		toolBar.add(btnAddremoveBus);
		
		JCheckBox chckbxUpdateDriverDetails = new JCheckBox(" DRIVER DETAILS");
		chckbxUpdateDriverDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Driverdetails.main(new String[] {});
			}
		});
		chckbxUpdateDriverDetails.setBackground(Color.BLACK);
		chckbxUpdateDriverDetails.setForeground(Color.CYAN);
		chckbxUpdateDriverDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxUpdateDriverDetails.setBounds(585, 330, 303, 33);
		contentPane.add(chckbxUpdateDriverDetails);
		
		JCheckBox chckbxUpdateDriverDetails_1 = new JCheckBox("BUS DETAILS");
		chckbxUpdateDriverDetails_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Busdetails.main(new String[] {});
			}
		});
		chckbxUpdateDriverDetails_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		chckbxUpdateDriverDetails_1.setBackground(Color.BLACK);
		chckbxUpdateDriverDetails_1.setForeground(Color.CYAN);
		chckbxUpdateDriverDetails_1.setBounds(585, 397, 303, 33);
		contentPane.add(chckbxUpdateDriverDetails_1);
		
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setBounds(585, 21, 112, 126);
		getContentPane().add(lblNewLabel_2);
		Image im1=new ImageIcon(this.getClass().getResource("/jnn logo.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(im1));
		
		
		
		
	
	JLabel lblUpdate = new JLabel("UPDATE:");
	lblUpdate.setBackground(Color.BLACK);
	lblUpdate.setForeground(Color.BLACK);
	lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
	lblUpdate.setBounds(398, 330, 112, 33);
	contentPane.add(lblUpdate);
	


	JButton btnLogout = new JButton("LOGOUT");
	btnLogout.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			MainPage.main(new String[] {});
		}
	});
	btnLogout.setBackground(Color.BLACK);
	btnLogout.setForeground(Color.CYAN);
	btnLogout.setBounds(874, 231, 125, 27);
	contentPane.add(btnLogout);
	Image img7=new ImageIcon(this.getClass().getResource("/logout.jpg")).getImage();
	btnLogout.setIcon(new ImageIcon(img7));
	
	
	JTextPane textPane = new JTextPane();
	textPane.setEditable(false);
	textPane.setBounds(316, 166, 747, 405);
	contentPane.add(textPane);	
	
	JLabel lblNewLabel_1 = new JLabel(" ");
	lblNewLabel_1.setForeground(Color.CYAN);
	Image img9=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
	 lblNewLabel_1.setIcon(new ImageIcon(img9));
	lblNewLabel_1.setBounds(0, 0, 1481, 861);
contentPane.add(lblNewLabel_1);	
	

		
	}
}
