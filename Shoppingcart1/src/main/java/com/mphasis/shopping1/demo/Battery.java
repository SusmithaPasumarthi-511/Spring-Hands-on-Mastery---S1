package com.mphasis.shopping1.demo;

public class Battery extends Product {
	    private boolean Rechargeable;
	    
// Parameterized constructor
	    public Battery(String productId, String productName, double price, int capacity) {
	        super(productId, productName, price);
	        this.Rechargeable = Rechargeable;
	    }

		public boolean isRechargeable() {
			return Rechargeable;
		}

		public void setRechargeable(boolean rechargeable) {
			this.Rechargeable  = rechargeable;
		}
	    
	    // Getter and setter for capacity
	   
	}