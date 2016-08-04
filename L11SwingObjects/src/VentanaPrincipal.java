import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame{
	//Layout
	//Declaraci�n como private de todos los elementos que aparecer�n en ventana
	private JPanel contentPane;
	private JTextField txtForm;
	private JTextField textMsg;
	private JTextArea textArea;
	private JButton btnComprobacion;
	private JLabel etiquetaNombre;
	
	
	public VentanaPrincipal() {
		setTitle("Mi ventana");

		//Propiedades necesarias para lanzar nuestra ventana
		//Que pasa si cerramos la ventana:EXIT
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//DDimensiones de la ventana
		setBounds(100, 100, 500, 300);
		//A�adimos un Layout
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//Lo a�adimos al JFrame
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//A�ade una primera etiqueta donde pondr�: "Nombre"
		etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaNombre.setFont(new Font("Arial", Font.BOLD, 11));
		etiquetaNombre.setBounds(10, 11, 464, 14);
		etiquetaNombre.setText("Vicent");
		contentPane.add(etiquetaNombre);
		
		//A�ade un campo para escribir texto; nuevo JTextField
		txtForm = new JTextField();
		txtForm.setText("Escribe algo");
		txtForm.setBounds(20, 36, 442, 20);
		contentPane.add(txtForm);
		txtForm.setColumns(10);
		
		//A�ade otro campo para escribir texto; nuevo JTextField
		textMsg = new JTextField();
		textMsg.setEnabled(false); //No permite escribir en ejecuci�n
		textMsg.setColumns(10);
		textMsg.setBounds(20, 231, 442, 20);
		textMsg.setText("Nuevo mensage de texto");
		textMsg.setEnabled(true); //Permite escribir en ejecuci�n
		contentPane.add(textMsg);
		
		//A�ade un Bot�n
		btnComprobacion = new JButton("Comprobar");
		//Evento addActionListener
		//Accion que suceder� al apretar el bot�n
		//Evento ActionListener: pasivo hasta que recibe la se�al. Espera en background
		btnComprobacion.addActionListener(new ActionListener() {
			//Que hacemos cuando nos llega un evento
			public void actionPerformed(ActionEvent arg0) {
				//por ejemplo, comprobar si en textForm hay algo escrito
				String texto=txtForm.getText();
				if(texto.length()==0){
					textMsg.setText("NO HAY CONTENIDO");
				}else{
					textMsg.setText("HAY CONTENIDO");
				}
			}
		});
		btnComprobacion.setBounds(22, 84, 167, 23);
		contentPane.add(btnComprobacion);
		
		//Text Area
		//A�ade un area de Texto que permite escribir varias l�neas y permite retornos de carro
		//No hace scrooll, para ello habr�a que poner primero un JScrollPanel y "dentro" el TextArea
		textArea = new JTextArea();
		//textArea.setEditable(false); No permitir�a escribir en el textArea
		textArea.setEditable(true);    //Permite escribir en el textArea
		textArea.setBounds(20, 118, 442, 102);
		contentPane.add(textArea);
	}
	
	//Definici�n de un nuevo m�todo de la clase
	public void cambiarMsg(String msg){
		textMsg.setText(msg);
	}
}