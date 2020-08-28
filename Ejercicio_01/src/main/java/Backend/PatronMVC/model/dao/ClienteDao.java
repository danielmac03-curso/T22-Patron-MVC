package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Cliente;

/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */
public class ClienteDao
{

	public void registrarCliente(Cliente miCliente)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO cliente (nombre, apellido, direccion, dni) VALUES ('" + 
			miCliente.getNombreCliente()+"', '"+
			miCliente.getApellidoCliente()+"', '"+
			miCliente.getDireccionCliente()+"', '"+
			miCliente.getDniCliente()+"');";
			
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public Cliente buscarCliente(int codigo) 
	{
		Conexion conex= new Conexion();
		Cliente cliente= new Cliente();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM cliente where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				cliente.setIdCliente(Integer.parseInt(res.getString("id")));
				cliente.setNombreCliente(res.getString("nombre"));
				cliente.setApellidoCliente(res.getString("apellido"));
				cliente.setDireccionCliente(res.getString("direccion"));
				cliente.setDniCliente(Integer.parseInt(res.getString("dni")));
				cliente.setDateCliente(res.getDate("fecha"));
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return cliente;
			}
			else return null;				
	}

	public void modificarCliente(Cliente miCliente) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE cliente SET id= ? ,nombre = ? , apellido=? , direccion=? , dni= ?, fecha= (CURRENT_DATE) WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miCliente.getIdCliente());
            estatuto.setString(2, miCliente.getNombreCliente());
            estatuto.setString(3, miCliente.getApellidoCliente());
            estatuto.setString(4, miCliente.getDireccionCliente());
            estatuto.setInt(5,miCliente.getDniCliente());
            estatuto.setInt(6, miCliente.getIdCliente());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarCliente(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM cliente WHERE id='"+codigo+"'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
