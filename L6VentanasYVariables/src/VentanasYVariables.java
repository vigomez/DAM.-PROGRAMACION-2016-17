import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class VentanasYVariables extends JFrame {
	
	//La clase VentanasYVariables hereda de la clase JFrame
	
	//Atributos

	private JPanel contentPane; //declara el contenedor
	private JTextField cajaTexto; //declara una caja caja de texto
	private JTextField cajaTexto2; //declara otra caja de texto
	private JLabel etiqueta1; //declara un label
	private JLabel etiqueta2; //declara otro label
	

	/**
	 * Lanza la ventana.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanasYVariables frame = new VentanasYVariables();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Configura la ventana .
	 */
	public VentanasYVariables() {
		
		//Declaracion de variables
		
		String name="Vicent";
		int numeroAlumnos=16;	
		
		//Configura la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 300);
		
		//Configura el contenedor
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Configura la primera caja de texto	
		cajaTexto = new JTextField();
		cajaTexto.setBounds(10, 42, 159, 53);
		contentPane.add(cajaTexto);
		cajaTexto.setColumns(10);
		cajaTexto.setText(name); //Escribe el valor de "name" en la caja de texto
		
		//Configura la segunda caja de texto
		cajaTexto2 = new JTextField();		
		cajaTexto2.setBounds(243, 42, 159, 53);
		contentPane.add(cajaTexto2);
		cajaTexto2.setColumns(10);
		cajaTexto2.setText(String.valueOf(numeroAlumnos)); //Escribe numero de alumnos
		
		
		//Configura un Label: etiqueta 1
		etiqueta1 = new JLabel("Etiqueta1");
		etiqueta1.setBounds(10, 11, 95, 20);
		contentPane.add(etiqueta1);
		
		//Configura un Label: etiqueta 2
		etiqueta2 = new JLabel("Etiqueta2");
		etiqueta2.setBounds(243, 11, 95, 20);
		contentPane.add(etiqueta2);		
		
	}
}
