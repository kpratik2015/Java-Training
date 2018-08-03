package com.pratik.training.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This java program copies the content of one file into another
 * @author katariap
 *
 */

public class Copy {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
//		FileReader inFile = null;
//		FileWriter outFile = null;
		try {
			
			inFile = new FileInputStream("Git.zip");
			outFile = new FileOutputStream("GitCopy.zip");
//			inFile = new FileReader("Desert.jpg"); // reads 2 bytes at one go. However jpg is not text so corruption
//			outFile = new FileWriter("DesertCopy.jpg");
			
			int ch = 0;
			while(true) {
				ch = inFile.read();
				if(ch == -1) break;
				outFile.write(ch);
			}
			System.out.println("File copied successfully");
		} catch (FileNotFoundException fnfe) {
			System.out.println("Please check the no. of your glasses!");
		} catch (IOException ioe) {
			System.out.println("Please bang the hdd on the floor once and try again!");
		} 
		finally {
			try { inFile.close(); } catch(Exception e) {}
			try { outFile.close(); } catch(Exception e) {}
		}
	}
	
}
