import java.util.Random;

public class UsandoArrays_4 {

	public static void main(String[] args) {
		//Generar un nuevo generador de numeros pseudoaleatorios
		Random gen=new Random();
		//tipo nombre = inicializacion/new
		//Array de 10 objetos de la clase Figura
		Figura[] conjunto=new Figura[10];
		//Elemento figura temporal
		Figura f;
		
		//Inicialización
		for(int i=0;i<conjunto.length;i++){
			conjunto[i]=new Figura();
			f=conjunto[i];
			f.setAlto(gen.nextInt(100)); //gen.nextInt(100) devuelve un entero entre 0 y 99
			f.setAncho(gen.nextInt(100));
		}
		
		//Imprimir por pantalla todos los elementos
		for(int i=0;i<conjunto.length;i++){
			f=conjunto[i];
			System.out.println("La Figura nuemero "+i+" tiene un alto de "+f.getAlto()+" y un ancho de "+f.getAncho());
		}
	}

}