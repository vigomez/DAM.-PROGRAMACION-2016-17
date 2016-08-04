public class Principal {

	public static void main(String[] args) {
		
		//Generar un nuevo jugador
		Jugador player1=new Jugador();
		
		player1.setPuntos(10);
		player1.setArmaActual("espadada");
		
		//Generar un monstruo
		Monstruo ogro=new Monstruo();
		ogro.setTipoAtaque("hachazo");
		ogro.setVida(5);
		
		//Definimos un personaje de forma general
		Personaje personaje=new Personaje();
		personaje.setNivel(3);
		personaje.setVida(100);
		
		//Creamos una ventana
		Ventana v1 =new Ventana();
		v1.setVisible(true);

	}

}