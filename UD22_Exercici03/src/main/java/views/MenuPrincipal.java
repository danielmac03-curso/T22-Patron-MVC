package views;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.AsignadoController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.ProyectoController;
import controller.CientificoController;

public class MenuPrincipal extends JFrame{

	private AsignadoController asignado = new AsignadoController();
	private static final long serialVersionUID = 1L;
	private CientificoController cientifico = new CientificoController();
	private ProyectoController proyecto =  new ProyectoController();
	
	public MenuPrincipal() {
		setBounds(100, 100, 595, 327);
		setTitle("Vista Controlador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar Cientifico");
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cientifico.mostrarBuscar();
			}
		});
		btnBuscar.setBounds(217, 119, 155, 25);
		getContentPane().add(btnBuscar);
		
		JButton btnRegistrar = new JButton("Registrar Cientifico");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cientifico.mostrarRegistrar();
			}
		});
		btnRegistrar.setBounds(50, 119, 155, 25);
		getContentPane().add(btnRegistrar);
		
		JLabel lblTitulo = new JLabel("PATRÓN MODELO VISTA CONTROLADOR");
		lblTitulo .setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitulo .setBounds(64, 53, 472, 43);
		getContentPane().add(lblTitulo );
		
		JButton btnEliminar = new JButton("Eliminar Cientifico");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cientifico.mostrarEliminar();
			}
		});
		btnEliminar.setBounds(387, 119, 149, 25);
		getContentPane().add(btnEliminar);
		
		JButton btnRegistrarAsignacion = new JButton("Registrar Asignación");
		btnRegistrarAsignacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignado.mostrarRegistrarAsignado();
				
			}
		});
		btnRegistrarAsignacion.setBounds(50, 168, 155, 25);
		getContentPane().add(btnRegistrarAsignacion);
		
		JButton btnBuscarAsignacion = new JButton("Buscar Asignación");
		btnBuscarAsignacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignado.mostrarBuscarAsignado();
			}
		});
		btnBuscarAsignacion.setBounds(217, 168, 155, 25);
		getContentPane().add(btnBuscarAsignacion);
		
		JButton btnEliminarAsignacion = new JButton("Eliminar Asignación");
		btnEliminarAsignacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignado.mostrarEliminarAsignado();
			}
		});
		btnEliminarAsignacion.setBounds(387, 168, 155, 25);
		getContentPane().add(btnEliminarAsignacion);
		
		JButton btnRegistrarProyecto = new JButton("Registrar Proyecto");
		btnRegistrarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proyecto.mostrarRegistrar();
			}
		});
		btnRegistrarProyecto.setBounds(50, 217, 155, 25);
		getContentPane().add(btnRegistrarProyecto);
		
		JButton btnBuscarProyecto = new JButton("Buscar proyecto");
		btnBuscarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proyecto.mostrarBuscar();
			}
		});
		btnBuscarProyecto.setBounds(217, 217, 155, 25);
		getContentPane().add(btnBuscarProyecto);
		
		JButton btnEliminarProyecto = new JButton("Eliminar Proyecto");
		btnEliminarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proyecto.mostrarEliminar();
			}
		});
		btnEliminarProyecto.setBounds(387, 217, 149, 25);
		getContentPane().add(btnEliminarProyecto);
		
		
	}
	
	public void setCoordinador(CientificoController cientificoController) {
		this.cientifico=cientificoController;
	}
	public void setAsignadoCoordinador(AsignadoController asignadoController) {
		this.asignado=asignadoController;
	}
	public void setProyectoCoordinador(ProyectoController proyectoController) {
		this.proyecto=proyectoController;
	}
}
