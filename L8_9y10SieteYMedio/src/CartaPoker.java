
public class CartaPoker extends Carta{
	
	//Constantes adecuadas para carta poker
		public static final String CORAZONES="CORAZONES";
		public static final String PICAS="PICAS";
		public static final String TREBOLES="TREBOLES";
		public static final String DIAMANTES="DIAMANTES";

		//Constructor: llamamos al constructor de la clase padre
	public CartaPoker() {
		super();
		System.out.println("...pero de póker.");
	}
	
	//Métodos
	//Sobreescribimos el método setPalo para que nos sirva para carta Póker
	//Los otros métodos nos son útiles y se heredan de la clase padre
	
	public void setPalo(String palo) {
		//this hace referencia a la propia Carta
		//Control sobre el valor de entrada
		
		switch(palo){
			case CartaPoker.DIAMANTES: 			//Mejor utilizar la constante que case "OROS":
				this.palo = CartaPoker.DIAMANTES;
				break;
			case CartaPoker.TREBOLES:
				this.palo = CartaPoker.TREBOLES;
				break;
			case CartaPoker.CORAZONES:
				this.palo = CartaPoker.CORAZONES;
				break;
			case CartaPoker.PICAS:
				this.palo = CartaPoker.PICAS;
				break;
			default:
				this.palo = CartaPoker.PICAS;
		}			
	}

}
