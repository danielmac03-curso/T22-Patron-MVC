package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.model.dto.Video;


public class VentanaRegistroVideos extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private VideoController videoController; //objeto videoController que permite la relacion entre esta clase y la clase VideoController
	private JLabel labelTitulo;
	private JTextField textTitle,textDirector,textCli_id;
	private JLabel title,director,Cli_id;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistroVideos() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE VIDEO");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));
		
		title=new JLabel();
		title.setText("Título");
		title.setBounds(20, 120, 80, 25);
		getContentPane().add(title);
		
		Cli_id=new JLabel();
		Cli_id.setText("Cli_id");
		Cli_id.setBounds(20, 160, 80, 25);
		getContentPane().add(Cli_id);
		
		director=new JLabel();
		director.setText("Director");
		director.setBounds(255, 120, 80, 25);
		getContentPane().add(director);
		
		textTitle=new JTextField();
		textTitle.setBounds(80, 120, 150, 25);
		getContentPane().add(textTitle);
		
		textCli_id=new JTextField();
		textCli_id.setBounds(80, 160, 150, 25);
		getContentPane().add(textCli_id);
		
		textDirector=new JTextField();
		textDirector.setBounds(310, 120, 150, 25);
		getContentPane().add(textDirector);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textTitle.setText("");
		textDirector.setText("");
		textCli_id.setText("");
	}


	public void setCoordinador(VideoController controllerVideos) {
		this.videoController=controllerVideos;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Video miVideo=new Video();
				miVideo.setTitleVideo(textTitle.getText());
				miVideo.setDirectorVideo(textDirector.getText());
				miVideo.setCli_idVideo(Integer.parseInt(textCli_id.getText()));
				videoController.registrarVideo(miVideo);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}

	
	

}
