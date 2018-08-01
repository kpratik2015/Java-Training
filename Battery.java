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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batteryNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Battery other = (Battery) obj;
		if (batteryNumber != other.batteryNumber)
			return false;
		return true;
	}
	
	
	
	
}
