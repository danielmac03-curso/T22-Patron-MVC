package model.service;

import javax.swing.JOptionPane;
import model.dao.ProyectoDao;
import model.dto.Proyecto;
import controller.ProyectoController;

public class ProyectoServ {
	
	private ProyectoController proyectoController; 
	public static boolean consultaProyecto=false;
	public static boolean modificaProyecto=false;

	//Metodo de vinculación con el controller principal
	public void setProyectoController(ProyectoController proyectoController) {
		this.setController(proyectoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Proyecto miProyecto) {
		ProyectoDao miProyectoDao;
			miProyectoDao = new ProyectoDao();
			miProyectoDao.registrarProyecto(miProyecto);						
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Proyecto validarConsulta(String codigoProyecto) {
		ProyectoDao miProyectoDao;
		
		try {
			int codigo=Integer.parseInt(codigoProyecto);	
				miProyectoDao = new ProyectoDao();
				consultaProyecto=true;
				return miProyectoDao.buscarProyecto(codigo);						

			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaProyecto=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaProyecto=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Proyecto miProyecto) {
		ProyectoDao miProyectoDao;
			miProyectoDao = new ProyectoDao();
			miProyectoDao.modificarProyecto(miProyecto);	
			modificaProyecto=true;
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		ProyectoDao miProyectoDao=new ProyectoDao();
		miProyectoDao.eliminarProyecto(codigo);
	}

	
	//Getters i Setters
	public ProyectoController getProyectoController() {
		return proyectoController;
	}

	public void setController(ProyectoController proyectoController) {
		this.proyectoController = proyectoController;
	}



}

