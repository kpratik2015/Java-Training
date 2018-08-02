package com.pratik.training.innerclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsingLambdaWithCollections {

	
	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("Oracle");
		list.add("PHP");
		list.add("Python");
		list.add(".NET");
		list.add("JS");
		
		System.out.println("Using iterator");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		System.out.println("For loop - style 1");
		
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		
		System.out.println("For loop - style 2");
		
		for(String str : list)
			System.out.println(str);
		
		System.out.println("For each loop - lambda style");
		list.removeIf(str -> str.startsWith("J"));
		list.forEach(str -> System.out.println(str));
		
	}
	
}
