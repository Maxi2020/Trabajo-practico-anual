package edu.usal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
	public static Connection getConnection() {
		
	Connection cn = null;
	String url = PropertiesUtil.getUrl();
	try {
		Class.forName(PropertiesUtil.getDriver());
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	try {
		cn=DriverManager.getConnection(url, PropertiesUtil.getUser(), PropertiesUtil.getPassword());
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return cn;

	}
}
