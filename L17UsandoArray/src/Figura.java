public class Figura {
	private int alto;
	private int ancho;
	private float superficie;
	
	public Figura() {
		this.alto=0;
		this.ancho=0;
		this.superficie=0f;
	}
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public float getSuperficie() {
		return superficie;
	}

	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
}