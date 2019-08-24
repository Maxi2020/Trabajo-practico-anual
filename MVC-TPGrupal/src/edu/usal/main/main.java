package edu.usal.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
public static void main (String [] args) {
	Connection con = null;
	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3310/TrabajoPracticoAnual","root","1230");
		System.out.println("Estoy dentro");

	}
	catch (SQLException e) {
		e.printStackTrace();
	}
finally {
	if(con != null) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("con close");
	}
}
}
}
