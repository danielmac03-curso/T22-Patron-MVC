package Backend.PatronMVC;

import Backend.PatronMVC.controller.ClienteController;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.view.VentanaBuscar;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistro;

public class mainApp {
	
	ClienteServ miclienteServ;
	VentanaPrincipal miVentanaPrincipal;
	VentanaBuscar miVentanaBuscar;
	VentanaRegistro miVentanaRegistro;
	ClienteController clienteController;

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
		miVentanaRegistro=new VentanaRegistro();
		miVentanaBuscar= new VentanaBuscar();
		miclienteServ=new ClienteServ();
		clienteController= new ClienteController();
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setCoordinador(clienteController);
		miVentanaRegistro.setCoordinador(clienteController);
		miVentanaBuscar.setCoordinador(clienteController);
		miclienteServ.setclienteController(clienteController);
		
		/*Se establecen relaciones con la clase coordinador*/
		clienteController.setMiVentanaPrincipal(miVentanaPrincipal);
		clienteController.setMiVentanaRegistro(miVentanaRegistro);
		clienteController.setMiVentanaBuscar(miVentanaBuscar);
		clienteController.setClienteServ(miclienteServ);
				
		miVentanaPrincipal.setVisible(true);
	}

}
