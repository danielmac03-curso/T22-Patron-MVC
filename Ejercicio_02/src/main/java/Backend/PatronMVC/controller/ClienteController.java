
/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Cliente;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.view.VentanaBuscarClientes;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistroClientes;


public class ClienteController {
	
	private ClienteServ clienteServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroClientes miVentanaRegistroClientes;
	private VentanaBuscarClientes miVentanaBuscarClientes;
	
	//Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipalClientes() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipalClientes(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistroClientes getMiVentanaRegistroClientes() {
		return miVentanaRegistroClientes;
	}
	public void setMiVentanaRegistroClientes(VentanaRegistroClientes miVentanaRegistroClientes) {
		this.miVentanaRegistroClientes = miVentanaRegistroClientes;
	}
	public VentanaBuscarClientes getMiVentanaBuscarClientes() {
		return miVentanaBuscarClientes;
	}
	public void setMiVentanaBuscarClientes(VentanaBuscarClientes miVentanaBuscarClientes) {
		this.miVentanaBuscarClientes = miVentanaBuscarClientes;
	}
	public ClienteServ getClienteServ() {
		return clienteServ;
	}
	public void setClienteServ(ClienteServ clienteServ) {
		this.clienteServ = clienteServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistroClientes() {
		miVentanaRegistroClientes.setVisible(true);
	}
	public void mostrarVentanaConsultaClientes() {
		miVentanaBuscarClientes.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarCliente(Cliente miCliente) {
		clienteServ.validarRegistro(miCliente);
	}
	
	public Cliente buscarCliente(String codigoCliente) {
		return clienteServ.validarConsulta(codigoCliente);
	}
	
	public void modificarCliente(Cliente miCliente) {
		clienteServ.validarModificacion(miCliente);
	}
	
	public void eliminarCliente(String codigo) {
		clienteServ.validarEliminacion(codigo);
	}


}
