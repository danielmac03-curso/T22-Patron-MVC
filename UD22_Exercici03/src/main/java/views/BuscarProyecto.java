package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.ProyectoController;
import model.dto.Proyecto;
import model.service.ProyectoServ;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarProyecto extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textHoras;
	private ProyectoController proyectoController;
	private JButton btnModificar;
	private JButton btnGuardar;
	private JButton btnBuscar;
	private JButton btnCancelar;
	
	public BuscarProyecto() {
		setTitle("Vista buscar");
		setBounds(100, 100, 450, 283);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAdministrarProyectos = new JLabel("ADMINISTRAR PROYECTOS");
		lblAdministrarProyectos.setBounds(63, 25, 336, 46);
		lblAdministrarProyectos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		getContentPane().add(lblAdministrarProyectos);
		
		JLabel lblCodigo = new JLabel("Id");
		lblCodigo.setBounds(33, 86, 56, 16);
		getContentPane().add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setText("");
		textCodigo.setColumns(10);
		textCodigo.setBounds(101, 83, 97, 22);
		getContentPane().add(textCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(33, 132, 56, 16);
		getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setText("");
		textNombre.setColumns(10);
		textNombre.setBounds(101, 129, 97, 22);
		getContentPane().add(textNombre);
		
		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(235, 132, 56, 16);
		getContentPane().add(lblHoras);
		
		textHoras = new JTextField();
		textHoras.setText("");
		textHoras.setColumns(10);
		textHoras.setBounds(287, 129, 97, 22);
		getContentPane().add(textHoras);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilita(false, true,true, false, true, false);
				
			}
		});
		btnModificar.setBounds(163, 174, 97, 25);
		getContentPane().add(btnModificar);
		
		btnGuardar = new JButton();
		btnGuardar.setText("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Proyecto miProyecto=new Proyecto();
					miProyecto.setId(textCodigo.getText());
					miProyecto.setNombre(textNombre.getText());
					miProyecto.setHoras(Integer.parseInt(textHoras.getText()));

					proyectoController.modificarProyecto(miProyecto);
					
					if (ProyectoServ.modificaProyecto==true) {
						habilita(true, false, false, true, false, true);	
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Error en el ingreso de datos","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(54, 174, 97, 25);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnCancelar.setBounds(272, 174, 97, 25);
		getContentPane().add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proyecto miProyecto=proyectoController.buscarProyecto(textCodigo.getText());
				if (miProyecto!=null)
				{
					muestraProyecto(miProyecto);
				}
				else if(ProyectoServ.consultaProyecto==true){
					JOptionPane.showMessageDialog(null, "El proyecto no existe","Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(210, 86, 81, 18);
		getContentPane().add(btnBuscar);
		limpiar();
		
	}
	
	public void setCoordinador(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}
	private void muestraProyecto(Proyecto miProyecto) {
		textNombre.setText(miProyecto.getNombre());
		textHoras.setText(miProyecto.getHoras() + "");
		habilita(true, false, false, true, false, true);
	}



	public void limpiar()	{
		textCodigo.setText("");
		textNombre.setText("");
		textHoras.setText("");
		habilita(true, false, false, true, false, true);
	}


	public void habilita(boolean codigo, boolean nombre, boolean horas, boolean bBuscar, boolean bGuardar, boolean bModificar)	{
		textCodigo.setEditable(codigo);
		textNombre.setEditable(nombre);
		textHoras.setEditable(horas);
		btnBuscar.setEnabled(bBuscar);
		btnGuardar.setEnabled(bGuardar);
		btnModificar.setEnabled(bModificar);
	}
	
	private void close() {
		this.dispose();
	}
	
}
