/*
 * Esta clase permite realizar las operaciones asociadas a la lógica de negocio como tal, desde ella realizamos las validaciones 
 * y llamadas a las operaciones CRUD del sistema.
 * 
 * En caso de que se requieran procesos adicionales asociados a la lógica de negocio, aquí será donde se creen los métodos para 
 * dichos procesos, por ejemplo el método validarRegistro determina si los datos son correctos y permite registrar la cliente en
 * el Dao.
 */

package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.dao.ClienteDao;
import Backend.PatronMVC.model.dto.Cliente;
import Backend.PatronMVC.controller.ClienteController;

public class ClienteServ {
	
	private ClienteController clienteController; 
	public static boolean consultaCliente=false;
	public static boolean modificaCliente=false;
	
	//Metodo de vinculación con el controller principal
	public void setclienteController(ClienteController clienteController) {
		this.setController(clienteController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cliente miCliente) {
		ClienteDao miClienteDao;
		miClienteDao = new ClienteDao();
		miClienteDao.registrarCliente(miCliente);						
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cliente validarConsulta(String codigoCliente) {
		ClienteDao miClienteDao;
		
		try {
			int codigo=Integer.parseInt(codigoCliente);	
			miClienteDao = new ClienteDao();
			consultaCliente=true;
			return miClienteDao.buscarCliente(codigo);									
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaCliente=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaCliente=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cliente miCliente) {
		ClienteDao miClienteDao;
			miClienteDao = new ClienteDao();
			miClienteDao.modificarCliente(miCliente);	
			modificaCliente=true;

	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		ClienteDao miClienteDao=new ClienteDao();
		miClienteDao.eliminarCliente(codigo);
	}

	
	
	public ClienteController getClienteController() {
		return clienteController;
	}

	public void setController(ClienteController clienteController) {
		this.clienteController = clienteController;
	}



}
