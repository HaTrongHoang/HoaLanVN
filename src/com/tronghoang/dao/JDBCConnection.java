package com.tronghoang.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getConnection() {
		final String user = "root";
		final String password = "hoang1998";
		final String url = "jdbc:mysql://localhost:3306/hoalanvn?useSSL=false";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {

			System.out.println("Error connection database " + e);
		} catch (SQLException e) {
			System.out.println("Error connection database " + e);
			e.printStackTrace();
		}
		System.out.println();
		return null;

	}

}
