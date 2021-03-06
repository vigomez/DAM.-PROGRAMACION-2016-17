package Modelo;

public class Usuario {

		
		private int id;
		private String nombre="";
		private String apellido1="";
		private String apellido2="";
		private int edad=0;

		//CONSTRUCTOR
		public Usuario() {
			
		}

		//GETTERS Y SETTERS
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido1() {
			return apellido1;
		}

		public void setApellido1(String apellido1) {
			this.apellido1 = apellido1;
		}

		public String getApellido2() {
			return apellido2;
		}

		public void setApellido2(String apellido2) {
			this.apellido2 = apellido2;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		//M�todo para comprobar si una cadena es un n�mero
		//Devuelve true si es un numero
	    public boolean isNumeric(String cadena){
	    	try {
	    		Integer.parseInt(cadena);
	    		return true;
	    	} catch (NumberFormatException nfe){
	    		return false;
	    	}
	    }
	    
	    //M�todo para comprobar si una cadena es un conjunto de espacios.
	    public boolean sonEspacios(String cad)
	    {
	    for(int i =0; i<cad.length(); i++)
	       if(cad.charAt(i) != ' ')
	            return false;
	    
	    return true;
	    }
		//Permitir� mostrar todos los campos de usuario
		//Sobreescribimos el m�todo toString que se hereda autom�ticamente por se un objeto de java
		//Es un m�todo que "transforma" un objeto en una cadena
		public String toString(){
			return this.id+" "+this.nombre+" "+this.apellido1+" "+this.apellido2+" "+this.edad;
		}

	}

