import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

/**
* <h1>VentanaUsuariosCombo</h1>
* La clase VentanaUsuariosCombo nos muestra un sencillo ejemplo de uso del JComboBox
* <p>
* Aprendemos como:
*  - Usar el JComBoBox
*  - Introducir eventos
*  - Manejar objetos
*/
public class VentanaUsuariosCombo extends JFrame {

	private JPanel contentPane;
	private String[] ciudades={"València","Castelló","Alacant","Bilbao","San Sebastián","Vitoria"};
	private JComboBox comboNombresPersonas; //ComboBox para mostrar nombres de personas
	private JComboBox comboCiudades;         //ComboBox para mostrar nombres de ciudades
	private JTextField nombreElegido;       //Campo de texto para mostrar nombre elegido
	private JComboBox comboComunidades;     //ComboBox para mostrar nombre Comunidades Autónomas
	private Comunidad cv;                   //Comunidad Valenciana
	private Comunidad pv;                   //País Vasco

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuariosCombo frame = new VentanaUsuariosCombo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaUsuariosCombo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 123);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//CAmbiamos el manager a FlowLayout
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		//Añadimos los elementos gráficos
		JLabel lblUsuarios = new JLabel("Usuarios");
		contentPane.add(lblUsuarios);
		
		//Nuestra lista de usuarios
		comboNombresPersonas = new JComboBox();
		contentPane.add(comboNombresPersonas);
		comboNombresPersonas.addItem("Paco");  //Añade al Combo un objeto genérico, en este caso un string
		comboNombresPersonas.addItem("Julia");
		String nombre1="Ana";
		comboNombresPersonas.addItem(nombre1); 
		String nombre2="Pedro Gomez";
		comboNombresPersonas.addItem(nombre2);
		//Listener sobre el combo: el nombre elegido se mostrará en el campo de texto
		comboNombresPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreElegido.setText((String)comboNombresPersonas.getSelectedItem());
			}
		});
		
		//Nuestra lista de ciudades
		comboCiudades = new JComboBox();
		contentPane.add(comboCiudades);
		for(int i=0;i<ciudades.length;i++){
			comboCiudades.addItem(ciudades[i]);
		}
		
		//Campo de texto donde se mostrará el nombre elegido
		nombreElegido = new JTextField();
		contentPane.add(nombreElegido);
		nombreElegido.setColumns(10);
			
		
		//ComboBox que mostrará las Comunidades Autónomas
		//Ejemplo de como puede almacenar objetos, en este caso de la clase Comunidad
		comboComunidades = new JComboBox();
		cv=new Comunidad();
		pv=new Comunidad();
		//Rellenamos las provincias
		cv.setNombre("Comunidad Valenciana");
		pv.setNombre("País Vasco");
		cv.setNumProvincias(3);
		pv.setNumProvincias(3);
		cv.getProvincias()[0]="Castelló";
		cv.getProvincias()[1]="València";
		cv.getProvincias()[2]="Alacant";
		pv.getProvincias()[0]="Vizcaya";
		pv.getProvincias()[1]="Guipuzcoa";
		pv.getProvincias()[2]="Álava";
		//Añadimos el nombre de las Comunidades al Combo Box
		comboComunidades.addItem(cv);
		comboComunidades.addItem(pv);
		
		//Listener sobre el combo de Comunidades: Saca por monitor el nombre de las provincias
		comboComunidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comunidad c=(Comunidad)comboComunidades.getSelectedItem(); //Escoge el objeto del item seleccionado del combo box
				for(int i=0;i<c.getNumProvincias();i++) System.out.println(c.getProvincias()[i]);
			}
		});		
		
		contentPane.add(comboComunidades);

	}

}