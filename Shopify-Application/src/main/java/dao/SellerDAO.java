package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import dto.SellerDTO;

public class SellerDAO {

	public boolean registerSeller(SellerDTO seller) {
		Connection con = createTable();
		PreparedStatement ps = null;
		try {
			con.prepareStatement("insert into seller values(?,?,?,?,?,?)");
			ps.setString(1, seller.getFirstName());
			ps.setString(2,  seller.getLastName());
			ps.setString(2, seller.getLastName());
			ps.setString(3, seller.getEmail());
			ps.setString(4, seller.getPassword());
			ps.setLong(5, seller.getPhone());
			ps.setString(6, seller.getAddress());
			int rowsEffected = ps.executeUpdate();
			return rowsEffected > 0;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
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

	private Connection createTable() {
		Connection con = DatabaseConnection.getConnection();
		try {
			Statement stm = con.createStatement();
			stm.execute(
					"create table if not exists seller(FirstName varchar(45), lastName varChar(45), Email varChar(45) primary key, Password varchar(45), Phone bigint, Address varChar(45)) )");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
