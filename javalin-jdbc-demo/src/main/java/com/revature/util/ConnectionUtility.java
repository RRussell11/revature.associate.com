package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;
import org.postgresql.util.DriverInfo;

// The static method  interacts w/ the JDBC API to return a Connection object
public class ConnectionUtility {

	// This is a utility class which has a single static method
	// The private constructor restricts instantiation
	private ConnectionUtility() {
	}

	// Define a static method that will interact w/ the DriverManager class from the
	// JDBC API to return a Connection object
	public static Connection getConnection() throws SQLException {

		// Registered driver (postgress/driver), ( dependency / from Mvnrepository)
		// The driver allows JDBC to communicate with database
		DriverManager.registerDriver(new Driver());

		/*
		 * environment variables
		 * 
		 * + System.getenv(<environment variable name>)
		 */

		String url = System.getenv("db_url");
		url = "jdbc:postgresql://localhost:5432/postgres";
		String username = System.getenv("db_username");
		String password = System.getenv("db_password");

		// obtain a connection object by the DriverManager, getConnection() method
		Connection connection = DriverManager.getConnection(url, username, password);

		return connection;
	}

}
