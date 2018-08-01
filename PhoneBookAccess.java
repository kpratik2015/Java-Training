package com.pratik.training.basics;

public class PhoneBookAccess {

	
	public static void main(String[] args) {
		
		PhoneBook pb = new MyPhoneBook(); // object is of class only. No object creation of interface.
		pb.add("Pratik", "7972136486", "hello@pratikkataria.com");
		pb.add("ratik", "8972136486", "ello@pratikkataria.com");
		pb.add("atik", "9972136486", "llo@pratikkataria.com");
		
		
		
		pb.displayAll();
		
		pb.search("lol");
	}
	
}
