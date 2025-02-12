package com.example.SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLInjection {

	/**
	 * SQLInjection
	 */
	public static List<String> getUserNames(final String sqlForUsernames) {
		Connection conn = null;
		List<String> usernameList = null;
		try {
			conn = DriverManager.getConnection("", "", "");
			String sql = "SELECT username FROM User WHERE id ='" + sqlForUsernames + "'";
			Statement statement = conn.createStatement();
			final ResultSet rset = statement.executeQuery(sql);
			// String sql = "SELECT username FROM User WHERE  id = ?";
			// PreparedStatement pstatement = conn.prepareStatement(sql);
			// pstatement.setString(1, sqlForUsernames);
			// final ResultSet rset = pstatement.executeQuery();
			if (rset != null) {
				usernameList = new ArrayList<String>();
				while (rset.next()) {
					usernameList.add(rset.getString("username"));
				}
			}
		} catch (final Exception ex) {
			// ex.printStackTrace();
		//  }finally {
		//  	if (conn != null ) {
		//  		try {
		//  			conn.close();
		//  		} catch (SQLException e) {
		//  			e.printStackTrace();
		//  		}
		//  	}
		}
		return usernameList;
		
	}

}
