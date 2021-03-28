package com.pack.coffee.bean;

public class AddOn {

	private int addOnID;
	private String addOnName;
	
	private float addOnPrice;
	
public AddOn() {
		
	}

public AddOn(int addOnID, String addOnName, float addOnPrice) {
	super();
	this.addOnID = addOnID;
	this.addOnName = addOnName;
	this.addOnPrice = addOnPrice;
}

public int getAddOnID() {
	return addOnID;
}

public void setAddOnID(int addOnID) {
	this.addOnID = addOnID;
}

public String getAddOnName() {
	return addOnName;
}

public void setAddOnName(String addOnName) {
	this.addOnName = addOnName;
}

public float getAddOnPrice() {
	return addOnPrice;
}

public void setAddOnPrice(float addOnPrice) {
	this.addOnPrice = addOnPrice;
}



}
