package com.mphasis.shopping1.demo;

public class Disc extends Product {
	private int Capacity;

//Parameterized constructor
    public Disc(String productId, String productName, double price, String format) {
        super(productId, productName, price);
        this.Capacity = Capacity;
    }

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {	
		this.Capacity = capacity;
	}
    
	
}