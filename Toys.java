package com.pratik.training.inheritance;

public class Toys extends Products {
	
	public Toys() {
		// TODO Auto-generated constructor stub
	}
	
	public Toys(String product_name, String type, int stock, int price, String description) {
		super();
		this.id = count;
		this.product_name = product_name;
		this.type = type;
		this.stock = stock;
		this.price = price;
		this.description = description;
		product_list.add(this);
	}
	
	public Toys(String name, int stock) {
		super();
		this.id = count;
		this.product_name = name;
		this.stock = stock;
		product_list.add(this);
	}
	
	@Override
	public double discount(int age) {
		if( age >= 2 && age <= 4) 
			return 0.15;
		else if(age >=4 && age <= 5)
			return 0.05;
		
		return super.discount(age);
	}
	
	public void order(String name, int qty, int age) {
		if(search(name).getStock() < qty) {
			System.out.println("Stock not sufficient");
		} else {
			System.out.println("BILL:" );
			System.out.println(name + "\t" + qty * (search(name).getPrice() * discount(age)));
		}
	}
}
