package com.pratik.training.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This java program copies the content of one file into another faster
 * 
 * @author katariap
 *
 */

public class FastCopyText {

	public static void main(String[] args) {
		FileReader inFile = null;
		FileWriter outFile = null;
		BufferedReader inBuffer = null;
		BufferedWriter outBuffer = null;
		try {

			inFile = new FileReader("abc.txt");
			outFile = new FileWriter("copyOfabc.txt");
			inBuffer = new BufferedReader(inFile);
			outBuffer = new BufferedWriter(outFile);

			String line = "";
			
			while(true) {
				line = inBuffer.readLine();
				if(line == null) break;
				outBuffer.write(line);
				outBuffer.newLine(); 
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
