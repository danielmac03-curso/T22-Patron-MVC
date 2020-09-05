package UD22.UD22_Exercici03;

import controller.CientificoController;
import model.service.CientificoServ;
import controller.AsignadoController;
import model.service.AsignadoServ;
import controller.ProyectoController;
import model.service.ProyectoServ;

import views.*;

public class MainApp {
	MenuPrincipal menuPrincipal;
	
	CientificoServ miCientificoServ;
	BuscarCientifico buscarCientifico;
	RegistrarCientifico registrarCientifico;
	EliminarCientifico eliminarCientifico;
	CientificoController cientificoController;

	AsignadoServ miAsignadoServ;
	BuscarAsignado buscarAsignado;
	RegistrarAsignado registrarAsignado;
	EliminarAsignado eliminarAsignado;
	AsignadoController asignadoController;
	
	ProyectoServ miProyectoServ;
	BuscarProyecto buscarProyecto;
	RegistrarProyecto registrarProyecto;
	EliminarProyecto eliminarProyecto;
	ProyectoController proyectoController;
	
	public static void main(String[] args) {
		MainApp miPrincipal=new MainApp();
		miPrincipal.iniciar();
	}


private void iniciar() {
	/*Se instancian las clases*/
	menuPrincipal=new MenuPrincipal();
	
	registrarCientifico = new RegistrarCientifico();
	buscarCientifico = new BuscarCientifico();
	eliminarCientifico = new EliminarCientifico();
	miCientificoServ=new CientificoServ();
	cientificoController= new CientificoController();
	
	registrarAsignado=new RegistrarAsignado();
	buscarAsignado= new BuscarAsignado();
	eliminarAsignado= new EliminarAsignado();
	miAsignadoServ = new AsignadoServ();
	asignadoController = new AsignadoController();

	registrarProyecto = new RegistrarProyecto();
	buscarProyecto = new BuscarProyecto();
	eliminarProyecto = new EliminarProyecto();
	miProyectoServ=new ProyectoServ();
	proyectoController= new ProyectoController();
	
	/*Se establecen las relaciones entre clases*/
	menuPrincipal.setCoordinador(cientificoController);
	registrarCientifico.setCoordinador(cientificoController);
	buscarCientifico.setCoordinador(cientificoController);
	eliminarCientifico.setCoordinador(cientificoController);
	miCientificoServ.setCientificoController(cientificoController);
	
	menuPrincipal.setAsignadoCoordinador(asignadoController);
	registrarAsignado.setCoordinador(asignadoController);
	buscarAsignado.setCoordinador(asignadoController);
	eliminarAsignado.setCoordinador(asignadoController);
	miAsignadoServ.setAsignadoController(asignadoController);
	
	menuPrincipal.setProyectoCoordinador(proyectoController);
	registrarProyecto.setCoordinador(proyectoController);
	buscarProyecto.setCoordinador(proyectoController);
	eliminarProyecto.setCoordinador(proyectoController);
	miProyectoServ.setProyectoController(proyectoController);
	
	
	/*Se establecen relaciones con la clase coordinador*/
	cientificoController.setMenuPrincipal(menuPrincipal);
	cientificoController.setRegistrar(registrarCientifico);
	cientificoController.setEliminar(eliminarCientifico);
	cientificoController.setClienteServ(miCientificoServ);
	cientificoController.setBuscar(buscarCientifico);		
	
	asignadoController.setMenuPrincipal(menuPrincipal);
	asignadoController.setRegistrarAsignado(registrarAsignado);
	asignadoController.setEliminarAsignado(eliminarAsignado);
	asignadoController.setAsignadoServ(miAsignadoServ);
	asignadoController.setBuscarAsignado(buscarAsignado);	
	
	proyectoController.setMenuPrincipal(menuPrincipal);
	proyectoController.setRegistrar(registrarProyecto);
	proyectoController.setEliminar(eliminarProyecto);
	proyectoController.setClienteServ(miProyectoServ);
	proyectoController.setBuscar(buscarProyecto);
	
	menuPrincipal.setVisible(true);
}

}
