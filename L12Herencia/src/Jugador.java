public class Jugador extends Personaje{

	private int puntos=0;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public void addPuntos(){
		this.puntos = this.puntos+1;
	}

}