package com.pratik.training.threading;


class Account {
	
	int acno;
	double balance;
	Account(int acno, double balance) {
		super();
		this.acno = acno;
		this.balance = balance;
	}
	

	synchronized void withdraw(double amount) {
		try {
			Thread.sleep(100);
			if(amount < balance) {
				Thread.sleep(100);
				balance -= amount;
				Thread.sleep(100);
				System.out.println("Balance left: " +balance);
			}
			else {
				System.out.println("Insufficient Balance!");
			}
		} catch (Exception e) { }
	}
}

class Transaction implements Runnable {

	Account account;
	
	Transaction(Account account) {
		// super();
		this.account = account;
	}



	@Override
	public void run() {
		account.withdraw(4500);
	}
	
}

public class SyncDemo {

	public static void main(String[] args) {
		Account acc = new Account(1111, 5500);
		Transaction tx1 = new Transaction(acc);
		Transaction tx2 = new Transaction(acc);
		Thread th1 = new Thread(tx1);
		Thread th2 = new Thread(tx2);
		th1.start();
		th2.start();
	}
	
}
