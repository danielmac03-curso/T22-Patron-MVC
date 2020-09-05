package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import model.dto.Cientifico;
import controller.CientificoController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarCientifico extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField textNomApels;
	private JTextField textDNI;
	private CientificoController cientificoController;
	/**
	 * Initialize the contents of the frame.
	 */
	public RegistrarCientifico() {
		setTitle("Vista registrar");
		setBounds(100, 100, 450, 221);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("REGISTRO DE CIENTÍFICOS");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo.setBounds(54, 13, 321, 48);
		getContentPane().add(lblTitulo);
		
		textNomApels = new JTextField();
		textNomApels.setBounds(101, 80, 122, 22);
		getContentPane().add(textNomApels);
		textNomApels.setColumns(10);
		
		JLabel lblNombre = new JLabel("NomApels");
		lblNombre.setBounds(23, 83, 66, 16);
		getContentPane().add(lblNombre);
				
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(255, 83, 30, 16);
		getContentPane().add(lblDNI);
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(288, 80, 122, 22);
		getContentPane().add(textDNI);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
							Cientifico miCientifico=new Cientifico();
							miCientifico.setNomApels(textNomApels.getText());
							
							cientificoController.registrarCientifico(miCientifico);	
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"Error en el ingreso de datos","Error",JOptionPane.ERROR_MESSAGE);
							System.out.println(ex);
						}
					}
					
			
		});
		btnNewButton.setBounds(111, 125, 97, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnCancelar.setBounds(222, 125, 97, 25);
		getContentPane().add(btnCancelar);
		limpiar();
	}
	
	private void limpiar() 
	{
		textNomApels.setText("");
		textDNI.setText("");
	}
	
	public void setCoordinador(CientificoController cientificoController) {
		this.cientificoController=cientificoController;
	}
	private void close() {
		this.dispose();
	}
}
