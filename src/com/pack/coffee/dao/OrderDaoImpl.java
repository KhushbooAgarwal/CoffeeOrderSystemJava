package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;



import com.pack.coffee.bean.Orders;
import com.pack.coffee.util.MySQLConnectionManagement;

public class OrderDaoImpl implements OrderDao {
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	@Override
	public int CreateOrder(int orderId,int customerId, String orderDate, int voucherId)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("INSERT INTO ORDERS VALUES(?,?,?)");
	
		statement.setInt(1, orderId);
		statement.setInt(2, customerId);
		statement.setDate(3, getCurrentDate());
		//statement.setInt(4, voucherId);
		
		int rows = statement.executeUpdate();
	
		connection.close();
		return rows;
	}

	@Override
	public Orders getOrderByCustid(int customerId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Orders orders = null;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM ORDERS WHERE CUSTOMER_ID=?");
		statement.setInt(1, customerId);
	

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			orders = new Orders();
			orders.setCustomerId(resultSet.getInt(1));
			orders.setOrderDate(resultSet.getDate(2));
			orders.setVoucherID(resultSet.getInt(3));
		
			
		}
		connection.close(); // throwing check exception SQLException

		return orders;
	}
	@Override
	public int getMaxOrderId() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		int id= 0;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT MAX(ORDER_ID) FROM ORDERS");
	
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {		
			id = resultSet.getInt(1);
			
		//	System.out.println(id);
			
		}
		connection.close(); // throwing check exception SQLException

		return id;
	}

	@Override
	public boolean isOrderIsPresent(int orderId) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		int id= 0;
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT ORDER_ID FROM ORDERS WHERE ORDER_ID =?");
		statement.setInt(1, orderId);
		
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {		
			id = resultSet.getInt(1);
			
			System.out.println(orderId);
			
		}
		connection.close(); 
		if(id!=0)
			return true;
		else 
			return false;
		

	}


}
