package com.pratik.training.threading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class FileManager{

	static String src = "C:\\src";
	static String dest = "C:\\dest";
	
	
	public static void main(String[] args) {
		
		Path dirsrc = Paths.get(src);
		
		try {
			
			WatchService watcher = dirsrc.getFileSystem().newWatchService();
			dirsrc.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
			System.out.println("Monitoring directory for changes...");
			// listen to events
			
			while (true) {
				WatchKey watchKey = watcher.take();
				// get list of events as they occur
				List<WatchEvent<?>> events = watchKey.pollEvents();
				//iterate over events
				
				for (WatchEvent event : events) {
					WatchEvent<Path> watchEvent = castEvent(event);
					//check if the event refers to a new file created
					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
						
						Path fp = dirsrc.resolve(watchEvent.context());
						System.out.println("File Created: " + fp);
						
						new Thread(
								() -> {
									
								    try {
										copyFileWithUppercase(fp.toString(), fp.toString().replace("src", "dest"));
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								    
									
								}
								).start();
						
						
					}
					
					 watchKey.reset();
				}
			}
			
		} catch( Exception e ) {
			e.printStackTrace();
		}
		
		
	}
	
	

	static <T> WatchEvent<T> castEvent(WatchEvent<?> event) {
	    return (WatchEvent<T>)event;
	}
	
	public static void copyFileWithUppercase(String srcString, String destString) throws IOException {
		File file1 = new File(srcString);
		File file2 = new File(destString); 
		char CharCounter = 0;       
		BufferedReader in = (new BufferedReader(new FileReader(file1)));
		PrintWriter out = (new PrintWriter(new FileWriter(file2)));
		int ch;
		try {
			while ((ch = in.read()) != -1)
			{
			   if (Character.isLowerCase(ch))
			   {
			        ch=Character.toUpperCase(ch);// convert assign variable
			   }
			out.write(ch);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		in.close();
		out.close();
		file1.delete();
	}
	
}
