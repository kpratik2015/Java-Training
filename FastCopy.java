package com.pratik.training.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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

public class FastCopy {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
		BufferedInputStream inBuffer = null;
		BufferedOutputStream outBuffer = null;
		try {
			
			inFile = new FileInputStream("Git.zip");
			outFile = new FileOutputStream("GitCopy.zip");
			inBuffer = new BufferedInputStream(inFile);
			outBuffer = new BufferedOutputStream(outFile);
			long startTime = System.nanoTime();
			int ch = 0;
			while (true) {
				ch = inBuffer.read();
				if (ch == -1)
					break;
				outBuffer.write(ch);
			}
			long endTime = System.nanoTime();
			System.out.println("Time taken: " + (endTime - startTime));
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
