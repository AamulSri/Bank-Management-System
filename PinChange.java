package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

	JLabel pinCng, repin;
	JPasswordField pinChangeText, repinText;
	JButton confirm, back;
	String pinNo;
	String pinChange;

	PinChange(String pinNumber) {
		this.pinNo = pinNumber;
		// Skeleton of Pin Chnage
		setTitle("Pin Change Window");
		setBounds(330, 100, 800, 450);
		setLayout(null);
		setVisible(true);

		// Labels and Buttons

		JLabel text = new JLabel("Change Your PIN");
		text.setBounds(280, 10, 500, 100);
		text.setFont(new Font("Oswarld", Font.BOLD, 25));
		text.setForeground(Color.WHITE);
		add(text);

		pinCng = new JLabel("Enter New Pin");
		pinCng.setBounds(200, 150, 150, 25);
		pinCng.setFont(new Font("Oswarld", Font.BOLD, 20));
		pinCng.setForeground(Color.WHITE);
		add(pinCng);
		// PIN Text Field
		pinChangeText = new JPasswordField();
		pinChangeText.setBounds(355, 150, 150, 20);
		pinChangeText.setBackground(Color.WHITE);
		pinChangeText.setFont(new Font("Oswarld", Font.BOLD, 15));
		pinChangeText.setBorder(null);
		add(pinChangeText);

		repin = new JLabel("Re-Enter Pin");
		repin.setBounds(200, 200, 150, 25);
		repin.setFont(new Font("Oswarld", Font.BOLD, 20));
		repin.setForeground(Color.WHITE);
		add(repin);

		repinText = new JPasswordField();
		repinText.setBounds(355, 200, 150, 20);
		repinText.setBackground(Color.WHITE);
		repinText.setFont(new Font("Oswarld", Font.BOLD, 15));
		repinText.setBorder(null);
		add(repinText);

		confirm = new JButton("CONFIRM");
		confirm.setBounds(280, 300, 100, 20);
		confirm.setBackground(Color.WHITE);
		confirm.setFont(new Font("Oswarld", Font.BOLD, 15));
		confirm.setBorder(null);
		confirm.addActionListener(this);
		add(confirm);

		back = new JButton("BACK");
		back.setBounds(400, 300, 100, 20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Oswarld", Font.BOLD, 15));
		back.setBorder(null);
		back.addActionListener(this);
		add(back);

		// Add Background Image
		ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Images/greyBackground.jpg"));
		Image bgAdj = bg.getImage().getScaledInstance(800, 450, Image.SCALE_DEFAULT);
		ImageIcon backgrd = new ImageIcon(bgAdj);
		JLabel bgLabel = new JLabel(backgrd);
		bgLabel.setBounds(0, 0, 800, 450);
		add(bgLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
       String newPin = pinChangeText.getText();
       String rePin = repinText.getText();
		
		if (e.getSource() == confirm) {
         
			try {
				if(!newPin.equals(rePin)) {
					JOptionPane.showMessageDialog(null,"Pin Number Don't Match");
					return;
				}
				if(newPin.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter New Pin");
					
				}
				if(newPin.equals("")) {
					JOptionPane.showMessageDialog(null,"Enter Re-Pin");
					
				}
				Connect con = new Connect();
				//pin is used in 3 tables here so we have to update every table
				
				String updateBank = "Update bank set Pin_Number='"+rePin+"' where Pin_Number ='"+pinNo+"'";
				String updateLogin = "Update login set Pin_Number='"+rePin+"' where Pin_Number ='"+pinNo+"'";
				String updateRegisterThree = "Update register_three set Pin_Number='"+rePin+"' where Pin_Number ='"+pinNo+"'";
				
				con.s.execute(updateBank);
				con.s.execute(updateLogin);
				con.s.execute(updateRegisterThree);
				
				JOptionPane.showMessageDialog(null,"Pin Changed SUCCESSFULLY");
				
				setVisible(false);
				new Transaction(rePin).setVisible(true);
				
			}catch(Exception ex) {
				System.out.println(ex);
			}
			
			
		} else if (e.getSource() == back) {
             setVisible(false);
             new Transaction(rePin).setVisible(true);
		}

	}

	public static void main(String[] args) {

		new PinChange("").setVisible(true);
	}

}
