package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import model.dto.Proyecto;
import controller.ProyectoController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarProyecto extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textHoras;
	private ProyectoController proyectoController;
	private JTextField textField;
	/**
	 * Initialize the contents of the frame.
	 */
	public RegistrarProyecto() {
		setTitle("Vista registrar");
		setBounds(100, 100, 450, 280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("REGISTRO DE PROYECTOS");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(65, 13, 323, 48);
		getContentPane().add(lblTitulo);
		
		textNombre = new JTextField();
		textNombre.setBounds(101, 125, 97, 22);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(33, 128, 56, 16);
		getContentPane().add(lblNombre);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(235, 83, 56, 16);
		getContentPane().add(lblHoras);
		
		textHoras = new JTextField();
		textHoras.setColumns(10);
		textHoras.setBounds(290, 80, 97, 22);
		getContentPane().add(textHoras);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
							Proyecto miProyecto=new Proyecto();
							miProyecto.setNombre(textNombre.getText());
							miProyecto.setHoras(Integer.parseInt(textHoras.getText()));
							
							proyectoController.registrarProyecto(miProyecto);	
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"Error en el ingreso de datos","Error",JOptionPane.ERROR_MESSAGE);
							System.out.println(ex);
						}
					}
					
			
		});
		btnNewButton.setBounds(102, 173, 97, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnCancelar.setBounds(226, 173, 97, 25);
		getContentPane().add(btnCancelar);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(33, 83, 56, 16);
		getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setText("");
		textField.setColumns(10);
		textField.setBounds(101, 80, 97, 22);
		getContentPane().add(textField);
		limpiar();
	}
	
	private void limpiar() 
	{
		textNombre.setText("");
		textHoras.setText("");
	}
	
	public void setCoordinador(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}
	private void close() {
		this.dispose();
	}
}
