package edu.usal.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
private static Properties properties=CargarProperties();
	
private static Properties CargarProperties() {
	properties = new Properties();
	try {
		properties.load(new FileInputStream("Archivo.properties"));
		return properties;
	}
	catch(IOException e){
		IOGeneral.pritln("Error al leer el archivo properties\nMensaje: "+e.getMessage());
	}
	return null;
}
public static String getPathClientes()  {
	
	return properties.getProperty("PathCliente");
}
public static String getFileClientes() {
	return properties.getProperty("FileCliente");
}
}
