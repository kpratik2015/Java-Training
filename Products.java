package com.pratik.training.inheritance;

import java.util.ArrayList;

public class Products extends Inventory{
	
	protected String product_name;
	protected int id;
	protected static int count;
	protected String type = "N/A";
	protected int stock = 0;
	protected int price = 0;
	protected String description = "N/A";
	
	
	public ArrayList<Products> getProduct_list() {
		return product_list;
	}


	public Products(String name, int stock) {
		super();
		this.id = count;
		count++;
		this.product_name = name;
		this.stock = stock;
		product_list.add(this);
	}
	
	
	
	public Products(String product_name, String type, int stock, int price, String description) {
		super();
		this.id = count;
		count++;
		this.product_name = product_name;
		this.type = type;
		this.stock = stock;
		this.price = price;
		this.description = description;
		product_list.add(this);
	}

	public Products() {
		count++;
	}


	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Products search(String name) {
		for(Products p : product_list) {
			if(p.getProduct_name().equals(name)) {
				return p;
			}
		}
		
		return null;
	}

	@Override
	public String toString() {
		return "Products [id="+id+", product_name=" + product_name + ", type=" + type + ", stock=" + stock + ", price=" + price
				+ ", description=" + description + "]\n";
	}

	public double discount(int age) {
		return 1.0;
	}
	
	public void order(String name, int qty) {
		if(search(name).getStock() < qty) {
			System.out.println("Stock not sufficient");
		} else {
			System.out.println("BILL:" );
			System.out.println(name + "\t" + qty * search(name).getPrice());
		}
	}
	
}
