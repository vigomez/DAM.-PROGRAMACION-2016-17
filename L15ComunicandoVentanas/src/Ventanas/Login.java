package Ventanas; //La clase Login estará en el paquete Ventanas

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private String nombreBoton;
	//no crea un nuevo objeto de la clase Login, sino una etiqueta de referencia a un objeto tipo Login
	private Login referencia;
	//Permite acceso desde esta ventana, Login, a otra, vPrincipal, pasándola como referencia
	private VentanaPrincipal vPrincipal;

	/**
	 * Create the frame.
	 */
	public Login(VentanaPrincipal vP) {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.nombreBoton="Cmbio texto"; //Ejemplo uso de this
		// referencia se asocia al objeto creado que es  tipo Login.
		referencia=this;
		//La etiqueta vPrincipal se asocia al input de Login. Se hace visible a toda la clase
		vPrincipal=vP;
		
		//Creamos un botón. Al pulsarlo se cerrará la ventana 
		JButton boton = new JButton("Cerrar");
		boton.addActionListener(new ActionListener() {
			//Estamos detro de un nuevo objeto. 
			//No se puede hacer directamente login.dispose() o this.dispose()
			//para cerrar ventana.
			//Es necesario tener una referenia a login 
			//en la declaración de Atributos para que sea accesible aquí
			public void actionPerformed(ActionEvent arg0) {
				referencia.dispose();
			}
		});
		boton.setBounds(238, 228, 186, 23);
		contentPane.add(boton);
		
		//Creamos otro botón. Al pulsarlo se hará visible vPrincipal e invisible Login
		JButton saltarVentana = new JButton("VentanaPrincipal >>");
		saltarVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vPrincipal.setVisible(true); //vPrincipal es accesible aquí
				referencia.setVisible(false);
			}
		});
		saltarVentana.setBounds(238, 194, 186, 23);
		contentPane.add(saltarVentana);
	}

}