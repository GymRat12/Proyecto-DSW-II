package com.cibertec.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

	public Connection getConnection() {
		Connection cn = null;
		
		//change credentials
		final String username = "JeancaDeve"; 
		final String password = "Kevicho_5593";
		final String urlConnection = "jdbc:mysql://localhost:3306/db_muebles?characterEncoding=latin1&createDatabaseIfNotExist=true&serverTimezone=UTC";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			cn = DriverManager.getConnection(urlConnection, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}

}