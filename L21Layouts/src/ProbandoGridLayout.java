import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
* <h1>ProbandoGridLayout</h1>
* La clase ProbandoGridLayout nos muestra un sencillo ejemplo de uso del Layout GridLayout
* <p>
* Este Layout nos permite presentar los componentes en forma de matriz o tabla de forma automática
* 
*/
public class ProbandoGridLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProbandoGridLayout frame = new ProbandoGridLayout();
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
	public ProbandoGridLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 3, 10, 10));
		
		JButton btnNewButton = new JButton("Boton1");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Boton3");
		contentPane.add(btnNewButton_2);
	
		
		JButton btnNewButton_1 = new JButton("Boton2");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Boton4");
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Etiqueta1");
		contentPane.add(lblNewLabel);
	}

}