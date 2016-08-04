public class UsandoString {

	public static void main(String[] args) {
		// Generar dos variables String (literales)
		String s1=""; //Vacío
		String s2="Vicent";
		
		//Imprimir los String
		System.out.println("El String s2:"+s2);
		
		//Igualar
		System.out.println("Longitud de s1:"+s1.length()); //Longitud del string
		if(s1.length()==0){
			System.out.println("El String s1 está vacio");
		}
		s1=s2; //asigna a s1 el contenido de s2
		System.out.println("El String s1:"+s1);
		System.out.println("Longitud de s1:"+s1.length());
		
		//Modificar
		s1=s1+" es profesor";
		System.out.println("El String s1:"+s1);
		System.out.println("El String s2:"+s2);
		
		//String literal frente String objeto
		//Crea dos objetos String.
		String s3=new String("Nombre");
		String s4=new String("Nombre");
		
		s1="Vicent";
		System.out.println("El String s1:"+s1);
		System.out.println("El String s2:"+s2);
		System.out.println("El String s3:"+s3);
		System.out.println("El String s4:"+s4);
		if(s1==s2){
			System.out.println("s1 = s2");
		}
		if(s3==s4){
			System.out.println("s3 = s4");
		}
		//Uso del método de la clase String .compareTo 
		if(s3.compareTo(s4)==0) System.out.println("s3 y s4 sus contenidos son iguales");
		
		//Otros metodos
		System.out.println(s1.toLowerCase()); //Escribe el string en minúsculas
		System.out.println(s1.toUpperCase()); //Escribe el string en mayúsculas
	}

}