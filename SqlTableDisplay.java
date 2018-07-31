package com.pratik.training.basics;

public class SqlTableDisplay {
	
	public static void main(String[] args) {
		String[][] data = {
				{"P101", "Nokia Handset", "Some Description", "2000.0"},
				{"P102", "Samsung Handset", "Description", "20000.0"},
				{"P103", "Sony Ericsson Handset", "Again Some Description", "1500.0"},
				{"P104", "LG Handset", "No Description", "1000.0"},
		};
		
		String[] colNames = {"ID", "Name", "Description", "Price"};
		DisplayData dd = new DisplayData(data, colNames);
		dd.displayInTable();
		
	}

}
