package views;

import javax.swing.*;


import java.awt.Font;

import controller.CientificoController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarCientifico extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField textCientifico;
	private CientificoController cientificoController;
	
	public EliminarCientifico() {
		setTitle("Vista eliminar");
		setBounds(100, 100, 450, 232);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblEliminarCientifico = new JLabel("ELIMINAR CIENTIFICOS");
		lblEliminarCientifico.setBounds(85, 23, 296, 31);
		lblEliminarCientifico.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(lblEliminarCientifico);
		
		JLabel lblCientifico = new JLabel("DNI");
		lblCientifico.setBounds(131, 79, 44, 16);
		getContentPane().add(lblCientifico);
		
		textCientifico = new JTextField();
		textCientifico.setText("");
		textCientifico.setEditable(true);
		textCientifico.setColumns(10);
		textCientifico.setBounds(186, 76, 97, 22);
		getContentPane().add(textCientifico);
		
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
		if (!textCientifico.getText().equals(""))
		{
			int respuesta = JOptionPane.showConfirmDialog(this,
					"Esta seguro de eliminar al científico?", "Confirmación",
					JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_NO_OPTION)
			{
				cientificoController.eliminarCientifico(textCientifico.getText());
				limpiar();
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
		}
	}
	public void limpiar()
	{
		textCientifico.setText("");
	}
	private void close() {
		this.dispose();
	}
	public void setCoordinador(CientificoController cientificoController) {
		this.cientificoController=cientificoController;
	}

}
