package com.englishpractice.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils {
	
	public static Connection getSQLServerConnection() throws SQLException {
        String hostname = "localhost", database = "EnglishPractice", username = "sa", password = "";
        return getSQLServerConnection(hostname, database, username, password, true);
    }
	
	public static Connection getSQLServerConnection(String hostname, String database, String username, String password, Boolean windowAuthentication) throws SQLException {
        String connectionURL = String.format("jdbc:sqlserver://%s;database=%s", hostname, database);
        return windowAuthentication ? DriverManager.getConnection(connectionURL.concat(";integratedSecurity=true;")) : DriverManager.getConnection(connectionURL, username, password);
    }
}
