
/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Video;
import Backend.PatronMVC.model.service.VideoServ;
import Backend.PatronMVC.view.VentanaBuscarVideos;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistroVideos;


public class VideoController {
	
	private VideoServ videoServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroVideos miVentanaRegistroVideos;
	private VentanaBuscarVideos miVentanaBuscarVideos;
	
	//Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipalVideos(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistroVideos getMiVentanaRegistroVideos() {
		return miVentanaRegistroVideos;
	}
	public void setMiVentanaRegistroVideos(VentanaRegistroVideos miVentanaRegistroVideos) {
		this.miVentanaRegistroVideos = miVentanaRegistroVideos;
	}
	public VentanaBuscarVideos getMiVentanaBuscarVideos() {
		return miVentanaBuscarVideos;
	}
	public void setMiVentanaBuscarVideos(VentanaBuscarVideos miVentanaBuscarVideos) {
		this.miVentanaBuscarVideos = miVentanaBuscarVideos;
	}
	public VideoServ getVideoServ() {
		return videoServ;
	}
	public void setVideoServ(VideoServ videoServ) {
		this.videoServ = videoServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistroVideos() {
		miVentanaRegistroVideos.setVisible(true);
	}
	public void mostrarVentanaConsultaVideos() {
		miVentanaBuscarVideos.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarVideo(Video miVideo) {
		videoServ.validarRegistro(miVideo);
	}
	
	public Video buscarVideo(String codigoVideo) {
		return videoServ.validarConsulta(codigoVideo);
	}
	
	public void modificarVideo(Video miVideo) {
		videoServ.validarModificacion(miVideo);
	}
	
	public void eliminarVideo(String codigo) {
		videoServ.validarEliminacion(codigo);
	}


}
