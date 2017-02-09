package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.ConexionDB;
import Modelo.UsuariosDB;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* <h1>RegistroUsuario</h1>
* Ventana que nos permitirá registrar un usuario en
* nuestra base de datos.
*
*/
public class RegistroUsuario extends JFrame {

	//Contenedor Principal BorderLayout
	private JPanel contentPane;
	//Contenedor de los campos de registro
	private JPanel campos;
	//Contenedor del botón de registro
	private JPanel registro;
	
	
	//Elementos del JPanel campos
	private JTextField nombreTxt;
	private JTextField apellido1Txt;
	private JTextField apellido2Txt;
	private JTextField edadTxt;
	private JLabel lblNombre;
	private JLabel lblApellido1;
	private JLabel lblApellido2;
	private JLabel lblEdad;
	
	//Elementos del JPanel registro
	private JButton btn_registro;
	
	
    //Manejadores de la base de datos
	private ConexionDB db;
	private UsuariosDB udb;
	private Connection conexion; //Conexión
	private boolean connected =false; //Conexión con éxito
	/**
	 * Create the frame.
	 */
	public RegistroUsuario() {
		
		//Características del JFrame
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 172);
		
		//Panel que contendrá el Panel para los datos y el Panel para el registro
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
 
		//Campos de registro en un GridLayout
		campos = new JPanel();
		contentPane.add(campos);
		campos.setLayout(new GridLayout(0, 2, -200, 5));
		contentPane.add(campos, BorderLayout.NORTH);
		
		//Nombre
		lblNombre = new JLabel("Nombre");
		campos.add(lblNombre);
		
		nombreTxt = new JTextField();
		campos.add(nombreTxt);
		nombreTxt.setColumns(10);
		
		//Primer apellido
		lblApellido1 = new JLabel("Apellido1");
		campos.add(lblApellido1);
		
		apellido1Txt = new JTextField();
		campos.add(apellido1Txt);
		apellido1Txt.setColumns(10);
		
		//Segundo Apellido
		lblApellido2 = new JLabel("Apellido2");
		campos.add(lblApellido2);
		
		apellido2Txt = new JTextField();
		campos.add(apellido2Txt);
		apellido2Txt.setColumns(10);
		
		//Edad
		lblEdad = new JLabel("Edad");
		campos.add(lblEdad);
		
		edadTxt = new JTextField();
		campos.add(edadTxt);
		edadTxt.setColumns(10);
		
		//Boton de registro en un FlowLayout
		registro = new JPanel();
		contentPane.add(registro);
		registro.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		//Registramos nuevo usuario y cerramos la conexion
		btn_registro = new JButton("Registro");
		btn_registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				udb.insertarUsuario(nombreTxt.getText(), apellido1Txt.getText(), apellido2Txt.getText(), Integer.valueOf(edadTxt.getText()));
			}
		});
		registro.add(btn_registro);
		
		
		
		//Creamos nuestro objeto para el manejo de la base de datos
		db=new ConexionDB("localhost","usuarios","root","");
		//Establecemos la conexion
		connected=db.connectDB();
		//Asignamos con el getter la conexion establecida
		conexion=db.getConexion();
		//Pasamos la conexión a un nuevo objeto UsuariosDB para insertar datos.
		udb=new UsuariosDB(conexion); 
		
        
		//Comprobamos si la conexión ha tenido éxito
		if(connected==false) {
			System.out.println("SIN EXITO EN LA CONEXION");
		}
		else System.out.println("EXITO EN LA CONEXION");
	}

}