package edu.usal.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClientes {
private static Properties properties;
public static String getPathClientes () throws IOException, FileNotFoundException {
	try {
		properties = new Properties();
		properties.load(new FileReader("config.properties"));
		
	}
	catch (IOException e) {
	e.printStackTrace();	
	}
	return properties.getProperty("patchCliente");
}
}
