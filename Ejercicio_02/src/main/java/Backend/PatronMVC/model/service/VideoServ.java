/*
 * Esta clase permite realizar las operaciones asociadas a la lógica de negocio como tal, desde ella realizamos las validaciones 
 * y llamadas a las operaciones CRUD del sistema.
 * 
 * En caso de que se requieran procesos adicionales asociados a la lógica de negocio, aquí será donde se creen los métodos para 
 * dichos procesos, por ejemplo el método validarRegistro determina si los datos son correctos y permite registrar la video en
 * el Dao.
 */

package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.dao.VideoDao;
import Backend.PatronMVC.model.dto.Video;
import Backend.PatronMVC.controller.VideoController;

public class VideoServ {
	
	private VideoController videoController; 
	public static boolean consultaVideo=false;
	public static boolean modificaVideo=false;
	
	//Metodo de vinculación con el controller principal
	public void setvideoController(VideoController videoController) {
		this.setController(videoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Video miVideo) {
		VideoDao miVideoDao;
		miVideoDao = new VideoDao();
		miVideoDao.registrarVideo(miVideo);						
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Video validarConsulta(String codigoVideo) {
		VideoDao miVideoDao;
		
		try {
			int codigo=Integer.parseInt(codigoVideo);	
			miVideoDao = new VideoDao();
			consultaVideo=true;
			return miVideoDao.buscarVideo(codigo);									
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaVideo=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaVideo=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Video miVideo) {
		VideoDao miVideoDao;

			miVideoDao = new VideoDao();
			miVideoDao.modificarVideo(miVideo);	
			modificaVideo=true;

	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		VideoDao miVideoDao=new VideoDao();
		miVideoDao.eliminarVideo(codigo);
	}

	
	
	public VideoController getVideoController() {
		return videoController;
	}

	public void setController(VideoController videoController) {
		this.videoController = videoController;
	}



}
