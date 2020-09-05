package model.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.conexion.Conexion;
import model.dto.Cientifico;

/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */
public class CientificoDao {

	public void registrarCientifico(Cientifico miCientifico)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO cientifico (nomApels) VALUES " + "('" 
					+ miCientifico.getNomApels() + "');";
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
	
	public Cientifico buscarCientifico(int codigo) 
	{
		Conexion conex= new Conexion();
		Cientifico cientifico= new Cientifico();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM cientifico where dni = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				cientifico.setDni(res.getString("dni"));
				cientifico.setNomApels(res.getString("nomApels"));
				
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return cientifico;
			}
			else return null;				
	}
	
	public void modificarCientifico(Cientifico miCientifico) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE cientifico SET dni= ? ,nomApels = ? WHERE dni= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, miCientifico.getDni());
            estatuto.setString(2, miCientifico.getNomApels());
            estatuto.setString(3, miCientifico.getDni());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha modificado correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}
	
	public void eliminarCientifico(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM cientifico WHERE dni='"+codigo+"'";
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
