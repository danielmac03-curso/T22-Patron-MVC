package Backend.PatronMVC.view;

import java.awt.event.*;
import javax.swing.*;
import Backend.PatronMVC.model.dto.Cliente;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.controller.ClienteController;

public class VentanaBuscarClientes  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private ClienteController clienteController; //objeto clienteController que permite la relacion entre esta clase y la clase clienteController
	private JLabel labelTitulo;
	private JTextField textId, textDate, textNombre, textApellido, textDni, textDireccion;
	private JLabel id, date, nombre, apellido, dni, direccion;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarClientes() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 80, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR CLIENTES");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		id=new JLabel();
		id.setText("Codigo");
		id.setBounds(20, 80, 80, 25);
		getContentPane().add(id);
		
		date = new JLabel();
		date.setText("Fecha");
		date.setBounds(255, 80, 80, 25);
		getContentPane().add(date);
		
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
		
		textId=new JTextField();
		textId.setBounds(80, 80, 80, 25);
		getContentPane().add(textId);
		
		textDate = new JTextField();
		textDate.setBounds(310, 82, 150, 25);
		getContentPane().add(textDate);
		
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
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		getContentPane().add(botonCancelar);
		getContentPane().add(botonBuscar);
		getContentPane().add(botonModificar);
		getContentPane().add(botonEliminar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
				
		setSize(490, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

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
				miCliente.setIdCliente(Integer.parseInt(textId.getText()));
				miCliente.setNombreCliente(textNombre.getText());
				miCliente.setApellidoCliente(textApellido.getText());
				miCliente.setDniCliente(Integer.parseInt(textDni.getText()));
				miCliente.setDireccionCliente(textDireccion.getText());

				clienteController.modificarCliente(miCliente);
				
				if (ClienteServ.modificaCliente==true) {
					habilita(true, false, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(e2);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cliente miCliente=clienteController.buscarCliente(textId.getText());
			if (miCliente!=null)
			{
				muestraCliente(miCliente);
			}
			else if(ClienteServ.consultaCliente==true){
				JOptionPane.showMessageDialog(null, "La cliente no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, false, true, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textId.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Cliente?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					clienteController.eliminarCliente(textId.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la cliente consultada
	 * @param miCliente
	 */
	private void muestraCliente(Cliente miCliente) {
		textNombre.setText(miCliente.getNombreCliente());
		textApellido.setText(miCliente.getApellidoCliente()+"");
		textDni.setText(miCliente.getDniCliente()+"");
		textDireccion.setText(miCliente.getDireccionCliente());
		textDate.setText(miCliente.getDateCliente().toString());
		habilita(true, false, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textId.setText("");
		textNombre.setText("");
		textDni.setText("");
		textApellido.setText("");
		textDireccion.setText("");
		habilita(true, false, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param dni
	 * @param tel
	 * @param direccion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean codigo, boolean date, boolean nombre, boolean apellido, boolean dni, boolean direccion, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textId.setEditable(codigo);
		textDate.setEditable(date);
		textNombre.setEditable(nombre);
		textDni.setEditable(apellido);
		textApellido.setEditable(dni);
		textDireccion.setEditable(direccion);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
