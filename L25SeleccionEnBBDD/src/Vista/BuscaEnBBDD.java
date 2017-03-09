package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Usuario;
import Modelo.ConexionDB;
import Modelo.UsuariosDB;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
* BuscaEnBBDD
* Buscará los datos en BBDD a partir de un nombre
*/
public class BuscaEnBBDD extends JFrame {

	//Contenedor Principal BorderLayout
	private JPanel contentPane;
	//Contenedor de los campos de registro
	private JPanel campos;
	//Contenedor para el botón buscar
	private JPanel panel;
	
	//Campos
	private JTextField nombreTxt;
	private JTextField apellido1Txt;
	private JTextField apellido2Txt;
	private JTextField edadTxt;
	private JLabel lblNombre;
	private JLabel lblApellido1;
	private JLabel lblApellido2;
	private JLabel lblEdad;
	private JButton botonBuscar;

	//Manejadores de la base de datos
		private ConexionDB db;
		private UsuariosDB udb;
		private Connection conexion; //Conexión
		private boolean connected =false; //Conexión con éxito
	/**
	 * Create the frame.
	 */
	public BuscaEnBBDD() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 172);
		
		//Panel Principal
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		//Panel para las etiquetas y los campos de nombre, apellidos y edad
		campos = new JPanel();
		contentPane.add(campos);
		campos.setLayout(new GridLayout(0, 2, -200, 5));
		contentPane.add(campos, BorderLayout.NORTH);
		
		lblNombre = new JLabel("Nombre");
		campos.add(lblNombre);
		
		nombreTxt = new JTextField();
		campos.add(nombreTxt);
		nombreTxt.setColumns(10);
		
		lblApellido1 = new JLabel("Apellido1");
		campos.add(lblApellido1);
		
		apellido1Txt = new JTextField();
		campos.add(apellido1Txt);
		apellido1Txt.setColumns(10);
		
		lblApellido2 = new JLabel("Apellido2");
		campos.add(lblApellido2);
		
		apellido2Txt = new JTextField();
		campos.add(apellido2Txt);
		apellido2Txt.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		campos.add(lblEdad);
		
		edadTxt = new JTextField();
		campos.add(edadTxt);
		edadTxt.setColumns(10);
		
		//Panel para el botón de búsqueda
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		//Botón de búsqueda: Buscamos al usuario y cerramos la conexion
		botonBuscar = new JButton("Buscar");
		botonBuscar.setBackground(Color.YELLOW);
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conectar(); //Conectamos con BBDD
				Usuario u=udb.buscarUsuario(nombreTxt.getText()); //Buscamos usuario y cerramos conexion
				apellido1Txt.setText(u.getApellido1());           //Sacamos datos por ventana
				apellido2Txt.setText(u.getApellido2());
				edadTxt.setText(String.valueOf(u.getEdad()));
			}
		});
		panel.add(botonBuscar);
		

		
		
	}
	
	//Conectar con la base de datos
	private void Conectar(){
		//Conexión con la BBDD
		//Creamos nuestro objeto para el manejo de la base de datos
		db=new ConexionDB("localhost","usuarios","root","");
		//Establecemos la conexion
		connected=db.connectDB();
		//Asignamos con el getter la conexion establecida
		conexion=db.getConexion();
		//Pasamos la conexión a un nuevo objeto UsuariosDB para insertar datos.
		udb=new UsuariosDB(conexion); 
	}
	

}