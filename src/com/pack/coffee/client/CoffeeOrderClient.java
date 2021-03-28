package com.pack.coffee.client;

import com.pack.coffee.persentation.CoffeePersentation;
import com.pack.coffee.persentation.CoffeePersentationImpl;

public class CoffeeOrderClient {

	public static void main(String[] args) {
		
CoffeePersentation coffee=new CoffeePersentationImpl();
		coffee.checkCustomer();
		coffee.showCoffee();
	}
}
