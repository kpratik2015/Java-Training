package com.pratik.training.basics;

public class TestToy {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		/*
		 * toy obj, number passed. 5 objects created
		 */
		Toy t1 = new Toy(5);
		Toy t2 = (Toy) t1.clone();
		System.out.println(t1);
		System.out.println(t2);
		t1.getBattarr()[0].setBatteryNumber(3);
		System.out.println(t1);
		System.out.println(t2);
	}
}
