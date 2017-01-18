import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AgregandoMenu extends JFrame {

	private JPanel contentPane;
	private JTextField informacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregandoMenu frame = new AgregandoMenu();
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
	public AgregandoMenu() {
		
		//Utilizamos un BorderLayout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		informacion = new JTextField();
		informacion.setEditable(false);
		getContentPane().add(informacion, BorderLayout.SOUTH);
		informacion.setColumns(10);
		
		JPanel aplicacion = new JPanel();
		getContentPane().add(aplicacion, BorderLayout.CENTER);
		aplicacion.setLayout(null);
		
		JLabel lblEtiqueta = new JLabel("Etiqueta");
		lblEtiqueta.setBounds(10, 11, 46, 14);
		aplicacion.add(lblEtiqueta);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 38, 89, 23);
		aplicacion.add(btnNewButton);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnLista = new JMenu("Lista");
		menuBar.add(mnLista);
		
		JMenuItem mntmItem = new JMenuItem("Item1");
		
		mntmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				informacion.setText("He tecleado informacion");
			}
		});
		
		mnLista.add(mntmItem);
		
		JMenuItem mntmItem_1 = new JMenuItem("Item2");
		mnLista.add(mntmItem_1);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		//Añadir separador
		mnLista.addSeparator();
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo1");
		mnLista.add(mntmNuevo);
		

		//Añadir separador
		mnLista.addSeparator();
		
		JMenu mnSubmenu = new JMenu("Submenu");
		mnLista.add(mnSubmenu);
		
		JMenuItem mntmSubmenu = new JMenuItem("Submenu1");
		mnSubmenu.add(mntmSubmenu);
		
		//Añadir separador
		mnLista.addSeparator();
		
		JCheckBoxMenuItem chckbxmntmCheck = new JCheckBoxMenuItem("Check");
		mnLista.add(chckbxmntmCheck);
		
		JRadioButtonMenuItem rdbtnmntmRadio = new JRadioButtonMenuItem("Radio1");
		mnLista.add(rdbtnmntmRadio);
		
		JRadioButtonMenuItem rdbtnmntmRadio_1 = new JRadioButtonMenuItem("Radio2");
		mnLista.add(rdbtnmntmRadio_1);
	
		
		
	}
}
