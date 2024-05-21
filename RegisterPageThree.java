package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RegisterPageThree extends JFrame implements ActionListener {

	JRadioButton saving, current, fixed, recurring;
	JCheckBox atmCard, inernetBanking, mobBanking, emailAndSMS, cheque, eStatement, declaration;
	JButton submit, cancel;
	String formNo;

	RegisterPageThree(String formNo) {
		// Skeleton of Account Details
		this.formNo = formNo;
		setTitle("Account Details");
		setBounds(330, 30, 750, 600);
		setVisible(true);
		getContentPane().setBackground(Color.decode("#E5E8E8"));
		setLayout(null);

		// Heading of the page
		JLabel accDetails = new JLabel("Account Details");
		accDetails.setBounds(265, 5, 450, 80);
		accDetails.setFont(new Font("Osward", Font.BOLD, 25));
		accDetails.setForeground(Color.WHITE);
		add(accDetails);

		// Account Type
		JLabel accType = new JLabel("Account Type");
		accType.setBounds(125, 60, 450, 80);
		accType.setFont(new Font("Osward", Font.BOLD, 17));
		accType.setForeground(Color.WHITE);
		add(accType);

		saving = new JRadioButton("Saving Account");
		saving.setBounds(155, 120, 200, 20);
		saving.setFont(new Font("Osward", Font.BOLD, 12));
		saving.setForeground(Color.BLACK);
		saving.setBackground(Color.WHITE);
		add(saving);

		current = new JRadioButton("Current Account");
		current.setBounds(355, 120, 200, 20);
		current.setFont(new Font("Osward", Font.BOLD, 12));
		current.setForeground(Color.BLACK);
		current.setBackground(Color.WHITE);
		add(current);

		fixed = new JRadioButton("Fixed Deposite Account");
		fixed.setBounds(155, 140, 200, 20);
		fixed.setFont(new Font("Osward", Font.BOLD, 12));
		fixed.setForeground(Color.BLACK);
		fixed.setBackground(Color.WHITE);
		add(fixed);

		recurring = new JRadioButton("Recurring Deposite Account");
		recurring.setBounds(355, 140, 200, 20);
		recurring.setFont(new Font("Osward", Font.BOLD, 12));
		recurring.setForeground(Color.BLACK);
		recurring.setBackground(Color.WHITE);
		add(recurring);

		ButtonGroup accTypeGroup = new ButtonGroup();
		accTypeGroup.add(current);
		accTypeGroup.add(fixed);
		accTypeGroup.add(recurring);
		accTypeGroup.add(saving);

		// Card Number Details
		JLabel cardNo = new JLabel("Card Number");
		cardNo.setBounds(125, 170, 200, 80);
		cardNo.setFont(new Font("Osward", Font.BOLD, 16));
		cardNo.setForeground(Color.WHITE);
		add(cardNo);
		JLabel cardNoDetail = new JLabel("Your 16 Digit Card Number");
		cardNoDetail.setBounds(125, 190, 200, 80);
		cardNoDetail.setFont(new Font("Osward", Font.ITALIC, 10));
		cardNoDetail.setForeground(Color.WHITE);
		add(cardNoDetail);
		JLabel cardNumberNo = new JLabel("XXXX-XXXX-XXXX-1432");
		cardNumberNo.setBounds(325, 170, 200, 80);
		cardNumberNo.setFont(new Font("Osward", Font.BOLD, 14));
		cardNumberNo.setForeground(Color.WHITE);
		add(cardNumberNo);

		// Pin Number Details
		JLabel pinNo = new JLabel("Pin");
		pinNo.setBounds(125, 220, 200, 80);
		pinNo.setFont(new Font("Osward", Font.BOLD, 16));
		pinNo.setForeground(Color.WHITE);
		add(pinNo);
		JLabel pinNoDetails = new JLabel("Your 4 Digit Password");
		pinNoDetails.setBounds(125, 240, 200, 80);
		pinNoDetails.setFont(new Font("Osward", Font.ITALIC, 10));
		pinNoDetails.setForeground(Color.WHITE);
		add(pinNoDetails);
		JLabel pinNumberNo = new JLabel("XXXX");
		pinNumberNo.setBounds(325, 220, 200, 80);
		pinNumberNo.setFont(new Font("Osward", Font.BOLD, 14));
		pinNumberNo.setForeground(Color.WHITE);
		add(pinNumberNo);

		// Service Required
		JLabel service = new JLabel("Service Required");
		service.setBounds(125, 280, 200, 80);
		service.setFont(new Font("Osward", Font.BOLD, 16));
		service.setForeground(Color.WHITE);
		add(service);

		// ATM CARD
		atmCard = new JCheckBox("ATM Card");
		atmCard.setBounds(155, 340, 200, 20);
		atmCard.setFont(new Font("Osward", Font.BOLD, 12));
		atmCard.setForeground(Color.BLACK);
		atmCard.setBackground(Color.WHITE);
		add(atmCard);

		// Internet Banking
		inernetBanking = new JCheckBox("Internet Banking");
		inernetBanking.setBounds(355, 340, 200, 20);
		inernetBanking.setFont(new Font("Osward", Font.BOLD, 12));
		inernetBanking.setForeground(Color.BLACK);
		inernetBanking.setBackground(Color.WHITE);
		add(inernetBanking);

		// Mobile Banking
		mobBanking = new JCheckBox("Mobile Banking");
		mobBanking.setBounds(155, 360, 200, 20);
		mobBanking.setFont(new Font("Osward", Font.BOLD, 12));
		mobBanking.setForeground(Color.BLACK);
		mobBanking.setBackground(Color.WHITE);
		add(mobBanking);

		// Email And SMS Alert
		emailAndSMS = new JCheckBox("Email And SMS Alert");
		emailAndSMS.setBounds(355, 360, 200, 20);
		emailAndSMS.setFont(new Font("Osward", Font.BOLD, 12));
		emailAndSMS.setForeground(Color.BLACK);
		emailAndSMS.setBackground(Color.WHITE);
		add(emailAndSMS);

		// Cheque
		cheque = new JCheckBox("Cheque Book");
		cheque.setBounds(155, 380, 200, 20);
		cheque.setFont(new Font("Osward", Font.BOLD, 12));
		cheque.setForeground(Color.BLACK);
		cheque.setBackground(Color.WHITE);
		add(cheque);

		// E-Statemet
		eStatement = new JCheckBox("E-Statement");
		eStatement.setBounds(355, 380, 200, 20);
		eStatement.setFont(new Font("Osward", Font.BOLD, 12));
		eStatement.setForeground(Color.BLACK);
		eStatement.setBackground(Color.WHITE);
		add(eStatement);

		// Declaration
		declaration = new JCheckBox("");
		declaration.setBounds(10, 455, 15, 10);
		declaration.setBackground(Color.BLACK);
		add(declaration);

		JLabel dec = new JLabel(
				"I hereby declare that the information furnished above is true, complete and correct to the best of my knowledge.");
		dec.setBounds(60, 450,800, 20);
		dec.setForeground(Color.WHITE);
		add(dec);
		// Submit
		submit = new JButton("Submit");
		submit.setBounds(225, 520, 120, 27);
		submit.setFont(new Font("Osward", Font.BOLD, 14));
		submit.setBackground(new Color(70, 80, 90));
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		add(submit);

		// Cancel
		cancel = new JButton("Cancel");
		cancel.setBounds(400, 520, 120, 27);
		cancel.setFont(new Font("Osward", Font.BOLD, 14));
		cancel.setBackground(new Color(70, 80, 90));
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);

		// Image
		ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Images/register.jpg"));
		Image bgAdj = bg.getImage().getScaledInstance(750, 600, Image.SCALE_DEFAULT);
		ImageIcon backgrd = new ImageIcon(bgAdj);
		JLabel bglabel = new JLabel(backgrd);
		bglabel.setBounds(0, 0, 750, 600);
		add(bglabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == submit) {

			Random ran = new Random();
			// Card Number And Pin Number Generator
			String cardNumber = "" + Math.abs((ran.nextLong() % 9000000000L) + 1432509000000000L);
			String pinNumber = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);

			// Account Type
			String accType = null;
			if (saving.isSelected()) {
				accType = saving.getText();
			} else if (current.isSelected()) {
				accType = current.getText();
			} else if (fixed.isSelected()) {
				accType = fixed.getText();
			} else if (recurring.isSelected()) {
				accType = recurring.getText();
			}

			// Service Selection

			String service = "";
			if (atmCard.isSelected()) {
				service = service + " ATM Card ";
			}
			if (inernetBanking.isSelected()) {
				service = service + " Internet Banking ";
			}
			if (mobBanking.isSelected()) {
				service = service + " Mobile Banking ";
			}
			if (emailAndSMS.isSelected()) {
				service = service + " Email and SMS Alerts ";
			}
			if (cheque.isSelected()) {
				service = service + " Check Book ";
			}
			if (eStatement.isSelected()) {
				service = service + " E-Statement ";
			}

			// Database Connection
			try {
				if (accType == null) {
					JOptionPane.showMessageDialog(null, "Account Type is required");
				}
				if (!declaration.isSelected()) {
					JOptionPane.showMessageDialog(null, "Must agree with declaration statement");
				} else {
					Connect con = new Connect();
					String queryPageThree = "insert into register_three values('" + formNo + "','" + cardNumber + "','"
							+ pinNumber + "','" + accType + "','" + service + "')";
					String queryLogin = "insert into login values('" + formNo + "','" + cardNumber + "','" + pinNumber
							+ "')";
					con.s.executeUpdate(queryPageThree);
					con.s.executeUpdate(queryLogin);

					JOptionPane.showMessageDialog(null, "Card Number:  " + cardNumber + "\n Pin:  " + pinNumber);
                     
					//Can't open an account at zero balance therefore have to deposite some amount
					setVisible(false);
					new Deposite(pinNumber).setVisible(true);
				}

			} catch (Exception ec) {
				System.out.println(ec);
			}

		} else if (e.getSource() == cancel) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new RegisterPageThree("");
	}

}
