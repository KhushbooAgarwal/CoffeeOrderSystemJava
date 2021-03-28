package com.pack.coffee.bean;

public class Coffee {
	
	private int coffeeId;
	private String coffeeName;
	private String coffeeSize;
	private float coffeePrice;
	
	
	public Coffee() {
		
	}


	public Coffee(int coffeeId, String coffeeName, String coffeeSize, float coffeePrice) {
		super();
		this.coffeeId = coffeeId;
		this.coffeeName = coffeeName;
		this.coffeeSize = coffeeSize;
		this.coffeePrice = coffeePrice;
	}


	public int getCoffeeId() {
		return coffeeId;
	}


	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}


	public String getCoffeeName() {
		return coffeeName;
	}


	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}


	public String getCoffeeSize() {
		return coffeeSize;
	}


	public void setCoffeeSize(String coffeeSize) {
		this.coffeeSize = coffeeSize;
	}


	public float getCoffeePrice() {
		return coffeePrice;
	}


	public void setCoffeePrice(float coffeePrice) {
		this.coffeePrice = coffeePrice;
	}
	
	
	
}
