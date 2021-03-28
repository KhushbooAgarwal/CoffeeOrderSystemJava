package com.pack.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.bean.OrderTransaction;
import com.pack.coffee.util.MySQLConnectionManagement;

public class OrderTransactionDaoImpl implements OrderTransactionDao {

	@Override
	public int createOrderTran(int orderTranId , int orderId, int coffeeId, int addOnID)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		connection = MySQLConnectionManagement.getConnection();		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO ORDERTRANSACTION VALUES(?,?,?,?)");
		
		statement.setInt(1, orderTranId);
		statement.setInt(2, orderId);
		statement.setInt(3, coffeeId);
		statement.setInt(4, addOnID);
		
		int rows = statement.executeUpdate();
	
		connection.close();
		return rows;
	}

	@Override
	public ArrayList<OrderTransaction> getOrderTranByOrderID(int orderId)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		OrderTransaction ordersTran = null;
		ArrayList<OrderTransaction> ordTranList = new ArrayList<>();
		
		connection = MySQLConnectionManagement.getConnection();	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM ORDERTRANSACTION WHERE ORDER_ID=?");
		statement.setInt(1, orderId);
	

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			ordersTran = new OrderTransaction();
			ordersTran.setOrderTranId(resultSet.getInt(1));
			ordersTran.setOrderId(resultSet.getInt(2));
			
			ordersTran.setCoffeeId(resultSet.getInt(3));
			ordersTran.setAddOnID(resultSet.getInt(4));
		
			ordTranList.add(ordersTran);
			
		}
		connection.close(); // throwing check exception SQLException

		return ordTranList;
	}
	
	@Override
	public ArrayList<Integer> getCoffeeIdByOrderID(int orderId)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		OrderTransaction ordersTran = null;
		ArrayList<Integer> ordTranList = new ArrayList<>();
		
		connection = MySQLConnectionManagement.getConnection();		
		PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT(COFFEE_ID) FROM ORDERTRANSACTION WHERE ORDER_ID=?");
		statement.setInt(1, orderId);
	

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
				ordTranList.add(resultSet.getInt(1));
			
		}
		connection.close(); // throwing check exception SQLException

		return ordTranList;
	}
	@Override
	public ArrayList<Integer> getAddOnIdByOrderID(int orderId)
			throws ClassNotFoundException, SQLException {
		Connection connection = null;
		OrderTransaction ordersTran = null;
		ArrayList<Integer> ordTranList = new ArrayList<>();
		connection = MySQLConnectionManagement.getConnection();		
		PreparedStatement statement = connection.prepareStatement("SELECT ADDON_ID FROM ORDERTRANSACTION WHERE ORDER_ID=?");
		statement.setInt(1, orderId);
	

		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
				ordTranList.add(resultSet.getInt(1));
			
		}
		connection.close(); // throwing check exception SQLException

		return ordTranList;
	}

	@Override
	public int getMaxOrderTranId() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		int id= 0;
		
		connection = MySQLConnectionManagement.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("SELECT MAX(ORDERTRAN_ID) FROM ORDERTRANSACTION");
	
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {		
			id = resultSet.getInt(1);
			
		//	System.out.println(id);
			
		}
		connection.close(); // throwing check exception SQLException

		return id;
	}
}
