package com.pack.coffee.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Coffee;
import com.pack.coffee.dao.CoffeeDao;
import com.pack.coffee.dao.CoffeeDaoImpl;


public class CoffeeServiceImpl implements CoffeeService {
	private CoffeeDao coffeeDao =  new CoffeeDaoImpl();
	ArrayList<Coffee> coffeeList = new ArrayList<>();
	@Override
	public ArrayList<Coffee> getAllCoffeeDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return coffeeDao.getAllCoffeeDetails();
	}
	
	@Override
	public ArrayList<String> getAllCoffeeNameDetails() throws ClassNotFoundException, SQLException {
		
		return coffeeDao.getAllCoffeeNameDetails();
	}

	@Override
	public Coffee getCoffeeByNameAndSize(String coffeeName, String coffeeSize) throws ClassNotFoundException, SQLException {
		return coffeeDao.getCoffeeByNameAndSize(coffeeName, coffeeSize);
		 
	}

	@Override
	public float getPriceByCoffeeId(int coffeeId) throws ClassNotFoundException, SQLException {
		return coffeeDao.getPriceByCoffeeId(coffeeId);
	}

	@Override
	public ArrayList<String> getAllCoffeeSize() throws ClassNotFoundException, SQLException {
		return coffeeDao.getAllCoffeeSize();
	}

	@Override
	public Coffee getCoffeeDetailsById(int coffeeId) throws ClassNotFoundException, SQLException {
		return coffeeDao.getCoffeeDetailsById(coffeeId);
	}

	

}
