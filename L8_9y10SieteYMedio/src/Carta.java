
//Definición de la clase con palabra reservada Carta
//Nombre de la clase debe ser igual a la del fichero .java

public class Carta {
	
	//Propiedades, publicas para acceder desde fuera
	//Privadas solo accesibles desde la clase. Es necesario un método para asignarlos.
	//Protected: accesibles clases hijas (Herencia). Facilitan reutilización de código.

	protected int numero;
	protected String palo;
	
	//Constantes
	public static final String BASTOS="BASTOS";
	public static final String COPAS="COPAS";
	public static final String OROS="OROS";
	public static final String ESPADAS="ESPADAS";

	//Constructor: mismo nombre que la classe pero no palabra reservada class
	//Punto de entrada que se ejecuta al crear un objeto de tipo carta
	
	public Carta() {
		System.out.println("Creada una carta");
		
	}
	
	//Metodos o funciones
	
	//Asigna un numero a la carta
	// void significa que no devuelve nada
	//Se escribe: public/private queSaca nombre (entrada)
	
	public void setNumero(int numero){
		
		//Condicional para controlar que el numero propuesto sea correcto. IF
		if (numero<1){
			this.numero=1;}
		else if (numero>12){
			this.numero=12;}
		else{
			this.numero=numero;}
				
	}
	
	//Permite saber el numero de la carta una vez asignado
	public int getNumero(){
		return numero;
	
	}

	//Metodos para asignar palo a carta y para extraer valor de palo:getter i setter
	
	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		//this hace referencia a la propia Carta
		//Control sobre el valor de entrada
		
		switch(palo){
			case Carta.OROS: 			//Mejor utilizar la constante que case "OROS":
				this.palo = Carta.OROS;
				break;
			case Carta.COPAS:
				this.palo = Carta.COPAS;
				break;
			case Carta.ESPADAS:
				this.palo = Carta.ESPADAS;
				break;
			case Carta.BASTOS:
				this.palo = Carta.BASTOS;
				break;
			default:
				this.palo = Carta.BASTOS;
		}			
	}

}
