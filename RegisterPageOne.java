package BankManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import java.util.*;

public class RegisterPageOne extends JFrame implements ActionListener{
    
	Long appNo;
	JTextField fnameText,lnameText,fatherNameText,emailText,addText,cityText,stateText,pincodeText;
	JButton  next;
	JRadioButton male, female,married, unmarried,other;
	JDateChooser jdate;
	RegisterPageOne() {
		// *!*!Skeleton of Registration Page 1
		setTitle("Register Yourself Here");
		setBounds(330, 30, 700, 700);
		setVisible(true);
		getContentPane().setBackground(Color.decode("#E5E8E8"));
		setLayout(null);

		// *!*!Labels are made here

		// Application Number
		Random rn = new Random();
		appNo = Math.abs((rn.nextLong() % 9000L) + 1000L);
		JLabel appForm = new JLabel("Appliation Form No." + appNo);
		appForm.setBounds(150, 5, 450, 80);
		appForm.setFont(new Font("Osward", Font.BOLD, 30));
		appForm.setForeground(Color.WHITE);
		add(appForm);

		// First Name
		JLabel fname = new JLabel("First Name");
		fname.setBounds(100, 80, 80, 80);
		fname.setFont(new Font("Osward", Font.BOLD, 15));
		fname.setForeground(Color.WHITE);
		add(fname);

		// Adding First Name Text Fields
		fnameText = new JTextField();
		fnameText.setBounds(270, 110, 250, 20);
		fnameText.setBackground(Color.WHITE);
		fnameText.setForeground(Color.BLACK);
		fnameText.setBorder(null);
		add(fnameText);

		// Last Name
		JLabel lname = new JLabel("Last Name");
		lname.setBounds(100, 130, 80, 80);
		lname.setFont(new Font("Osward", Font.BOLD, 15));
		lname.setForeground(Color.WHITE);
		add(lname);

		// Adding LAst Name Text Fields
		lnameText = new JTextField();
		lnameText.setBounds(270, 160, 250, 20);
		lnameText.setBackground(Color.WHITE);
		lnameText.setForeground(Color.BLACK);
		lnameText.setBorder(null);
		add(lnameText);

		// Father's Name
		JLabel fatherName = new JLabel("Farther's Name");
		fatherName.setBounds(100, 180, 200, 80);
		fatherName.setFont(new Font("Osward", Font.BOLD, 15));
		fatherName.setForeground(Color.WHITE);
		add(fatherName);

		// Adding Father's Name Text Fields
	    fatherNameText = new JTextField();
		fatherNameText.setBounds(270, 210, 250, 20);
		fatherNameText.setBackground(Color.WHITE);
		fatherNameText.setForeground(Color.BLACK);
		fatherNameText.setBorder(null);
		add(fatherNameText);

		// Date Of Birth
		JLabel dob = new JLabel("Date Of Birth");
		dob.setBounds(100, 230, 100, 80);
		dob.setFont(new Font("Osward", Font.BOLD, 15));
		dob.setForeground(Color.WHITE);
		add(dob);

		// Add Calender
		jdate = new JDateChooser();
		jdate.setBounds(270, 260, 250, 20);
		jdate.setBackground(Color.WHITE);
		jdate.setBorder(null);
		add(jdate);

		// Gender
		JLabel gender = new JLabel("Gender");
		gender.setBounds(100, 280, 80, 80);
		gender.setFont(new Font("Osward", Font.BOLD, 15));
		gender.setForeground(Color.WHITE);
		add(gender);

		// Add Radio Buttons For Male and Female
		male = new JRadioButton("Male");
		male.setBounds(270, 310, 120, 20);
		male.setBackground(Color.WHITE);
		male.setForeground(Color.BLACK);
		add(male);
		female = new JRadioButton("Female");
		female.setBounds(390, 310, 130, 20);
		female.setBackground(Color.WHITE);
		female.setForeground(Color.BLACK);
		add(female);

		// Code for selecting only one radio button either male or female --> solution
		// :- grouping them.
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(female);
		genderGroup.add(male);

		// Email Address
		JLabel email = new JLabel("Email Address");
		email.setBounds(100, 330, 100, 80);
		email.setFont(new Font("Osward", Font.BOLD, 15));
		email.setForeground(Color.WHITE);
		add(email);

		// Adding Email Text Fields
		emailText = new JTextField();
		emailText.setBounds(270, 360, 250, 20);
		emailText.setBackground(Color.WHITE);
		emailText.setForeground(Color.BLACK);
		emailText.setBorder(null);
		add(emailText);

		// Address
		JLabel adress = new JLabel("Address");
		adress.setBounds(100, 380, 80, 80);
		adress.setFont(new Font("Osward", Font.BOLD, 15));
		adress.setForeground(Color.WHITE);
		add(adress);

		// Adding Address Text Fields
		addText = new JTextField();
		addText.setBounds(270, 410, 250, 20);
		addText.setBackground(Color.WHITE);
		addText.setForeground(Color.BLACK);
		addText.setBorder(null);
		add(addText);

		// City
		JLabel city = new JLabel("City");
		city.setBounds(100, 430, 80, 80);
		city.setFont(new Font("Osward", Font.BOLD, 15));
		city.setForeground(Color.WHITE);
		add(city);

		// Adding city Text Fields
		cityText = new JTextField();
		cityText.setBounds(270, 460, 250, 20);
		cityText.setBackground(Color.WHITE);
		cityText.setForeground(Color.BLACK);
		cityText.setBorder(null);
		add(cityText);

		// State
		JLabel state = new JLabel("State");
		state.setBounds(100, 480, 80, 80);
		state.setFont(new Font("Osward", Font.BOLD, 15));
		state.setForeground(Color.WHITE);
		add(state);

		// Adding state Text Fields
		stateText = new JTextField();
		stateText.setBounds(270, 510, 250, 20);
		stateText.setBackground(Color.WHITE);
		stateText.setForeground(Color.BLACK);
		stateText.setBorder(null);
		add(stateText);

		// Pincode
		JLabel pincode = new JLabel("Pin Code");
		pincode.setBounds(100, 530, 80, 80);
		pincode.setFont(new Font("Osward", Font.BOLD, 15));
		pincode.setForeground(Color.WHITE);
		add(pincode);

		// Adding pincode Text Fields
		pincodeText = new JTextField();
		pincodeText.setBounds(270, 560, 250, 20);
		pincodeText.setBackground(Color.WHITE);
		pincodeText.setForeground(Color.BLACK);
		pincodeText.setBorder(null);
		add(pincodeText);

		// Marital Status
		JLabel marital = new JLabel("Marital Status");
		marital.setBounds(100, 580, 200, 80);
		marital.setFont(new Font("Osward", Font.BOLD, 15));
		marital.setForeground(Color.WHITE);
		add(marital);

		// Add Radio Buttons For Married Unmarried Other
		married = new JRadioButton("Married");
		married.setBounds(270, 610,80, 20);
		married.setBackground(Color.WHITE);
		married.setForeground(Color.BLACK);
		add(married);
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(350, 610,100, 20);
		unmarried.setBackground(Color.WHITE);
		unmarried.setForeground(Color.BLACK);
		add(unmarried);
		other = new JRadioButton("Other");
		other.setBounds(450, 610,70, 20);
		other.setBackground(Color.WHITE);
		other.setForeground(Color.BLACK);
		add(other);

		// Code for selecting only one radio button either married/unmarried/other -->
		// solution :- grouping them.
		ButtonGroup statusGroup = new ButtonGroup();
		statusGroup.add(married);
		statusGroup.add(unmarried);
		statusGroup.add(other);

		// Page No.
		JLabel pNo = new JLabel("Page 1");
		pNo.setBounds(550, 50, 200, 80);
		pNo.setFont(new Font("Osward", Font.BOLD, 15));
		pNo.setForeground(Color.WHITE);
		add(pNo);

		// Next Button
	    next = new JButton("Next");
     	next.setBackground(new Color(70, 80, 90));
		next.setForeground(Color.BLACK);
		next.setBounds(590, 625, 80, 30);
		next.setBorder(null);
		next.addActionListener(this);
		add(next);
		
		
		// Image
		ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("Images/register.jpg"));
		Image bgAdj = bg.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
		ImageIcon backgrd = new ImageIcon(bgAdj);
		JLabel bglabel = new JLabel(backgrd);
		bglabel.setBounds(0, 0, 700, 700);
		add(bglabel);

	}

	@Override
	
	public void actionPerformed(ActionEvent e) {

		String formNo = ""+appNo;
		String fname = fnameText.getText();
		String lname = lnameText.getText();
		String fathername = fatherNameText.getText();
		
		String dob = ((JTextField) jdate.getDateEditor().getUiComponent()).getText();
		
		String gender = null;
		if(male.isSelected()) {
			gender ="Male";
		}else if(female.isSelected()) {
			gender = "Female";
		}
		
		String email = emailText.getText();
		String add = addText.getText();
		String city = cityText.getText();
		String state = stateText.getText();
		String pin = pincodeText.getText();
		
		String maritalStatus = null;
		if(married.isSelected()) {
			maritalStatus = "Married";
		}else if(unmarried.isSelected()) {
			maritalStatus = "Unmarried";
		}if(other.isSelected()) {
			maritalStatus = "Other";
		}
		
		try {
			if(fname.equals("") ||fathername.equals("") || email.equals("")|| add.equals("") ) {
				JOptionPane.showMessageDialog(null,"Can't Leave The Field Empty");
			}
			else {
				Connect con = new Connect();
				String query = "insert into register_one values('"+formNo+"','"+fname+"','"+lname+"','"+fathername+"','"+dob+"','"+gender+"','"+email+"','"+add+"','"+city+"','"+state+"','"+pin+"','"+maritalStatus+"')";
			    con.s.executeUpdate(query);
			    
			    setVisible(false);
			    new RegisterPageTwo(formNo).setVisible(true);
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RegisterPageOne();
	}

}
