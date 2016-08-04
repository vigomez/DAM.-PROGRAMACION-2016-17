import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Eventos01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eventos01 frame = new Eventos01();
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
	public Eventos01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Añadimos un botón
		JButton btnNewButton = new JButton("New button");
		
		System.out.println("SE EJECUTA"); 
		
		//LISTENER: Espera que se pulse sobre el botón: nombre_boton_addActionListener
		//Mientras no se pulse el botón no se ejecutará la acción correspondiente.
		btnNewButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Botón pulsado");
					}
				}
		);
		//LISTENER
		
		System.out.println("SE EJECUTA 2");
		
		btnNewButton.setBounds(10, 11, 122, 23);
		contentPane.add(btnNewButton);
	}

}