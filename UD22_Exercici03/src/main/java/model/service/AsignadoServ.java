package model.service;

import javax.swing.JOptionPane;
import model.dao.AsignadoDao;
import model.dto.Asignado;
import controller.AsignadoController;

public class AsignadoServ {
	
	private AsignadoController asignadoController; 
	public static boolean consultaAsignado=false;
	public static boolean modificaAsignado=false;
	
	//Metodo de vinculación con el controller principal
	public void setAsignadoController(AsignadoController asignadoController) {
		this.setController(asignadoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Asignado miAsignado) {
		AsignadoDao miAsignadoDao;
		miAsignadoDao = new AsignadoDao();
		miAsignadoDao.registrarAsignado(miAsignado);						
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Asignado validarConsulta(String cientifico, String proyecto) {
		AsignadoDao miAsignadoDao;
		
		try {
			miAsignadoDao = new AsignadoDao();
			consultaAsignado=true;
			return miAsignadoDao.buscarAsignado(cientifico,proyecto);									
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un error","Error",JOptionPane.ERROR_MESSAGE);
			consultaAsignado=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Asignado miAsignado) {
		AsignadoDao miAsignadoDao;

			miAsignadoDao = new AsignadoDao();
			miAsignadoDao.modificarAsignado(miAsignado);	
			modificaAsignado=true;

	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String cientifico, String proyecto) {
		AsignadoDao miAsignadoDao=new AsignadoDao();
		miAsignadoDao.eliminarAsignado(cientifico,proyecto);
	}

	
	
	public AsignadoController getAsignadoController() {
		return asignadoController;
	}

	public void setController(AsignadoController asignadoController) {
		this.asignadoController = asignadoController;
	}


}

