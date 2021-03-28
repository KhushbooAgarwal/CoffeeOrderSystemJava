package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pack.coffee.bean.Customers;
import com.pack.coffee.util.MySQLConnectionManagement;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int addCustomer(int custId,String custName, long phoneNum) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("INSERT INTO CUSTOMERS VALUES(?,?,?)");
		statement.setInt(1, custId);
		statement.setString(2, custName);
		statement.setLong(3, phoneNum);
		
		int rows = statement.executeUpdate();
	
		connection.close();
		return rows;
	}
	
	@Override
	public Customers getCustomerByPhone(long phoneNum) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Customers customer = null;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM CUSTOMERS WHERE PHONE_NUMBER=?");
		statement.setLong(1, phoneNum);
	

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			customer = new Customers();
			customer.setCustomerID(resultSet.getInt(1));
			customer.setCustomerName(resultSet.getString(2));
			customer.setPhoneNumber(resultSet.getLong(3));
		
			
		}
		connection.close(); 

		return customer;
	}

	@Override
	public int getMaxCustomer() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		int id= 0;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT MAX(CUSTOMER_ID) FROM CUSTOMERS");
	
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {		
			id = resultSet.getInt(1);
			
	//		System.out.println(id);
			
		}
		connection.close(); // throwing check exception SQLException

		return id;
	}

	@Override
	public int checkCustomer(long phoneNum) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		int id= 0;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT CUSTOMER_ID FROM CUSTOMERS WHERE PHONE_NUMBER=?");
		statement.setLong(1, phoneNum);
	
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {		
			id = resultSet.getInt(1);
			
		//	System.out.println(id);
			
		}
		connection.close(); // throwing check exception SQLException

		return id;
	}

	@Override
	public Customers getCustomerId(String custName, long phoneNum) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Customers customer = null;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM CUSTOMERS WHERE CUSTOMER_NAME= ? and PHONE_NUMBER=?");
		statement.setString(1, custName);
		statement.setLong(2, phoneNum);
	

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			customer = new Customers();
			customer.setCustomerID(resultSet.getInt("customer_id"));
			customer.setCustomerName(resultSet.getString("customer_name"));
			customer.setPhoneNumber(resultSet.getLong("phone_number"));
		
			//System.out.println("LLLLLLLLLLL"+customer.getCustomerID());
		}
		connection.close(); 

		return customer;
	}
	
	@Override
	public String getCustomerName(int custId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		String custName=null;

		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT CUSTOMER_NAME FROM CUSTOMERS WHERE CUSTOMER_ID= ?");
		statement.setInt(1, custId);
	

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			custName=resultSet.getString(1);
		
		}
		connection.close(); 

		return custName;
	}


}
