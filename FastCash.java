package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {

	JButton draw100, draw500, draw1000, draw2000, draw5000, draw10000, back;
	String pinNo;

	FastCash(String pinNumber) {
		this.pinNo = pinNumber;
		// Skeleton of deposite
		setTitle("Deposite Window");
		setBounds(330, 100, 800, 450);
		setLayout(null);
		setVisible(true);

		// Labels and Buttons

		JLabel text = new JLabel("Select Withrawal Amount");
		text.setBounds(250, 10, 500, 100);
		text.setFont(new Font("Oswarld", Font.BOLD, 25));
		text.setForeground(Color.WHITE);
		add(text);

		// Fast Cash Withdraw Buttons
		draw100 = new JButton("Rs.100");
		draw100.setBounds(200, 150, 150, 20);
		draw100.setBackground(Color.WHITE);
		draw100.setFont(new Font("Oswarld", Font.BOLD, 15));
		draw100.setBorder(null);
		draw100.addActionListener(this);
		add(draw100);

		draw500 = new JButton("Rs.500");
		draw500.setBounds(200, 200, 150, 20);
		draw500.setBackground(Color.WHITE);
		draw500.setFont(new Font("Oswarld", Font.BOLD, 15));
		draw500.setBorder(null);
		draw500.addActionListener(this);
		add(draw500);

		draw1000 = new JButton("Rs.1000");
		draw1000.setBounds(200, 250, 150, 20);
		draw1000.setBackground(Color.WHITE);
		draw1000.setFont(new Font("Oswarld", Font.BOLD, 15));
		draw1000.setBorder(null);
		draw1000.addActionListener(this);
		add(draw1000);

		draw2000 = new JButton("Rs.2000");
		draw2000.setBounds(450, 150, 150, 20);
		draw2000.setBackground(Color.WHITE);
		draw2000.setFont(new Font("Oswarld", Font.BOLD, 15));
		draw2000.setBorder(null);
		draw2000.addActionListener(this);
		add(draw2000);

		draw5000 = new JButton("Rs.5000");
		draw5000.setBounds(450, 200, 150, 20);
		draw5000.setBackground(Color.WHITE);
		draw5000.setFont(new Font("Oswarld", Font.BOLD, 15));
		draw5000.setBorder(null);
		draw5000.addActionListener(this);
		add(draw5000);

		draw10000 = new JButton("Rs.10000");
		draw10000.setBounds(450, 250, 150, 20);
		draw10000.setBackground(Color.WHITE);
		draw10000.setFont(new Font("Oswarld", Font.BOLD, 15));
		draw10000.setBorder(null);
		draw10000.addActionListener(this);
		add(draw10000);

		back = new JButton("BACK");
		back.setBounds(350, 350, 100, 20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Oswarld", Font.BOLD, 15));
		back.setBorder(null);
		back.addActionListener(this);
		add(back);

		// Image
		ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Images/greyBackground.jpg"));
		Image bgAdj = bg.getImage().getScaledInstance(800, 450, Image.SCALE_DEFAULT);
		ImageIcon backgrd = new ImageIcon(bgAdj);
		JLabel bglabel = new JLabel(backgrd);
		bglabel.setBounds(0, 0, 800, 450);
		add(bglabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String amount = "";
		Date date = new Date();
		int balance = 0;

		if (e.getSource() == back) {
			setVisible(false);
			new Transaction(pinNo).setVisible(true);

		} else {
			amount = ((JButton) e.getSource()).getText().substring(3);
			if (amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter amount to WITHDRAW");
			} else {
				try {
					Connect con = new Connect();
					// checking for sufficient balance to withdraw
					ResultSet result = con.s.executeQuery("select * from bank where pin_number = '" + pinNo + "'");
					while (result.next()) {
						if (result.getString("T_Type").equalsIgnoreCase("Deposite")) {
							balance += Integer.parseInt(result.getString("Amount"));
						} else {
							balance -= Integer.parseInt(result.getString("Amount"));
						}
					}

					if (e.getSource() != back && balance < Integer.parseInt(amount)) {
						JOptionPane.showMessageDialog(null, "Insufficient Balance");
						return;
					}
                   
					//Updating Amount Values
					String query = "insert into bank values('" + pinNo + "','" + date + "','Withdraw','" + amount
							+ "')";
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,
							"Amount Rs." + amount + " withdrawn SUCCESSFULLY in your Account");
					

				} catch (SQLException ex) {
					System.out.println(ex);
				}

			}
		}

	}

	public static void main(String[] args) {
		new FastCash("");

	}

}
