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
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.TextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;

/*Clase que busca por el nombre todos los usuarios que aparecen
 * en una BBDD con dicho nombre, los muestra en un JComboBox y permite elegir
 * en caso de que haya varios casos
 */
public class UpdateUsuario extends JFrame {

	
	    //Contenedor Principal 
		private JPanel contentPane;
		
		//Contenedores secundarios
		private JPanel campos;
		private JPanel panel;
		
		//Campos de registro, botones y áreas de texto
		private JLabel lblUsuarios;
		private JTextField nombreTxt;
		private JTextField apellido1Txt;
		private JTextField apellido2Txt;
		private JTextField edadTxt;
		private JLabel lblNombre;
		private JLabel lblApellido1;
		private JLabel lblApellido2;
		private JLabel lblEdad;
		private JButton btnBuscar;
		private JTextArea textMensajes;
		

		//Manejadores de la base de datos
		private ConexionDB db;
		private UsuariosDB udb;
		private Connection conexion; //Conexión
		private boolean connected =false; //Conexión con éxito
		
		//JCOmbobox de usuarios
		private JComboBox comboBox;
		private int numero_de_items; //numero de elementos en el ComboBox
		private JButton btnActualizar;
		
		//Objeto usuario, a nivel de clase para que sea visible a toda
		
		private Usuario u;

		
		/**
		 * Create the frame.
		 */
		public UpdateUsuario() {
			setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 539, 334);
			
			//El JPanel General del JFRAME es un BorderLayout
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
            
			//Al JPanel general se le añade un JPanel "campos" tipo GridLayout
			//para los campos: ComboBox, nombre, apellido1, apellido2, edad.
			
			campos = new JPanel();
			campos.setLayout(new GridLayout(0, 2, -300, 5));
			contentPane.add(campos, BorderLayout.NORTH);
			
			lblUsuarios = new JLabel("Usuarios");
			campos.add(lblUsuarios);
			
			//Añadimos un JComboBox al lado del label usuarios para mostrar el resultado
			//de la búsqueda sobre la base de datos
			comboBox = new JComboBox();		
			//Listener sobre los items para permitir seleccionar el que queramos del Combo Box
			//Y rellenar los datos de la ventana
			comboBox.addActionListener(new miComboBox());
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
			
			//Al JPanel Principal añadimos otro Panel para los botones y una area de texto de información
			
			panel = new JPanel();
			panel.setLayout(null);
			contentPane.add(panel, BorderLayout.CENTER);
					
			//Botón para actualizar los datos de un jugador
			btnActualizar = new JButton("Actualizar");
			btnActualizar.setBounds(163, 8, 108, 23);
			btnActualizar.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnActualizar.addActionListener(new miBotonActualizar()); 
			panel.add(btnActualizar);
			
			//Botón para Buscar usuario por nombre y los encontrados los pondremos en el Combox
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(281, 8, 108, 23);
			btnBuscar.addActionListener(new miBotonBuscar()); 
			panel.add(btnBuscar);
			
