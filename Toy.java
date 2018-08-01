package com.pratik.training.basics;

import java.util.ArrayList;

public class Toy implements Cloneable {

	private Battery[] battarr;
	private int numberOfBatteries;
	private static int count;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Toy clonedToy = (Toy) super.clone();
		Battery[] newBattArr = new Battery[battarr.length];
		for(int i = 0; i < battarr.length; i++){
			Battery battClone = (Battery) battarr[i].clone();
			newBattArr[i] = battClone;
		}
		
		clonedToy.setBattarr(newBattArr);
		return clonedToy;
	}
	
	
	public Toy() {

	}
	
	public Toy(int numberOfBatteries) {
		super();
		this.battarr = new Battery[numberOfBatteries];

		for(int i = 0; i < numberOfBatteries; i++){

			Battery b = new Battery(count++);
	
			battarr[i] = b;

		}
	}
	
	


	public Battery[] getBattarr() {
		return battarr;
	}


	public void setBattarr(Battery[] battarr) {
		this.battarr = battarr;
	}


	@Override
	public String toString() {
		ArrayList<Integer> batList = new ArrayList<Integer>();
		for(int i = 0 ; i < battarr.length ; i++) {
			batList.add(battarr[i].getBatteryNumber());
		}
		
		return "Toy [battarr=" + batList + "]";
	}


	public int getNumberOfBatteries() {
		return numberOfBatteries;
	}


	public void setNumberOfBatteries(int numberOfBatteries) {
		this.numberOfBatteries = numberOfBatteries;
	}
	
	
	
	
	
}
