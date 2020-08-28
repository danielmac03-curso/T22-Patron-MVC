package Backend.PatronMVC.view;

import java.awt.event.*;
import javax.swing.*;


import Backend.PatronMVC.controller.ClienteController;
import Backend.PatronMVC.controller.VideoController;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private ClienteController clienteController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private VideoController videoController; //objeto VideoController que permite la relacion entre esta clase y la clase VideoController
	private JTextArea areaIntroduccion;
	private JLabel lbl_Titulo, lbl_Seleccion, lbl_Clientes, lbl_Videos;
	private JButton btn_RegistrarClientes, btn_BuscarClientes, btn_BuscarVideos, btn_RegistrarVideos;
	public String textoIntroduccion = "";


	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btn_RegistrarClientes = new JButton();
		btn_RegistrarClientes.setBounds(170, 276, 120, 25);
		btn_RegistrarClientes.setText("Registrar");
		
		btn_BuscarClientes = new JButton();
		btn_BuscarClientes.setBounds(310, 276, 120, 25);
		btn_BuscarClientes.setText("Buscar");

		lbl_Titulo = new JLabel();
		lbl_Titulo.setText("PATRON MODELO VISTA CONTROLADOR");
		lbl_Titulo.setBounds(60, 40, 380, 30);
		lbl_Titulo.setFont(new java.awt.Font("Verdana", 1, 15));

		lbl_Seleccion = new JLabel();
		lbl_Seleccion.setText("Escoja que operacion desea realizar");
		lbl_Seleccion.setBounds(75, 240, 250, 25);
		
		lbl_Clientes = new JLabel("CLIENTES");
		lbl_Clientes.setBounds(60, 281, 55, 14);
		
		lbl_Videos = new JLabel("VIDEOS");
		lbl_Videos.setBounds(60, 327, 55, 14);
		
		btn_BuscarVideos = new JButton();
		btn_BuscarVideos.setText("Buscar");
		btn_BuscarVideos.setBounds(310, 322, 120, 25);
		
		btn_RegistrarVideos = new JButton();
		btn_RegistrarVideos.setText("Registrar");
		btn_RegistrarVideos.setBounds(170, 322, 120, 25);
		

		textoIntroduccion = "Esta aplicación presenta un ejemplo práctico del patron "
				+ "de diseño MVC.\n\n"
				+ "La aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Persona." +
				"tambien son vinculados algunos conceptos de los Patrones Value Object y Data Access Objetc\n";

		areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(50, 90, 380, 140);
		areaIntroduccion.setEditable(false);
		areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduccion.setLineWrap(true);
		areaIntroduccion.setText(textoIntroduccion);
		areaIntroduccion.setWrapStyleWord(true);
		areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));

		btn_RegistrarClientes.addActionListener(this);
		btn_BuscarClientes.addActionListener(this);
		
		btn_RegistrarVideos.addActionListener(this);
		btn_BuscarVideos.addActionListener(this);
		
		getContentPane().add(btn_BuscarClientes);
		getContentPane().add(btn_RegistrarClientes);
		getContentPane().add(lbl_Seleccion);
		getContentPane().add(lbl_Titulo);
		getContentPane().add(areaIntroduccion);
		getContentPane().add(lbl_Clientes);
		getContentPane().add(lbl_Videos);
		getContentPane().add(btn_BuscarVideos);
		getContentPane().add(btn_RegistrarVideos);
		
		setSize(480, 409);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}


	public void setCoordinador(ClienteController clienteController) {
		this.clienteController=clienteController;
	}
	
	public void setCoordinador(VideoController videoController) {
		this.videoController=videoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn_RegistrarClientes) {
			clienteController.mostrarVentanaRegistroClientes();			
		}
		if (e.getSource()==btn_BuscarClientes) {
			clienteController.mostrarVentanaConsultaClientes();			
		}
		if (e.getSource()==btn_RegistrarVideos) {
			videoController.mostrarVentanaRegistroVideos();			
		}
		if (e.getSource()==btn_BuscarVideos) {
			videoController.mostrarVentanaConsultaVideos();			
		}
	}
}
