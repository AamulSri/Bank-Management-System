package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	// private JPanel contentPane;

	JButton signin = new JButton("SIGN IN");
	JButton clear = new JButton("CLEAR");
	JButton register = new JButton("REGISTER");

	JTextField cardText;

	JPasswordField pinText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Login frame = new Login();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public Login() {
		// *!*! The Login Page Skeleton
		setTitle("Welcome To Industan Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(330, 100, 800, 450);
		setLayout(null);
		setUndecorated(true);
		// making setLayout null bcz without it
		// we can't reposition our logo by default it will be on center

		// *!*! Changing Background color
		getContentPane().setBackground(Color.WHITE);

		// *!*! Adding Bank Logo on the JFrame

		/*
		 * ImageIcon icon = new
		 * ImageIcon(ClassLoader.getSystemResource("Images/logo.png")); // used for
		 * locating the image we want to use
		 * 
		 * Image imgAdj = icon.getImage().getScaledInstance(80, 80,
		 * DO_NOTHING_ON_CLOSE); // Adjusting the image size as we want
		 * 
		 * ImageIcon img = new ImageIcon(imgAdj); // We can't pass Image Value directly
		 * into the JLable // therefore converting it into ImageIcon
		 * 
		 * JLabel label = new JLabel(img); label.setBounds(100, 0, 100, 80); add(label);
		 * // Making Jlabel and then setting it's bounds and adding label
		 */

		// *!*! Adding Heading On the Login Page
		JLabel text = new JLabel("Welcome To Industan ATM");
		text.setFont(new Font("Osward", Font.BOLD, 35));
		Color gray = new Color(70, 80, 90);
		text.setForeground(Color.DARK_GRAY);
		text.setBounds(170, 0, 800, 80);
		add(text);

		// *!*! Adding Card No On the Login Page
		JLabel cardNo = new JLabel("Card No.");
		cardNo.setFont(new Font("Osward", Font.BOLD, 25));
		cardNo.setBounds(150, 150, 200, 30);
		add(cardNo);

		cardText = new JTextField();
		cardText.setBounds(300, 150, 200, 30);
		add(cardText);

		// *!*! Adding PIN On the Login Page
		JLabel pin = new JLabel("Pin");
		pin.setFont(new Font("", Font.BOLD, 25));
		pin.setBounds(150, 200, 200, 30);
		add(pin);

		pinText = new JPasswordField();
		pinText.setBounds(300, 200, 200, 30);
		add(pinText);

		// *!*! Adding Buttons on the login page

		// Sign in
		signin.setBounds(300, 280, 80, 30);
		signin.setBorder(null);
		signin.setBackground(gray);
		signin.setForeground(Color.WHITE);
		signin.addActionListener(this);
		add(signin);

		// clear
		clear.setBounds(420, 280, 80, 30);
		clear.setBorder(null);
		clear.setBackground(gray);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);

		// register
		register.setBounds(300, 330, 200, 30);
		register.setBorder(null);
		register.setBackground(gray);
		register.setForeground(Color.WHITE);
		register.addActionListener(this);
		add(register);

		// *!*! Adding Image In Background
		ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Images/rupee.jpg"));
		Image bgAdj = bg.getImage().getScaledInstance(800, 450, Image.SCALE_DEFAULT);
		ImageIcon backgrd = new ImageIcon(bgAdj);
		JLabel bglabel = new JLabel(backgrd);
		bglabel.setBounds(0, 0, 800, 450);
		add(bglabel);

	}

	// *!*!*! Used to do actions on buttons we defined
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clear) {
			cardText.setText("");
			pinText.setText("");
		} else if (e.getSource() == signin) {
			Connect con = new Connect();
			String cardNo = cardText.getText();
			String pinNo = pinText.getText();

			String query = "select * from login where Card_Number ='" + cardNo + "' and Pin_Number = '" + pinNo + "'";
			try {
				ResultSet result = con.s.executeQuery(query);

				if (result.next()) {
					setVisible(false);
					new Transaction(pinNo).setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}

		} else if (e.getSource() == register) {
			setVisible(false);
			new RegisterPageOne().setVisible(true);
		}

	}

}
