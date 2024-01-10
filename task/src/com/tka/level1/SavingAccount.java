package com.tka.level1;

import java.util.Scanner;

public class SavingAccount extends Bank_Account {
	static Scanner sc=new Scanner(System.in);
	double interestRate=5.15;
	 int dep;
	 int with;
	  int balance;
	 double interest;

	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SavingAccount(int accountNumber, String accountName, int balance,double interestRate) {
		super(accountNumber, accountName, balance);
		this.interestRate=interestRate;
		
	}
	public  void deposit() {
		System.out.println("Enter the amount to be deposited");
		 dep=sc.nextInt();
		System.out.println("Deposited amount:"+dep);
	}
	public  void withdraw() {
		System.out.println("Enter the amount to be withdraw");
		 with=sc.nextInt();
		System.out.println("Amount you Withdraw:"+with);
	}
	
	public  void display() {
		 //balance=dep-with;
		Bank_Account bc=new Bank_Account();
		System.out.println("Enter the account holder's name ,Account number");
		bc.setAccountName(sc.next());
		bc.setAccountNumber(sc.nextInt());
		deposit();
		withdraw();
		balance=dep-with;
		bc.setBalance(balance);
		System.out.println(bc);
		System.out.println("Current interest rate available to your saving acccount is:"+interestRate+"%");
		 interest();
		
		}
	public  void interest() {
		interest=balance+(balance*(interestRate/100));
		System.out.println("Interest on current saving is:"+interest);
	}
	public static void main(String[] args) {
		SavingAccount sc=new SavingAccount();
		
		sc.display();
		
	}

}
