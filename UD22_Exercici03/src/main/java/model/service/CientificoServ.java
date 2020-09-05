package model.service;

import javax.swing.JOptionPane;
import model.dao.CientificoDao;
import model.dto.Cientifico;
import controller.CientificoController;

public class CientificoServ {
	
	private CientificoController cientificoController; 
	public static boolean consultaCientifico=false;
	public static boolean modificaCientifico=false;

	//Metodo de vinculación con el controller principal
	public void setCientificoController(CientificoController cientificoController) {
		this.setController(cientificoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
			miCientificoDao = new CientificoDao();
			miCientificoDao.registrarCientifico(miCientifico);						
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cientifico validarConsulta(String codigoCientifico) {
		CientificoDao miCientificoDao;
		
		try {
			int codigo=Integer.parseInt(codigoCientifico);	
				miCientificoDao = new CientificoDao();
				consultaCientifico=true;
				return miCientificoDao.buscarCientifico(codigo);						

			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaCientifico=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaCientifico=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
			miCientificoDao = new CientificoDao();
			miCientificoDao.modificarCientifico(miCientifico);	
			modificaCientifico=true;
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		CientificoDao miCientificoDao=new CientificoDao();
		miCientificoDao.eliminarCientifico(codigo);
	}

	
	//Getters i Setters
	public CientificoController getCientificoController() {
		return cientificoController;
	}

	public void setController(CientificoController cientificoController) {
		this.cientificoController = cientificoController;
	}



}

