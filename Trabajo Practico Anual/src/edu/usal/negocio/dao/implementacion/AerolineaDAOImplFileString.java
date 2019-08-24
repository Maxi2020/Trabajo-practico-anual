package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.util.PropertiesUtil;

public class AerolineaDAOImplFileString implements AerolineaDAO {
		private File file;
		private Scanner scanner;
	@Override
	public Hashtable<Integer, String> leerAerolineas() throws FileNotFoundException, IOException {

				file = new File(PropertiesUtil.getPathTxt(), PropertiesUtil.getAllAerolineas());
				scanner= new Scanner(file);
				Hashtable<Integer, String> list = new Hashtable<Integer, String>();
				while (scanner.hasNextLine()){
					String[] straux = scanner.nextLine().split(",");		
					list.put(Integer.valueOf(straux[0]), straux[1]);
				}
				return list;
	}
}
