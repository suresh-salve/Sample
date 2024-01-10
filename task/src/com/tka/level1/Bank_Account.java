package com.tka.level1;

public class Bank_Account {
int accountNumber;
String accountName;
int balance;

public Bank_Account() {
	super();
	// TODO Auto-generated constructor stub
}
public Bank_Account(int accountNumber, String accountName, int balance) {
	super();
	this.accountNumber = accountNumber;
	this.accountName = accountName;
	this.balance = balance;
}
public int getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}
public String getAccountName() {
	return accountName;
}
public void setAccountName(String accountName) {
	this.accountName = accountName;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
@Override
public String toString() {
	return "Bank_Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
			+ "]";
}
}
