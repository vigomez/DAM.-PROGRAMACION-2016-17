import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {
	
	/*Es conveniente que todos los atributos de la clase
	 * aparezcan al principio y se tenga cuidado al 
	 * definirlos como public, private o protected
	 */

	//Panel contenedor
	private JPanel contentPane;

	//Un objeto operaciones
	private Operaciones op;
	
	//botones números (opciones de refactor de Eclipse facilitan organización)
	private JButton boton1 = new JButton("1");
	private JButton boton2 = new JButton("2");
	private JButton boton3 = new JButton("3");
	private JButton boton4 = new JButton("4");
	private JButton boton5 = new JButton("5");
	private JButton boton6 = new JButton("6");
	private JButton boton7 = new JButton("7");
	private JButton boton8 = new JButton("8");
	private JButton boton9 = new JButton("9");
	private JButton boton0 = new JButton("0");
	
	//botones operaciones
	private JButton suma = new JButton("+");
	private JButton resta = new JButton("-");
	private JButton multiplica = new JButton("*");
	private JButton divide = new JButton("/");
	private JButton btnult = new JButton("+Ult"); //suma acumulativa
	
	//botones control flujo de operaciones
	private JButton borra = new JButton("C");
	private JButton result = new JButton("=");
	private JButton ultimaOp = new JButton("Ult");
	
	//texto resultados
	private JTextField resultado;
	
	//numeros para operaciones y su correspondiente string
	private int num1=0;
	private String numTxt1="";
	private int num2=0;
	private String numTxt2="";
	
	//semaforo numeros.
	//True supone que estamos introduciendo el primer número para hacer una operación
	private boolean isNum1=true;
	
	//semaforo operacion nueva
	//True supone que hemos terminado una operación y vamos a hacer otra
	private boolean isNueva=true;
	
	//tipos de operación
	private final static int SUMA=0;
	private final static int RESTA=1;
	private final static int MULTIPLICA=2;
	private final static int DIVIDE=3;
	private int tipoOp=0;
	
	//Etiqueta para mi LOG:mensajes de control por monitor
	private static String _NOMBRE="CALCULADORA";
	


	/**
	 * Constructor de la Calculadora
	 */
	public Calculadora() {
		
		//Elementos gráficos
		
		//JPanel que contendrá botones y campos de texto
		System.out.println("Entro en "+_NOMBRE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Botones para los números con su listener genérico
		 * miBotonCalculadora(), que se implementará como una inner class
		 */
		
		boton1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton1.setBounds(10, 11, 59, 58);
		//Aqui se incluye el evento del boton
		boton1.addActionListener(new miBotonCalculadora());
		contentPane.add(boton1);
		
		boton2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton2.setBounds(79, 11, 59, 58);
		//Aqui se incluye el evento del boton
		boton2.addActionListener(new miBotonCalculadora());
		contentPane.add(boton2);
		
		boton3.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton3.setBounds(148, 11, 59, 58);
		//Aqui se incluye el evento del boton
		boton3.addActionListener(new miBotonCalculadora());
		contentPane.add(boton3);
		
		boton4.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton4.setBounds(10, 80, 59, 58);
		//Aqui se incluye el evento del boton
		boton4.addActionListener(new miBotonCalculadora());
		contentPane.add(boton4);
		
		boton5.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton5.setBounds(79, 80, 59, 58);
		//Aqui se incluye el evento del boton
		boton5.addActionListener(new miBotonCalculadora());
		contentPane.add(boton5);
		
		boton6.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton6.setBounds(148, 80, 59, 58);
		//Aqui se incluye el evento del boton
		boton6.addActionListener(new miBotonCalculadora());
		contentPane.add(boton6);
		
		boton7.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton7.setBounds(10, 149, 59, 58);
		//Aqui se incluye el evento del boton
		boton7.addActionListener(new miBotonCalculadora());
		contentPane.add(boton7);
		
		boton8.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton8.setBounds(79, 149, 59, 58);
		//Aqui se incluye el evento del boton
		boton8.addActionListener(new miBotonCalculadora());
		contentPane.add(boton8);
		
		boton9.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton9.setBounds(148, 149, 59, 58);
		//Aqui se incluye el evento del boton
		boton9.addActionListener(new miBotonCalculadora());
		contentPane.add(boton9);
		
		boton0.setFont(new Font("Arial Black", Font.PLAIN, 16));
		boton0.setBounds(79, 218, 59, 58);
		//Aqui se incluye el evento del boton
		boton0.addActionListener(new miBotonCalculadora());
		contentPane.add(boton0);
		
		//Campo de texto para mostrar los números y el resultado
		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setFont(new Font("Arial", Font.PLAIN, 16));
		resultado.setBounds(217, 11, 200, 58);
		contentPane.add(resultado);
		resultado.setColumns(10);
		
		/*Botones para las operaciones con su listener genérico
		 * miOpCalculadora(), que se implementará como una inner class
		 * será el listener para la suma, resta, multiplicación y división
		 */
		suma.setFont(new Font("Arial Black", Font.PLAIN, 16));
		suma.setBounds(217, 80, 59, 58);
		suma.addActionListener(new miOpCalculadora());
		contentPane.add(suma);
		
		resta.setFont(new Font("Arial Black", Font.PLAIN, 16));
		resta.setBounds(286, 80, 59, 58);
		resta.addActionListener(new miOpCalculadora());
		contentPane.add(resta);
		
		multiplica.setFont(new Font("Arial Black", Font.PLAIN, 16));
		multiplica.setBounds(217, 149, 59, 58);
		multiplica.addActionListener(new miOpCalculadora());
		contentPane.add(multiplica);
		
		divide.setFont(new Font("Arial Black", Font.PLAIN, 16));
		divide.setBounds(286, 149, 59, 58);
		divide.addActionListener(new miOpCalculadora());
		contentPane.add(divide);
		
		//Operacion: suma acumulativa
				btnult.setFont(new Font("Arial Black", Font.PLAIN, 12));
				btnult.setBounds(286, 218, 59, 58);
				contentPane.add(btnult);
				//De esta forma se incluiría el evento del botón si no fuese a una inner class
				btnult.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					try{
						//Convertimos el numero a int
						num1=Integer.valueOf(numTxt1);
						resultado.setText(String.valueOf(op.suma(num1)));
						//Reseteamos valores
						inicializacion_bis();
					}
					catch (Exception e)
					{
						resultado.setText("");
						resultado.setText("SYNTAX ERROR");
						inicializacion_bis();
					}
					}
				});

		//Botones para el control del flujo de operaciones
		
		//Botón de borrado
		borra.setFont(new Font("Arial Black", Font.PLAIN, 16));
		borra.setBounds(358, 80, 59, 58);
		contentPane.add(borra);
		//De esta forma se incluiría el evento del botón si no fuese a una inner class
		borra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Reseteamos valores
				inicializacion();
			}
		});
		
		//Botón de "igual" (resultado)
		result.setFont(new Font("Arial Black", Font.PLAIN, 16));
		result.addActionListener(new miOpCalculadora());
		result.setBounds(355, 149, 59, 58);		
		contentPane.add(result);
		
		//Botón para recuperar y reutilizar el último resultado obtenido
		ultimaOp.setFont(new Font("Arial Black", Font.PLAIN, 16));
		ultimaOp.setBounds(217, 218, 59, 58);
		contentPane.add(ultimaOp);
		//De esta forma se incluiría el evento del botón si no fuese a una inner class
		ultimaOp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resultado.setText(String.valueOf((int)op.ultimaOp()));
				numTxt1=String.valueOf((int)op.ultimaOp());
			}
		});
		
		
		//Generar un nuevo objeto op
		op=new Operaciones();
		//Reseteamos todos los valores
		inicializacion();
		
	}
	
	//Método que se resetea todos los parámetros cuando se lanza el programa
	//Ejemplo de método sin entrada ni salida
	private void inicializacion(){
		numTxt1="";
		num1=0;
		num2=0;
		numTxt2="";
		isNueva=false;
		resultado.setText("");
		isNum1=true;
	}
	
	//Idem que resetea los valores después de una operación
	private void inicializacion_bis(){
		numTxt1="";
		num1=0;
		numTxt2="";
		num2=0;
		isNum1=true;
		isNueva=true;
		}
	
	/*Mi implementación especifica de los ActionListener 
	 * para los botones de los números y operaciones aritméticas 
	 * a través de inner clases
	 */
	
	//Listener para los botones de los números
	
	private class miBotonCalculadora implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Con getSource "identificamos el botón" pulsado
			//cada uno de los cuales ya habíamos "bautizado" con 
			//el número correspondiente
			JButton b=(JButton)e.getSource();
			
			//En el caso de que antes de pulsar el botón hubiésemos seleccionado operación
			//Estamos escribiendo un nuevo número: vaciamos pantalla y semáforo isNueva a false
			if(isNueva){
				//En el caso de nueva operacion borramos pantalla y semáforo isNueva a false
				resultado.setText("");
				isNueva=false;
			}
			
			//Añadimos en el campo de texto el número pulsado
			resultado.setText(resultado.getText()+(b.getText()));
			
			//Contralamos si la cifra que estamos poniendo se debe añadir al primer número o al 
			//segundo de la operación
			
			if(isNum1){
				numTxt1=numTxt1+b.getText();
			}else{
				numTxt2=numTxt2+b.getText();
			}
		} 
		
		
	}
	
	//Listener para las operaciones suma, resta, multiplicación, división e igual
	private class miOpCalculadora implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//getSource nos permite identificar el boton pulsado
			JButton b=(JButton)e.getSource();
			
		try{
			//Almacenamos el numero pulsado previamente a la operación
			//elegida teniendo en cuenta si era el primer o el segundo
			//numero introducido y actualizando el semáforo isNum1 en 
			//consecuencia
			if(isNum1){
				//Convertimos el numero a int
				num1=Integer.valueOf(numTxt1);
				isNum1=false;
				numTxt1="";
			}else{
				//Convertimos el numero a int
				num2=Integer.valueOf(numTxt2);
				isNum1=true;	
				numTxt2="";
			}
			//Almacenamos la operacion a realizar
			if(b.getText()=="+"){
				tipoOp=SUMA;
				//Mostramos en la caja de resultado la operacion
				resultado.setText(resultado.getText()+(b.getText()));
			}else if(b.getText()=="-"){
				tipoOp=RESTA;
				//Mostramos en la caja de resultado la operacion
				resultado.setText(resultado.getText()+(b.getText()));
			}else if(b.getText()=="*"){
				tipoOp=MULTIPLICA;
				//Mostramos en la caja de resultado la operacion
				resultado.setText(resultado.getText()+(b.getText()));
			}else if(b.getText()=="/"){
				tipoOp=DIVIDE;
				//Mostramos en la caja de resultado la operacion
				resultado.setText(resultado.getText()+(b.getText()));
			}else if(b.getText()=="="){
				int resI;
				//Realizamos operacion y la mostramos
				switch (tipoOp){
					case SUMA:
						resI=op.suma(num1, num2);
						resultado.setText(String.valueOf(resI));
						break;
					case RESTA:
						resI=op.resta(num1, num2);
						resultado.setText(String.valueOf(resI));
						break;
					case MULTIPLICA:
						resI=op.multiplica(num1, num2);
						resultado.setText(String.valueOf(resI));
						break;
					case DIVIDE:
						resI=op.divide(num1, num2);
						resultado.setText(String.valueOf(resI));
						break;
				}
				//Reseteamos valores
				inicializacion_bis();
			}		
		}
		catch (Exception e1)
		{
			resultado.setText("");
			resultado.setText("SYNTAX ERROR");
			inicializacion_bis();
		}
		}
		
	}
}