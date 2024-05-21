package BankManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import java.util.*;

public class RegisterPageTwo extends JFrame implements ActionListener {

	JComboBox religionDrop, categoryDrop, incomeDrop, eduDrop, occuDrop;
	JTextField panText, adharText;
	JButton next;
	JRadioButton snrYes, snrNo, existYes, existNo;
    String formNum;

	RegisterPageTwo(String formNo) {
		this.formNum = formNo;
		// *!*!Skeleton of Registration Page 2
		setTitle("Register Yourself Here");
		setBounds(330, 30, 700, 700);
		setVisible(true);
		getContentPane().setBackground(Color.decode("#E5E8E8"));
		setLayout(null);

		// *!*!Labels are made here

		// Application Number
		JLabel appForm = new JLabel("Appliation Form No." + formNum);
		appForm.setBounds(150, 5, 450, 80);
		appForm.setFont(new Font("Osward", Font.BOLD, 30));
		appForm.setForeground(Color.WHITE);
		add(appForm);

		// Religion
		JLabel religion = new JLabel("Religion");
		religion.setBounds(100, 80, 80, 80);
		religion.setFont(new Font("Osward", Font.BOLD, 15));
		religion.setForeground(Color.WHITE);
		add(religion);

		// Adding Religion DropDown Fields
		String rel[] = {"Hindu","Muslim","Sikh","Chirstian","Budhism","Other"};
		religionDrop = new JComboBox(rel);
		religionDrop.setBounds(270, 110, 250, 20);
		add(religionDrop);
		religionDrop.setBackground(Color.WHITE);
		
		// Category
		JLabel category = new JLabel("Category");
		category.setBounds(100, 130, 80, 80);
		category.setFont(new Font("Osward", Font.BOLD, 15));
		category.setForeground(Color.WHITE);
		add(category);

		// Adding Category DropDown Fields
		String cat[] = {"General","OBC","ST","SC","Other"};
		categoryDrop = new JComboBox(cat);
		categoryDrop.setBounds(270, 160, 250, 20);
		categoryDrop.setBackground(Color.WHITE);
		add(categoryDrop);
		
		
		// Income
		JLabel income = new JLabel("Income");
		income.setBounds(100, 180, 200, 80);
		income.setFont(new Font("Osward", Font.BOLD, 15));
		income.setForeground(Color.WHITE);
		add(income);
		
		//Income Drop Down
		String incomeCategory[] = {"Nill","<1,50,000","<2,50,000","<3,50,000","<4,50,000","other"};
		incomeDrop = new JComboBox(incomeCategory);
		incomeDrop.setBounds(270, 210, 250, 20);
		incomeDrop.setBackground(Color.WHITE);
		add(incomeDrop);
		
		// Educational Qualification
		JLabel education = new JLabel("Education");
		education.setBounds(100, 230, 100, 80);
		education.setFont(new Font("Osward", Font.BOLD, 15));
		education.setForeground(Color.WHITE);
		add(education);

		// Add Educstion Drop down
		String edu[] = {"Non-Graduate","Graduate","Post Graduate","Phd"};
		eduDrop = new JComboBox(edu);
		eduDrop.setBounds(270, 260, 250, 20);
		eduDrop.setBackground(Color.WHITE);
		add(eduDrop);
		
		// Occupation drop down
		JLabel occupation = new JLabel("Occupation");
		occupation.setBounds(100, 280, 100, 80);
		occupation.setFont(new Font("Osward", Font.BOLD, 15));
		occupation.setForeground(Color.WHITE);
		add(occupation);

		//Occupation Drop Down
		String occu[] = {"Self Employed","Salaried","Business","Salaried","Retiered","Student", "Other"};
		occuDrop = new JComboBox(occu);
		occuDrop.setBounds(270, 310, 250, 20);
		occuDrop.setBackground(Color.WHITE);
		add(occuDrop);
		
		// Pan
		JLabel pan = new JLabel("Pan");
		pan.setBounds(100, 330, 80, 80);
		pan.setFont(new Font("Osward", Font.BOLD, 15));
		pan.setForeground(Color.WHITE);
		add(pan);

		// Adding Pan Text Fields
		panText = new JTextField();
		panText.setBounds(270, 360, 250, 20);
		panText.setBackground(Color.WHITE);
		panText.setForeground(Color.BLACK);
		add(panText);

		// Adhaar Card
		JLabel adhar = new JLabel("Aadhaar");
		adhar.setBounds(100, 380, 80, 80);
		adhar.setFont(new Font("Osward", Font.BOLD, 15));
		adhar.setForeground(Color.WHITE);
		add(adhar);

		// Adding Aadhaar Text Fields
		adharText = new JTextField();
		adharText.setBounds(270, 410, 250, 20);
		adharText.setBackground(Color.WHITE);
		adharText.setForeground(Color.BLACK);
		add(adharText);

		// Senior Citizen
		JLabel snr = new JLabel("Senior Citizen");
		snr.setBounds(100, 440, 150, 80);
		snr.setFont(new Font("Osward", Font.BOLD, 15));
		snr.setForeground(Color.WHITE);
		add(snr);

		// Add Radio Buttons For Senior Citizen
		snrYes = new JRadioButton("Yes");
		snrYes.setBounds(270, 470, 120, 20);
		snrYes.setBackground(Color.WHITE);
		snrYes.setForeground(Color.BLACK);
		add(snrYes);
		snrNo = new JRadioButton("No");
		snrNo.setBounds(390, 470, 130, 20);
		snrNo.setBackground(Color.WHITE);
		snrNo.setForeground(Color.BLACK);
		add(snrNo);

		// Code for selecting only one radio button either Yes or No --> solution
		// :- grouping them.
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(snrNo);
		genderGroup.add(snrYes);

		// Existing Account Status
		JLabel existing = new JLabel("Existing Account");
		existing.setBounds(100, 490, 200, 80);
		existing.setFont(new Font("Osward", Font.BOLD, 15));
		existing.setForeground(Color.WHITE);
		add(existing);

		// Add Radio Buttons For Existing Account
		existYes = new JRadioButton("Yes");
		existYes.setBounds(270, 520,120, 20);
		existYes.setBackground(Color.WHITE);
		existYes.setForeground(Color.BLACK);
		add(existYes);
		existNo = new JRadioButton("No");
		existNo.setBounds(390, 520,130, 20);
		existNo.setBackground(Color.WHITE);
		existNo.setForeground(Color.BLACK);
		add(existNo);

		// Code for selecting only one radio button either Yes or No -->
		// solution :- grouping them.
		ButtonGroup statusGroup = new ButtonGroup();
		statusGroup.add(existYes);
		statusGroup.add(existNo);

		// Page No.
		JLabel pNo = new JLabel("Page 2");
		pNo.setBounds(550, 50, 200, 80);
		pNo.setFont(new Font("Osward", Font.BOLD, 15));
		pNo.setForeground(Color.WHITE);
		add(pNo);

		// Next Button
		next = new JButton("Next");
		next.setBackground(new Color(70, 80, 90));
		next.setForeground(Color.WHITE);
		next.setBounds(590, 625, 80, 30);
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

		String formNo = "" + formNum;
		String religion = (String) religionDrop.getSelectedItem();
		String category = (String) categoryDrop.getSelectedItem();
		String income = (String) incomeDrop.getSelectedItem();
		String education = (String) eduDrop.getSelectedItem();
		String occupation = (String) occuDrop.getSelectedItem();

		String snrCitizen = null;
		if (snrYes.isSelected()) {
			snrCitizen = "Yes";
		} else if (snrNo.isSelected()) {
			snrCitizen = "No";
		}

		String pan = panText.getText();
		String adhar = adharText.getText();

		String existingAccount = null;
		if (existYes.isSelected()) {
			existingAccount = "Yes";
		} else if (existNo.isSelected()) {
			existingAccount = "No";
		}

		
		try {
			if (pan.equals("") || adhar.equals("")) {
				JOptionPane.showMessageDialog(null, "Aadhaar or Pan can't be Empty");
			} else {
				Connect con = new Connect();
				String query = "insert into register_two values('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+snrCitizen+"','"+pan+"','"+adhar+"','"+existingAccount+"')";
				con.s.executeUpdate(query);
				
				setVisible(false);
				new RegisterPageThree(formNo).setVisible(true);
				
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RegisterPageTwo("");
	}

}
