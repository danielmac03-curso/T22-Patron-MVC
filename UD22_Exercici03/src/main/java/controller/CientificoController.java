package controller;

import model.dto.Cientifico;
import model.service.CientificoServ;
import views.BuscarCientifico;
import views.MenuPrincipal;
import views.RegistrarCientifico;
import views.EliminarCientifico;


public class CientificoController {
	
	private CientificoServ cientificoServ;
	private MenuPrincipal menuPrincipal;
	private RegistrarCientifico registrar;
	private BuscarCientifico buscar;
	private EliminarCientifico eliminar;
	
	//Metodos getter Setters de vistas
	public MenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}
	public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}
	public RegistrarCientifico getRegistrar() {
		return registrar;
	}
	public void setRegistrar(RegistrarCientifico registrar) {
		this.registrar = registrar;
	}
	public BuscarCientifico getBuscar() {
		return buscar;
	}
	public void setBuscar(BuscarCientifico buscar) {
		this.buscar = buscar;
	}
	public EliminarCientifico getEliminar() {
		return eliminar;
	}
	public void setEliminar(EliminarCientifico eliminar) {
		this.eliminar = eliminar;
	}
	public CientificoServ getCientificoServ() {
		return cientificoServ;
	}
	public void setClienteServ(CientificoServ cientificoServ) {
		this.cientificoServ = cientificoServ;
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
	public void registrarCientifico(Cientifico miCientifico) {
		cientificoServ.validarRegistro(miCientifico);
	}
	
	public Cientifico buscarCientifico(String codigoCientifico) {
		return cientificoServ.validarConsulta(codigoCientifico);
	}
	
	public void modificarCientifico(Cientifico miCientifico) {
		cientificoServ.validarModificacion(miCientifico);
	}
	
	public void eliminarCientifico(String codigoCientifico) {
		cientificoServ.validarEliminacion(codigoCientifico);
	}


}

