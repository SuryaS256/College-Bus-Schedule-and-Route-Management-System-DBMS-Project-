import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class StudentLogin {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin window = new StudentLogin();
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
	public StudentLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1261, 607);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel label = new JLabel(" ");
		label.setBounds(599,0,94,129);
		Image img1=new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();
		label.setIcon(new ImageIcon(img1));
		frame.getContentPane().add(label);
		
		JLabel lblBusScheduleAnd = new JLabel("BUS SCHEDULE AND ROUTE MANAGEMENT SYSTEM");
		lblBusScheduleAnd.setForeground(new Color(0, 0, 153));
		lblBusScheduleAnd.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBusScheduleAnd.setBounds(372, 175, 621, 25);
		frame.getContentPane().add(lblBusScheduleAnd);
		
		JLabel lblStudentLogin = new JLabel("STUDENT LOGIN");
		lblStudentLogin.setForeground(new Color(0, 0, 153));
		lblStudentLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudentLogin.setBounds(574, 244, 182, 25);
		frame.getContentPane().add(lblStudentLogin);
		
		JLabel lblAdmissionNumber = new JLabel("ADMISSION NUMBER:");
		lblAdmissionNumber.setForeground(new Color(255, 51, 0));
		lblAdmissionNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmissionNumber.setBounds(449, 337, 244, 25);
		frame.getContentPane().add(lblAdmissionNumber);
		
		textField = new JTextField();
		textField.setBounds(748, 340, 138, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "ENTER THE ADMISSION NUMBER");
				}
					
				else
					
				SearchBus.main(new String[] {});
			}
		});
		btnLogin.setForeground(new Color(0, 255, 255));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.setBounds(596, 433, 149, 37);
		Image img2=new ImageIcon(this.getClass().getResource("/login succ.jpg")).getImage();
		btnLogin.setIcon(new ImageIcon(img2));
		frame.getContentPane().add(btnLogin);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(311, 140, 752, 393);
		frame.getContentPane().add(textPane);	
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setForeground(Color.CYAN);
		Image ig1=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
		 lblNewLabel_1.setIcon(new ImageIcon(ig1));
		lblNewLabel_1.setBounds(0, 0, 1481, 861);
	frame.getContentPane().add(lblNewLabel_1);
	}

}
