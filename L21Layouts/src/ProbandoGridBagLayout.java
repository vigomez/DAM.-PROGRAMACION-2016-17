import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

/**
* <h1>ProbandoGridBagLayout</h1>
* La clase ProbandoGridBagLayout nos muestra un sencillo ejemplo de uso del Layout GridBagLayout
* <p>
* Este Layout es el más flexible pero al mismo tiempo el más complejo de configurar
* 
*
* @author  Paco Gómez
* @version 1.0
* @since   2016-04-29
* @see <a href="http://cookingsoftware.blogspot.com.es/2016/03/java-layout-managers.html">Java. Layout Managers</a>
*/
public class ProbandoGridBagLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProbandoGridBagLayout frame = new ProbandoGridBagLayout();
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
	public ProbandoGridBagLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblEt = new JLabel("Et1");
		GridBagConstraints gbc_lblEt = new GridBagConstraints();
		gbc_lblEt.weightx = 0.2;
		gbc_lblEt.insets = new Insets(0, 0, 5, 5);
		gbc_lblEt.gridx = 0;
		gbc_lblEt.gridy = 0;
		contentPane.add(lblEt, gbc_lblEt);
		
		JButton btnNewButton2 = new JButton("Boton2");
		GridBagConstraints gbc_btnNewButton2 = new GridBagConstraints();
		gbc_btnNewButton2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton2.weightx = 0.8;
		gbc_btnNewButton2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton2.anchor = GridBagConstraints.NORTH;
		//gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton2.gridx = 1;
		gbc_btnNewButton2.gridy = 0;
		contentPane.add(btnNewButton2, gbc_btnNewButton2);
		
		JButton btnNewButton3 = new JButton("Boton3");
		GridBagConstraints gbc_btnNewButton3 = new GridBagConstraints();
		gbc_btnNewButton3.insets = new Insets(5, 0, 5, 0);
		gbc_btnNewButton3.ipady = 5;
		gbc_btnNewButton3.ipadx = 5;
		gbc_btnNewButton3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton3.gridwidth = 2;
		gbc_btnNewButton3.anchor = GridBagConstraints.NORTH;
		//gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton3.gridx = 0;
		gbc_btnNewButton3.gridy = 1;
		contentPane.add(btnNewButton3, gbc_btnNewButton3);
		
		JLabel lblEt_1 = new JLabel("Et2");
		GridBagConstraints gbc_lblEt_1 = new GridBagConstraints();
		gbc_lblEt_1.weightx = 0.2;
		gbc_lblEt_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblEt_1.gridx = 0;
		gbc_lblEt_1.gridy = 2;
		contentPane.add(lblEt_1, gbc_lblEt_1);
		
		JButton btnBoton_1 = new JButton("Boton5");
		GridBagConstraints gbc_btnBoton_1 = new GridBagConstraints();
		gbc_btnBoton_1.weightx = 0.8;
		gbc_btnBoton_1.gridx = 1;
		gbc_btnBoton_1.gridy = 2;
		contentPane.add(btnBoton_1, gbc_btnBoton_1);
		
		
	}

}