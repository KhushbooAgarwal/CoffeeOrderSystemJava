package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.Coffee;
import com.pack.coffee.util.MySQLConnectionManagement;

public class CoffeeDaoImpl implements CoffeeDao {

	@Override
	public ArrayList<Coffee> getAllCoffeeDetails() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		ArrayList<Coffee> coffeeList = new ArrayList<>();

		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM COFFEE ORDER BY COFFEE_NAME");

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			Coffee coffee =  new Coffee();
			coffee.setCoffeeId(resultSet.getInt(1));
			coffee.setCoffeeName(resultSet.getString(2));
			coffee.setCoffeeSize(resultSet.getString(3));
			coffee.setCoffeePrice(resultSet.getFloat(4));
			
			coffeeList.add(coffee);
		}
		connection.close();
		return coffeeList;
		
	}
	
	@Override
	public ArrayList<String> getAllCoffeeNameDetails() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		ArrayList<String> coffeeNameList = new ArrayList<>();

		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT(COFFEE_NAME) FROM COFFEE");

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {

		//	Coffee coffee = new Coffee();
		//	coffee.setCoffeeId(resultSet.getInt(1));
	
			coffeeNameList.add(resultSet.getString(1));
		}
		connection.close();
		return coffeeNameList;
	}

	@Override
	public Coffee getCoffeeByNameAndSize(String coffeeName, String coffeeSize)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Coffee coffee = null;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM COFFEE WHERE COFFEE_NAME=? AND COFFEE_SIZE=?");
		statement.setString(1, coffeeName);
		statement.setString(2, coffeeSize);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			coffee = new Coffee();
			coffee.setCoffeeId(resultSet.getInt(1));
			coffee.setCoffeeName(resultSet.getString(2));
			coffee.setCoffeeSize(resultSet.getString(3));
			coffee.setCoffeePrice(resultSet.getFloat(4));
			
		}
		connection.close(); // throwing check exception SQLException

		return coffee;
	
	}
	
	@Override
	public float getPriceByCoffeeId(int coffeeId)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Coffee coffee = null;
		float price= 0f;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT COFFEE_PRICE FROM COFFEE WHERE COFFEE_ID=?");
		statement.setInt(1, coffeeId);
		
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			price = resultSet.getFloat(1);
			
		}
		connection.close(); // throwing check exception SQLException

		return price;
	
	}

	@Override
	public ArrayList<String> getAllCoffeeSize() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		ArrayList<String> coffeeList = new ArrayList<>();

		connection = MySQLConnectionManagement.getConnection();		
		PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT(COFFEE_SIZE) FROM COFFEE");

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {

	
			coffeeList.add(resultSet.getString(1));
		}
		connection.close();
		return coffeeList;
	}

	@Override
	public Coffee getCoffeeDetailsById(int coffeeId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Coffee coffee = null;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM COFFEE WHERE COFFEE_ID=?");
		statement.setInt(1, coffeeId);
	
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			coffee = new Coffee();
			coffee.setCoffeeId(resultSet.getInt(1));
			coffee.setCoffeeName(resultSet.getString(2));
			coffee.setCoffeeSize(resultSet.getString(3));
			coffee.setCoffeePrice(resultSet.getFloat(4));
			
		}
		connection.close(); // throwing check exception SQLException

		return coffee;
	}

	

}
