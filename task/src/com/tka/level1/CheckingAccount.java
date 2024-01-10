package com.tka.level1;

import java.util.Scanner;

public class CheckingAccount extends Bank_Account{
	static Scanner sc=new Scanner(System.in);
int overDraftLimit=10000;
int dep;
int with;
 int balance;
 double overDraftAmount;


public CheckingAccount() {
	super();
	// TODO Auto-generated constructor stub
}

public CheckingAccount(int accountNumber, String accountName, int balance) {
	super(accountNumber, accountName, balance);
	// TODO Auto-generated constructor stub
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
	Bank_Account bc=new Bank_Account();
	System.out.println("Enter the account holder's name ,Account number");
	bc.setAccountName(sc.next());
	bc.setAccountNumber(sc.nextInt());
	deposit();
	withdraw();
	balance=dep-with;
	bc.setBalance(balance);
	System.out.println(bc);
	System.out.println("Over Draft limit is:"+overDraftLimit);
	overdraft();
}
public  void overdraft() {
	overDraftAmount=balance+overDraftLimit;
	System.out.println("Maximum amount you can withdraw is:"+overDraftAmount);
}
public static void main(String[] args) {
	CheckingAccount ca=new CheckingAccount();
	ca.display();
}

}
