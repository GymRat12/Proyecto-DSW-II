package com.cibertec.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

	
	public Connection getConnection() {
		Connection cn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/laboratoriot2?characterEncoding=latin1",
					"cibertec","DavalosSanchez12*");
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return cn;
	}
	
}
