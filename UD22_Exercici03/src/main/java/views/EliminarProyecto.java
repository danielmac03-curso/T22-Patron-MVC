package views;

import javax.swing.*;


import java.awt.Font;

import controller.ProyectoController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarProyecto extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField textCodigo;
	private ProyectoController proyectoController;
	
	public EliminarProyecto() {
		setTitle("Vista eliminar");
		setBounds(100, 100, 450, 232);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblEliminarProyectos = new JLabel("ELIMINAR PROYECTOS");
		lblEliminarProyectos.setBounds(90, 26, 285, 31);
		lblEliminarProyectos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(lblEliminarProyectos);
		
		JLabel lblCodigo = new JLabel("Id");
		lblCodigo.setBounds(118, 79, 56, 16);
		getContentPane().add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setText("");
		textCodigo.setEditable(true);
		textCodigo.setColumns(10);
		textCodigo.setBounds(186, 76, 97, 22);
		getContentPane().add(textCodigo);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(80, 132, 97, 25);
		getContentPane().add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnCancelar.setBounds(250, 132, 97, 25);
		getContentPane().add(btnCancelar);
	}
	public void eliminar() {
		if (!textCodigo.getText().equals(""))
		{
			int respuesta = JOptionPane.showConfirmDialog(this,
					"Esta seguro de eliminar el proyecto?", "Confirmación",
					JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_NO_OPTION)
			{
				proyectoController.eliminarProyecto(textCodigo.getText());
				limpiar();
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void limpiar()
	{
		textCodigo.setText("");
	}
	private void close() {
		this.dispose();
	}
	public void setCoordinador(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}

}

