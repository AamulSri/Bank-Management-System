package BankManagementSystem;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

	String pinNo;
	JButton back;

	MiniStatement(String pinNumber) {
		this.pinNo = pinNumber;
		setTitle("Mini Statement Window");
		setBounds(450, 70, 600, 630);
		setLayout(null);
		setVisible(true);
		
		// Image
		ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Images/redCoins.jpg"));
		Image bgAdj = bg.getImage().getScaledInstance(600, 630, Image.SCALE_DEFAULT);
		ImageIcon backgrd = new ImageIcon(bgAdj);
		JLabel bglabel = new JLabel(backgrd);
		bglabel.setBounds(0, 0, 600,630);
		add(bglabel);
		
		ImageIcon bgMini = new ImageIcon(ClassLoader.getSystemResource("Images/miniStatement.jpg"));
		Image bgMiniAdj = bgMini.getImage().getScaledInstance(350,450, Image.SCALE_DEFAULT);
		ImageIcon bacMinikgrd = new ImageIcon(bgMiniAdj);
		JLabel bgMinilabel = new JLabel(bacMinikgrd);
		bgMinilabel.setBounds(120,55,350,450);
		bglabel.add(bgMinilabel);

		//Moto of window
		JLabel text = new JLabel("Bank Statement Of");
		text.setBounds(200,3,200,50);
		text.setFont(new Font("Raleway", Font.BOLD, 20));
		text.setForeground(Color.WHITE);
		bglabel.add(text);

		// Name of Bank
		JLabel bankName = new JLabel("Industan Bank");
		bankName.setBounds(110,1,150,60);
		bankName.setFont(new Font("Raleway", Font.BOLD,18));
		bankName.setForeground(Color.BLACK);
		bgMinilabel.add(bankName);
		
		//back button
		back = new JButton("BACK");
		back.setBounds(245,540, 100, 20);
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Oswarld", Font.BOLD, 15));
		back.setBorder(null);
		back.addActionListener(this);
		bglabel.add(back);
		
		//card number label
		JLabel cardNo = new JLabel("Card Number");
		cardNo.setBounds(30,70,350,30);
		cardNo.setFont(new Font("Raleway", Font.BOLD,17));
		cardNo.setForeground(Color.BLACK);
		bgMinilabel.add(cardNo);
		
		//account text
		JLabel cardNoText = new JLabel();
		cardNoText.setBounds(65,70,350,30);
		cardNoText.setFont(new Font("Raleway", Font.BOLD,12));
		cardNoText.setForeground(Color.BLACK);
		bgMinilabel.add(cardNoText);
		
		
		try {
			Connect con = new Connect();
			ResultSet result = con.s.executeQuery("select * from login where pin_number =  '"+pinNo+"'");
			while(result.next()) {
				cardNo.setText("Card Number: "+ result.getString("Card_Number").substring(0,4)+"XXXXXXXX"+result.getString("Card_Number").substring(12));	
			}	
		}catch(Exception ex) {
			System.out.println(ex);
		}
       
		
		JLabel mini = new JLabel();
		mini.setBounds(20,50,500,300);
		mini.setFont(new Font("Raleway", Font.BOLD,13));
		mini.setForeground(Color.BLACK);
		bgMinilabel.add(mini);
		
		try {
			Connect con = new Connect();
			ResultSet result =con.s.executeQuery("select * from bank where pin_number = '"+pinNo+"'");
			while(result.next()) {
		       mini.setText(mini.getText() +"<html>"+ result.getString("D_Date")+"&nbsp;&nbsp;&nbsp;"+ result.getString("T_Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ result.getString("Amount")+"<br><br><html>" );
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transaction(pinNo).setVisible(true);

	}

	public static void main(String[] args) {
		new MiniStatement("");
	}

}
