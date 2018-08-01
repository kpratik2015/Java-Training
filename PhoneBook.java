package com.pratik.training.basics;

public interface PhoneBook {

	public void add(String name, String number, String email);
	public void search(String name);
	public void displayByEntry(Entry e);
	public void displayAll();
	
}
