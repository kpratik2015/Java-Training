package com.pratik.training.basics;

public class BankAccountException extends Exception {

	public BankAccountException() {
		
	}

	public BankAccountException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BankAccountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BankAccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BankAccountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
