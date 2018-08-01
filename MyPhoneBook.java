package com.pratik.training.basics;

import java.util.*;
import static com.pratik.training.basics.Entry.count;
/*
 * Develop a phonebook where we will be storing the name, number and
 * email address of our friends, etc.
 * 
 */
public class MyPhoneBook implements PhoneBook {
	
	private String name;
	private ArrayList<Entry> entries;
	private String[] colNames;
	
	public MyPhoneBook() {
		this.setName("My PhoneBook");
		this.entries = new ArrayList<Entry>(100);
		this.colNames = new String[] {"Name", "Number", "Email"};
	}
	
	public MyPhoneBook(String name, int noOfEntries) {
		this.setName(name);
		this.entries = new ArrayList<Entry>(noOfEntries);
	}
	
	@Override
	public void add(String name, String number, String email) {
		this.entries.add(new Entry(name, number, email));
	}
	
	@Override
	public void search(String name){
		boolean flag = false;
		for(Entry s : entries){
	        if(s.getName() != null && s.getName().equals(name)){
	        	System.out.println("Entry Found:");
	        	displayByEntry(s);
	        	flag = true;
	        }
		}
		if( !flag ) System.out.println("No Entry Found!");
	}
	
	@Override
	public void displayByEntry(Entry e) {
		System.out.println(e.getName()+"\t"+e.getNumber()+"\t"+e.getEmailid());
	}
	
	@Override
	public void displayAll() {

		String[][] data = new String[count][colNames.length];
		
		for(int i = 0 ; i < count ; i++) {
			data[i][0] = entries.get(i).getName();
			data[i][1] = entries.get(i).getNumber();
			data[i][2] = entries.get(i).getEmailid();
		}
		
		DisplayData stb = new DisplayData(data, colNames);
		stb.displayInTable();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
