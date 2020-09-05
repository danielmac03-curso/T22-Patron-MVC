package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.AsignadoController;
import model.dto.Asignado;
import model.service.AsignadoServ;

public class BuscarAsignado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textCientifico;
	private JTextField textProyecto;
	private AsignadoController asignadoController;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JButton btnBuscar;
	private JButton btnCancelar;
	
	public BuscarAsignado() {
		setTitle("Vista buscar");
		setBounds(100, 100, 450, 292);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAdministrarAsignado = new JLabel("ADMINISTRAR ASIGNACIONES");
		lblAdministrarAsignado.setBounds(46, 27, 344, 46);
		lblAdministrarAsignado.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(lblAdministrarAsignado);
		
		JLabel lblCientífico = new JLabel("Científico");
		lblCientífico.setBounds(86, 86, 56, 16);
		getContentPane().add(lblCientífico);
		
		textCientifico = new JTextField();
		textCientifico.setText("");
		textCientifico.setColumns(10);
		textCientifico.setBounds(154, 86, 97, 22);
		getContentPane().add(textCientifico);
		
		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setBounds(86, 132, 56, 16);
		getContentPane().add(lblProyecto);
		
		textProyecto = new JTextField();
		textProyecto.setText("");
		textProyecto.setColumns(10);
		textProyecto.setBounds(154, 129, 97, 22);
		getContentPane().add(textProyecto);
		
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilita(true, true, false, true, false);
				
			}
		});
		btnModificar.setBounds(166, 181, 97, 25);
		getContentPane().add(btnModificar);
		
		btnGuardar = new JButton();
		btnGuardar.setText("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					try {				
						Asignado miAsignado=new Asignado();
						miAsignado.setCientifico(textCientifico.getText());
						miAsignado.setProyecto(textProyecto.getText());

						

						asignadoController.modificarAsignado(miAsignado);
						
						if (AsignadoServ.modificaAsignado==true) {
							habilita(true, true, true, false, true);	
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,"Error en el ingreso de datos","Error",JOptionPane.ERROR_MESSAGE);
						System.out.println(e2);
					}
					
				}
			}
		});
		btnGuardar.setBounds(58, 181, 97, 25);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnCancelar.setBounds(275, 181, 97, 25);
		getContentPane().add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Asignado miAsignado=asignadoController.buscarAsignado(textCientifico.getText(),textProyecto.getText());
				if (miAsignado!=null)
				{
					muestraAsignado(miAsignado);
				}
				else if(AsignadoServ.consultaAsignado==true){
					JOptionPane.showMessageDialog(null, "La asignación no existe","Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(277, 131, 81, 18);
		getContentPane().add(btnBuscar);
		limpiar();
		
	}
	
	public void setCoordinador(AsignadoController asignadoController) {
		this.asignadoController=asignadoController;
	}
	
	/**
	 * permite cargar los datos de la video consultada
	 * @param miVideo
	 */
	private void muestraAsignado(Asignado miAsignado) {
		textCientifico.setText(miAsignado.getCientifico());
		textProyecto.setText(miAsignado.getProyecto());
		habilita(true, true, true, false, true);
	}

	public void limpiar()	{
		textCientifico.setText("");
		textProyecto.setText("");
		habilita(true, true, true, false, true);
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

	public void habilita(boolean cientifico, boolean proyecto,	boolean bBuscar, boolean bGuardar, boolean bModificar)	{
		textCientifico.setEditable(cientifico);
		textProyecto.setEditable(proyecto);
		btnBuscar.setEnabled(bBuscar);
		btnGuardar.setEnabled(bGuardar);
		btnModificar.setEnabled(bModificar);
	}
	
	private void close() {
		this.dispose();
	}
	
}

