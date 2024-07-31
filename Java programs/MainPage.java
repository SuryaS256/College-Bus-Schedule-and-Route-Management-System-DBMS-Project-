import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(00, 00, 1366, 768);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JLabel label = new JLabel(" ");
		label.setBounds(607,11,95,120);
		Image img1=new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		frame.getContentPane().setLayout(null);
		label.setIcon(new ImageIcon(img1));
		frame.getContentPane().add(label);
		
		JLabel lblJawaharlalNehruNational = new JLabel("JAWAHARLAL NEHRU NATIONAL COLLEGE OF ENGINEERING");
		lblJawaharlalNehruNational.setForeground(Color.BLACK);
		lblJawaharlalNehruNational.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblJawaharlalNehruNational.setBounds(357, 130, 708, 31);
		frame.getContentPane().add(lblJawaharlalNehruNational);
		
		JLabel lblBusScheduleAnd = new JLabel("BUS SCHEDULE AND ROUTE MANAGEMENT SYSTEM");
		lblBusScheduleAnd.setForeground(Color.BLUE);
		lblBusScheduleAnd.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBusScheduleAnd.setBounds(367, 181, 627, 31);
		frame.getContentPane().add(lblBusScheduleAnd);
		
	
		
		JLabel lblSelectTheUser = new JLabel("SELECT THE USER TYPE:");
		lblSelectTheUser.setForeground(new Color(255, 51, 0));
		lblSelectTheUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelectTheUser.setBounds(437, 342, 251, 23);
		frame.getContentPane().add(lblSelectTheUser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(710, 345, 134, 25);
		comboBox.addItem("STUDENT");
		comboBox.addItem("ADMIN");
		comboBox.setSelectedItem(null);
		frame.getContentPane().add(comboBox);
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedItem()==null)
				{
					JOptionPane.showMessageDialog(null, "SELECT EITHER STUDENT OR ADMIN");
				}
				else if(comboBox.getSelectedItem()=="STUDENT")
				{
					StudentLogin.main(new String[] {});
				}
				else
				{
					driver1.main(new String[] {});
				}
			}
		});
		
		btnGo.setForeground(Color.CYAN);
		btnGo.setBackground(Color.BLACK);
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGo.setBounds(607, 442, 108, 31);
		Image img2=new ImageIcon(this.getClass().getResource("/next1.jpg")).getImage();
		btnGo.setIcon(new ImageIcon(img2));
		frame.getContentPane().add(btnGo);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(344, 172, 678, 355);
		frame.getContentPane().add(textPane);	
		
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setForeground(Color.CYAN);
		Image i1=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
		 lblNewLabel_1.setIcon(new ImageIcon(i1));
		lblNewLabel_1.setBounds(0, 0, 1481, 861);
	frame.getContentPane().add(lblNewLabel_1);
	}
}
