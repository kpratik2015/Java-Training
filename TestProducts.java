package com.pratik.training.inheritance;

public class TestProducts {
	public static void main(String[] args) {
		
		
		
		Products p = new Toys("Toy1", "toy", 5, 100, "N/A");
		
		new Toys("Toy2","toy", 4, 200, "N/A");
		
		new Books("Book1", "book", 7, 150, "N/A");
		
		new Books("Book2", "book", 10, 70, "N/A");
		
		p.setDescription("Wow Product");
		
		System.out.println(new Products().getProduct_list());
		
		new Toys().order("Toy2", 2 , 3);
		
		new Books().order("Book1", 2);
		
		
	}
}
