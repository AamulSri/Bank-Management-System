package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.util.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    long balance;
	JButton back;
	String pinNo, accNo;
	JLabel bankStatement,bankStatementAmount;
	
	 BalanceEnquiry(String pinNumber) {
		 this.pinNo = pinNumber;
		 ResultSet resBalance , resCardNo;
		 
			// Skeleton of Balance Enquiry 
			setTitle("Balance Enquiry Window");
			setBounds(550, 100,500,350);
			setLayout(null);
			setVisible(true);
		 
			JLabel text = new JLabel("Balance Details ");
			text.setBounds(170,10,300,80);
			text.setFont(new Font("Oswarld", Font.BOLD, 20));
			text.setForeground(Color.WHITE);
			add(text);
			
			try {
				Connect con = new Connect();
				//Checking Balance And Account Details
				resBalance = con.s.executeQuery("select * from bank where pin_number = '"+ pinNo +"'");
						while (resBalance.next()) {
					if (resBalance.getString("T_Type").equalsIgnoreCase("Deposite")) {
						balance += Long.parseLong(resBalance.getString("Amount"));
					} else {
						balance -= Long.parseLong(resBalance.getString("Amount"));
					}
				}
				resCardNo = con.s.executeQuery("select Card_Number from login where pin_number ='"+pinNo+"'");
				while(resCardNo.next()) {
					accNo = resCardNo.getString("Card_Number");
				}
                
				bankStatement = new JLabel("Balance For Account No." +accNo+ " is ");
				bankStatement.setBounds(45,50,450,100);
				bankStatement.setForeground(Color.WHITE);
				bankStatement.setFont(new Font("Raleway",Font.BOLD,18));
				add(bankStatement);
				
				bankStatementAmount = new JLabel(" Rs."+balance);
				bankStatementAmount.setBounds(200,80,250,150);
				bankStatementAmount.setForeground(Color.WHITE);
				bankStatementAmount.setFont(new Font("Raleway",Font.BOLD,20));
				add(bankStatementAmount);
				
				
			}catch(Exception ex) {
				System.out.println(ex);
			}
		 
			
			//back Button
			back = new JButton("BACK");
			back.setBounds(190, 250, 110, 20);
			back.setBackground(Color.WHITE);
			back.setFont(new Font("Oswarld", Font.BOLD, 15));
			back.setBorder(null);
			back.addActionListener(this);
			add(back);


			// Image
			ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Images/redCoins.jpg"));
			Image bgAdj = bg.getImage().getScaledInstance(800, 450, Image.SCALE_DEFAULT);
			ImageIcon backgrd = new ImageIcon(bgAdj);
			JLabel bglabel = new JLabel(backgrd);
			bglabel.setBounds(0, 0,500, 350);
			add(bglabel);

	}

	 @Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new Transaction(pinNo).setVisible(true);
			
		} 
	 
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

	

}
