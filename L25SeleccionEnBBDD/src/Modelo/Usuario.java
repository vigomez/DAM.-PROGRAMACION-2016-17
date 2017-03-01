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
		
		//Permitirá mostrar todos los campos de usuario
		//Sobreescribimos el método toString que se hereda automáticamente por se un objeto de java
		//Es un método que "transforma" un objeto en una cadena
		public String toString(){
			return this.id+" "+this.nombre+" "+this.apellido1+" "+this.apellido2+" "+this.edad;
		}

	}

