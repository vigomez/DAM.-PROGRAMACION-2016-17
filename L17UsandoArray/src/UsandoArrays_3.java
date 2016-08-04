public class UsandoArrays_3 {

	public static void main(String[] args) {
		
		//tipo nombre = inicializacion/new
		//Ejemplo de un Array de objetos de la clase Figura creada por nosotros
		Figura[] conjunto=new Figura[10];
		//Elemento figura temporal
		//Figura f;
		
		//Ejemplo de como inicializar uno a una cada elemento del array
		//Nueva Figura en la posicion 0
		//conjunto[0]=new Figura();
		//f=conjunto[0];
		//f.setAlto(5);
		//System.out.println("El alto de la Figura es "+f.getAlto());
		
		//Inicialización
		for(int i=0;i<conjunto.length;i++){
			conjunto[i]=new Figura();
			System.out.println("Creada la figura:"+i);
		}
		
		

	}

}