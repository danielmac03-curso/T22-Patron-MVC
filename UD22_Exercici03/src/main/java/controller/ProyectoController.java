package controller;

import model.service.ProyectoServ;
import views.BuscarProyecto;
import views.MenuPrincipal;
import views.RegistrarProyecto;
import views.EliminarProyecto;
import model.dto.Proyecto;


public class ProyectoController {
	
	private ProyectoServ proyectoServ;
	private MenuPrincipal menuPrincipal;
	private RegistrarProyecto registrar;
	private BuscarProyecto buscar;
	private EliminarProyecto eliminar;
	
	//Metodos getter Setters de vistas
	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}
	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
	public RegistrarProyecto getRegistrar() {
		return registrar;
	}
	public void setRegistrar(RegistrarProyecto registrar) {
		this.registrar = registrar;
	}
	public BuscarProyecto getBuscar() {
		return buscar;
	}
	public void setBuscar(BuscarProyecto buscar) {
		this.buscar = buscar;
	}
	public EliminarProyecto getEliminar() {
		return eliminar;
	}
	public void setEliminar(EliminarProyecto eliminar) {
		this.eliminar = eliminar;
	}
	public ProyectoServ getCientificoServ() {
		return proyectoServ;
	}
	public void setClienteServ(ProyectoServ proyectoServ) {
		this.proyectoServ = proyectoServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarRegistrar() {
		registrar.setVisible(true);
	}
	public void mostrarBuscar() {
		buscar.setVisible(true);
	}
	public void mostrarEliminar() {
		eliminar.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarProyecto(Proyecto miProyecto) {
		proyectoServ.validarRegistro(miProyecto);
	}
	
	public Proyecto buscarProyecto(String codigoProyecto) {
		return proyectoServ.validarConsulta(codigoProyecto);
	}
	
	public void modificarProyecto(Proyecto miProyecto) {
		proyectoServ.validarModificacion(miProyecto);
	}
	
	public void eliminarProyecto(String codigoProyecto) {
		proyectoServ.validarEliminacion(codigoProyecto);
	}


}

