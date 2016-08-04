package visual; //La clase Ventana1 forma parte del paquete visual

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Jugador; //importamos la clase Jugador que hemos creado en el paquete logica
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana1 extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Ventana1() {
		setTitle("VENTANA 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creamos un objeto de la clase Jugador
		Jugador j1=new Jugador();
	}
}