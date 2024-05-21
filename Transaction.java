package BankManagementSystem;


import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
	JButton deposite,pinChange, fastCash, withdraw,mini,balance,exit;
	String pinNumber;
	Transaction(String pinNo){
		this.pinNumber = pinNo;
		// Skeleton of the Transaction Window
		setTitle("Transaction Window");
		setBounds(330,50,800, 600);
		setVisible(true);
		//setUndecorated(true);
		setLayout(null);
		
		//Transaction Page Services
		
		deposite = new JButton("DEPOSITE");
		deposite.setBounds(70,150,120,50);
		deposite.setBackground(Color.decode("#536872"));
		deposite.setForeground(Color.WHITE);
		deposite.setBorder(null);
		deposite.addActionListener(this);
		add(deposite);
		
		pinChange = new JButton("PIN CHANGE");
		pinChange.setBounds(70,250,120,50);
		pinChange.setBackground(Color.decode("#536872"));
		pinChange.setForeground(Color.WHITE);
		pinChange.setBorder(null);
		pinChange.addActionListener(this);
		add(pinChange);
		
		fastCash = new JButton("FAST CHASH");
		fastCash.setBounds(70,350,120,50);
		fastCash.setBackground(Color.decode("#536872"));
		fastCash.setForeground(Color.WHITE);
		fastCash.setBorder(null);
		fastCash.addActionListener(this);
		add(fastCash);
		
		withdraw = new JButton("CASH WITHDRAW");
		withdraw.setBounds(600,150,120,50);
		withdraw.setBackground(Color.decode("#cf1010"));
		withdraw.setForeground(Color.WHITE);
		withdraw.setBorder(null);
		withdraw.addActionListener(this);
		add(withdraw);
		
		mini = new JButton("MINI STATEMENT");
		mini.setBounds(600,250,120,50);
		mini.setBackground(Color.decode("#cf1010"));
		mini.setForeground(Color.WHITE);
		mini.setBorder(null);
		mini.addActionListener(this);
		add(mini);
		
		balance = new JButton("BALANCE ENQUIRY");
		balance.setBounds(600,350,120,50);
		balance.setBackground(Color.decode("#cf1010"));
		balance.setForeground(Color.WHITE);
		balance.setBorder(null);
		balance.addActionListener(this);
		add(balance);
		
		exit = new JButton("EXIT");
		exit.setBounds(300,500,150,30);
		exit.setFont(new Font("Osward", Font.BOLD,20));
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.WHITE);
		exit.setBorder(null);
		exit.addActionListener(this);
		add(exit);
		
		//Image
		ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Images/atmFinal.jpeg"));
		Image bgAdj = bg.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon backgrd = new ImageIcon(bgAdj);
		JLabel bglabel = new JLabel(backgrd);
		bglabel.setBounds(0,0, 800, 600);
		add(bglabel);
		
		
		
		
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==deposite) {
			setVisible(false);
			new Deposite(pinNumber).setVisible(true);
		}
		else if(e.getSource()==pinChange) {
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}
		else if(e.getSource()==fastCash) {
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}
        else if(e.getSource()==withdraw) {
        	setVisible(false);
			new Withdraw(pinNumber).setVisible(true);
		
        }else if(e.getSource()==balance) {
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
			              
		}else if(e.getSource()==mini) {
			setVisible(false);
			new MiniStatement(pinNumber).setVisible(true);
			
		}
		if(e.getSource()==exit) {
			System.exit(0);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new Transaction("");

	}

	

}
