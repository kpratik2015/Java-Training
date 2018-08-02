package com.pratik.training.innerclass;

@FunctionalInterface
interface Printer {
	void print(String document);
}


class DotMatrixPrinter implements Printer {
	@Override
	public void print(String document) {
		System.out.println("Code to print the " + document);
	}
}

class WordApplication {

	/*
	 * This code is not highly re-usable. 
	 * It is not worth writing in separate file and sharing with others.
	 * Basically its usability is less.
	 */
	
	class InbuiltPrinter implements Printer {
		/*
		 * Innerclass can be a public class.
		 * Why this innerclass? Because logically WordApplication is not a printer.
		 * That is, there is no IS-A relation with Printer for WordApplication.	
		 */
		@Override
		public void print(String document) {
			System.out.println("Code to print the " + document);
		}
	}

	
}

public class InnerClassesAndLambda {
	
	public static void main(String[] args) {
		
		// Innerclass
		class InkjetPrinter implements Printer {
			@Override
			public void print(String document) {
				System.out.println("Code to print the " + document);
			}
		}
		
		InkjetPrinter ip = new InkjetPrinter();
		ip.print("abc.txt");
		
		// Anonymous Inner Class
		Printer p = new Printer() { // Writing a class that implements Printer interface
			public void print(String document) {
				System.out.println("Code to print the " + document);
			}
		};
		p.print("xyz.txt");
		
		// Lamba Style - anonymous functions/methods
		// Lambda style can only be used with interfaces having one method
		Printer pr = (String document) -> {
			System.out.println("Code to print the " + document);
		};
		// OR
		// Printer pr = (String document) -> System.out.println("Code to print the " + document);
		// OR
		// Printer pr = d -> System.out.println("Code to print the " + d);
		pr.print("ai.txt");
	}
	
}
