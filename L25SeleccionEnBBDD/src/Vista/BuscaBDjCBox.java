package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Modelo.ConexionDB;
import Modelo.Usuario;
import Modelo.UsuariosDB;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/*Clase que busca por el nombre todos los usuarios que aparecen
 * en una BBDD, los muestra en un JComboBox y permite elegir
 * en caso de que haya varios casos
 */
public class BuscaBDjCBox extends JFrame {

	
	    //Contenedor Principal 
		private JPanel contentPane;
		//Contenedores secundarios
		private JPanel campos;
		private JPanel panel;
		
		//Campos de registro, botones y áreas de texto
		private JTextField nombreTxt;
		private JTextField apellido1Txt;
		private JTextField apellido2Txt;
		private JTextField edadTxt;
		private JLabel lblUsuarios;
		private JLabel lblNombre;
		private JLabel lblApellido1;
		private JLabel lblApellido2;
		private JLabel lblEdad;
		private JButton btnBuscar;
		

		//Manejadores de la base de datos
		private ConexionDB db;
		private UsuariosDB udb;
		private Connection conexion; //Conexión
		private boolean connected =false; //Conexión con éxito
		
		//JCOmbobox de usuarios
		private JComboBox comboBox;
		private int numero_de_items; //numero de elementos en el ComboBox
		
		/**
		 * Create the frame.
		 */
		public BuscaBDjCBox() {
			
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 467, 227);
			
			//El JPanel General del JFRAME es un BorderLayout
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));

			//Al JPanel general se le añade un JPanel "campos" tipo GridLayout
			//para los campos: ComboBox, nombre, apellido1, apellido2, edad.
			campos = new JPanel();
			contentPane.add(campos);
			campos.setLayout(new GridLayout(0, 2, -300, 5));
			contentPane.add(campos, BorderLayout.NORTH);
			
			lblUsuarios = new JLabel("Usuarios");
			campos.add(lblUsuarios);
			
			//Añadimos un JComboBox al lado del label usuarios para mostrar el resultado
			//de la búsqueda sobre la base de datos
			comboBox = new JComboBox();
			//Listener sobre los items para permitir seleccionar el que queramos del Combo Box
			//Y rellenar los datos de la ventana
			
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Por defecto mostrará en pantalla la primera coincidencia con el
					//nombre encontrado en la BBDD
					//Seleccionando sobre el desplegable del JComboBox se podrá cambiar si hay varias coincidencias
					
					Usuario u=(Usuario)comboBox.getSelectedItem();
					
					if (u!=null) //Si la lista no del Combox no está vacía
					{
				    nombreTxt.setText(u.getNombre());
					apellido1Txt.setText(u.getApellido1());
					apellido2Txt.setText(u.getApellido2());
					edadTxt.setText(String.valueOf(u.getEdad()));
					//Comprobacion
					System.out.println("El usuario seleccionado es: "+u.toString());}
				}
			}
			);
			comboBox.setFocusable(true);
			comboBox.setFocusTraversalKeysEnabled(true);
			campos.add(comboBox);
			
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
			
			//Al JPanel Principal añadimos otro Panel para el botón buscar
			panel = new JPanel();
			//contentPane.add(panel);
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			contentPane.add(panel, BorderLayout.CENTER);

			
			//Botón Buscar: Buscamos usuario por nombre y los encontrados los ponemos en el Combox
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Vaciamos el ComboBox
					comboBox.removeAllItems(); //Vaciamos los Items anteriores
					//Conectamos con la BBDD
					Conectar();
					//Buscamos el usuario por el nombre y las coincidencias van a un ComboBox
					udb.buscarUsuario(nombreTxt.getText(),comboBox);
					
					numero_de_items=comboBox.getItemCount(); //Número de ítems en el ComboBox
					//Sirve para el caso en que el nombre buscado no está en la BBDD y el Combox esté vacío
					if (numero_de_items==0){
					apellido1Txt.setText("Usuario no encontrado");
					apellido2Txt.setText("Usuario no encontrado");
					edadTxt.setText("Usuario no encontrado");}					
				}
			});
			panel.add(btnBuscar);
			
			

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
