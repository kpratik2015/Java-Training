package com.pratik.training.basics;

public class Entry {
	
	static int count = 0;
	String name;
	String number;
	String emailid;
	
	public Entry() {
		count++;
	}

	public Entry(String name, String number, String emailid) {
		super();
		count++;
		this.name = name;
		this.number = number;
		this.emailid = emailid;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	

}
