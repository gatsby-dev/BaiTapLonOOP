package com.englishpractice.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public static Connection getConnection() throws SQLException {
		return SQLServerConnUtils.getSQLServerConnection();
	}

	public static void main(String[] args) throws SQLException {
		System.out.println("Get connection ...");
		Connection conn = ConnectionUtils.getConnection();
		System.out.println("Get connection: " + conn);
		System.out.println("Done!");
	}

}
