public class Cumple {

	private String nombre; //Almacenara el nombre de una persona
	private int edad; //Edad de la persona
	private int dia; //dia de cumpleaños [1-31]
	private int mes; //mes de cumpleaños [1-12]
	private int anyo; //anyo de cumpleaños [1940-2015]
	
	public Cumple() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		if(dia<1){
			this.dia = 1;
		}else if(dia>31){
			this.dia = 31;
		}else{
			this.dia = dia;
		}
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		if(mes<1){
			this.mes = 1;
		}else if(mes>12){
			this.mes = 12;
		}else{
			this.mes = mes;
		}
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		if(anyo<1940){
			this.anyo = 1940;
		}else if(anyo>2015){
			this.anyo = 2015;
		}else{
			this.anyo = anyo;
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}