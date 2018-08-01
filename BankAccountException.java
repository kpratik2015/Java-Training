package com.pratik.training.basics;

public class BankAccount {

	private int accno;
	private double balance;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(int accno, double balance) {
		super();
		this.setAccno(accno);
		this.balance = balance;
	}
	
	public double withdraw(double amount) throws BankAccountException {
		if( amount > balance ) {
			BankAccountException e = new BankAccountException("Insufficient Balance!");
			throw e;
		}
		else {
			balance -= amount;
			return balance;
		}
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}
	
	public static void main(String[] args) {
		BankAccount bankAcc = new BankAccount(100, 5000);
		
		try {
			double balance = bankAcc.withdraw(6000);
			System.out.println("Balance left: " + balance);
		} catch(BankAccountException e) {
			System.out.println(e);
		}
		
	}
	
}
