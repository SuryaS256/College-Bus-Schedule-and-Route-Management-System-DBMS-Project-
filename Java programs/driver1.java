

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.Canvas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class driver1 {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					driver1 window = new driver1();
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
	public driver1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1288, 709);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUS SCHEDULE AND ROUTE MANAGEMENT SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(376, 186, 658, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 158, 1211, -258);
		frame.getContentPane().add(separator);
		
		JLabel lblDriverLogin = new JLabel("ADMIN LOGIN");
		lblDriverLogin.setForeground(new Color(255, 51, 0));
		lblDriverLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDriverLogin.setBounds(556, 245, 174, 43);
		frame.getContentPane().add(lblDriverLogin);
		
		JLabel lblDriverName = new JLabel("ADMIN NAME:");
		lblDriverName.setForeground(new Color(255, 51, 0));
		lblDriverName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDriverName.setBounds(486, 319, 191, 37);
		frame.getContentPane().add(lblDriverName);
		
		textField = new JTextField();
		textField.setBounds(700, 329, 197, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(new Color(255, 51, 0));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(486, 394, 149, 28);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(700, 400, 197, 25);
		
		frame.getContentPane().add(passwordField);
		
		
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setForeground(Color.CYAN);
		Image img2=new ImageIcon(this.getClass().getResource("/login succ.jpg")).getImage();
		btnLogin.setIcon(new ImageIcon(img2));
		String s=new String(passwordField.getPassword());
		btnLogin.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "ENTER ADMIN NAME AND PASSWORD");
				}
				
				else if(textField.getText().equals("admin")&& Arrays.equals(passwordField.getPassword(),new char[] {'a','d','m','i','n'})) {
				Driverupdate.main(new String[] {});
			}
				else
				{
					JOptionPane.showMessageDialog(null, "ENTER CORRECT ADMIN NAME AND PASSWORD");
				}
			}}
			
		);
		btnLogin.setBounds(608, 468, 134, 37);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setBounds(579, 16, 112, 131);
		frame.getContentPane().add(lblNewLabel_2);
		Image im1=new ImageIcon(this.getClass().getResource("/jnn logo.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(im1));

		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(317, 184, 746, 403);
		frame.getContentPane().add(textPane);	
		
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setForeground(Color.CYAN);
		Image img1=new ImageIcon(this.getClass().getResource("/j back1.jpg")).getImage();
		 lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(0, 0, 1481, 861);
	frame.getContentPane().add(lblNewLabel_1);
			
		
	
	
	
		
		
		
		
		
		
		
	}
}

