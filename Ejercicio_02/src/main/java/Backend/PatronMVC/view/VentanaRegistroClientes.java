package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.ClienteController;
import Backend.PatronMVC.model.dto.Cliente;


public class VentanaRegistroClientes extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private ClienteController clienteController; //objeto clienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textNombre,textApellido,textDni,textDireccion;
	private JLabel nombre,apellido,dni,direccion;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistroClientes() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE CLIENTES");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		getContentPane().add(nombre);

		dni=new JLabel();
		dni.setText("DNI");
		dni.setBounds(255, 160, 80, 25);
		getContentPane().add(dni);
		
		direccion=new JLabel();
		direccion.setText("Direccion");
		direccion.setBounds(20, 160, 80, 25);
		getContentPane().add(direccion);
		
		apellido=new JLabel();
		apellido.setText("Apellido");
		apellido.setBounds(255, 120, 80, 25);
		getContentPane().add(apellido);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 150, 25);
		getContentPane().add(textNombre);

		textDni=new JTextField();
		textDni.setBounds(310, 160, 150, 25);
		getContentPane().add(textDni);
		
		textDireccion=new JTextField();
		textDireccion.setBounds(80, 160, 150, 25);
		getContentPane().add(textDireccion);
		
		textApellido=new JTextField();
		textApellido.setBounds(310, 120, 150, 25);
		getContentPane().add(textApellido);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textNombre.setText("");
		textDni.setText("");
		textApellido.setText("");
		textDireccion.setText("");
	}


	public void setCoordinador(ClienteController clienteController) {
		this.clienteController=clienteController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cliente miCliente=new Cliente();
				miCliente.setNombreCliente(textNombre.getText());
				miCliente.setApellidoCliente(textApellido.getText());
				miCliente.setDniCliente(Integer.parseInt(textDni.getText()));
				miCliente.setDireccionCliente(textDireccion.getText());
				
				clienteController.registrarCliente(miCliente);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
	
	

}
