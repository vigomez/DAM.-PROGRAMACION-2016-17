package ventanas; //La clase que definamos estará en el paquete ventanas

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaImc extends JFrame {

	private JPanel contentPane;
	private JTextField masaJtext;
	private JTextField alturaJtext;
	private JTextField imcJtext;
	
	//Las variables necesarias para realizar el cálculo
	String masa,estatura,imc;
	float masaF,estaturaF,imcF;
	float estaturaFmetros;

	/**
	 * Create the frame.
	 */
	public VentanaImc() {
		setTitle("Calculadora IMC"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta indicando que se introduzca la masa
		JLabel lblNewLabel = new JLabel("Masa (Kg)");
		lblNewLabel.setBounds(10, 11, 116, 14);
		contentPane.add(lblNewLabel);
		
		//Campo de texto donde se introducirá el valor de la masa
		masaJtext = new JTextField();
		masaJtext.setBounds(10, 36, 116, 20);
		contentPane.add(masaJtext);
		masaJtext.setColumns(10);
		
		//Etiqueta indicando que se introduzca la estatura
		JLabel lblEstaturacm = new JLabel("Estatura (cm)");
		lblEstaturacm.setBounds(10, 72, 116, 14);
		contentPane.add(lblEstaturacm);
		
		//Campo de texto donde se introducirá el valor de la altura
		alturaJtext = new JTextField();
		alturaJtext.setColumns(10);
		alturaJtext.setBounds(10, 97, 116, 20);
		contentPane.add(alturaJtext);
		
		//Botón que al pulsar calculará el IMC
		JButton btnNewButton = new JButton("IMC");
			//"Esperando" a que sea pulsado
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Recoger los datos de la ventana
				masa=masaJtext.getText();
				masaF=Float.valueOf(masa); //Pasar la masa de string a número
				System.out.println(masaF);
				estatura=alturaJtext.getText();
				estaturaF=Float.valueOf(estatura); //Pasar la altura de string a número
				System.out.println(estaturaF);
				//Calcular imc
				estaturaFmetros=estaturaF/100; //Pasa la altura de cm a metros
				System.out.println(estaturaFmetros);
				imcF=(masaF)/(estaturaFmetros*estaturaFmetros); //Calcula IMC
				System.out.println(imcF);
				//Sacar por pantalla imc. Lo pasa de float a String
				imcJtext.setText(String.valueOf(imcF)); 
			}
		});
		btnNewButton.setBounds(136, 96, 109, 23);
		contentPane.add(btnNewButton);
		
		//Campo de texto donde saldrá el valor de IMC
		imcJtext = new JTextField();
		imcJtext.setEditable(false); //No editable, no permite modificar lo escrito
		imcJtext.setBounds(255, 97, 169, 20);
		contentPane.add(imcJtext);
		imcJtext.setColumns(10);
	}

}