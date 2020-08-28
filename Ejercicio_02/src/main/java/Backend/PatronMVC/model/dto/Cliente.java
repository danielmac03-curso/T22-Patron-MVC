package Backend.PatronMVC.model.dto;

import java.sql.Date;

public class Cliente {
	
	private Integer idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String direccionCliente;
	private Integer dniCliente;
	private Date dateCliente;
	
	/**
	 * @return the idCliente
	 */
	public Integer getIdCliente() {
		return idCliente;
	}
	
	/**
	 * @param setIdCliente the idCliente to set
	 */
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	/**
	 * @param setNombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	/**
	 * @return the apellidoCliente
	 */
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	
	/**
	 * @param setApellidoCliente the apellidoCliente to set
	 */
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	
	/**
	 * @return the direccionCliente
	 */
	public String getDireccionCliente() {
		return direccionCliente;
	}
	
	/**
	 * @param setDireccionCliente the direccionCliente to set
	 */
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	
	/**
	 * @return the dniCliente
	 */
	public Integer getDniCliente() {
		return dniCliente;
	}
	
	/**
	 * @param setDniCliente the dniCliente to set
	 */
	public void setDniCliente(Integer dniCliente) {
		this.dniCliente = dniCliente;
	}
	
	/**
	 * @return the dateCliente
	 */
	public Date getDateCliente() {
		return dateCliente;
	}
	
	/**
	 * @param setDateCliente the dateCliente to set
	 */
	public void setDateCliente(Date dateCliente) {
		this.dateCliente = dateCliente;
	}
}
