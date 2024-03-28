package com.jsp.ShopifyApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.jsp.ShopifyApplication.dto.BuyerDTO;

public class BuyerDAO {
	
	public void createTable() {
		Connection con = DatabaseConnection.getConnection();

		try {
			Statement stm = con.createStatement();
			stm.execute(
					"create table if not exists buyer(FirstName varchar(45), LastName varchar(45), Email varchar(45) primary key, Password varchar(45), wallet double, Phone bigint, Address varchar(45))");
			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean registerBuyer(BuyerDTO buyer) {
		createTable();
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into buyer values(?,?,?,?,?,?,?)");
			ps.setString(1, buyer.getFirstName());
			ps.setString(2, buyer.getLastName());
			ps.setString(3, buyer.getEmail());
			ps.setString(4,buyer.getPassword());
			ps.setLong(5, buyer.getPhone());
			ps.setDouble(6, buyer.getWallet());
			ps.setString(7, buyer.getAddress());
			int rowsEffected = ps.executeUpdate();
			return rowsEffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