			//Area para mensajes
			textMensajes = new JTextArea();
			textMensajes.setBorder(new LineBorder(Color.RED));
			textMensajes.setWrapStyleWord(true);
			textMensajes.setEditable(false);
			textMensajes.setBounds(10, 38, 503, 92);
			textMensajes.setText("Pon tu nombre y búscate en la BBDD de usuarios.");
			panel.add(textMensajes);

			

	}
		//Métodos de la Clase

		//Conectar con la base de datos
		private void Conectar(){
			//Conexión con la BBDD
			//Creamos nuestro objeto para el manejo de la base de datos
			try{
				db=new ConexionDB("localhost","usuarios","root","");
				//Establecemos la conexion
				connected=db.connectDB();
				//Asignamos con el getter la conexion establecida
				conexion=db.getConexion();
				//Pasamos la conexión a un nuevo objeto UsuariosDB para insertar datos.
				udb=new UsuariosDB(conexion);}
			catch(Exception e)
			{
				textMensajes.setText( " Debe haber algún problema con la BBDD o con la conexión.");	
			}
		}
		
		//Método para comprobar los datos del usuario si se modifican
		private boolean ComprobarDatos()
		{   if (u==null)
		       {textMensajes.setText(" No hay datos que actualizar.");return false;}		
		    else if (!u.isNumeric(edadTxt.getText()))
				{textMensajes.setText("EDAD no correcta."); return false;}
			else if (u.sonEspacios(nombreTxt.getText()))
				{textMensajes.setText("Falta el nombre."); return false;}
			else if (u.sonEspacios(apellido1Txt.getText()))
				{textMensajes.setText("Falta el primer apellido."); return false;}
			else if (u.sonEspacios(apellido2Txt.getText()))
				{textMensajes.setText("Falta el segundo apellido."); return false;}
			else{
			return true;}
		
		}
		
		
		//Inner Clases para los diferentes listeners
		
		//Listener para el ComboBox
		private class miComboBox implements ActionListener {
		@Override
		   public void actionPerformed(ActionEvent e) {
				//Por defecto mostrará en pantalla la primera coincidencia con el
				//nombre encontrado en la BBDD
				//Seleccionando sobre el desplegable del JComboBox se podrá cambiar si hay varias coincidencias
				
				u=(Usuario)comboBox.getSelectedItem();
				
				if (u!=null) //Si la lista del combox no está vacía
				{
				nombreTxt.setText(u.getNombre());
				apellido1Txt.setText(u.getApellido1());
				apellido2Txt.setText(u.getApellido2());
				edadTxt.setText(String.valueOf(u.getEdad()));
				textMensajes.setText(" Si el usuario mostrado no eres tu, mira la lista de usuarios.\n Puedes modificar y actualizar tus datos o buscarte con otro nombre.");
				//Comprobacion
				System.out.println("El usuario seleccionado es: "+u.toString());}
				
			}

		}
		
		//Listener para el boton Buscar
		private class miBotonBuscar implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Vaciamos el ComboBox
				comboBox.removeAllItems(); //Vaciamos los Items anteriores del ComboBox
				apellido1Txt.setText("");
				apellido2Txt.setText("");
				edadTxt.setText("");
				//Conectamos con la BBDD
				Conectar();
				//Buscamos el usuario por el nombre y las coincidencias van a un ComboBox
				udb.buscarUsuario(nombreTxt.getText(),comboBox);
				
				numero_de_items=comboBox.getItemCount(); //Número de ítems en el ComboBox
				//Sirve para el caso en que el nombre buscado no esté en la lista
				if (numero_de_items==0){
				apellido1Txt.setText("Usuario no encontrado");
				apellido2Txt.setText("Usuario no encontrado");
				edadTxt.setText("Usuario no encontrado");
				textMensajes.setText(" Lo siento no estás registrado o no has introducido un nombre.\n Puedes volver a buscar con otro nombre.");
				}		
				}
		}
		
		//Listener para el boton Actualizar
		private class miBotonActualizar implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				    //Antes de realizar la consulta a la base de datos debemos actualizar el objeto usuario
				    //Si los datos modificados son correctos
					
				if (ComprobarDatos())	
					{u.setNombre(nombreTxt.getText());
					u.setApellido1(apellido1Txt.getText());
					u.setApellido2(apellido2Txt.getText());
					u.setEdad(Integer.valueOf(edadTxt.getText()));
					//Conectamos y actualizamos usuario
					Conectar();
					//udb.actualizarUsuario(u);
					udb.actualizarUsuarioPreparada(u);
					//Comprobacion
					textMensajes.setText("Tu usuario se ha actualizado como: "+u.toString()+"\n Puedes hacer una nueva búsqueda");
					System.out.println("El usuario se ha actualizado a: "+u.toString());
					//Vaciamos el ComboBox u los campos de texto
					comboBox.removeAllItems();
					nombreTxt.setText("");
					apellido1Txt.setText("");
					apellido2Txt.setText("");
					edadTxt.setText("");

			        }
				}
			}
	}



