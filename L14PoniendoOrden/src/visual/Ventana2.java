package visual; //Indica que esta clase está en el paquete visual
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Ventana2 extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Ventana2() {
		setTitle("VENTANA 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("A Ventana 1");
		btnNewButton.setBounds(98, 117, 245, 23);
		contentPane.add(btnNewButton);
	}

}