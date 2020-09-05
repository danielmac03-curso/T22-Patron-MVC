package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.CientificoController;
import model.dto.Cientifico;
import model.service.CientificoServ;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarCientifico extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField textNomApels;
	private JTextField textDNI;
	private CientificoController cientificoController;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JButton btnBuscar;
	private JButton btnCancelar;
	
	public BuscarCientifico() {
		setTitle("Vista buscar");
		setBounds(100, 100, 450, 274);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAdministrarCientíficos = new JLabel("ADMINISTRAR CIENTÍFICOS");
		lblAdministrarCientíficos.setBounds(58, 27, 330, 46);
		lblAdministrarCientíficos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(lblAdministrarCientíficos);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(80, 78, 56, 16);
		getContentPane().add(lblDNI);
		
		textDNI = new JTextField();
		textDNI.setText("");
		textDNI.setColumns(10);
		textDNI.setBounds(148, 75, 97, 22);
		getContentPane().add(textDNI);
		
		JLabel lblNombre = new JLabel("NomApels");
		lblNombre.setBounds(80, 124, 67, 16);
		getContentPane().add(lblNombre);
		
		textNomApels = new JTextField();
		textNomApels.setText("");
		textNomApels.setColumns(10);
		textNomApels.setBounds(148, 121, 97, 22);
		getContentPane().add(textNomApels);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilita(false, true, false, true, false);
				
			}
		});
		btnModificar.setBounds(167, 169, 97, 25);
		getContentPane().add(btnModificar);
		
		btnGuardar = new JButton();
		btnGuardar.setText("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cientifico miCientifico=new Cientifico();
					miCientifico.setDni(textDNI.getText());
					miCientifico.setNomApels(textNomApels.getText());

					cientificoController.modificarCientifico(miCientifico);
					
					if (CientificoServ.modificaCientifico==true) {
						habilita(true, false, true, false, true);	
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Error en el ingreso de datos","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(58, 169, 97, 25);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnCancelar.setBounds(280, 169, 97, 25);
		getContentPane().add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cientifico miCientifico=cientificoController.buscarCientifico(textDNI.getText());
				if (miCientifico!=null)
				{
					muestraCientifico(miCientifico);
				}
				else if(CientificoServ.consultaCientifico==true){
					JOptionPane.showMessageDialog(null, "El científico no existe","Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(257, 78, 81, 18);
		getContentPane().add(btnBuscar);
		limpiar();
		
	}
	
	public void setCoordinador(CientificoController cientificoController) {
		this.cientificoController=cientificoController;
	}
	private void muestraCientifico(Cientifico miCientifico) {
		textNomApels.setText(miCientifico.getNomApels());
		habilita(true, false, true, false, true);
	}



	public void limpiar()	{
		textNomApels.setText("");
		textDNI.setText("");
		habilita(true, false, true, false, true);
	}


	public void habilita(boolean codigo, boolean nombre, boolean bBuscar, boolean bGuardar, boolean bModificar)	{
		textDNI.setEditable(codigo);
		textNomApels.setEditable(nombre);
		btnBuscar.setEnabled(bBuscar);
		btnGuardar.setEnabled(bGuardar);
		btnModificar.setEnabled(bModificar);
	}
	
	private void close() {
		this.dispose();
	}
	
}
