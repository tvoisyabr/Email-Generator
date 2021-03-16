	package com.email;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String companySuffix = ".gmail.com";
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 8;
	private String alternateEmail;
	
	//Constructor to receive first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//Call a method asking for department - return department;
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		
		//Call a method that returns random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		  email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
		  System.out.println("Your email is: " + email);
	}
	
	private String setDepartment( ) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Department codes \n1 for Sales\n2 for Development \n3 for Accounting \n0 for none \nEnter department code: ");
		int choice = scn.nextInt();
		
		if(choice == 1) {return "sales";}
		else if(choice == 2) {return "development";}
		else if(choice == 3) {return "accounting";}
		else {return "";}	
	}
	
	//Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@$%";
		char[] password = new char[length];
		for(int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public void setAlternateEmail(String altEmail) {this.alternateEmail = altEmail;}
	public void setMailboxCapacity(int capacity) {this.mailboxCapacity = capacity;}
	public void changePassword(String password) {this.password = password;}
	
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "Display Name: " + firstName + " " + lastName +
				"\nCompany email: " + email +
				"\nPassword: " + password +
				"\nMailnox capacity: " + mailboxCapacity +"mb";
	}
	

}
