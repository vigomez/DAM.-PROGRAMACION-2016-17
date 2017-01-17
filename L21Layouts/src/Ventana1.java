
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana1 extends JPanel {
	
	public JButton btnAVentana;
	/**
	 * Create the panel.
	 */
	public Ventana1() {
		setLayout(null);
		
		btnAVentana = new JButton("A ventana 2 >>");
		btnAVentana.setBounds(122, 97, 199, 105);
		add(btnAVentana);

	}

}
