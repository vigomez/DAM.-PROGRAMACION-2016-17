import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textEdad;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textAnyo;
	private JTextField textMsg;
	
	private JButton btnGuardar;
	
	//Crear objeto cumple
	private Cumple cump;
	
	public VentanaPrincipal() {
		
		//Crearemos un nuevo cumpleaños
		cump=new Cumple();
		
		setTitle("CUMPLE PERSONA");
		//Configuraciones
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Etiqueta del nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 70, 14);
		contentPane.add(lblNombre);
		
		//Campo del nombre
		textNombre = new JTextField();
		textNombre.setBounds(90, 8, 334, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		//Etiqueta de la edad
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 51, 70, 14);
		contentPane.add(lblEdad);
		
		//Campo del edad
		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(90, 48, 86, 20);
		contentPane.add(textEdad);
		
		//Etiqueta del dia
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(10, 96, 70, 14);
		contentPane.add(lblDia);
		
		//Etiqueta del mes
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(10, 133, 70, 14);
		contentPane.add(lblMes);
		
		//Etiqueta del año
		JLabel lblAnyo = new JLabel("A\u00F1o");
		lblAnyo.setBounds(10, 168, 70, 14);
		contentPane.add(lblAnyo);
		
		//Campo del dia
		textDia = new JTextField();
		textDia.setColumns(10);
		textDia.setBounds(90, 93, 86, 20);
		contentPane.add(textDia);
		
		//Campo del mes
		textMes = new JTextField();
		textMes.setColumns(10);
		textMes.setBounds(90, 130, 86, 20);
		contentPane.add(textMes);
		
		//Campo del año
		textAnyo = new JTextField();
		textAnyo.setColumns(10);
		textAnyo.setBounds(90, 165, 86, 20);
		contentPane.add(textAnyo);
		
		//Boton Guardar
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Relleno  el objeto
				cump.setNombre(textNombre.getText());
				String edadString=textEdad.getText();
				int edad=Integer.valueOf(edadString);
				cump.setEdad(edad);
				String diaString=textDia.getText();
				int dia=Integer.valueOf(diaString);
				cump.setDia(dia);
				String mesString=textMes.getText();
				int mes=Integer.valueOf(mesString);
				cump.setMes(mes);
				String anyoString=textAnyo.getText();
				int anyo=Integer.valueOf(anyoString);
				cump.setAnyo(anyo);
				
				//Mostrar por ventana MSG
				System.out.println(cump.getNombre()+" tiene "+cump.getEdad()+" y los cumple el dia "+cump.getDia());
				textMsg.setText(cump.getNombre()+" tiene "+cump.getEdad()+" y los cumple el dia "+cump.getDia());
			}
		});
		btnGuardar.setBounds(10, 212, 414, 23);
		contentPane.add(btnGuardar);
		
		//Mensages
		textMsg = new JTextField();
		textMsg.setEnabled(false);
		textMsg.setBounds(10, 246, 414, 38);
		contentPane.add(textMsg);
		textMsg.setColumns(10);
		

	}
}