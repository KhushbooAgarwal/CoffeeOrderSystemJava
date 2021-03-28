package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.AddOn;
import com.pack.coffee.bean.Coffee;
import com.pack.coffee.util.MySQLConnectionManagement;

public class AddOnDaoImpl implements AddOnDao {

	@Override
	public ArrayList<AddOn> getAllAddOn() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		ArrayList<AddOn> addOnList = new ArrayList<>();

		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM ADDON");

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {

			AddOn addOn = new AddOn();
			addOn.setAddOnID(resultSet.getInt(1));
			addOn.setAddOnName(resultSet.getString(2));
			addOn.setAddOnPrice(resultSet.getFloat(3));
			

			addOnList.add(addOn);
		}
		connection.close();
		return addOnList;
		
	}
	

	
	@Override
	public AddOn getAddOnByName(String addOnName) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		AddOn addOn = null;
		float price= 0f;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM ADDON WHERE AddOn_Name=?");
		statement.setString(1, addOnName);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			addOn = new AddOn();
			addOn.setAddOnID(resultSet.getInt(1));
			addOn.setAddOnName(resultSet.getString(2));
			addOn.setAddOnPrice(resultSet.getFloat(3));
			
		}
		connection.close(); // throwing check exception SQLException

		return addOn;
	
	}

	@Override
	public float getAddOnIdByName(int addOnId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
			float price= 0f;
		
			connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT ADDON_PRICE FROM ADDON WHERE AddOn_ID=?");
		statement.setInt(1, addOnId);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			price = resultSet.getFloat(1);
			
		}
		connection.close(); // throwing check exception SQLException

		return price;
	
	}

	@Override
	public float getAddOnPriceById(int addOnId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
			float price= 0f;
		
			connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT ADDON_PRICE FROM ADDON WHERE AddOn_ID=?");
		statement.setInt(1, addOnId);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			price = resultSet.getFloat(1);
			
		}
		connection.close(); // throwing check exception SQLException

		return price;
	
	}



	@Override
	public AddOn getAddOnDetailsById(int addOnId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		AddOn addOn = null;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM ADDON WHERE AddOn_ID=?");
		statement.setInt(1, addOnId);
	
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			addOn = new AddOn();
			addOn.setAddOnID(resultSet.getInt(1));
			addOn.setAddOnName(resultSet.getString(2));
			addOn.setAddOnPrice(resultSet.getFloat(3));
			
			
		}
		connection.close(); // throwing check exception SQLException

		return addOn;
	
	}
}
