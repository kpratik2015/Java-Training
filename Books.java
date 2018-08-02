package com.pratik.training.inheritance;

public class Books extends Products {

	final double BOOKS_DISC = 0.10; 
	
	public Books() {
		// TODO Auto-generated constructor stub
	}
	
	public Books(String product_name, String type, int stock, int price, String description) {
		super();
		this.id = count;
		this.product_name = product_name;
		this.type = type;
		this.stock = stock;
		this.price = price;
		this.description = description;
		product_list.add(this);
	}
	
	public Books(String name, int stock) {
		super();
		this.id = count;
		this.product_name = name;
		this.stock = stock;
		product_list.add(this);
	}
	
	@Override
	public double discount(int age) {
		return BOOKS_DISC;
	}
}
