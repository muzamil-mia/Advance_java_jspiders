package com.jsp.ShopifyApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jsp.ShopifyApplication.dto.BuyerDTO;
import com.jsp.ShopifyApplication.dto.SellerDTO;

public class SellerDAO {

	public void createTable() {
		Connection con = DatabaseConnection.getConnection();

		try {
			Statement stm = con.createStatement();
			stm.execute(
					"create table if not exists seller(FirstName varchar(45), LastName varchar(45), Email varchar(45) primary key, Password varchar(45), Phone bigint, Address varchar(45))");
			stm.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean registerSeller(SellerDTO seller) {
		System.out.println(seller.getLastName());
		createTable();
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into seller values(?,?,?,?,?,?)");
			ps.setString(1, seller.getFirstName());
			ps.setString(2, seller.getLastName());
			ps.setString(3, seller.getEmail());
			ps.setString(4, seller.getPassword());
			ps.setLong(5, seller.getPhone());
			ps.setString(6, seller.getAddress());
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

	public SellerDTO fetchSellerByMail(String email) {
		createTable();
		Connection con = DatabaseConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from seller where email = ?");
			ps.setString(1, email);
			ResultSet res = ps.executeQuery();
			if(!res.next()) {
				return null;
			}else {
				SellerDTO seller = new SellerDTO();
				seller.setFirstName(res.getString(1));
				seller.setLastName(res.getNString(2));
				seller.setEmail(res.getString(3));
				seller.setPassword(res.getString(4));
				seller.setPhone(res.getLong(5));
				seller.setAddress(res.getString(6));
				return seller;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
