package Pirncipal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
public static void main (String [] args) throws ClassNotFoundException  {
	Connection con;
	Class.forName("com.mysql.jdbc.Driver");
	String jdbs= "jdbc:mysql://localhost:3306/sakila";

	try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usal", "root", "password");

System.out.println("Estoy dentro");
	}
	catch (SQLException e) {
		e.printStackTrace();
	}

}
}

