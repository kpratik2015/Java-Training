package com.pratik.training.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) throws Exception {
		
		FileOutputStream fout = new FileOutputStream("emp.dat");
		ObjectOutputStream serializer = new ObjectOutputStream(fout);
		
		Employee emp = new Employee(100, "Pratik", 1000);
		
		serializer.writeObject(emp);
		
		serializer.close();
		
		fout.close();
		
		FileInputStream fin = new FileInputStream("emp.dat");
		ObjectInputStream deserializer = new ObjectInputStream(fin);
		
//		System.out.println(deserializer.getClass());
		
		Employee emp1 = (Employee) deserializer.readObject();
		
		System.out.println(emp1); // override toString
		
		deserializer.close();
		fin.close();
		
	}
	
}
