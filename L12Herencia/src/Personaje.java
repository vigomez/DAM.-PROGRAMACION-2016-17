
public class Personaje {
	//Definicion de las propiedades
	private int vida=100;
	private int nivel=1;
	private String armaActual="";
	
	public Personaje() {
		// TODO Auto-generated constructor stub
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public void quitarVida(){
		this.vida=this.vida-1;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getArmaActual() {
		return armaActual;
	}

	public void setArmaActual(String armaActual) {
		this.armaActual = armaActual;
	}

	
}