package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import model.dto.Asignado;
import controller.AsignadoController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarAsignado extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField textProyecto;
	private JTextField textCientifico;
	private AsignadoController asignadoController;
	/**
	 * Initialize the contents of the frame.
	 */
	public RegistrarAsignado() {
		setTitle("Vista registrar");
		setBounds(100, 100, 450, 260);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("REGISTRO DE ASIGNACIONES");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(46, 19, 340, 48);
		getContentPane().add(lblTitulo);
		
		textCientifico= new JTextField();
		textCientifico.setBounds(155, 74, 191, 22);
		getContentPane().add(textCientifico);
		textCientifico.setColumns(10);
		
		JLabel lblCientifico = new JLabel("Científico");
		lblCientifico.setBounds(87, 77, 56, 16);
		getContentPane().add(lblCientifico);
		
		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setBounds(87, 123, 56, 16);
		getContentPane().add(lblProyecto);
				
		textProyecto= new JTextField();
		textProyecto.setColumns(10);
		textProyecto.setBounds(155, 120, 191, 22);
		getContentPane().add(textProyecto);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
							Asignado miAsignado=new Asignado();
							miAsignado.setProyecto(textProyecto.getText());
							miAsignado.setCientifico(textCientifico.getText());

							
							asignadoController.registrarAsignado(miAsignado);	
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"Error en el ingreso de datos","Error",JOptionPane.ERROR_MESSAGE);
							System.out.println(ex);
						}
					}
					
			
		});
		btnRegistrar.setBounds(87, 175, 97, 25);
		getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnCancelar.setBounds(245, 175, 97, 25);
		getContentPane().add(btnCancelar);
		limpiar();
	}
	
	private void limpiar() 
	{
		textCientifico.setText("");
		textProyecto.setText("");
	}
	
	public void setCoordinador(AsignadoController asignadoController) {
		this.asignadoController=asignadoController;
	}
	private void close() {
		this.dispose();
	}
}

