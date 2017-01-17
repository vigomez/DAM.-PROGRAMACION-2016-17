import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;


/**
* <h1>ProbandoFlowLayout</h1>
* La clase ProbandoFlowLayout nos muestra un sencillo ejemplo de uso del Layout FlowLayout
* <p>
* Este es un Layout muy sencillo utilizado para que automáticamente se coloquen los elementos de acuerdo
* a su tamaño
* 
*
*/
public class ProbandoFlowLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProbandoFlowLayout frame = new ProbandoFlowLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creamos la ventana
	 */
	public ProbandoFlowLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		JLabel lblNombre = new JLabel("Nombre");
		contentPane.add(lblNombre);
		
		JButton btnNewButton = new JButton("Nuevo Nombre");
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Probando FlowLayout");
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Boton numero 3");
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Elemento nuevo");
		contentPane.add(lblNewLabel_1);
	}

}