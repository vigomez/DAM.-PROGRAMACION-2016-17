import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Imagenes extends JFrame {

	private JPanel contentPane;
	private JLabel lblEtiqueta;

	/**
	 * ESTE ES EL MAIN
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imagenes frame = new Imagenes();
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
	public Imagenes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//En la ventana incluiremos una etiqueta que tendr� asociada una imagen y no un texto
		//Se ha de usar el m�todo nombre_etiqueta.setIcon(image);
		//image ha de ser un objeto de la clase ImageIcon creado a partir de una imagen .png, .jpg, ...
		//El m�todo getClass().getResource(string); permite acceder a la direcci�n del recurso
		
		lblEtiqueta = new JLabel();
		try{
			//Pasamos una referencia de donde est� la imagen y la transforma en un objeto ImageIcon
			//La imagen, Dado.jpg, est� en la carpeta imagenes dentro del proyecto
			
			ImageIcon imagen=new ImageIcon(getClass().getResource("imagenes/Dado.jpg"));
			//Pone la imagen en la etiqueta.
			lblEtiqueta.setIcon(imagen);
			
			//Control de excepciones
		}catch(Exception e){
			System.out.println("LA IMAGEN NO EXISTE");
			e.printStackTrace();
		}
		lblEtiqueta.setBounds(10, 11, 256, 256);
		contentPane.add(lblEtiqueta);
	}
}
