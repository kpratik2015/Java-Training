package com.pratik.training.basics;

public class DisplayData {

	String[][]data;
	String[]colNames;
	int[] maxlen;
	
	public DisplayData() {
		
	}
	
	
	
	public DisplayData(String[][] data, String[] colNames) {
		super();
		this.data = data;
		this.colNames = colNames;
	}
	
	public String padRight(String s, int n) {
	     return String.format("%1$" + n + "s", s);  
	}

	public String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}
	
	public void maxlenCalculate() {
		maxlen = new int[colNames.length];
		for(int i = 0; i < colNames.length ; i++) {
			for(int j = 0 ; j < colNames.length ; j++) {
				if(data[j][i].length() > maxlen[i])
					maxlen[i] = data[j][i].length();
			}
		}
	}
	
	
	public void printBoundry() {
		System.out.print("+-");
		for(int i = 0 ; i < maxlen.length ; i++) {
			if( i == maxlen.length-1) {
				System.out.print(
						String.format("%"+maxlen[i]+"s", "").replace(' ', '-') + 
						"-+");
				break;
			}
				
			
			System.out.print(
					String.format("%"+maxlen[i]+"s", "").replace(' ', '-') + 
					"-+-");
		}
		System.out.println();
		
	}
	
	public void DataRow(String[][] arr) {
		for(int i = 0; i < maxlen.length ; i++) {
			
			for(int j = 0 ; j < maxlen.length ; j++) {
				System.out.print(
						"| " + arr[i][j]+ 
				
				padRight("", maxlen[j] - arr[i][j].length() + 1 ) );
			}
			
			System.out.print("|");
			System.out.println();
			
		}
	}
	
	public void ColRow(String[] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			
			System.out.print(
			"| " 
			+ arr[i] 
			+ padRight("", maxlen[i] - arr[i].length() ) 
			+ " "
			);
			
		}
		System.out.print("|");
		System.out.println();
		
	}
	
	public void displayInTable() {
		maxlenCalculate();
		printBoundry();
		ColRow(colNames);
		printBoundry();
		DataRow(data);			
		printBoundry();
	}
	
}
