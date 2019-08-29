package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import edu.usal.negocio.dao.interfaces.ProvinciaDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.util.DAOException;
import edu.usal.util.PropertiesUtil;

public class ProvinciaDAOImplFileString implements ProvinciaDAO {
	private File file;
	private Scanner scanner;
		
	@Override
	public Hashtable<Integer, String> leerProvincias() throws FileNotFoundException, IOException {
	
				file = new File(PropertiesUtil.getPathTxt(), PropertiesUtil.getAllProvincias());
				scanner= new Scanner(file);
				Hashtable<Integer, String> list = new Hashtable<Integer, String>();
				while (scanner.hasNextLine()){
					String[] straux = scanner.nextLine().split(",");		
					list.put(Integer.valueOf(straux[0]), straux[1]);
				}
				return list;
	}

	@Override
	public void addProvincia(Clientes cliente, Connection cn) throws DAOException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProvincia(Clientes cliente) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProvincia(Clientes cliente, Connection cn) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Provincias queryProvincia(int Id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Provincias> getAllProvincias() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
