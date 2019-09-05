package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.negocio.dominio.Vuelos;
import edu.usal.util.DAOException;
import edu.usal.util.PropertiesUtil;

public class AerolineaDAOImplFileSerializable implements AerolineaDAO {
	private FileOutputStream fileOut;
	private FileInputStream fileInput;
	private ObjectOutputStream objectOut;
	private ObjectInputStream objectInput;
	private File file;
	

	@Override
	public void addAerolinea(Aerolineas aerolinea, Connection cn) throws DAOException, SQLException, IOException {
		List<Aerolineas> listado = this.getAllAerolineas();
		listado.add(aerolinea);
		this.saveAllAerolineas(listado);
	}

	private void saveAllAerolineas(List<Aerolineas> listado) throws IOException {
		this.file = new File(PropertiesUtil.getPathAerolineas(), PropertiesUtil.getFileAerolineas());
    	this.fileOut = new FileOutputStream(file);
    	this.objectOut = new ObjectOutputStream(fileOut);
    	this.objectOut.writeObject(listado);
    	this.objectOut.close();
	}

	@Override
	public void updateAerolinea(Aerolineas aerolinea) throws DAOException, IOException {
		List<Aerolineas> listado = this.getAllAerolineas();
		for(Aerolineas aerolineas : listado) {
			if(aerolineas.getIdAerolinea() == aerolinea.getIdAerolinea()) {
				listado.remove(aerolineas);
				listado.add(aerolinea);
				this.saveAllAerolineas(listado);
			}
		}
	}

	@Override
	public void deleteAerolinea(Aerolineas aerolinea, Connection cn) throws DAOException, IOException {
		List<Aerolineas> listado = this.getAllAerolineas();
		for(Aerolineas aerolineas : listado) {
			if(aerolineas.getIdAerolinea() == aerolinea.getIdAerolinea()) {
				listado.remove(aerolineas);
				this.saveAllAerolineas(listado);
			}
		}
	}

	@Override
	public List<Aerolineas> getAllAerolineas() throws DAOException, IOException {
		this.file= new File(PropertiesUtil.getPathAerolineas(),PropertiesUtil.getFileAerolineas());
		if(!file.exists()){
			file = new File(PropertiesUtil.getPathAerolineas());
			file.mkdirs();
			file= new File(PropertiesUtil.getPathAerolineas(),PropertiesUtil.getFileAerolineas());
			file.createNewFile();
			this.saveAllAerolineas(this.LecturaTxt());
		}
		this.file= new File(PropertiesUtil.getPathAerolineas(),PropertiesUtil.getFileAerolineas());
		this.fileInput = new FileInputStream(file);
    	this.objectInput = new ObjectInputStream(fileInput);
	    
		try {
			@SuppressWarnings("unchecked")
			List<Aerolineas> lista = (ArrayList<Aerolineas>) objectInput.readObject();
			this.fileInput.close();
	    	this.objectInput.close();
			return lista;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private ArrayList<Aerolineas> LecturaTxt(){
		ArrayList<Aerolineas> lista = new ArrayList<Aerolineas>();
		try {
			
			this.file= new File(PropertiesUtil.getPathTxt(), PropertiesUtil.getAllAerolineas());
			Scanner scanner= new Scanner(file);
			while (scanner.hasNextLine()){
				String[] straux = scanner.nextLine().split(",");
				Aerolineas aerolinea = new Aerolineas();
				aerolinea.setAlianza(straux[0]);
				aerolinea.setNombreAerolinea(straux[1]);
				aerolinea.setVuelo(new ArrayList<Vuelos>());
				lista.add(aerolinea);
			}
			scanner.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return lista;
}
	
	@Override
	public Aerolineas queryAerolinea(int Id) throws DAOException, IOException {
		List<Aerolineas> listado = this.getAllAerolineas();
		for(Aerolineas aerolineas : listado) {
			if(aerolineas.getIdAerolinea() == Id) {
			return aerolineas;
			}
		}return null;
	}

}
