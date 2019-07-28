package Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class LoginView extends JFrame {
	/**
	 * the login frame
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField tfUser;
	private JPasswordField tfPassword;
	JButton btnSignIn = new JButton("Sign In");
	
	public LoginView() {
		setTitle("Northampton Research Center - Desktop");
		setIconImage(new ImageIcon(LoginView.class.getResource("../imgs/ICON.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(580, 510);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel sidepan = new JPanel();
		sidepan.setBounds(0, 0, 115, 510);
		getContentPane().add(sidepan);
		sidepan.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(LoginView.class.getResource("../imgs/logincover.jpg")));
		lblNewLabel_1.setBounds(0, 0, 113, 478);
		sidepan.add(lblNewLabel_1);
		
		JPanel midpane = new JPanel();
		midpane.setBackground(Color.WHITE);
		midpane.setBounds(115, 0, 460, 510);
		getContentPane().add(midpane);
		midpane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginView.class.getResource("../imgs/bg.jpg")));
		lblNewLabel_2.setBounds(115, 0, 450, 475);
		midpane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 103, 41);
		lblNewLabel_2.add(lblNewLabel);
		
		JLabel lblUserId = new JLabel("Username");
		lblUserId.setFont(new Font("Arial", Font.PLAIN, 10));
		lblUserId.setBounds(93, 209, 228, 25);
		lblNewLabel_2.add(lblUserId);
		
		tfUser = new JTextField();
		tfUser.setBounds(149, 212, 228, 20);
		lblNewLabel_2.add(tfUser);
		tfUser.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(149, 238, 228, 20);
		lblNewLabel_2.add(tfPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 10));
		lblPassword.setBounds(93, 236, 46, 25);
		lblNewLabel_2.add(lblPassword);
	
		btnSignIn.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnSignIn.setBackground(Color.WHITE);
			}
			public void mouseExited(MouseEvent e) {
				btnSignIn.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.setFont(new Font("Arial", Font.PLAIN, 10));
		btnSignIn.setBackground(Color.LIGHT_GRAY);
		btnSignIn.setBounds(292, 300, 85, 21);
		lblNewLabel_2.add(btnSignIn);
	}
	
	
	//return userid and password from the textfields
	public  String getUserId() { return this.tfUser.getText(); }
	
	public  char[] getUserPass() { return this.tfPassword.getPassword(); }

	
	//add button listener
	public void signIN(ActionListener a) {btnSignIn.addActionListener(a);}
}
