package edu.usal.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClientes {
private static Properties properties;
public static String getPathClientes () throws IOException, FileNotFoundException {
	try {
		properties = new Properties();
		FileInputStream fileInput= new FileInputStream("Archivo.properties");
		properties.load(fileInput);
        fileInput.close();
	}
	catch (IOException e) {
	e.printStackTrace();	
	}
	return properties.getProperty("pathCliente");
}
}
