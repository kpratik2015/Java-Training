package com.pratik.training.threading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

class Connection {
	
	public Connection() {
		// TODO Auto-generated constructor stub

	}
	
	
	
}

class ConnectionPool {
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(connection);
		result = prime * result + ((semaphore == null) ? 0 : semaphore.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConnectionPool other = (ConnectionPool) obj;
		if (!Arrays.equals(connection, other.connection))
			return false;
		if (semaphore == null) {
			if (other.semaphore != null)
				return false;
		} else if (!semaphore.equals(other.semaphore))
			return false;
		return true;
	}

	Semaphore semaphore = new Semaphore(5);
	Connection[] connection = new Connection[5];
	static Map<Integer, Integer>busyFree;
	
	public ConnectionPool() {
		// TODO Auto-generated constructor stub
		for(int i = 4 ; i >= 0 ; i--) {
			connection[i] = new Connection();
			busyFree = new HashMap<>();
			busyFree.put(i, 0);
		}
	}
	
	public Connection getConnection() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) { }
		int index = 0;
		for(int i : busyFree.keySet()) {
			if(busyFree.get(i) == 0) {
				index = i;
				busyFree.put(index, 1);
				break;
			}
				
		}
		return connection[index];
	}
	
	public void closeConnection(Connection c) {
		int index = 0;
		for(int i : busyFree.keySet()) {
			if(busyFree.get(i) == 1) {
				busyFree.put(i, 0);
				break;
			}
			
		}
		
		semaphore.release();
	}
	
}

public class SempahoreDemo {
	
	public static void main(String[] args) {
		ConnectionPool cPool = new ConnectionPool();
		
		Runnable r = () -> {
			Connection c = cPool.getConnection();
			System.out.println(c);
//			System.out.println("Thread ID: " + Thread.currentThread().getId());
			try { Thread.sleep(5000); } catch(Exception e) { }
			cPool.closeConnection(c);
		};
		
		for(int i = 0 ; i < 10 ; i++) { 
			new Thread(r).start();
		}
		
		
	}
	
}
