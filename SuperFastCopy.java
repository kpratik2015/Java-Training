package com.pratik.training.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * This java program copies the content of one file into another faster
 * 
 * @author katariap
 *
 */

public class SuperFastCopy {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
		
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		
		ByteBuffer buffer = null; // Only one buffer is required
 		
		try {

			buffer = ByteBuffer.allocateDirect(1024 * 16); // 16 kb
			inFile = new FileInputStream("Git.zip");
			outFile = new FileOutputStream("GitCopy.zip");
			inChannel = inFile.getChannel();
			outChannel = outFile.getChannel();
			long startTime = System.nanoTime();

			while(true) {
			
				int count = inChannel.read(buffer);
				if(count == -1) break;
				buffer.flip(); // moving cursor of buffer to start so that write can be performed
				outChannel.write(buffer);
				buffer.clear();
				
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
				inChannel.close();
				inFile.close();
			} catch (Exception e) {
			} // first close buffer and then close file. Buffer needs to be flushed first from
				// memory
			try {
				outChannel.close();
				outFile.close();
			} catch (Exception e) {
			}
		}
	}

}
