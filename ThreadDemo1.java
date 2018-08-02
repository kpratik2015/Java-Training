package com.pratik.training.threading;

public class ThreadDemo1 {
	
	class Task1 implements Runnable {

		@Override
		public void run() {
			for(int i = 0 ; i < 100000 ; i++)
				System.out.println("i is: " + i);
		}
		
	}
	
	class Task2 implements Runnable {

		@Override
		public void run() {
			for(int j = 0 ; j < 100000 ; j++)
				System.out.println("j is: " + j);
		}
		
	}
	
 
	
	Runnable Task3 = () -> {
		for(int k = 0 ; k < 100000 ; k++)
			System.out.println("k is: " + k);
	};
	
	void launch() {
		Thread th1 = new Thread(new Task1());
		Thread th2 = new Thread(new Task2());
		Thread th3 = new Thread(Task3);
		th1.setPriority(1);
		th2.setPriority(5);
		th3.setPriority(10); // Doesn't guarantee that th3 will finish first
		
		th1.start(); // run method is called internally
		th2.start();
		th3.start();
		
//		new Thread(
//			() -> {
//				for(int l = 0 ; l < 10000 ; l++)
//					System.out.println("l is: " + l);
//			}
//		).start();
	
	}
	
	public static void main(String[] args) {
		new ThreadDemo1().launch();
	}
	

}
