package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.conexion.Conexion;
import model.dto.Asignado;

/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */
public class AsignadoDao{

	public void registrarAsignado(Asignado miAsignado)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO Asignado_A (cientifico, proyecto) VALUES ('" + 
			miAsignado.getCientifico()+"', '"+
			miAsignado.getProyecto()+"');";
			
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se registro");
		}
	}

	public Asignado buscarAsignado(String cientifico, String proyecto) 
	{
		Conexion conex= new Conexion();
		Asignado asignado= new Asignado();
		boolean existe=false;
		String sql="";
		try {
			sql = "SELECT * FROM Asignado_A WHERE cientifico = ? and  proyecto= ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setString(1, cientifico);
			consulta.setString(2, proyecto);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				asignado.setProyecto(res.getString("proyecto"));
				asignado.setCientifico(res.getString("cientifico"));
			}
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return asignado;
			}
			else return null;				
	}

	public void modificarAsignado(Asignado miAsignado) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Asignado_A SET proyecto= ? ,cientifico = ? WHERE proyecto = ? and cientifico = ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, miAsignado.getProyecto());
            estatuto.setString(2, miAsignado.getCientifico());
            estatuto.setString(3, miAsignado.getProyecto());
            estatuto.setString(4,miAsignado.getCientifico());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha modificado correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarAsignado(String cientifico, String proyecto)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM Asignado_A WHERE cientifico= '"+ cientifico + "' and proyecto= '" + proyecto + "'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha eliminado correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se elimino");
		}
	}


}
