package com.pratik.training.basics;

public class TestPerson {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person("Pratik", 22);
		System.out.println(p1); // println is calling valueOf and valueOf is calling toString
	
		Person p2 = new Person("Pratik", 22);
		
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		Person p3 = (Person) p1.clone(); // clone() is protected. It is only available to subclasses. We can call it from inside person class. We cannot create object here and call it.
		
		System.out.println(p3);
		
		p1 = p2 = null; // eligible for garbage collection provided no one else is pointing to it. Still only if garbage collection is called.
		
		System.gc();
		
		/*
		 * Shallow copies references for object. 
		 */
		
		Address addr = new Address(400083, "Mumbai");
		
		Person p4 = new Person("Pat", 22, addr);
		
		Person p5 = (Person) p4.clone();
		
		System.out.println(p4.getAddress().getCity()); // Mumbai
		System.out.println(p5.getAddress().getCity()); // Mumbai
		
		p5.getAddress().setCity("Pune");
		
		System.out.println(p4.getAddress().getCity()); // Pune if shallow copy. Mumbai if deep copy
		System.out.println(p5.getAddress().getCity()); // Pune 
			
		
		
		
	}

}
