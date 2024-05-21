package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;

public class Deposite extends JFrame implements ActionListener {

	JTextField depositeText;
	JButton deposite, back;
	String pinNo;

	Deposite(String pinNumber) {
		this.pinNo = pinNumber;
		// Skeleton of deposite
		setTitle("Deposite Window");
		setBounds(330, 100, 800, 450);
		setLayout(null);
		setVisible(true);

		// Labels and Buttons

		JLabel text = new JLabel("Enter the Amount you want to Deposite");
		text.setBounds(200, 10, 500, 100);
		text.setFont(new Font("Oswarld", Font.BOLD, 20));
		text.setForeground(Color.WHITE);
		add(text);

		// Deposite Text Field
		depositeText = new JTextField();
		depositeText.setBounds(240, 150, 300, 20);
		depositeText.setBackground(Color.WHITE);
		depositeText.setFont(new Font("Oswarld", Font.BOLD, 15));
		depositeText.setBorder(null);
		add(depositeText);

		deposite = new JButton("DEPOSITE");
		deposite.setBounds(280, 250, 100, 20);
		deposite.setBackground(Color.WHITE);
		deposite.setFont(new Font("Oswarld", Font.BOLD, 15));
		deposite.setBorder(null);
		deposite.addActionListener(this);
		add(deposite);

		back = new JButton("BACK");
		back.setBounds(400, 250, 100, 20);
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

		if (e.getSource() == deposite) {

			String amount = depositeText.getText();
			Date date = new Date();

			if (amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter amount to DEPOSITE");
			} else {
				try {
					Connect con = new Connect();
					String query = "insert into bank values('" + pinNo + "','" + date + "','Deposite','" + amount
							+ "')";
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,
							"Amount Rs." + amount + " deopsited SUCCESSFULLY in your Account");
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
		new Deposite("");

	}

}
