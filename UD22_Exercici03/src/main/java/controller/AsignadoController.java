package controller;

import model.dto.Asignado;
import model.service.AsignadoServ;
import views.BuscarAsignado;
import views.EliminarAsignado;
import views.MenuPrincipal;
import views.RegistrarAsignado;


public class AsignadoController {
	
	private AsignadoServ asignadoServ;
	private MenuPrincipal menuPrincipal;
	private RegistrarAsignado registrar;
	private BuscarAsignado buscar;
	private EliminarAsignado eliminar;
	
	//Metodos getter Setters de vistas
	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}
	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
	public RegistrarAsignado getMiVentanaRegistroVideos() {
		return registrar;
	}
	public void setRegistrarAsignado(RegistrarAsignado registrar) {
		this.registrar = registrar;
	}
	public BuscarAsignado getBuscarAsignado() {
		return buscar;
	}
	public void setBuscarAsignado(BuscarAsignado buscar) {
		this.buscar = buscar;
	}
	public EliminarAsignado getEliminarVideo() {
		return eliminar;
	}
	public void setEliminarAsignado(EliminarAsignado eliminar) {
		this.eliminar = eliminar;
	}
	public AsignadoServ getAsignadoServ() {
		return asignadoServ;
	}
	public void setAsignadoServ(AsignadoServ asignadoServ) {
		this.asignadoServ = asignadoServ;
	}
	
	//Hace visible las vistas de registrar, buscar i eliminar
	public void mostrarRegistrarAsignado() {
		registrar.setVisible(true);
	}
	public void mostrarBuscarAsignado() {
		buscar.setVisible(true);
	}
	public void mostrarEliminarAsignado() {
		eliminar.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarAsignado(Asignado miAsignado) {
		asignadoServ.validarRegistro(miAsignado);
	}
	
	public Asignado buscarAsignado(String cientifico, String proyecto) {
		return asignadoServ.validarConsulta(cientifico, proyecto);
	}
	
	public void modificarAsignado(Asignado miAsignado) {
		asignadoServ.validarModificacion(miAsignado);
	}
	
	public void eliminarAsignado(String cientifico, String proyecto) {
		asignadoServ.validarEliminacion(cientifico, proyecto);
	}


}
