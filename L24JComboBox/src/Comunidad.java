
public class Comunidad {

	private String nombre;
	private String[] provincias=new String[10];
	private int numProvincias;
	
	
	public Comunidad() {
		
	}

	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String[] getProvincias() {
		return provincias;
	}


	public void setProvincias(String[] provincias) {
		this.provincias = provincias;
	}


	public int getNumProvincias() {
		return numProvincias;
	}


	public void setNumProvincias(int numProvincias) {
		this.numProvincias = numProvincias;
	}
	
	public String toString(){
		return this.nombre;
	}

}
