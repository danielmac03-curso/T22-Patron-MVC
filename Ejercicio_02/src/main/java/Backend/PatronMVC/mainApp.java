package Backend.PatronMVC;

import Backend.PatronMVC.controller.*;
import Backend.PatronMVC.view.*;
import Backend.PatronMVC.model.service.*;


public class mainApp {
	
	VentanaPrincipal miVentanaPrincipal;
	
	ClienteServ miClienteServ;
	VentanaBuscarClientes miVentanaBuscarClientes;
	VentanaRegistroClientes miVentanaRegistroClientes;
	ClienteController ControllerClientes;
	
	VideoServ miVideoServ;
	VentanaBuscarVideos miVentanaBuscarVideos;
	VentanaRegistroVideos miVentanaRegistroVideos;
	VideoController ControllerVideos;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mainApp miPrincipal=new mainApp();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		miVentanaPrincipal=new VentanaPrincipal();
		
		miVentanaRegistroClientes=new VentanaRegistroClientes();
		miVentanaBuscarClientes= new VentanaBuscarClientes();
		miClienteServ=new ClienteServ();
		ControllerClientes= new ClienteController();
		
		miVentanaRegistroVideos=new VentanaRegistroVideos();
		miVentanaBuscarVideos= new VentanaBuscarVideos();
		miVideoServ=new VideoServ();
		ControllerVideos= new VideoController();
		
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setCoordinador(ControllerClientes);
		miVentanaRegistroClientes.setCoordinador(ControllerClientes);
		miVentanaBuscarClientes.setCoordinador(ControllerClientes);
		miClienteServ.setController(ControllerClientes);
		
		miVentanaPrincipal.setCoordinador(ControllerVideos);
		miVentanaRegistroVideos.setCoordinador(ControllerVideos);
		miVentanaBuscarVideos.setCoordinador(ControllerVideos);
		miVideoServ.setController(ControllerVideos);
		
		
		/*Se establecen relaciones con la clase coordinador*/
		ControllerClientes.setMiVentanaPrincipalClientes(miVentanaPrincipal);
		ControllerClientes.setMiVentanaRegistroClientes(miVentanaRegistroClientes);
		ControllerClientes.setMiVentanaBuscarClientes(miVentanaBuscarClientes);
		ControllerClientes.setClienteServ(miClienteServ);
		
		ControllerVideos.setMiVentanaPrincipalVideos(miVentanaPrincipal);
		ControllerVideos.setMiVentanaRegistroVideos(miVentanaRegistroVideos);
		ControllerVideos.setMiVentanaBuscarVideos(miVentanaBuscarVideos);
		ControllerVideos.setVideoServ(miVideoServ);
				
		miVentanaPrincipal.setVisible(true);
		
	}

}
