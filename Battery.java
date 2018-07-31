package com.pratik.training.basics;

public class Battery implements Cloneable {
	
	private int batteryNumber;

	public Battery() {
		
	}
	
	public Battery(int batteryNumber) {
		super();
		this.batteryNumber = batteryNumber;
	}
	
	@Override
	public String toString() {
		return "Battery [batteryNumber=" + batteryNumber + "]";
	}
	

	

	public int getBatteryNumber() {
		return batteryNumber;
	}

	public void setBatteryNumber(int batteryNumber) {
		this.batteryNumber = batteryNumber;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
