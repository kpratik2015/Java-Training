package com.pratik.training.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {
	
	public static void main(String[] args) {
		FileReader inFile = null;
		FileWriter outFile = null;
		BufferedReader inBuffer = null;
		BufferedWriter outBuffer = null;
		try {

			inFile = new FileReader("links.txt");
			outFile = new FileWriter("linksOutput.txt");
			inBuffer = new BufferedReader(inFile);
			outBuffer = new BufferedWriter(outFile);

			String line = "";
//			List<String> linkList = new ArrayList<>();
			Set<String> linkHash = new HashSet<>();
			
			while(true) {
				line = inBuffer.readLine();
				if(line == null) break;
//				if(!linkList.contains(line)) {
//					linkList.add(line);
//					outBuffer.write(line);
//					outBuffer.newLine();	
//				}
				if(linkHash.add(line)) {
					outBuffer.write(line);
					outBuffer.newLine();	
				}
				 
			}
			
			System.out.println("File copied successfully");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Please check the no. of your glasses!");
		} catch (IOException ioe) {
			System.out.println("Please bang the hdd on the floor once and try again!");
		} finally {
			try {
				inBuffer.close();
				inFile.close();
			} catch (Exception e) {
			} // first close buffer and then close file. Buffer needs to be flushed first from
				// memory
			try {
				outBuffer.close();
				outFile.close();
			} catch (Exception e) {
			}
		}
	}

}
