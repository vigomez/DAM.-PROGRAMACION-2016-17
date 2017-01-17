
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Ventana2 extends JPanel {

	public JButton btnAVentana;
	/**
	 * Create the panel.
	 */
	public Ventana2() {
		setLayout(new BorderLayout(0, 0));
		
		btnAVentana = new JButton("A ventana 1 <<");
		add(btnAVentana, BorderLayout.CENTER);

	}

}