import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ProbandoBoton extends JFrame {

	private JPanel contentPane;
	private JTextField caja1;
	private JTextField caja2;
	private JButton boton1;
	private JButton boton2;
	

	/**
	 * Punto de entrada a app y ejecución.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProbandoBoton frame = new ProbandoBoton();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Configuracion de la ventana.
	 */
	public ProbandoBoton() {
		
		//Marco y contenido
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Boton 1
		boton1 = new JButton("Apr\u00E9tame"); //Es Aprétame
		//lo añade al hacer doble click sobre el botón en design
		//LisTENER+EVENTO (espera pase algo para ejecutarse)
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Accion a desarrollar al apretar el boton: Escribir en caja1 un texto
				caja1.setText("Hola he apretado el botón");
			}
		});
		boton1.setBounds(24, 24, 140, 23);
		contentPane.add(boton1);
		
		//Campo de Texto caja donde imprimir algo si apretamos el botón
		caja1 = new JTextField();
		caja1.setBounds(24, 83, 257, 30);
		contentPane.add(caja1);
		caja1.setColumns(10);
		
		//Segundo boton
		boton2 = new JButton("C\u00F3meme"); //Es Cómeme
		//listener evento para hacer algo al apretar el segundo botón
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Saca contenido de caja 1 por consola
				System.out.println(caja1.getText());
				//Saca contenido de caja1 por caja2 al apretar
				caja2.setText(caja1.getText());
			}
		});
		boton2.setBounds(24, 135, 140, 23);
		contentPane.add(boton2);
		
		//Segunda caja, campo de texto.
		caja2 = new JTextField();
		caja2.setColumns(10);
		caja2.setBounds(24, 194, 257, 30);
		contentPane.add(caja2);
	}
}
