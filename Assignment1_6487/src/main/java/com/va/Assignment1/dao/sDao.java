package com.va.Assignment1.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.va.Assignment1.model.Signup;

public class sDao {
	public int registerUser(Signup su) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		String INSERT_SQL = "INSERT INTO Signup (username, userEmail, pass, preferredName, fullName) VALUES (?, ?, ?, ?, ?)";
	    int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assign2_hetapatel", "root",
				"1617")) {
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL);
            ps.setInt(1, 2);
            ps.setString(1, su.getUserName());
            ps.setString(2, su.getUserEmail());
            ps.setString(3, su.getPassword());
            ps.setString(4, su.getPreferredName());
            ps.setString(5, su.getName());
            System.out.println(ps);
            result = ps.executeUpdate();
        } catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}			
		}
	}
}