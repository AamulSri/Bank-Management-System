package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;

public class Withdraw extends JFrame implements ActionListener {

	JTextField withdrawText;
	JButton withdraw, back;
	String pinNo;

	Withdraw(String pinNumber) {
		this.pinNo = pinNumber;
		// Skeleton of Withdraw
		setTitle("Withdraw Window");
		setBounds(330, 100, 800, 450);
		setLayout(null);
		setVisible(true);

		// Labels and Buttons

		JLabel text = new JLabel("Enter the Amount you want to Withdraw");
		text.setBounds(200, 15, 500, 100);
		text.setFont(new Font("Oswarld", Font.BOLD, 20));
		text.setForeground(Color.WHITE);
		add(text);

		// Withdraw Text Field
		withdrawText = new JTextField();
		withdrawText.setBounds(240, 150, 300, 20);
		withdrawText.setBackground(Color.WHITE);
		withdrawText.setFont(new Font("Oswarld", Font.BOLD, 15));
		withdrawText.setBorder(null);
		add(withdrawText);

		withdraw = new JButton("WITHDRAW");
		withdraw.setBounds(270, 250, 110, 20);
		withdraw.setBackground(Color.WHITE);
		withdraw.setFont(new Font("Oswarld", Font.BOLD, 15));
		withdraw.setBorder(null);
		withdraw.addActionListener(this);
		add(withdraw);

		 
		// Image
		ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Images/redCoins.jpg"));
		Image bgAdj = bg.getImage().getScaledInstance(800, 450, Image.SCALE_DEFAULT);
		ImageIcon backgrd = new ImageIcon(bgAdj);
		JLabel bglabel = new JLabel(backgrd);
		bglabel.setBounds(0, 0, 800, 450);
		add(bglabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == withdraw) {

			String amount = withdrawText.getText();
			Date date = new Date();

			if (amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter amount to WITHDRAW");
			} else {
				try {
					Connect con = new Connect();
					String query = "insert into bank values('" + pinNo + "','" + date + "','Withdraw','" + amount
							+ "')";
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,
							"Amount Rs." + amount + " withdrawn SUCCESSFULLY from your Account");
					setVisible(false);
					new Transaction(pinNo).setVisible(true);

				} catch (SQLException ex) {
					System.out.println(ex);
				}

			}
		} else if (e.getSource() == back) {
			setVisible(false);
			new Transaction(pinNo).setVisible(true);
		}

	}

	public static void main(String[] args) {
		new Withdraw("");

	}

}
