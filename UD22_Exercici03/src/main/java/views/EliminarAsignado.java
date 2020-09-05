package views;

import javax.swing.*;


import java.awt.Font;

import controller.AsignadoController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarAsignado extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField textCientifico, textProyecto;
	private AsignadoController asignadoController;
	
	public EliminarAsignado() {
		setTitle("Vista eliminar");
		setBounds(100, 100, 450, 232);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblEliminarAsignados = new JLabel("ELIMINAR ASIGNACIONES");
		lblEliminarAsignados.setBounds(80, 13, 293, 31);
		lblEliminarAsignados.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(lblEliminarAsignados);
		
		JLabel lblCientifico = new JLabel("Científico");
		lblCientifico.setBounds(121, 57, 56, 16);
		getContentPane().add(lblCientifico);
		
		textCientifico = new JTextField();
		textCientifico.setText("");
		textCientifico.setEditable(true);
		textCientifico.setColumns(10);
		textCientifico.setBounds(186, 57, 116, 22);
		getContentPane().add(textCientifico);
		
		textProyecto = new JTextField();
		textProyecto.setText("");
		textProyecto.setEditable(true);
		textProyecto.setColumns(10);
		textProyecto.setBounds(186, 86, 116, 22);
		getContentPane().add(textProyecto);
		
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
		
		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setBounds(121, 89, 56, 16);
		getContentPane().add(lblProyecto);
	}
	public void eliminar() {
		if (!textCientifico.getText().equals(""))
		{
			int respuesta = JOptionPane.showConfirmDialog(this,
					"Esta seguro de eliminar la asignación?", "Confirmación",
					JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_NO_OPTION)
			{
				asignadoController.eliminarAsignado(textCientifico.getText(), textProyecto.getText());
				limpiar();
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Ingrese un numero de documento", "Información",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void limpiar()
	{
		textCientifico.setText("");
		textProyecto.setText("");
	}
	private void close() {
		this.dispose();
	}
	public void setCoordinador(AsignadoController asignadoController) {
		this.asignadoController=asignadoController;
	}
}
