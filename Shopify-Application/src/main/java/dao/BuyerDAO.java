package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BuyerDTO;

public class BuyerDAO {
	private Connection createTable() {
		Connection con = DatabaseConnection.getConnection();

		try {
			Statement stm = con.createStatement();
			stm.execute(
					"create table if not exists buyer(FirstName varchar(45), lastName varChar(45), Email varChar(45) primary key, Password varchar(45), Wallet double, Phone bigint, Address varChar(45)) )");
			stm.close();
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return con;
	}

	public boolean registeBuyer(BuyerDTO buyer) {
		Connection con = createTable();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("insert into buyer values(?,?,?,?,?,?,?)");
			ps.setString(1, buyer.getFirstName());
			ps.setString(2, buyer.getLastName());
			ps.setString(3, buyer.getEmail());
			ps.setString(4, buyer.getPassword());
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
